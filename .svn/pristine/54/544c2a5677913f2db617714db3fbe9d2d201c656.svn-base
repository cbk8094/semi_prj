package kr.co.publicvoid.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.publicvoid.mapper.LanguageMapper;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.LanguageVO;

public class LanguageService {
	public static final LanguageService INSTANCE = new LanguageService();
	
	private LanguageService() {}
	
	public static LanguageService getInstance() {
		return INSTANCE;
	}
	
	public List<LanguageVO> getList() {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			LanguageMapper languageMapper = sqlSession.getMapper(LanguageMapper.class);
			return languageMapper.selectList();
		}
	}

}
