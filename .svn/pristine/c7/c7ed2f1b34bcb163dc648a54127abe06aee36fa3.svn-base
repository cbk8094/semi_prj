package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.GuestbookVO;

public interface GuestbookMapper {
	// 등록
	int insert(GuestbookVO guestbookVO);
	
	// 수정
	int update(GuestbookVO guestbookVO);
	
	// 삭제
	int delete(Long guestbookNo);
	
	// 목록 조회
	List<GuestbookVO> selectList();
	
	// 단일 조회
	GuestbookVO selectOne(Long guestbookNo);
	
	// (받은) 회원 번호로 목록 조회
	List<GuestbookVO> selectListByMemberNo(Long memberNo);
	
	
}
