package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 라이브러리 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibraryVO { // 라이브러리
	private Long libraryNo; // 라이브러리번호
	private Long memberNo; // 회원번호
	private Long gameNo; // 게임번호
	private boolean isHidden; // 숨김여부
	private boolean isFavorite; // 즐겨찾기여부
	private Date regDate; // 등록일자
	
	private GameVO gameVO; // 게임 정보
}
