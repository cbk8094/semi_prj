package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.PublisherVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class PublisherMapperTests {
	private PublisherMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(PublisherMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		PublisherVO publisherVO = PublisherVO.builder().publisherName("퍼블리셔명").build();		
		log.info(mapper.insert(publisherVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		PublisherVO publisherVO = mapper.selectOne(164L);
		publisherVO.setPublisherName("수정된퍼블리셔명");

		log.info(mapper.update(publisherVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(164L));
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
