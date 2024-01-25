package kr.co.publicvoid.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.publicvoid.mapper.GuestbookMapper;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.GuestbookVO;

public class GuestbookService {
	public static final GuestbookService INSTANCE = new GuestbookService();
	
	private GuestbookService() {}
	
	public static GuestbookService getInstance() {
		return INSTANCE;
	}

	// 회원 번호로 목록 조회
	public List<GuestbookVO> getListByMemberNo(Long memberNo){
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GuestbookMapper guestbookMapper = sqlSession.getMapper(GuestbookMapper.class);
			List<GuestbookVO> GuestbookList = guestbookMapper.selectListByMemberNo(memberNo);

			return GuestbookList;
		}
	}
	
	
}
