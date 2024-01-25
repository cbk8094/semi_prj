package kr.co.publicvoid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.publicvoid.vo.PurchaseVO;

public interface PurchaseMapper {
	// 등록
	int insert(PurchaseVO purchaseVO);
	
	// 수정
	int update(PurchaseVO purchaseVO);
	
	// 삭제
	int delete(Long purchaseNo);
	
	// 목록 조회
	List<PurchaseVO> selectList();
	
	// 단일 조회
	PurchaseVO selectOne(Long purchaseNo);
	
	// 회원 번호로 목록 조회
	List<PurchaseVO> selectListByMemberNo(Long memberNo);
	
	// 환불 내역을 가진 구매내역인지 확인
	int selectHasRefund(Long purchaseNo);
}
