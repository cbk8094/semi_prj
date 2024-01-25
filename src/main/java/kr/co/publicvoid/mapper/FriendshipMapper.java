package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.FriendshipVO;

public interface FriendshipMapper {
	// 등록
	int insert(FriendshipVO friendshipVO);
	
	// 수정
	int update(FriendshipVO friendshipVO);
	
	// 삭제
	int delete(Long friendshipNo);
	
	// 목록 조회
	List<FriendshipVO> selectList();
	
	// 단일 조회
	FriendshipVO selectOne(Long friendshipNo);
}
