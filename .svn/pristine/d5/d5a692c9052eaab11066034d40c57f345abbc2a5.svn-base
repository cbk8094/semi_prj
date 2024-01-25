package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.GuestbookVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class GuestbookMapperTests {
	private GuestbookMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(GuestbookMapper.class);

	@Test
	public void testExist(){	
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		GuestbookVO guestbookVO = GuestbookVO.builder().memberNo(2L).writerNo(3L).guestbookContent("방명록내용22").build();
		
		log.info(mapper.insert(guestbookVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		GuestbookVO guestbookVO = mapper.selectOne(2L);
		guestbookVO.setMemberNo(3L);
		guestbookVO.setWriterNo(3L);
		guestbookVO.setGuestbookContent("수정된방명록내용");

		log.info(mapper.update(guestbookVO));
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
		log.info(mapper.selectOne(3L));
	}
}
