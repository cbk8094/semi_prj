package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.MemberItemVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class MemberItemMapperTests {
	private MemberItemMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(MemberItemMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		MemberItemVO memberItemVO = MemberItemVO.builder().memberNo(3L).itemNo(1L).build();
		
		log.info(mapper.insert(memberItemVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		MemberItemVO memberItemVO = mapper.selectOne(2L);
		memberItemVO.setMemberNo(4L);
		memberItemVO.setItemNo(4L);

		log.info(mapper.update(memberItemVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(6L));
	}
	
	// 목록 조회 테스트
	@Test
	public void selectListTest() {
		mapper.selectList().forEach(log::info);
	}
	
	// 단일 조회 테스트
	@Test
	public void selectOneTest() {
		log.info(mapper.selectOne(5L));
	}
}
