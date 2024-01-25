package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.SaleVO;

public interface SaleMapper {
	// 등록
	int insert(SaleVO saleVO);
	
	// 수정
	int update(SaleVO saleVO);
	
	// 삭제
	int delete(Long saleNo);
	
	// 목록 조회
	List<SaleVO> selectList();
	
	// 단일 조회
	SaleVO selectOne(Long saleNo);
	
	// 게임 번호로 단일 조회
	SaleVO selectOneByGameNo(Long gameNo);
	
	// 현재 진행 중인 세일 조회
	SaleVO selectOneByGameNoNow(Long gameNo);
}
