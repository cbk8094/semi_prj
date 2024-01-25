package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.ChatVO;

public interface ChatMapper {
	// 등록
	int insert(ChatVO chatVO);
	
	// 수정
	int update(ChatVO chatVO);
	
	// 삭제
	int delete(Long chatNo);
	
	// 목록 조회
	List<ChatVO> selectList();
	
	// 단일 조회
	ChatVO selectOne(Long chatNo);
}
