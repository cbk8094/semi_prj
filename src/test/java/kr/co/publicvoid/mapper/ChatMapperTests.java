package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.ChatVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class ChatMapperTests {
	private ChatMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(ChatMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		ChatVO chatVO = ChatVO.builder().chatRoomNo(4L).memberNo(4L).chatContent("ㅇㅇ").build();
		
		log.info(mapper.insert(chatVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		ChatVO chatVO = mapper.selectOne(11L);
		
		chatVO.setChatRoomNo(4L);
		chatVO.setMemberNo(3L);
		chatVO.setChatContent("와웅");
		
		log.info(mapper.update(chatVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(10L));
	}
	
	// 목록 조회 테스트
	@Test
	public void selectListTest() {
		mapper.selectList().forEach(log::info);
	}
	
	// 단일 조회 테스트
	@Test
	public void selectOneTest() {
		log.info(mapper.selectOne(12L));
	}
}
