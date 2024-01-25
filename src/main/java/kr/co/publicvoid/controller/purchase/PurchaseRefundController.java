package kr.co.publicvoid.controller.purchase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.LibraryService;
import kr.co.publicvoid.service.PurchaseService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.LibraryVO;
import kr.co.publicvoid.vo.MemberVO;
import kr.co.publicvoid.vo.PurchaseVO;

@WebServlet("/purchase/refund")
public class PurchaseRefundController extends HttpServlet{

	private PurchaseService purchaseService = PurchaseService.getInstance();
	private LibraryService libraryService = LibraryService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 현재 로그인한 회원 확인
		MemberVO loginMember = WebUtils.getLoginMember(req);

		if(loginMember == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Long memberNo = loginMember.getMemberNo();
		
		// purchaseNo 넘어왔는지 확인
		if(req.getParameter("purchaseNo") == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		Long purchaseNo = Long.parseLong(req.getParameter("purchaseNo"));
		
		PurchaseVO purchaseVO = purchaseService.getOne(purchaseNo);

		if(purchaseVO == null) {
			WebUtils.jsonPrintREST(resp, false, 1, "존재하지 않는 구매내역입니다", null);
			return;
		}
		
		// 현재 로그인한 회원과 구매내역의 주인이 일치한지 확인
		if(purchaseVO.getMemberNo() != loginMember.getMemberNo()) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		// 라이브러리 번호 확인
		LibraryVO libraryVO = libraryService.getOneByMemberNoAndGameNo(purchaseVO.getMemberNo(), purchaseVO.getGameNo());

		if(libraryVO == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}

		// 구매내역에 가격 마이너스 및 환불로 추가, 라이브러리에서 삭제, 게임 판매량 감소, 회원 누적구매액 및 포인트 감소
		// 포인트 감소 시 구매액의 5% 감소 (원래는 포인트 적립 내역 테이블이 따로 있어야 함)
		
		boolean result = purchaseService.refund(purchaseNo);
		
		if(result == false) {
			WebUtils.jsonPrintREST(resp, false, 1, "환불에 실패했습니다", null);
			return;
		}
		
		// 성공 시 새로고침 시킬 예정
		WebUtils.jsonPrintREST(resp, true, 0, "환불을 완료했습니다", null);
		
	}
}














