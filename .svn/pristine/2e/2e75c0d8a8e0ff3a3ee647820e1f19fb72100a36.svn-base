package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.dto.BoardCriteria2;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardMapperTests {
	private BoardMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(BoardMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 주의!!! JUnit 4의 InitalizeError 때는 반드시 테스트 어노테이션이 붙은 메서드 시그니처가 제대로 작성되어 있는지 확인할 것!
	// 모든 테스트 메서드 시그니처에는 파라미터가 있어선 안 됨!!
	
	// 카테고리는 notice, event, faq, qna 중 하나만 들어가게 CHECK Constraint 생성함
	
	// 등록 테스트
	@Test
	public void insertTest() {
		BoardVO boardVO = BoardVO.builder().memberNo(1L).boardCategory("qna").boardSubCategory("subcate").boardTitle("테스트제목").boardContent("테스트내용").build();
		
		log.info(mapper.insert(boardVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		BoardVO boardVO = mapper.selectOne(3L);
		boardVO.setMemberNo(2L);
		boardVO.setBoardCategory("event");
		boardVO.setBoardSubCategory("수정됨");
		boardVO.setBoardTitle("수정된제목");
		boardVO.setBoardContent("수정된내용"); 
		boardVO.setIsAnswer("1");
		boardVO.setAnswerContent("답변");
		log.info(mapper.update(boardVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(35L));
	}
	
	// 목록 조회 테스트
	@Test
	public void selectListTest() {
		mapper.selectList().forEach(log::info);
	}
	// 목록 조회 테스트2
	@Test
	public void selectListTest2() {
		mapper.getListByMemberno(1L, BoardCriteria2.builder().category("qna").build()).forEach(log::info);
	}
	
	// 단일 조회 테스트
	@Test
	public void selectOneTest() {
		log.info(mapper.selectOne(3L));
	}
	
	
}
