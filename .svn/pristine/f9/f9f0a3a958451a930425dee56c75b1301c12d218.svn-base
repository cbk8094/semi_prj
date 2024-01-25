package kr.co.publicvoid.service;

import org.apache.ibatis.session.SqlSession;

import kr.co.publicvoid.mapper.MemberImageMapper;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.MemberImageVO;

public class MemberImageService {
	public static final MemberImageService INSTANCE = new MemberImageService();

	private MemberImageService() {}
	
	public static MemberImageService getInstance() {
		return INSTANCE;
	}
	
	// 단일 조회
	public MemberImageVO getOneByMemberNo(Long memberNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			MemberImageMapper memberImageMapper = sqlSession.getMapper(MemberImageMapper.class);
			MemberImageVO memberImageVO = memberImageMapper.selectOneByMemberNo(memberNo);

			return memberImageVO;
		}
	}
	
	// 회원 이미지 수정 (DB 삭제 후 등록)
	public boolean updateMemberImage(MemberImageVO memberImageVO) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession()) {
			MemberImageMapper memberImageMapper = sqlSession.getMapper(MemberImageMapper.class);
			
			// 먼저 기존 MemberImage를 찾는다.
			MemberImageVO prevMemberImageVO = memberImageMapper.selectOneByMemberNo(memberImageVO.getMemberNo());

			int result = 0;

			// 이전 것이 있으면 그것을 먼저 지운다
			if(prevMemberImageVO != null) {
				result = memberImageMapper.delete(prevMemberImageVO.getFileNo());
				
				if(result == 0) {
					sqlSession.rollback();
					return false;
				}
			}
			
			result = memberImageMapper.insert(memberImageVO);
			
			if(result == 0) {
				sqlSession.rollback();
				return false;
			}

			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
				return false;
			}

			return true;
		}
	}
	
}
