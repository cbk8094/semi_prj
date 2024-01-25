package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게시글 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO { // 게시글
	private Long rowNum; // 순번을 위한 번호
	private Long boardNo; // 게시글번호
	private Long memberNo; // 회원번호
	private String boardCategory; // 카테고리 (notice: 공지, event: 이벤트, faq: 자주묻는질문, qna: 문의)
	private String boardSubCategory; // 서브카테고리 (카테고리별로 다름)
	private String boardTitle; // 제목
	private String boardContent; // 내용
	private String isAnswer; // 답변여부 (문의하기만 사용)
	private String answerContent; // 답변내용 (문의하기만 사용)
	private Date answerDate;
	private Date regDate; // 등록일자
	private String nickname;
	
	// 검색조건
	private String searchTxt;
}
