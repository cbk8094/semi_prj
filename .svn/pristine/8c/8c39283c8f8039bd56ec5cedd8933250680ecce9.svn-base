package kr.co.publicvoid.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.util.WebUtils;

@WebServlet("/member/duplicateId")
public class MemberDuplicateId extends HttpServlet{
	private MemberService memberService = MemberService.getInstance();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String memberId = req.getParameter("memberId");
		
		boolean member = memberService.duplicateId(memberId);
		
		boolean success = !member;
	    int code = success ? 1 : 0;
	    String message = success ? "사용가능한 아이디입니다" : "중복된 아이디입니다";

	    // JSON 응답 메시지 생성 및 전송
	    WebUtils.jsonPrintREST(resp, success, code, message, null);
	}
}
