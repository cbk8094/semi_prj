package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.ChatParticipantVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class ChatParticipantMapperTests {
	private ChatParticipantMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(ChatParticipantMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		ChatParticipantVO chatParticipantVO = ChatParticipantVO.builder().chatRoomNo(4L).memberNo(4L).build();
		
		log.info(mapper.insert(chatParticipantVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		ChatParticipantVO chatParticipantVO = mapper.selectOne(5L);
		
		chatParticipantVO.setChatRoomNo(2L);
		chatParticipantVO.setMemberNo(4L);
		log.info(mapper.update(chatParticipantVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(5L));
	}
	
	// 목록 조회 테스트
	@Test
	public void selectListTest() {
		mapper.selectList().forEach(log::info);
	}
	
	// 단일 조회 테스트
	@Test
	public void selectOneTest() {
		log.info(mapper.selectOne(7L));
	}
}
