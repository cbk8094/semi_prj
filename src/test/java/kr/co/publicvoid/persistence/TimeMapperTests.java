package kr.co.publicvoid.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.mapper.TimeMapper;
import kr.co.publicvoid.util.MybatisUtils;
import lombok.extern.log4j.Log4j;

// DB 연결 테스트용

@Log4j
public class TimeMapperTests {
	private TimeMapper mapper = MybatisUtils.sqlSessionFactory().openSession().getMapper(TimeMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	@Test
	public void testGetTime(){
		log.info(mapper.getTime());
	}

}






















