package kr.co.publicvoid.controller.board;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import kr.co.publicvoid.mapper.BoardMapper;
import kr.co.publicvoid.service.BoardService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.BoardVO;
import kr.co.publicvoid.vo.MemberVO;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

//@Log4j
@Slf4j
@WebServlet("/board/eventwrite")
public class EventWriteController extends HttpServlet{
	private BoardService boardService = BoardService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BoardVO> boardList = boardService.getList(new BoardVO());
		System.out.println(boardService);
//		List<BoardVO> boardList = null;
		
		req.setAttribute("boardList", boardList);

		req.getRequestDispatcher("/WEB-INF/views/board/eventwrite.jsp").forward(req, resp);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		// 한글깨짐 encoding 설정
		req.setCharacterEncoding("utf-8");
		
		
		// 실제 로직
	
		MemberVO memberVO = WebUtils.getLoginMember(req);
		try {
			if(memberVO == null) {
				WebUtils.alert(resp, "로그인해주세요", "/member/login");
				return;
			}
			if(memberVO.isAdmin() == false) {
				WebUtils.alert(resp, "잘못된 접근입니다", "/");
				return;
			} 
		    
		    String boardTitle = req.getParameter("boardTitle");
		    String boardContent = req.getParameter("boardContent");
		    
		    
		    BoardVO board = BoardVO.builder()

			        .boardCategory("event") 
			        .boardTitle(boardTitle)
			        .boardContent(boardContent)
			        .build();
		    
		    // insert query
		    boardService.insert(board);  
		    
		    // event 데이터 재조회(특정 화면으로 이동하고자 하는 경우 재조회를 통해 데이터를 다시 조회하여 넘김)
		    List<BoardVO> boardList = boardService.getList(new BoardVO());
			System.out.println(boardService);
			req.setAttribute("boardList", boardList);
	 		
		}catch(Exception e) {
			e.printStackTrace();
		}
 		resp.sendRedirect("event");
	}
}
