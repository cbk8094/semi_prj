package kr.co.publicvoid.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.publicvoid.mapper.CartMapper;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.CartItemVO;
import kr.co.publicvoid.vo.CartVO;
import kr.co.publicvoid.vo.GameVO;
import kr.co.publicvoid.vo.LibraryVO;
import kr.co.publicvoid.vo.MemberVO;
import kr.co.publicvoid.vo.PurchaseVO;
import kr.co.publicvoid.vo.WishVO;

public class CartService {
	public static final CartService INSTANCE = new CartService();
	private CartItemService cartItemService = CartItemService.getInstance();
	private GameService gameService = GameService.getInstance();
	private MemberService memberService = MemberService.getInstance();
	private SaleService saleService = SaleService.getInstance();
	private PurchaseService purchaseService = PurchaseService.getInstance();
	private WishService wishService = WishService.getInstance();
	private LibraryService libraryService = LibraryService.getInstance();

	private CartService() {}
	
	public static CartService getInstance() {
		return INSTANCE;
	}
	
	// 장바구니 생성
	public boolean insert(CartVO cartVO) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession()) {
	        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
	        
	        int result = cartMapper.insert(cartVO);

	        if(result == 0) {
	        	sqlSession.rollback();
	        	return false;
	        }
	        
	        sqlSession.commit();
	        return true;
	    }
	}
	
	public CartVO getOne(Long cartNo) {
	    try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
	        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
	        return cartMapper.selectOne(cartNo);
	    }
	}

	public CartVO getOneByMemberNo(Long memberNo) {
	    try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
	        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
	        return cartMapper.selectOneByMemberNo(memberNo);
	    }
	}
	
	public boolean orderCart(Long cartNo) {
	    try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession()) {
			int result = 0;
	    	
	    	// 카트 조회
	    	CartVO cartVO = getOne(cartNo);
	    	
	    	// 일단 카트의 회원 조회
	    	MemberVO memberVO = memberService.getOne(cartVO.getMemberNo());
	    	Long memberNo = memberVO.getMemberNo();
			
			List<CartItemVO> cartItemList = cartItemService.getListByCartNo(cartVO.getCartNo());
			
			// 순회하며 구매내역에 추가, 라이브러리에 추가, 게임 판매량 증가, 회원 누적구매액 및 포인트 증가, 회원의 위시리스트에 있으면 위시리스트에서 삭제, 마지막으로 장바구니 상품 삭제
			// 포인트는 구매 가격의 5% 증가
			for(CartItemVO cartItem : cartItemList) {
				
				// 세일 정보까지 포함하여 cartItem에 담아서 cartItemList 업데이트함
				GameVO gameVO = gameService.getOne(cartItem.getGameNo());
				
				gameVO.setSaleVO(saleService.getOneByGameNoNow(gameVO.getGameNo()));
				cartItem.setGameVO(gameVO);
				
				Long gameNo = gameVO.getGameNo();
				int purchasePrice = gameVO.getDiscountedPrice();
				
				// 구매내역에 추가
				PurchaseVO purchaseVO = PurchaseVO.builder().memberNo(memberNo).gameNo(gameNo).purchasePrice(purchasePrice).build();
				
				result = purchaseService.register(purchaseVO);
				
				if(result == 0) {
					sqlSession.rollback();
					return false;
				}
				
				// 라이브러리에 추가
				LibraryVO libraryVO = LibraryVO.builder().memberNo(memberNo).gameNo(gameNo).build();
				
				result = libraryService.register(libraryVO);
				
				if(result == 0) {
					sqlSession.rollback();
					return false;
				}
				
				// 게임 판매량 증가
				result = gameService.updateSaleCount(gameNo, 1);
				
				if(result == 0) {
					sqlSession.rollback();
					return false;
				}
				
				// 누적구매액 증가
				result = memberService.updatePurchase(memberNo, purchasePrice);
				
				if(result == 0) {
					sqlSession.rollback();
					return false;
				}
				
				// 포인트 증가 (10의 자리에서 반올림)
				result = memberService.updatePoint(memberNo, ((int)(purchasePrice * 0.05) + 5) / 10 * 10);
				
				if(result == 0) {
					sqlSession.rollback();
					return false;
				}
				
				// 위시리스트에 있으면 위시리스트에서 삭제
				WishVO wishVO = wishService.getOneByMemberNoAndGameNo(memberNo, gameNo);
				if(wishVO != null) {
					result = wishService.delete(wishVO.getWishNo());

					if(result == 0) {
						sqlSession.rollback();
						return false;
					}
				}
				
				// 장바구니 상품 삭제
				result = cartItemService.delete(cartItem.getCartItemNo());

				if(result == 0) {
					sqlSession.rollback();
					return false;
				}
			}
	    	
			// 여기까지 전부 성공하면 커밋
			sqlSession.commit();
	    	return true;
	    }
	}
}

















