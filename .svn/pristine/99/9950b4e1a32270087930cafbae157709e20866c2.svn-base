package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.SaleVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class SaleMapperTests {
	private SaleMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(SaleMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		SaleVO saleVO = SaleVO.builder().gameNo(188L).saleRate(5).saleStartDate(new Date()).saleEndDate(new Date()).build();
		log.info(mapper.insert(saleVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		SaleVO saleVO = mapper.selectOne(1L);
		saleVO.setGameNo(201L);
		saleVO.setSaleRate(44);
		saleVO.setSaleStartDate(new Date());
		saleVO.setSaleEndDate(new Date());

		log.info(mapper.update(saleVO));
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
		log.info(mapper.selectOne(4L));
	}
}
