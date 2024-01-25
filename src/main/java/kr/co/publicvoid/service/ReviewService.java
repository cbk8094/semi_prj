package kr.co.publicvoid.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.publicvoid.dto.CriteriaNew;
import kr.co.publicvoid.mapper.ReviewMapper;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.ReviewVO;

public class ReviewService {
	public static final ReviewService INSTANCE = new ReviewService();

	private ReviewService() {}
	
	public static ReviewService getInstance() {
		return INSTANCE;
	}
	
	 // 특정 게임의 리뷰 목록
    public List<ReviewVO> getListByGameNo(Long gameNo) {
        try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
            ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
            return reviewMapper.selectListByGameNo(gameNo);
        }
    }

    // 특정 게임의 평균 평점 구하기
    public double getAverageScoreByGameNo(Long gameNo) {
        try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
            ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
            List<ReviewVO> reviewList = reviewMapper.selectListByGameNo(gameNo);
            
            // 람다식으로 해결함
            return reviewList.stream().mapToInt(ReviewVO::getReviewScore).average().orElse(0.0);
        }
    }
    
    // 특정 회원의 평균 평점 구하기
    public double getAverageScoreByMemberNo(Long memberNo) {
        try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
            ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
            List<ReviewVO> reviewList = reviewMapper.selectListByMemberNo(memberNo);
            
            // 람다식으로 해결함
            return reviewList.stream().mapToInt(ReviewVO::getReviewScore).average().orElse(0.0);
        }
    }

    // 특정 회원의 리뷰 목록
    public List<ReviewVO> getListByMemberNo(Long memberNo) {
        try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
            ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
            return reviewMapper.selectListByMemberNo(memberNo);
        }
    }
    
    // 특정 회원의 리뷰 목록 (페이징)
    public List<ReviewVO> getListByMemberNoWithPaging(CriteriaNew criteria, Long memberNo) {
        try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
            ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
            return reviewMapper.selectListByMemberNoWithPaging(criteria, memberNo);
        }
    }
    
    // 특정 게임의 리뷰 목록 (페이징)
    public List<ReviewVO> getListByGameNoWithPaging(CriteriaNew criteria, Long gameNo) {
        try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
            ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
            return reviewMapper.selectListByGameNoWithPaging(criteria, gameNo);
        }
    }

    // 특정 회원의 리뷰 목록 (3개만)
    public List<ReviewVO> getListByMemberNoLimit3(Long memberNo) {
        try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
            ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
            return reviewMapper.selectListByMemberNoLimit3(memberNo);
        }
    }

    // 특정 회원의 리뷰 개수
    public int getCountByMemberNo(Long memberNo) {
        try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
            ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
            return reviewMapper.selectCountByMemberNo(memberNo);
        }
    }
    
    // 특정 게임의 리뷰 개수
    public int getCountByGameNo(Long gameNo) {
        try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
            ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
            return reviewMapper.selectCountByGameNo(gameNo);
        }
    }
}
















