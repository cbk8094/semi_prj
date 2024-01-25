package kr.co.publicvoid.controller.wish;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.GameService;
import kr.co.publicvoid.service.LibraryService;
import kr.co.publicvoid.service.WishService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.GameVO;
import kr.co.publicvoid.vo.LibraryVO;
import kr.co.publicvoid.vo.MemberVO;
import kr.co.publicvoid.vo.WishVO;

@WebServlet("/wish/add")
public class WishRegisterController extends HttpServlet{
	private WishService wishService = WishService.getInstance();
	private GameService gameService = GameService.getInstance();
	private LibraryService libraryService = LibraryService.getInstance();
	
	// 위시리스트에 등록 및 삭제
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVO memberVO = WebUtils.getLoginMember(req);
		
		if(memberVO == null) {
			WebUtils.jsonPrintREST(resp, false, 5, "로그인해주세요", null);
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

		// 해당 회원이 이미 갖고 있는 게임인지 확인
		LibraryVO libraryVO = libraryService.getOneByMemberNoAndGameNo(memberNo, gameNo);
		if(libraryVO != null) { // 이미 갖고 있음
			WebUtils.jsonPrintREST(resp, false, 4, "이미 가지고 있는 게임입니다", null);
			return;
		}
		
		// 해당 회원이 이미 위시리스트에 담은 게임인지 확인
		WishVO wishVO = wishService.getOneByMemberNoAndGameNo(memberNo, gameNo);
		
		if(wishVO != null) { // 위시리스트에 있음 (위시리스트에서 지우기)
			int result = wishService.delete(wishVO.getWishNo());
			
			if(result > 0) {
				WebUtils.jsonPrintREST(resp, true, 0, "2", null);
				return;
			}else {
				WebUtils.jsonPrintREST(resp, false, 2, "위시리스트 삭제에 실패했습니다", null);
				return;
			}
		}else { // 위시리스트에 없음 (위시리스트에 추가)
			wishVO = WishVO.builder().memberNo(memberNo).gameNo(gameNo).build();
			
			int result = wishService.register(wishVO);

			if(result > 0) {
				WebUtils.jsonPrintREST(resp, true, 0, "1", null);
				return;
			}else {
				WebUtils.jsonPrintREST(resp, false, 3, "위시리스트 추가에 실패했습니다", null);
				return;
			}
		}
		
	}
}





















