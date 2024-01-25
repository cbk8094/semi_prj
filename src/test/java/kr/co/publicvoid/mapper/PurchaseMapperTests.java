package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.PurchaseVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class PurchaseMapperTests {
	private PurchaseMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(PurchaseMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		PurchaseVO purchaseVO = PurchaseVO.builder().memberNo(3L).gameNo(187L).purchasePrice(20000).build();		
		log.info(mapper.insert(purchaseVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		PurchaseVO purchaseVO = mapper.selectOne(3L);
		purchaseVO.setMemberNo(1L);
		purchaseVO.setGameNo(190L);
		purchaseVO.setPurchasePrice(200000);
		purchaseVO.setPurchaseDate(new Date());
		purchaseVO.setRefund(true);

		log.info(mapper.update(purchaseVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(4L));
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
