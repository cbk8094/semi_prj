package kr.co.publicvoid.controller.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.GameService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.GameVO;
import lombok.extern.log4j.Log4j;

@WebServlet("")
@Log4j
public class MainController extends HttpServlet{
	
	private GameService gameService = GameService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 인기 게임 5개 (이건 원래 관리자에서 선택할 수 있게 해야 하지만 일단 임의로 고르겠음)
		// 874, 843, 811, 1165, 1158
		
		List<Long> gameNoList = new ArrayList<Long>(Arrays.asList(874L, 843L, 811L, 1165L, 1158L));
		List<GameVO> mainGameList = new ArrayList<GameVO>();
		
		gameNoList.forEach(gameNo -> {
			GameVO mainGameVO = gameService.getOneReq(gameNo);
			mainGameList.add(mainGameVO);
		});
		
		// 할인 게임 할인율 높은 순으로 4개
		List<GameVO> saleGameList = gameService.getListOrderBySaleRate();

		// 최신 게임 (가장 최근에 나온 순) 4개
		List<GameVO> recentGameList = gameService.getListOrderByReleaseDate();
		
		// 무료 게임 4개
		List<GameVO> freeGameList = gameService.getListFree();
		
		// 판매량 높은 순으로 5개 (세로로 배열)
		List<GameVO> popularGameList = gameService.getListOrderBySaleCount();
		
		// 평균 리뷰 점수 높은 순으로 5개 (세로로 배열)
		List<GameVO> reviewGameList = gameService.getListOrderByReviewAvg();

		req.setAttribute("mainGameList", mainGameList);
		req.setAttribute("saleGameList", saleGameList);
		req.setAttribute("recentGameList", recentGameList);
		req.setAttribute("freeGameList", freeGameList);
		req.setAttribute("popularGameList", popularGameList);
		req.setAttribute("reviewGameList", reviewGameList);
		
		req.getRequestDispatcher(WebUtils.VIEW_PATH + "/main/index.jsp").forward(req, resp);
	}
}


















