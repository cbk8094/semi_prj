package kr.co.publicvoid.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.publicvoid.mapper.PurchaseMapper;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.LibraryVO;
import kr.co.publicvoid.vo.PurchaseVO;

public class PurchaseService {
	
	public static final PurchaseService INSTANCE = new PurchaseService();
	private LibraryService libraryService = LibraryService.getInstance();
	private GameService gameService = GameService.getInstance();
	private MemberService memberService = MemberService.getInstance();
	
	private PurchaseService() {}
	
	public static PurchaseService getInstance() {
		return INSTANCE;
	}
	
	// 단일 조회
	public PurchaseVO getOne(Long purchaseNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
	        PurchaseMapper purchaseMapper = sqlSession.getMapper(PurchaseMapper.class);
	        return purchaseMapper.selectOne(purchaseNo);
	    }
	}
	
	// 구매내역에 추가
	public int register(PurchaseVO purchaseVO) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession()) {
			PurchaseMapper purchaseMapper = sqlSession.getMapper(PurchaseMapper.class);
			int result = purchaseMapper.insert(purchaseVO);

			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return result;
		}
	}
	
	// 회원 번호로 목록 조회
	public List<PurchaseVO> getListByMemberNo(Long memberNo){
	    try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
	        PurchaseMapper purchaseMapper = sqlSession.getMapper(PurchaseMapper.class);
	        return purchaseMapper.selectListByMemberNo(memberNo);
	    }
	}
	
	// 환불 내역을 가진 구매내역인지 확인
	public int hasRefund(Long purchaseNo) {
	    try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
	        PurchaseMapper purchaseMapper = sqlSession.getMapper(PurchaseMapper.class);
	        return purchaseMapper.selectHasRefund(purchaseNo);
	    }
	}
	
	// 환불하기
	public boolean refund(Long purchaseNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession()) {
			int result = 0;

			// 구매내역에 가격 마이너스 및 환불로 추가, 라이브러리에서 삭제, 게임 판매량 감소, 회원 누적구매액 및 포인트 감소
			// 포인트 감소 시 구매액의 5% 감소
	    	
			// 구매내역 조회
			PurchaseVO purchaseVO = getOne(purchaseNo);
			Long memberNo = purchaseVO.getMemberNo();
			Long gameNo = purchaseVO.getGameNo();
			int purchasePrice = purchaseVO.getPurchasePrice();
			int minusPurchasePrice = purchaseVO.getPurchasePrice() * -1;
			
			// 라이브러리 조회
			LibraryVO libraryVO = libraryService.getOneByMemberNoAndGameNo(memberNo, gameNo);
	    	
			// 구매내역에 추가 (가격 마이너스 및 환불로)
			PurchaseVO refundPurchaseVO = PurchaseVO.builder().memberNo(memberNo).gameNo(gameNo).purchasePrice(minusPurchasePrice).isRefund(true).refundPurchaseNo(purchaseVO.getPurchaseNo()).build();
			
			result = register(refundPurchaseVO);
			
			if(result == 0) {
				sqlSession.rollback();
				return false;
			}
			
			// 라이브러리에서 삭제
			result = libraryService.delete(libraryVO.getLibraryNo());
			
			if(result == 0) {
				sqlSession.rollback();
				return false;
			}
			
			// 게임 판매량 감소
			result = gameService.updateSaleCount(gameNo, -1);
			
			if(result == 0) {
				sqlSession.rollback();
				return false;
			}
			
			// 누적구매액 감소
			result = memberService.updatePurchase(memberNo, minusPurchasePrice);
			
			if(result == 0) {
				sqlSession.rollback();
				return false;
			}
			
			// 포인트 감소 (10의 자리에서 반올림)
			result = memberService.updatePoint(memberNo, (((int)(purchasePrice * 0.05) + 5) / 10 * 10) * -1);
			
			if(result == 0) {
				sqlSession.rollback();
				return false;
			}
			
			// 여기까지 전부 성공하면 커밋
			sqlSession.commit();
			return true;
		}
	}
	
}









