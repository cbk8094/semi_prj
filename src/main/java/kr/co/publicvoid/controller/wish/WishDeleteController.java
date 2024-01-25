package kr.co.publicvoid.controller.wish;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.service.WishService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.MemberVO;
import kr.co.publicvoid.vo.WishVO;

@WebServlet("/wish/delete")
public class WishDeleteController extends HttpServlet{

	private WishService wishService = WishService.getInstance();
	private MemberService memberService = MemberService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// memberNo 확인 및 로그인한 회원과 같은지 확인
		if(req.getParameter("memberNo") == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Long memberNo = Long.parseLong(req.getParameter("memberNo"));
		MemberVO memberVO = memberService.getOne(memberNo); // 값으로 넘어온 회원
		
		MemberVO loginMember = WebUtils.getLoginMember(req); // 로그인한 회원
		if(loginMember == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		if(!WebUtils.isSameMember(memberVO, loginMember)) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		// wishNo 확인
		if(req.getParameter("wishNo") == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Long wishNo = Long.parseLong(req.getParameter("wishNo"));
		
		WishVO wishVO = wishService.getOne(wishNo);
		
		if(wishVO == null) {
			WebUtils.jsonPrintREST(resp, false, 1, "해당 위시리스트가 존재하지 않습니다", null);
			return;
		}

		// 해당 위시리스트가 특정 회원의 것인지 조회 (memberNo가 같은지 조회한다)
		if(wishVO.getMemberNo() != loginMember.getMemberNo()) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
	
		// 위시리스트 삭제
		int result = wishService.delete(wishNo);

		if(result > 0) {
			WebUtils.jsonPrintREST(resp, true, 0, "위시리스트 삭제 성공", null);
		}else {
			WebUtils.jsonPrintREST(resp, false, 2, "위시리스트 삭제에 실패했습니다", null);
		}
		
	}
}
