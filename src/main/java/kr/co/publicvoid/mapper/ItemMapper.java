package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.ItemVO;

public interface ItemMapper {
	// 등록
	int insert(ItemVO itemVO);
	
	// 수정
	int update(ItemVO itemVO);
	
	// 삭제
	int delete(Long itemNo);
	
	// 목록 조회
	List<ItemVO> selectList();
	
	// 단일 조회
	ItemVO selectOne(Long itemNo);
}
