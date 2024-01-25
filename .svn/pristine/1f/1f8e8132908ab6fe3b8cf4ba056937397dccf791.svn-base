package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.CartVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class CartMapperTests {
	private CartMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(CartMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		CartVO cartVO = CartVO.builder().memberNo(3L).build();
		
		log.info(mapper.insert(cartVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		CartVO cartVO = mapper.selectOne(1L);
		
		cartVO.setMemberNo(2L);
		log.info(mapper.update(cartVO));
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
