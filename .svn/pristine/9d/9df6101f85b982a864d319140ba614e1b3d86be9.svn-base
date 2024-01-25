package kr.co.publicvoid.controller.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.LibraryService;
import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.LibraryVO;
import kr.co.publicvoid.vo.MemberVO;

// 라이브러리의 옵션 변경 (숨김, 즐겨찾기 처리)
@WebServlet("/library/modify")
public class LibraryModifyController extends HttpServlet{
	private LibraryService libraryService = LibraryService.getInstance();
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
		
		// libraryNo 넘어왔는지 확인
		if(req.getParameter("libraryNo") == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		Long libraryNo = Long.parseLong(req.getParameter("libraryNo"));
		
		LibraryVO libraryVO = libraryService.getOne(libraryNo);

		if(libraryVO == null) {
			WebUtils.jsonPrintREST(resp, false, 1, "존재하지 않는 라이브러리입니다", null);
			return;
		}
		
		// 본인의 라이브러리인지 확인
		if(libraryVO.getMemberNo() != loginMember.getMemberNo()) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}

		// modifyType 확인 (hidden, favorite 중 하나)
		if(req.getParameter("modifyType") == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		String modifyType = (String)req.getParameter("modifyType");
		
		int result = 0;

		// modifyType은 hidden, favorite 중 하나여야 함
		switch(modifyType) {
			case "hidden":
				if(libraryVO.isHidden() == true) { // 이미 hidden인 경우 해제
					result = libraryService.updateUnsetHidden(libraryNo);
				}else { // hidden함
					result = libraryService.updateSetHidden(libraryNo);
				}
				break;
			case "favorite":
				if(libraryVO.isFavorite() == true) { // 이미 favorite인 경우 해제
					result = libraryService.updateUnsetFavorite(libraryNo);
				}else { // favorite함
					result = libraryService.updateSetFavorite(libraryNo);
				}
				break;
			default:
				WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
				return;
		}
		
		if(result > 0) {
			WebUtils.jsonPrintREST(resp, true, 0, "라이브러리 수정에 성공했습니다", null);
		}else {
			WebUtils.jsonPrintREST(resp, false, 2, "라이브러리 수정에 실패했습니다", null);
			return;
		}
		
	}
}












