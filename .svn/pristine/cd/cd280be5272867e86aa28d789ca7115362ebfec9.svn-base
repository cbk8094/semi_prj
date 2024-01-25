package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.ItemImageVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class ItemImageMapperTests {
	private ItemImageMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(ItemImageMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		ItemImageVO itemImageVO = ItemImageVO.builder().itemNo(4L).originFileName("파일명").storedFileName("저장파일명").build();
		
		log.info(mapper.insert(itemImageVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		ItemImageVO ItemImageVO = mapper.selectOne(5L);
		ItemImageVO.setItemNo(1L);
		ItemImageVO.setOriginFileName("수정한파일명");
		ItemImageVO.setStoredFileName("수정한저장파일명");

		log.info(mapper.update(ItemImageVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(3L));
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
