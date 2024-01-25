package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.GameImageVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class GameImageMapperTests {
	private GameImageMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(GameImageMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		GameImageVO gameImageVO = GameImageVO.builder().gameNo(187L).originFileName("파일명").storedFileName("저장파일명").build();
		
		log.info(mapper.insert(gameImageVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		GameImageVO gameImageVO = mapper.selectOne(4L);
		gameImageVO.setGameNo(188L);
		gameImageVO.setOriginFileName("수정한파일명");
		gameImageVO.setStoredFileName("수정한저장파일명");
		gameImageVO.setThumbnail(true);

		log.info(mapper.update(gameImageVO));
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
		log.info(mapper.selectOne(3L));
	}
}
