package kr.co.publicvoid.controller.member;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.GameService;
import kr.co.publicvoid.service.GuestbookService;
import kr.co.publicvoid.service.LibraryService;
import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.service.ReviewService;
import kr.co.publicvoid.service.WishService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.GameVO;
import kr.co.publicvoid.vo.GuestbookVO;
import kr.co.publicvoid.vo.LibraryVO;
import kr.co.publicvoid.vo.MemberVO;
import kr.co.publicvoid.vo.ReviewVO;
import kr.co.publicvoid.vo.WishVO;
import lombok.extern.log4j.Log4j;

@WebServlet("/member/profile")
@Log4j
public class MemberProfileController extends HttpServlet {
	
	private MemberService memberService = MemberService.getInstance();
	private ReviewService reviewService = ReviewService.getInstance();
	private LibraryService libraryService = LibraryService.getInstance();
	private WishService wishService = WishService.getInstance();
	private GuestbookService guestbookService = GuestbookService.getInstance();
	private GameService gameService = GameService.getInstance();

	// 프로필 페이지
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("memberNo") == null) {
			WebUtils.alertBack(resp, "잘못된 접근입니다");
			return;
		}
		
		Long memberNo = Long.parseLong(req.getParameter("memberNo"));
		
		MemberVO member = memberService.getOne(memberNo); // 현재 페이지 주인 회원
		
		MemberVO loginMember = WebUtils.getLoginMember(req); // 로그인 중인 회원
		
		if(member == null) { // 없으면
			WebUtils.alertBack(resp, "존재하지 않는 회원입니다");
			return;
		}
		
		// 해당 회원 라이브러리 개수
		int libraryCount = libraryService.getCountByMemberNo(memberNo);
		
		// 해당 회원 평가 개수
		int reviewCount = reviewService.getCountByMemberNo(memberNo);
		
		// 해당 회원 위시리스트 개수
		int wishCount = wishService.getCountByMemberNo(memberNo);
		
		// 해당 회원 평균 평가 점수
		double reviewAvgScore = reviewService.getAverageScoreByMemberNo(memberNo);

		// 해당 회원의 라이브러리
		List<LibraryVO> libraryList = libraryService.getListByMemberNoLimit3(memberNo);
		libraryList.stream().map(library -> {
			GameVO gameVO = gameService.getOneReq(library.getGameNo());
			
			library.setGameVO(gameVO);
			
			return library;
		}).collect(Collectors.toList());
		
		// 해당 회원의 평가
		List<ReviewVO> reviewList = reviewService.getListByMemberNoLimit3(memberNo);
		reviewList.stream().map(review -> {
			GameVO gameVO = gameService.getOneReq(review.getGameNo());
			
			review.setGameVO(gameVO);
			
			return review;
		}).collect(Collectors.toList());
		
		// 해당 회원의 위시리스트
		List<WishVO> wishList = wishService.getListByMemberNoLimit3(memberNo);
		wishList.stream().map(wish -> {
			GameVO gameVO = gameService.getOneReq(wish.getGameNo());
			
			wish.setGameVO(gameVO);
			
			return wish;
		}).collect(Collectors.toList());
		
		// 해당 회원의 방명록
		List<GuestbookVO> guestbookList = guestbookService.getListByMemberNo(memberNo);
		guestbookList.stream().map(guestbook -> {
			MemberVO memberVO = memberService.getOne(guestbook.getWriterNo());
			
			guestbook.setMemberVO(memberVO);
			
			return guestbook;
		}).collect(Collectors.toList());
		
		if(loginMember != null) {
			if(WebUtils.isSameMember(member, loginMember)) { // 자기 거면
				req.setAttribute("mine", true);
			}
		}
		
		req.setAttribute("libraryCount", libraryCount);
		req.setAttribute("reviewCount", reviewCount);
		req.setAttribute("wishCount", wishCount);
		
		req.setAttribute("reviewAvgScore", reviewAvgScore);
		
		req.setAttribute("libraryList", libraryList);
		req.setAttribute("reviewList", reviewList);
		req.setAttribute("wishList", wishList);
		req.setAttribute("guestbookList", guestbookList);
		
		req.setAttribute("member", member);
		req.getRequestDispatcher(WebUtils.VIEW_PATH + "/member/profile.jsp").forward(req, resp);
		
	}
	
	// 프로필 수정(닉네임, 자기소개)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("memberNo") == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Long memberNo = Long.parseLong(req.getParameter("memberNo"));
		
		MemberVO memberVO = memberService.getOne(memberNo);

		if(memberVO == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "존재하지 않는 회원입니다", null);
			return;
		}
		
		MemberVO loginMember = WebUtils.getLoginMember(req);
		
		if(loginMember == null) {
			WebUtils.jsonPrintREST(resp, false, 1, "로그인해주세요", null);
			return;
		}
		
		if(!WebUtils.isSameMember(memberVO, loginMember)) {
			WebUtils.jsonPrintREST(resp, false, 2, "잘못된 접근입니다", null);
			return;
		}
		
		int result = 0;
		
		log.info(req.getParameter("memberNickname"));
		log.info(req.getParameter("memberIntroduce"));
		
		if(req.getParameter("memberNickname") != null) {
			loginMember.setMemberNickname((String)req.getParameter("memberNickname"));
			result = memberService.modify(loginMember);
		}
		
		if(req.getParameter("memberIntroduce") != null) {
			loginMember.setMemberIntroduce((String)req.getParameter("memberIntroduce"));
			result = memberService.modify(loginMember);
		}
		
		if(result > 0) {
			WebUtils.jsonPrintREST(resp, true, 0, "성공", loginMember);
		}else {
			WebUtils.jsonPrintREST(resp, false, 3, "회원정보 수정에 실패했습니다", null);
		}
	}
}
