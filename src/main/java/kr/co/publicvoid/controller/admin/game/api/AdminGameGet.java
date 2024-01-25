package kr.co.publicvoid.controller.admin.game.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.publicvoid.service.GameService;
import kr.co.publicvoid.service.SaleService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.GameVO;
import kr.co.publicvoid.vo.MemberVO;
import kr.co.publicvoid.vo.SaleVO;

@WebServlet("/admin/api/getOne")
public class AdminGameGet extends HttpServlet {
	private GameService gameService = GameService.getInstance();
	private SaleService saleService = SaleService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO memberVO = WebUtils.getLoginMember(req);
		
		if(memberVO == null) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		if(memberVO.isAdmin() == false) {
			WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
			return;
		}
		
		Gson gson = new Gson();
		resp.setContentType("application/json; charset=utf-8");

		GameVO gameVO = gameService.getOne(Long.valueOf(req.getParameter("gameNo")));
		SaleVO saleVO = saleService.getOneByGameNo(gameVO.getGameNo());
		gameVO.setSaleVO(saleVO);

		resp.getWriter().print(gson.toJson(gameVO));

	}

}
