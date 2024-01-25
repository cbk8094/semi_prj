package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.FriendshipVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class FriendshipMapperTests {
	private FriendshipMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(FriendshipMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		FriendshipVO friendshipVO = FriendshipVO.builder().requesterNo(2L).receiverNo(1L).build();
		
		log.info(mapper.insert(friendshipVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		FriendshipVO friendshipVO = mapper.selectOne(4L);
		friendshipVO.setBlock(false);

		log.info(mapper.update(friendshipVO));
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
		log.info(mapper.selectOne(6L));
	}
}
