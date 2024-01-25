package kr.co.publicvoid.controller.wish;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.GameService;
import kr.co.publicvoid.service.WishService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.GameVO;
import kr.co.publicvoid.vo.MemberVO;
import kr.co.publicvoid.vo.WishVO;

@WebServlet("/wish")
public class WishViewController extends HttpServlet{
	private WishService wishService = WishService.getInstance();
	private GameService gameService = GameService.getInstance();
	
	// 해당 회원이 이미 위시리스트에 담았는지 확인 (비동기)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVO memberVO = WebUtils.getLoginMember(req);
		
		if(memberVO == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Long memberNo = memberVO.getMemberNo();

		if(req.getParameter("gameNo") == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Long gameNo = Long.parseLong(req.getParameter("gameNo"));
		GameVO gameVO = gameService.getOne(gameNo);

		if(gameVO == null) {
			WebUtils.jsonPrintREST(resp, false, 1, "존재하지 않는 게임입니다", null);
			return;
		}
		
		// 해당 회원이 이미 위시리스트에 담은 게임인지 확인
		WishVO wishVO = wishService.getOneByMemberNoAndGameNo(memberNo, gameNo);
		
		if(wishVO != null) { // 이미 위시리스트에 있음
			WebUtils.jsonPrintREST(resp, true, 0, "1", null);
		}else { // 위시리스트에 없음
			WebUtils.jsonPrintREST(resp, true, 0, "2", null);
		}
	}
	
}













