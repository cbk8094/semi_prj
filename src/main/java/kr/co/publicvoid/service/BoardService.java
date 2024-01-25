package kr.co.publicvoid.service;

import java.util.List;

import kr.co.publicvoid.dto.BoardCriteria2;
import kr.co.publicvoid.mapper.BoardMapper;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardService {
	private static final BoardService INSTANCE  = new BoardService();
	
	private BoardService() {}
	
	public static BoardService getInstance() {
		return INSTANCE;
	}
	
	private BoardMapper boardMapper = MybatisUtils.sqlSessionFactory().openSession(true).getMapper(BoardMapper.class);
	 
	public List<BoardVO> getList(BoardVO vo) {
		return boardMapper.getList(vo);
	}
	public List<BoardVO> getListByMemberno(Long memberno, BoardCriteria2 criteria2) {
		log.info(criteria2);
		return boardMapper.getListByMemberno(memberno, criteria2);
	}
	public List<BoardVO> getListByMemberno2(Long memberno, BoardCriteria2 criteria2) {
		log.info(criteria2);
		return boardMapper.getListByMemberno2(memberno, criteria2);
	}
	
	public void insert(BoardVO vo) {
		boardMapper.insert(vo);
	}
	public void update(BoardVO vo) {
		boardMapper.update(vo);
	}
	public BoardVO selectOne(long boardNo) {
		BoardVO boardVO = boardMapper.selectOne(boardNo);
		return boardVO;
	}
	public int delete(Long boardNo) {
	    BoardVO boardVO = boardMapper.selectOne(boardNo);

	    if (boardVO == null) {
	        return 0;
	    } else {
	        int result = boardMapper.delete(boardNo);
	        return result;
	    }
	}
	public List<BoardVO> getListQna(BoardVO vo) {
		return boardMapper.getListQna(vo);
	}
	public int getCount(BoardCriteria2 boardCriteria2) {
		return boardMapper.getCount(boardCriteria2);
	}
}
