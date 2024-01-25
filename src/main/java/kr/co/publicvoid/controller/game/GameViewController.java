package kr.co.publicvoid.controller.game;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.CartItemService;
import kr.co.publicvoid.service.CartService;
import kr.co.publicvoid.service.GameService;
import kr.co.publicvoid.service.LibraryService;
import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.service.ReviewService;
import kr.co.publicvoid.service.WishService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.CartItemVO;
import kr.co.publicvoid.vo.CartVO;
import kr.co.publicvoid.vo.LibraryVO;
import kr.co.publicvoid.vo.MemberVO;
import kr.co.publicvoid.vo.WishVO;
import lombok.extern.log4j.Log4j;

@WebServlet("/game/view")
@Log4j
public class GameViewController extends HttpServlet {
	private GameService gameService = GameService.getInstance();
	private ReviewService reviewService = ReviewService.getInstance();
	private WishService wishService = WishService.getInstance();
	private LibraryService libraryService = LibraryService.getInstance();
	private MemberService memberService = MemberService.getInstance();
	private CartService cartService = CartService.getInstance();
	private CartItemService cartItemService = CartItemService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long gameNo = Long.parseLong(req.getParameter("gameNo"));
		
		req.setAttribute("game", gameService.getOne(gameNo));
		req.setAttribute("reviewScoreAvg", reviewService.getAverageScoreByGameNo(gameNo));

		MemberVO memberVO = WebUtils.getLoginMember(req);
		
		if(memberVO != null) {
			LibraryVO libraryVO = libraryService.getOneByMemberNoAndGameNo(memberVO.getMemberNo(), gameNo);
			
			// 이미 라이브러리에 보관 중이면
			if(libraryVO != null) {
				req.setAttribute("isBought", true);
			}
			
			CartVO cartVO = cartService.getOneByMemberNo(memberVO.getMemberNo());
			CartItemVO cartItemVO = null;
			
			boolean result;
			
			// 카트 없으면 만듦
			if(cartVO == null) {
				result = cartService.insert(CartVO.builder().memberNo(memberVO.getMemberNo()).build());
			
				if(result == false) {
					WebUtils.alertBack(resp, "장바구니 생성에 실패했습니다");
				}
			}else { // 장바구니가 있으면 장바구니 아이템 있는지 확인
				cartItemVO = cartItemService.getOneByCartNoAndGameNo(cartVO.getCartNo(), gameNo);
			}
			
			// 이미 장바구니에 보관 중이면
			if(cartItemVO != null) {
				req.setAttribute("isCarted", true);
			}
			
			WishVO wishVO = wishService.getOneByMemberNoAndGameNo(memberVO.getMemberNo(), gameNo);
			
			// 위시리스트에 추가한 상태라면
			if(wishVO != null) {
				req.setAttribute("isWished", true);
			}
		}
		
		req.getRequestDispatcher(WebUtils.VIEW_PATH + "/game/view.jsp").forward(req, resp);
	}
}




