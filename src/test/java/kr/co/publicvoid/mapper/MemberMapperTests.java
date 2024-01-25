package kr.co.publicvoid.mapper;

import org.junit.Test;

import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.MemberVO;
import lombok.Builder;
import lombok.extern.log4j.Log4j;


@Log4j
public class MemberMapperTests {
	private MemberMapper memberMapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(MemberMapper.class);
	private MemberService memberService = MemberService.getInstance();
	
	// 생성 테스트
	// 회원 코드 자동 부여
	// 중복일 경우 새로운 번호 부여
	@Test
	public void testCreate() {
		MemberVO vo = 
				MemberVO
				.builder()
				.memberCode(memberService.newMemberCode())
				.memberId("aa1047")
				.memberPw("1234")
				.memberNickname("bb1047")
				.build();
		memberMapper.insert(vo);
	}
	
	// 단일 조회 테스트
	@Test
	public void testSelectOne() {
		log.info(memberMapper.read(4L));
	}

	@Test
	public void testSelectOne2() {
		log.info(memberMapper.read2("ddd@naver.com"));
	}

	// 전체 조회 테스트
	@Test
	public void testGetList() {
		log.info(memberMapper.getList());
	}
	
	// 업데이트 테스트
	@Test	
	public void testUpdate() {
//		MemberVO vo = memberMapper.read(4L);
		MemberVO vo = memberMapper.read2("ddd@naver.com");
//		vo.setMemberPw("1234");
//		vo.setMemberId("ddd@naver.com");
		vo.setMemberIntroduce("안녕하세요..");
		memberMapper.update(vo);
	}
	
	// 삭제 테스트
	@Test
	public void testDelete() {
		memberMapper.delete(19L);
	}
	
	// 회원 코드 조회 테스트
	@Test
	public void testCodeUseing() {
		String rc = memberService.randomMemberCode();
		log.info(rc);
		log.info(memberMapper.codeCnt(rc));
	}
	
	// 회원 코드 이퀄문 여부 테스트
	@Test
	public void testIsDuplicateMemberCodes() {
		String rc = memberService.randomMemberCode();
		log.info(rc);
		if(memberMapper.codeCnt(rc).equals(0)) {
			log.info("중복입니다");
		}
	}
	
	// 회원 코드 중복 조회 테스트
	@Test
	public void testNewMemberCode() {
		log.info(memberService.newMemberCode());
	}
	
	
	// 로그인 테스트
	@Test
	public void testLogin() {
		MemberVO vo = 
				MemberVO.builder()
					.memberId("ddd@naver.com")
					.memberPw("124")
					.build();
		log.info(memberMapper.findIdPw(vo));
	}
	
	// 관리자 여부 테스트
	@Test
	public void testIsAdmin() {
		MemberVO vo = 
				MemberVO.builder()
					.memberNo(4L)
					.build();
		log.info(memberMapper.isAdmin(vo.getMemberNo()));
		log.info(memberService.isAdmin(vo));
	}
	
	
	
}
