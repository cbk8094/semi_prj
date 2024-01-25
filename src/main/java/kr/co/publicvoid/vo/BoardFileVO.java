package kr.co.publicvoid.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 게시글 파일 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
//아래 NoArgsConstructor와 AllArgsConstructor를 해야 IndexOutOfBoundException이 발생하지 않는다.
@NoArgsConstructor
@AllArgsConstructor
public class BoardFileVO { // 게시글 파일
	private Long fileNo; // 파일번호
	private Long boardNo; // 게시글번호
	private String originFileName; // 원본파일명
	private String storedFileName; // 저장파일명
	private boolean isImage; // 이미지여부
	private boolean isThumbnail; // 대표이미지여부
	private Date regDate; // 등록일자
}
