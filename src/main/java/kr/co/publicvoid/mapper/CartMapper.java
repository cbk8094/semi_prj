package kr.co.publicvoid.mapper;

import java.util.List;

import kr.co.publicvoid.vo.CartVO;

public interface CartMapper {
	// 등록
	int insert(CartVO cartVO);
	
	// 수정
	int update(CartVO cartVO);
	
	// 삭제
	int delete(Long cartNo);
	
	// 목록 조회
	List<CartVO> selectList();
	
	// 단일 조회
	CartVO selectOne(Long cartNo);
	
	// 회원 번호로 단일 조회
	CartVO selectOneByMemberNo(Long memberNo);
}
