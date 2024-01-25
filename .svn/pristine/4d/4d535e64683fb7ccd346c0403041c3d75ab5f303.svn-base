package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.CartItemVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class CartItemMapperTests {
	private CartItemMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(CartItemMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		CartItemVO cartItemVO = CartItemVO.builder().cartNo(3L).gameNo(186L).build();
		
		log.info(mapper.insert(cartItemVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		CartItemVO cartItemVO = mapper.selectOne(1L);
		
		cartItemVO.setCartNo(3L);
		cartItemVO.setGameNo(188L);
		log.info(mapper.update(cartItemVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(1L));
	}
	
	// 목록 조회 테스트
	@Test
	public void selectListTest() {
		mapper.selectList().forEach(log::info);
	}
	
	// 단일 조회 테스트
	@Test
	public void selectOneTest() {
		log.info(mapper.selectOne(6L));
	}
}
