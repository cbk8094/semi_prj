package kr.co.publicvoid.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.BoardService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.BoardVO;
import kr.co.publicvoid.vo.MemberVO;

@WebServlet("/board/faq")
public class BoardFaqController extends HttpServlet{
	private BoardService boardService = BoardService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<BoardVO> boardList = boardService.getList();
		System.out.println(boardService);
		
		String boardSubCategory = req.getParameter("boardSubCategory");
		 BoardVO board = BoardVO.builder()
		    		.boardCategory("faq")
		    		.boardSubCategory(boardSubCategory)
		    		.build();
			
	    List<BoardVO> boardList = boardService.getList(board);
		System.out.println(boardService);

		
		req.setAttribute("boardList", boardList);

		req.getRequestDispatcher("/WEB-INF/views/board/faq.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String boardSubCategory = req.getParameter("boardSubCategory");
	    String searchTxt = req.getParameter("searchTxt");
	    
	 
	    BoardVO board = BoardVO.builder()
	    		.boardCategory("faq")
	    		.boardSubCategory(boardSubCategory)
	    		
	    		// 검색조건 (title, content)
	    		.searchTxt(searchTxt)
	    		.build();
	    
	
	    List<BoardVO> boardList = boardService.getList(board);
		System.out.println(boardService);
		
//		resp.setContentType("text/html; charset=UTF-8");
//		resp.getWriter().print(boardList);
		
		// faqDataList만 따로 가져옴
		req.setAttribute("boardList", boardList);
		req.getRequestDispatcher("/WEB-INF/views/board/faqDataList.jsp").forward(req, resp);
		
	}
	
}