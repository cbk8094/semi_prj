package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.GameLanguageVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class GameLanguageMapperTests {
	private GameLanguageMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(GameLanguageMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		GameLanguageVO gameLanguageVO = GameLanguageVO.builder().gameNo(187L).languageNo(5L).build();
		
		log.info(mapper.insert(gameLanguageVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		GameLanguageVO gameLanguageVO = mapper.selectOne(15L);
		gameLanguageVO.setGameNo(188L);
		gameLanguageVO.setLanguageNo(6L);

		log.info(mapper.update(gameLanguageVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(18L));
	}
	
	// 목록 조회 테스트
	@Test
	public void selectListTest() {
		mapper.selectList().forEach(log::info);
	}
	
	// 단일 조회 테스트
	@Test
	public void selectOneTest() {
		log.info(mapper.selectOne(15L));
	}
	
	@Test
	public void selectListByGameNoTest(){
		log.info(mapper.selectListByGameNo(514L));
	}
}
