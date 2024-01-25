package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 포인트상점 회원 아이템 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberItemVO { // 포인트상점 회원 아이템
	private Long memberItemNo; // 회원아이템번호
	private Long memberNo; // 회원번호
	private Long itemNo; // 아이템번호
	private Date regDate; // 등록일자
}
