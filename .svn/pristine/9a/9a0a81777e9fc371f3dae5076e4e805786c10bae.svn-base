package kr.co.publicvoid.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.publicvoid.mapper.GenreMapper;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.GenreVO;

public class GenreService {
	public static final GenreService INSTANCE = new GenreService();
	
	private GenreService() {}
	
	public static GenreService getInstance() {
		return INSTANCE;
	}
	
	public List<GenreVO> getList() {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GenreMapper genreMapper = sqlSession.getMapper(GenreMapper.class);
			return genreMapper.selectList();
		}
	}
}