package kr.co.publicvoid.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.dto.BoardCriteria2;
import kr.co.publicvoid.dto.BoardPageDTO;
import kr.co.publicvoid.service.BoardService;
import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.BoardVO;
import kr.co.publicvoid.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@WebServlet("/board/event")
@Log4j
public class EventController extends HttpServlet {
	private BoardService boardService = BoardService.getInstance();
	private MemberService memberService = MemberService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		MemberVO member = memberService.getOne(1L);
		MemberVO member = WebUtils.getMember(req);
		String pageNum = req.getParameter("pageNum");
		String amount = req.getParameter("amount");
		
		log.info("===================");
		log.info("pageNum : " + pageNum);
		log.info("===================");
		
		BoardCriteria2.BoardCriteria2Builder cb = BoardCriteria2.builder();
		
		if (pageNum != null) {
			cb.pageNum(Integer.parseInt(pageNum));
		}
		
		if (amount != null) {
			cb.amount(Integer.parseInt(amount));
		}
		
		cb.category("event");

		String boardSubCategory = req.getParameter("boardSubCategory");
		 BoardVO board = BoardVO.builder()
		    		.boardCategory("event")
		    		.boardSubCategory(boardSubCategory)
		    		.build();
			
	    List<BoardVO> boardList = boardService.getList(board);
		System.out.println(boardService);

		
//		req.getSession().setAttribute("member", member);
		
		BoardCriteria2 boardCriteria = cb.build();
		
//		List<BoardVO> boardList = boardService.getListByMemberno2(member.getMemberNo(), boardCriteria);
		
		req.setAttribute("boardList", boardList);
		req.setAttribute("BoardPageDTO", new BoardPageDTO(boardCriteria, boardService.getCount(boardCriteria)));
//		req.setAttribute("boardList", boardList);

		req.getRequestDispatcher("/WEB-INF/views/board/event.jsp").forward(req, resp);
	}
}