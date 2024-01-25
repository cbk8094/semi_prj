package kr.co.publicvoid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.publicvoid.vo.WishVO;

public interface WishMapper {
	// 등록
	int insert(WishVO wishVO);
	
	// 수정
	int update(WishVO wishVO);
	
	// 삭제
	int delete(Long wishNo);
	
	// 목록 조회
	List<WishVO> selectList();
	
	// 단일 조회
	WishVO selectOne(Long wishNo);
	
	// 회원 번호, 게임 번호로 단일 조회
	WishVO selectOneByMemberNoAndGameNo(@Param("memberNo") Long memberNo, @Param("gameNo") Long gameNo);
	
	// 회원 번호로 목록 조회
	List<WishVO> selectListByMemberNo(Long memberNo);

	// 회원 번호로 목록 조회 (3개만)
	List<WishVO> selectListByMemberNoLimit3(Long memberNo);
	
	// 회원 번호로 개수 조회
	int selectCountByMemberNo(Long memberNo);
}
