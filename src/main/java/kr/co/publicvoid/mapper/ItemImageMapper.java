package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.ItemImageVO;

public interface ItemImageMapper {
	// 등록
	int insert(ItemImageVO itemImageVO);
	
	// 수정
	int update(ItemImageVO itemImageVO);
	
	// 삭제
	int delete(Long itemImageNo);
	
	// 목록 조회
	List<ItemImageVO> selectList();
	
	// 단일 조회
	ItemImageVO selectOne(Long itemImageNo);
}
