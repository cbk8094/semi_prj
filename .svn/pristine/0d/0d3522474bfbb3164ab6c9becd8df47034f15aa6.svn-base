package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.ChatRoomVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class ChatRoomMapperTests {
	private ChatRoomMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(ChatRoomMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		ChatRoomVO chatRoomVO = ChatRoomVO.builder().build();
		
		log.info(mapper.insert(chatRoomVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		ChatRoomVO chatRoomVO = mapper.selectOne(2L);
		chatRoomVO.setUpdateDate(new Date());

		log.info(mapper.update(chatRoomVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(3L));
	}
	
	// 목록 조회 테스트
	@Test
	public void selectListTest() {
		mapper.selectList().forEach(log::info);
	}
	
	// 단일 조회 테스트
	@Test
	public void selectOneTest() {
		log.info(mapper.selectOne(2L));
	}
}
