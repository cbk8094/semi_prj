package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게임 언어 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameLanguageVO { // 게임 언어
	private Long gameLanguageNo; // 게임언어번호
	private Long gameNo; // 게임번호
	private Long languageNo; // 언어번호
	private Date regDate; // 등록일자
	
	private String languageName; // 언어명
}
