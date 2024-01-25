package kr.co.publicvoid.controller.library;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.dto.FilteredLibraryListDTO;
import kr.co.publicvoid.dto.LibraryFilterDTO;
import kr.co.publicvoid.service.GameService;
import kr.co.publicvoid.service.LibraryService;
import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.GameVO;
import kr.co.publicvoid.vo.LibraryVO;
import kr.co.publicvoid.vo.MemberVO;

@WebServlet("/library/list")
public class LibraryListController extends HttpServlet{
	
	private MemberService memberService = MemberService.getInstance();
	private LibraryService libraryService = LibraryService.getInstance();
	private GameService gameService = GameService.getInstance();
	
	// 특정 회원의 라이브러리. 전부 볼 수 있음 (로그인 안 해도)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("memberNo") == null) {
			WebUtils.alertBack(resp, "잘못된 접근입니다");
			return;
		}
		
		Long memberNo = Long.parseLong(req.getParameter("memberNo"));
		
		MemberVO memberVO = memberService.getOne(memberNo);
		
		MemberVO loginMember = WebUtils.getLoginMember(req);
		
		if(memberVO == null) {
			WebUtils.alertBack(resp, "존재하지 않는 회원입니다");
			return;
		}else {
			if(loginMember != null) {
				if(WebUtils.isSameMember(memberVO, loginMember)) {
					req.setAttribute("mine", true);
				}
			}
		}
		
		req.setAttribute("member", memberVO);
		
		LibraryFilterDTO libraryFilterDTO = LibraryFilterDTO.builder().memberNo(memberNo).build();
		List<LibraryVO> libraryList = libraryService.getListByLibraryFilterDTO(libraryFilterDTO);

		libraryList.stream().map(library -> {
			GameVO gameVO = gameService.getOneReq(library.getGameNo());
			
			library.setGameVO(gameVO);
			
			return library;
		}).collect(Collectors.toList());
		
		req.setAttribute("libraryList", libraryList);

		req.getRequestDispatcher("/WEB-INF/views/library/list.jsp").forward(req, resp);
	}
	
	// 필터링된 리스트 조회
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 조회할 회원 확인
		if(req.getParameter("memberNo") == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Long memberNo = Long.parseLong(req.getParameter("memberNo"));
		
		MemberVO memberVO = memberService.getOne(memberNo);
		
		MemberVO loginMember = WebUtils.getLoginMember(req);
		
		if(memberVO == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		boolean mine = false;

		// 본인 거인지 확인
		if(loginMember != null) {
			if(WebUtils.isSameMember(memberVO, loginMember)) {
				mine = true;
			}
		}
		
		// filterType 확인 (all, hidden, favorite 중 하나)
		if(req.getParameter("filterType") == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		String filterType = (String)req.getParameter("filterType");
		
		// 필터 타입이 hidden인데 조회할 회원이 로그인할 회원 본인이 아닌 경우
		if(filterType.equals("hidden") && !WebUtils.isSameMember(memberVO, loginMember)) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		// filterType이 all, hidden, favorite 중 하나가 아닐 경우
		if(!filterType.equals("all") && !filterType.equals("hidden") && !filterType.equals("favorite")) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}

		LibraryFilterDTO libraryFilterDTO = LibraryFilterDTO.builder().memberNo(memberNo).filterType(filterType).build();
		
		List<LibraryVO> filteredLibraryList = libraryService.getListByLibraryFilterDTO(libraryFilterDTO);
		
		filteredLibraryList.stream().map(library -> {
			GameVO gameVO = gameService.getOne(library.getGameNo());
			
			library.setGameVO(gameVO);
			
			return library;
		}).collect(Collectors.toList());
		
		FilteredLibraryListDTO libraryListDTO = FilteredLibraryListDTO.builder().libraryList(filteredLibraryList).mine(mine).build();

		WebUtils.jsonPrintREST(resp, true, 0, "라이브러리 조회 성공", libraryListDTO);
		return;
	}
}














