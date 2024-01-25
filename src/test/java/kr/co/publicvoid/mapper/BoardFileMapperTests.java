package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.BoardFileVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardFileMapperTests {

	private BoardFileMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(BoardFileMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		BoardFileVO boardFileVO = BoardFileVO.builder().boardNo(7L).originFileName("원래파일명").storedFileName("저장파일명").isImage(true).isThumbnail(true).build();
		
		log.info(mapper.insert(boardFileVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		BoardFileVO boardFileVO = mapper.selectOne(4L);
		boardFileVO.setBoardNo(8L);
		boardFileVO.setOriginFileName("수정된원래파일명");
		boardFileVO.setStoredFileName("수정된저장파일명");
		boardFileVO.setImage(false);
		boardFileVO.setThumbnail(false); 
		log.info(mapper.update(boardFileVO));
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
