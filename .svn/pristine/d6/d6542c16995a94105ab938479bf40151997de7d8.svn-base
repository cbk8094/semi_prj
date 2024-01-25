package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.MemberImageVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class MemberImageMapperTests {
	private MemberImageMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(MemberImageMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		MemberImageVO memberImageVO = MemberImageVO.builder().memberNo(3L).originFileName("파일명").storedFileName("저장파일명").build();
		
		log.info(mapper.insert(memberImageVO));
	}
	
	// 수정 테스트steam_servlet
	@Test
	public void updateTest() {
		MemberImageVO memberImageVO = mapper.selectOne(5L);
		memberImageVO.setMemberNo(4L);
		memberImageVO.setOriginFileName("수정한파일명");
		memberImageVO.setStoredFileName("수정한저장파일명");

		log.info(mapper.update(memberImageVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(2L));
	}
	
	// 목록 조회 테스트
	@Test
	public void selectListTest() {
		mapper.selectList().forEach(log::info);
	}
	
	// 단일 조회 테스트
	@Test
	public void selectOneTest() {
		log.info(mapper.selectOne(4L));
	}
}
