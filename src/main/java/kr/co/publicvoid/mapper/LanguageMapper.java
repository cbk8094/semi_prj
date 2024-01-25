package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.LanguageVO;

public interface LanguageMapper {
	// 등록
	int insert(LanguageVO languageVO);
	
	// 수정
	int update(LanguageVO languageVO);
	
	// 삭제
	int delete(Long languageNo);
	
	// 목록 조회
	List<LanguageVO> selectList();
	
	// 단일 조회
	LanguageVO selectOne(Long languageNo);
}
