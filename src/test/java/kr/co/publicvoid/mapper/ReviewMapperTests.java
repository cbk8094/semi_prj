package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.ReviewVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class ReviewMapperTests {
	private ReviewMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(ReviewMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// reviewScore는 1, 2, 3, 4, 5만 입력되도록 CHECK 걸었음
	
	// 등록 테스트
	@Test
	public void insertTest() {
		ReviewVO reviewVO = ReviewVO.builder().gameNo(191L).memberNo(1L).reviewScore(1).reviewContent("쓰레기게임").build();
		log.info(mapper.insert(reviewVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		ReviewVO reviewVO = mapper.selectOne(1L);
		reviewVO.setGameNo(190L);
		reviewVO.setMemberNo(4L);
		reviewVO.setReviewScore(4);
		reviewVO.setReviewContent("우와왕");

		log.info(mapper.update(reviewVO));
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
