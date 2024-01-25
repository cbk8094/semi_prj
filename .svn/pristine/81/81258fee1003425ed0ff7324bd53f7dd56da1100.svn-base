package kr.co.publicvoid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.publicvoid.dto.CriteriaNew;
import kr.co.publicvoid.vo.ReviewVO;

public interface ReviewMapper {
	// 등록
	int insert(ReviewVO reviewVO);
	
	// 수정
	int update(ReviewVO reviewVO);
	
	// 삭제
	int delete(Long reviewNo);
	
	// 목록 조회
	List<ReviewVO> selectList();
	
	// 단일 조회
	ReviewVO selectOne(Long reviewNo);
	
	// 특정 게임의 리뷰 목록 조회
	List<ReviewVO> selectListByGameNo(Long gameNo);
	
	// 특정 회원의 리뷰 목록 조회
	List<ReviewVO> selectListByMemberNo(Long memberNo);
	
	// 특정 회원의 리뷰 목록 조회 (3개만)
	List<ReviewVO> selectListByMemberNoLimit3(Long memberNo);
	
	// 특정 회원의 리뷰 개수 조회
	int selectCountByMemberNo(Long memberNo);
	
	// 특정 게임의 리뷰 개수 조회
	int selectCountByGameNo(Long gameNo);
	
	// 특정 회원의 리뷰 목록 조회 (페이징)
	List<ReviewVO> selectListByMemberNoWithPaging(@Param("cri") CriteriaNew criteria, @Param("memberNo") Long memberNo);
	
	// 특정 게임의 리뷰 목록 조회 (페이징)
	List<ReviewVO> selectListByGameNoWithPaging(@Param("cri") CriteriaNew criteria, @Param("gameNo") Long gameNo);
}












