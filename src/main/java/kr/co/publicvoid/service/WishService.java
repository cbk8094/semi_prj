package kr.co.publicvoid.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.publicvoid.mapper.WishMapper;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.WishVO;

public class WishService {
	public static final WishService INSTANCE = new WishService();

	private WishService() {}
		
	public static WishService getInstance() {
		return INSTANCE;
	}
	
	// 위시리스트 추가
	public int register(WishVO wishVO) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession()) {
			WishMapper wishMapper = sqlSession.getMapper(WishMapper.class);
			int result = wishMapper.insert(wishVO);

			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return result;
		}
	}
	
	// 위시리스트 삭제
	public int delete(Long wishNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession()) {
			WishMapper wishMapper = sqlSession.getMapper(WishMapper.class);
			int result = wishMapper.delete(wishNo);

			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return result;
		}
	}
	
	// 단일 조회
	public WishVO getOne(Long wishNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
	        WishMapper wishMapper = sqlSession.getMapper(WishMapper.class);
	        return wishMapper.selectOne(wishNo);
		}
	}
	
	// 회원번호 및 게임번호로 단일 조회
	public WishVO getOneByMemberNoAndGameNo(Long memberNo, Long gameNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
	        WishMapper wishMapper = sqlSession.getMapper(WishMapper.class);
	        return wishMapper.selectOneByMemberNoAndGameNo(memberNo, gameNo);
		}
	}
	
	// 회원번호로 목록 조회
	public List<WishVO> getListByMemberNo(Long memberNo){
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
	        WishMapper wishMapper = sqlSession.getMapper(WishMapper.class);
	        return wishMapper.selectListByMemberNo(memberNo);
		}
	}
	
	// 회원번호로 목록 조회 (3개만)
	public List<WishVO> getListByMemberNoLimit3(Long memberNo){
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
	        WishMapper wishMapper = sqlSession.getMapper(WishMapper.class);
	        return wishMapper.selectListByMemberNoLimit3(memberNo);
		}
	}
	
	// 회원 번호로 개수 조회
	public int getCountByMemberNo(Long memberNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
	        WishMapper wishMapper = sqlSession.getMapper(WishMapper.class);
	        return wishMapper.selectCountByMemberNo(memberNo);
		}
	}
}








