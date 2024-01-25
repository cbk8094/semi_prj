package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.ChatParticipantVO;

public interface ChatParticipantMapper {
	// 등록
	int insert(ChatParticipantVO chatParticipantVO);
	
	// 수정
	int update(ChatParticipantVO chatParticipantVO);
	
	// 삭제
	int delete(Long chatParticipantNo);
	
	// 목록 조회
	List<ChatParticipantVO> selectList();
	
	// 단일 조회
	ChatParticipantVO selectOne(Long chatParticipantNo);
}
