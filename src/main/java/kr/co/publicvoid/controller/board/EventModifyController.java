package kr.co.publicvoid.controller.board;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.BoardService;
import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.BoardVO;
import kr.co.publicvoid.vo.MemberVO;


@WebServlet("/board/eventmodify")
public class EventModifyController extends HttpServlet{
	private BoardService boardService = BoardService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO member = WebUtils.getMember(req);
		if (member != null) {
			String boardNo = req.getParameter("boardNo");
			if (boardNo != null) {
				BoardVO board = boardService.selectOne(Long.valueOf(boardNo));
				System.out.println(boardNo);
				if (board.getMemberNo().equals(member.getMemberNo()) || member.isAdmin()) {
				
				
			
	    
	    // req의 rowNum으로 덮어써서 상세페이지의 rowNum값을 qna의 rowNum으로 나오게
//	    String rowNumStr = req.getParameter("rowNum");
//	    Long rowNum = Long.parseLong(rowNumStr);
	    
	 // QNA 데이터 재조회(특정 화면으로 이동하고자 하는 경우 재조회를 통해 데이터를 다시 조회하여 넘김)
		
	    //해당 boardNo가 PK이기 때문에 row가 하나밖에 안나와서 첫번째 인덱스를 호출
			req.setAttribute("board", board);
			req.getRequestDispatcher("/WEB-INF/views/board/eventmodify.jsp").forward(req, resp);
			}
		}
	}
		WebUtils.alert(resp, "비정상적 접근입니다", req.getContextPath() + "/board/qna");
}	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String boardNo = req.getParameter("boardNo");
		    String boardTitle = req.getParameter("boardTitle");
		    String boardContent = req.getParameter("boardContent");
		    
		    BoardVO board = BoardVO.builder()
			        .boardCategory("event") 
			        .boardTitle(boardTitle)
			        .boardContent(boardContent)
			        .boardNo(Long.valueOf(boardNo))
			        .build();
		    
		    // insert query
		    boardService.update(board);  
		    
		    // event 데이터 재조회(특정 화면으로 이동하고자 하는 경우 재조회를 통해 데이터를 다시 조회하여 넘김)
		    resp.sendRedirect("event");
	}
		
	
}	

