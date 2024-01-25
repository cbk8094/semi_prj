package kr.co.publicvoid.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.MemberVO;

@WebServlet("/member/signup")
public class MemberSignupController extends HttpServlet {
	private MemberService memberService = MemberService.getInstance();

	// 회원가입 폼 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/signup.jsp").forward(req, resp);
	}

	// 회원가입 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String memberId = req.getParameter("memberId"); // UK, 이메일 형식 수집
		String memberNickname = req.getParameter("memberNickname"); // 중복 가능한 형태
		String memberPw = req.getParameter("memberPw");
		
		MemberVO memberVO = MemberVO
				.builder()
				.memberCode(memberService.newMemberCode())
				.memberId(memberId)
				.memberNickname(memberNickname)
				.memberPw(memberPw)
				.build();
		
		System.out.println(memberVO);
		
		req.setAttribute("duplicateId", memberService.duplicateId(memberId)); 
		
		memberService.signup(memberVO);
		
		WebUtils.alert(resp, "가입을 축하합니다", "/member/login");
	}
}
