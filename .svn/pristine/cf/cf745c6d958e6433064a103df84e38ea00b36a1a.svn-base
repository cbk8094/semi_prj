package kr.co.publicvoid.controller.game;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.dto.GameSearchDTO;
import kr.co.publicvoid.service.GameService;
import kr.co.publicvoid.service.GenreService;
import kr.co.publicvoid.service.LanguageService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.GameVO;
import lombok.extern.log4j.Log4j;

@WebServlet("/game/list")
@Log4j
public class GameListController extends HttpServlet {
	
	private GameService gameService = GameService.getInstance();
	private GenreService genreService = GenreService.getInstance();
	private LanguageService languageService = LanguageService.getInstance();

	// 전체 목록 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		GameSearchDTO gameSearchDTO = new GameSearchDTO();
		
		if(req.getParameter("searchWord") != null) {
			gameSearchDTO.setKeyword(req.getParameter("searchWord"));
			req.setAttribute("searchWord", req.getParameter("searchWord"));
		}
		
		req.setAttribute("gameList", gameService.getFilteredAndPagingList(gameSearchDTO));
		req.setAttribute("genreList", genreService.getList());
		req.setAttribute("languageList", languageService.getList());
		
		req.getRequestDispatcher("/WEB-INF/views/game/list.jsp").forward(req, resp);
	}
	
	// 페이징 및 필터링된 목록 조회
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GameSearchDTO gameSearchDTO = new GameSearchDTO(Integer.parseInt(req.getParameter("nowPage")));
		
		gameSearchDTO.setKeyword(req.getParameter("title"));
		gameSearchDTO.setGenreNo(Long.parseLong(req.getParameter("genre")));
		gameSearchDTO.setPriceLimit(Integer.parseInt(req.getParameter("price")));

		List<String> languageNoList = null;
		if(req.getParameter("language").length() > 0) {
			String[] languageNoArr = req.getParameter("language").split("\\|");
			languageNoList = Arrays.asList(languageNoArr); 
		}
		gameSearchDTO.setLanguageNoList(languageNoList);
		gameSearchDTO.setSale(req.getParameter("sale").equals("1") ? true : false);
		
		log.info(gameSearchDTO);
		
		List<GameVO> gameList = gameService.getFilteredAndPagingList(gameSearchDTO);
		
		WebUtils.jsonPrint(resp, gameList);
		
	}
}








