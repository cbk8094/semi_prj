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

@WebServlet("/member/logout")
public class MemberLogoutController extends HttpServlet {
	private MemberService memberService = MemberService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO memberVO = (MemberVO) req.getSession().getAttribute("member");
		
		if(memberVO == null) {
			WebUtils.alertBack(resp, "이미 로그아웃하신 상태입니다");
		}else {
			req.setAttribute("status", "로그인 함");
			
			req.getSession().invalidate();

			WebUtils.alert(resp, "로그아웃하셨습니다", "/");
		}
	
	}
}
