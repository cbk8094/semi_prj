package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.PublisherVO;

public interface PublisherMapper {
	// 등록
	int insert(PublisherVO publisherVO);
	
	// 수정
	int update(PublisherVO publisherVO);
	
	// 삭제
	int delete(Long publisherNo);
	
	// 목록 조회
	List<PublisherVO> selectList();
	
	// 단일 조회
	PublisherVO selectOne(Long publisherNo);
	
	// 퍼블리셔명으로 찾아서 단일 조회
	PublisherVO selectOneByPublisherName(String publisherName);
}
