package kr.co.publicvoid.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.LanguageVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class LanguageMapperTests {
	private LanguageMapper mapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(LanguageMapper.class);

	@Test
	public void testExist(){
		assertNotNull(mapper); // 해당 객체가 null이면 빨간색이 뜨면서 테스트 통과 실패
	}
	
	// 등록 테스트
	@Test
	public void insertTest() {
		LanguageVO languageVO = LanguageVO.builder().languageName("빵상어").build();
		
		log.info(mapper.insert(languageVO));
	}
	
	// 수정 테스트
	@Test
	public void updateTest() {
		LanguageVO languageVO = mapper.selectOne(13L);
		languageVO.setLanguageName("수정된언어명");

		log.info(mapper.update(languageVO));
	}
	
	// 삭제 테스트
	@Test
	public void deleteTest() {
		log.info(mapper.delete(13L));
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
