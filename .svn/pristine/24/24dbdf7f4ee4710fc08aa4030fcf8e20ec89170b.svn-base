package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.LibraryVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class LibraryMapperTests {
	private LibraryMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(LibraryMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		LibraryVO libraryVO = LibraryVO.builder().memberNo(2L).gameNo(189L).build();
		
		log.info(mapper.insert(libraryVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		LibraryVO libraryVO = mapper.selectOne(3L);
		libraryVO.setMemberNo(4L);
		libraryVO.setGameNo(190L);
		libraryVO.setFavorite(true);
		libraryVO.setHidden(true);

		log.info(mapper.update(libraryVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(6L));
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
