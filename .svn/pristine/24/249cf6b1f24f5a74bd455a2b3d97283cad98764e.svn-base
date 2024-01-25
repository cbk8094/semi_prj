package kr.co.publicvoid.controller.cart;

import java.io.IOException;
import java.util.List;

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
import kr.co.publicvoid.service.PurchaseService;
import kr.co.publicvoid.service.SaleService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.CartItemVO;
import kr.co.publicvoid.vo.CartVO;
import kr.co.publicvoid.vo.LibraryVO;
import kr.co.publicvoid.vo.MemberVO;

@WebServlet("/cart/order")
public class CartOrderController extends HttpServlet{

	private CartService cartService = CartService.getInstance();
	private CartItemService cartItemService = CartItemService.getInstance();
	private GameService gameService = GameService.getInstance();
	private MemberService memberService = MemberService.getInstance();
	private SaleService saleService = SaleService.getInstance();
	private PurchaseService purchaseService = PurchaseService.getInstance();
	private LibraryService libraryService = LibraryService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVO loginMember = WebUtils.getLoginMember(req);
		
		if(loginMember == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Long memberNo = loginMember.getMemberNo();
		
		CartVO cartVO = cartService.getOneByMemberNo(memberNo);
		cartVO.setMemberVO(loginMember);
		
		List<CartItemVO> cartItemList = cartItemService.getListByCartNo(cartVO.getCartNo());
		
		// 주문할 게 하나라도 있는지만 확인하고 바로 Service 호출
		if(cartItemList.size() == 0) {
			WebUtils.jsonPrintREST(resp, false, 0, "구매할 상품이 존재하지 않습니다", null);
			return;
		}

		// 순회하면서 하나라도 이미 라이브러리에 존재하면 화면 새로고침하게 하기
		for (CartItemVO cartItem : cartItemList) {
		    LibraryVO libraryVO = libraryService.getOneByMemberNoAndGameNo(memberNo, cartItem.getGameNo());
		    
		    // 이미 라이브러리에 존재하는 상품이 있으면
		    if (libraryVO != null) {
		        WebUtils.jsonPrintREST(resp, false, 2, "이미 라이브러리에 존재하는 상품이 있습니다", null);
		        return;
		    }
		}
		
		// cartItem 순회하면서 구매내역에 추가, 게임 판매량 증가, 장바구니 상품 삭제, 회원 누적구매액 및 포인트 증가, 찜에 있으면 찜 리스트에서 삭제
		// 이 부분은 해당 Service 내에서 하게 한다.
		boolean result = cartService.orderCart(cartVO.getCartNo());
		
		if(result == false) {
			WebUtils.jsonPrintREST(resp, false, 1, "상품 구매에 실패했습니다", null);
			return;
		}
		
		// 성공 시 라이브러리로 가게 할 것임
		WebUtils.jsonPrintREST(resp, true, 0, "상품 구매를 완료했습니다", null);
	}
}





















