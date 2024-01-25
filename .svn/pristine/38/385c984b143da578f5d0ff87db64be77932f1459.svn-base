package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.WishVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class WishMapperTests {
	private WishMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(WishMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		WishVO wishVO = WishVO.builder().memberNo(1L).gameNo(664L).build();
		log.info(mapper.insert(wishVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		WishVO wishVO = mapper.selectOne(2L);
		wishVO.setMemberNo(4L);
		wishVO.setGameNo(664L);

		log.info(mapper.update(wishVO));
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
		log.info(mapper.selectOne(3L));
	}
}
