package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.ItemVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class ItemMapperTests {
	private ItemMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(ItemMapper.class);

	@Test
	public void testExist(){	
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 아이템 유형은 0, 1만 되게끔 CHECK 걸어줌
	
	// 등록 테스트
	@Test
	public void insertTest() {
		ItemVO itemVO = ItemVO.builder().itemName("아이템명").itemType(0).itemPrice(3000).build();
		
		log.info(mapper.insert(itemVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		ItemVO itemVO = mapper.selectOne(3L);
		itemVO.setItemName("수정된아이템명");
		itemVO.setItemType(1);
		itemVO.setItemPrice(5000);

		log.info(mapper.update(itemVO));
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
