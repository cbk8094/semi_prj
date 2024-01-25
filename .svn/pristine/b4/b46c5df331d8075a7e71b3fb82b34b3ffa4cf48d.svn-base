package kr.co.publicvoid.controller.review;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.dto.CriteriaNew;
import kr.co.publicvoid.dto.PageDTO;
import kr.co.publicvoid.dto.ReviewListDTO;
import kr.co.publicvoid.service.GameService;
import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.service.ReviewService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.GameVO;
import kr.co.publicvoid.vo.MemberVO;
import kr.co.publicvoid.vo.ReviewVO;
import lombok.extern.log4j.Log4j;

@WebServlet("/review/list")
@Log4j
public class ReviewListController extends HttpServlet{
	
	private ReviewService reviewService = ReviewService.getInstance();
	private MemberService memberService = MemberService.getInstance();
	private GameService gameService = GameService.getInstance();
	
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
		
		CriteriaNew criteria = new CriteriaNew();
		
		if(req.getParameter("pageNum") != null) { // pageNum 기본값 1
			criteria.setPageNum(Integer.parseInt(req.getParameter("pageNum")));
		}
		
		int reviewCount = reviewService.getCountByMemberNo(memberNo);
		
		PageDTO pageDTO = new PageDTO(criteria, reviewCount);
		
//		List<ReviewVO> reviewList = reviewService.getListByMemberNo(memberNo);
		List<ReviewVO> reviewList = reviewService.getListByMemberNoWithPaging(criteria, memberNo);
		reviewList.stream().map(review -> {
			GameVO gameVO = gameService.getOneReq(review.getGameNo());
			
			review.setGameVO(gameVO);
			
			return review;
		}).collect(Collectors.toList());
		
		req.setAttribute("reviewList", reviewList);
		req.setAttribute("pageDTO", pageDTO);

		req.getRequestDispatcher(WebUtils.VIEW_PATH + "/review/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if(req.getParameter("gameNo") == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Long gameNo = Long.parseLong(req.getParameter("gameNo"));
		
		// 리뷰 조회 시 페이징 이용할 것임
		CriteriaNew criteria = CriteriaNew.builder().amount(5).build();
		
		if(req.getParameter("pageNum") != null) { // pageNum 기본값 1
			criteria.setPageNum(Integer.parseInt(req.getParameter("pageNum")));
		}
		
		int reviewCount = reviewService.getCountByGameNo(gameNo);
		
		PageDTO pageDTO = new PageDTO(criteria, reviewCount);
		
		// 해당 게임의 리뷰 조회
		List<ReviewVO> reviewList = reviewService.getListByGameNoWithPaging(criteria, gameNo);

		// review를 순회하며 해당 회원의 리뷰 개수를 조회하여 set함
		reviewList.stream().map(review -> {
			review.setMemberVO(memberService.getOne(review.getMemberNo()));
			
			return review;
		}).collect(Collectors.toList());
		
		ReviewListDTO reviewListDTO = new ReviewListDTO();
		reviewListDTO.setReviewList(reviewList);
		reviewListDTO.setPageDTO(pageDTO);
		
		WebUtils.jsonPrintREST(resp, true, 0, "댓글 목록 조회 성공", reviewListDTO);
		return;
	}
	
}


















