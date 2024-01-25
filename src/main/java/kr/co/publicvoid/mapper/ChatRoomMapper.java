package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.ChatRoomVO;

public interface ChatRoomMapper {
	// 등록
	int insert(ChatRoomVO chatRoomVO);
	
	// 수정
	int update(ChatRoomVO chatRoomVO);
	
	// 삭제
	int delete(Long chatRoomNo);
	
	// 목록 조회
	List<ChatRoomVO> selectList();
	
	// 단일 조회
	ChatRoomVO selectOne(Long chatRoomNo);
}
