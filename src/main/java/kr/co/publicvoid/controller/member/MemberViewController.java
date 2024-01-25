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

@WebServlet("/member/mypage")
public class MemberViewController extends HttpServlet{
	
	private MemberService memberService = MemberService.getInstance();
	
	// 마이페이지 (누구나 볼 수 있음)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("memberNo") == null) {
			WebUtils.alertBack(resp, "잘못된 접근입니다");
			return;
		}
		
		Long memberNo = Long.parseLong(req.getParameter("memberNo"));
		
		MemberVO memberVO = memberService.getOne(memberNo);
		
		if(memberVO == null) {
			WebUtils.alertBack(resp, "존재하지 않는 회원입니다");
			return;
		}
		
		req.setAttribute("memberVO", memberVO);

		req.getRequestDispatcher(WebUtils.VIEW_PATH + "/member/mypage.jsp").forward(req, resp);
	}
}







