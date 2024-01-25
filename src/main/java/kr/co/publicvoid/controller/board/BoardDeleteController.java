package kr.co.publicvoid.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.publicvoid.service.BoardService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.BoardVO;
import kr.co.publicvoid.vo.MemberVO;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet{
	private BoardService boardService = BoardService.getInstance();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO memberVO = WebUtils.getMember(req);
		if(memberVO != null) {
			String boardNoStr = req.getParameter("boardNo");
			if(boardNoStr != null) {
				BoardVO boardVO = boardService.selectOne(Long.valueOf(boardNoStr));
				if(boardVO.getMemberNo().equals(memberVO.getMemberNo()) || memberVO.isAdmin()) {
					Long boardNo = Long.parseLong(boardNoStr);
					
					boardService.delete(boardNo);
					resp.sendRedirect("/board/qna");
				}
			}
			WebUtils.alert(resp, "비정상적 접근입니다..","/board/qna");
		}
	}
	
}
