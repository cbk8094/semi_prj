package kr.co.publicvoid.controller.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.CartItemService;
import kr.co.publicvoid.service.CartService;
import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.CartItemVO;
import kr.co.publicvoid.vo.CartVO;
import kr.co.publicvoid.vo.MemberVO;

@WebServlet("/cart/delete")
public class CartDeleteController extends HttpServlet{

	private CartService cartService = CartService.getInstance();
	private CartItemService cartItemService = CartItemService.getInstance();
	private MemberService memberService = MemberService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVO loginMember = WebUtils.getLoginMember(req);
		
		if(loginMember == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Long memberNo = loginMember.getMemberNo();
		
		if(req.getParameter("cartItemNo") == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Long cartItemNo = Long.parseLong(req.getParameter("cartItemNo"));
		
		CartItemVO cartItemVO = cartItemService.getOne(cartItemNo);
		
		if(cartItemVO == null) {
			WebUtils.jsonPrintREST(resp, false, 1, "이미 장바구니에 존재하지 않습니다", null);
			return;
		}

		// 해당 장바구니 아이템이 특정 회원의 것인지 조회 (cartNo가 같은지 조회한다)
		CartVO memberCartVO = cartService.getOneByMemberNo(memberNo);

		if(memberCartVO.getCartNo() != cartItemVO.getCartNo()) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
	
		// 특정 회원의 장바구니에 담긴 장바구니 아이템 지우기

		int result = cartItemService.delete(cartItemNo);

		if(result == 0) {
			WebUtils.jsonPrintREST(resp, false, 2, "장바구니 상품 삭제에 실패했습니다", null);
			return;
		}

		WebUtils.jsonPrintREST(resp, true, 0, "장바구니에 상품이 삭제되었습니다", null);
		
	}
}

















