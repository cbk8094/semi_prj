package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게임 리뷰 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVO { // 게임 리뷰
	private Long reviewNo; // 리뷰번호
	private Long gameNo; // 게임번호
	private Long memberNo; // 회원번호
	private int reviewScore; // 평점
	private String reviewContent; // 리뷰내용
	private Date regDate; // 등록일자
	
	// 추후 DTO로 분리
	private MemberVO memberVO; // 해당 회원
	private GameVO gameVO; // 게임 정보
}
