package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.NotifyVO;

public interface NotifyMapper {
	// 등록
	int insert(NotifyVO notifyVO);
	
	// 수정
	int update(NotifyVO notifyVO);
	
	// 삭제
	int delete(Long notifyNo);
	
	// 목록 조회
	List<NotifyVO> selectList();
	
	// 단일 조회
	NotifyVO selectOne(Long notifyNo);
}
