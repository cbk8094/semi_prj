package kr.co.publicvoid.service;

import org.junit.Test;

import kr.co.publicvoid.dto.BoardCriteria2;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardServiceTests {
	private BoardService boardService = BoardService.getInstance();
	
	@Test
	public void testExist() {
		log.info(boardService);
	}
	
	@Test
	public void testGetListByUserno() {
		boardService.getListByMemberno(1L, BoardCriteria2.builder().category("qna").build()).forEach(log::info);;
	}
}
