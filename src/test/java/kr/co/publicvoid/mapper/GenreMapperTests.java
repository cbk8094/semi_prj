package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.GenreVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class GenreMapperTests {
	private GenreMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(GenreMapper.class);

	@Test
	public void testExist(){	
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		GenreVO genreVO = GenreVO.builder().genreName("장르장르").build();
		
		log.info(mapper.insert(genreVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		GenreVO genreVO = mapper.selectOne(172L);
		genreVO.setGenreName("수정된장르명");

		log.info(mapper.update(genreVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(172L));
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
