package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 채팅내역 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatVO { // 채팅내역
	private Long chatNo; // 채팅메시지번호
	private Long chatRoomNo; // 채팅방번호
	private Long memberNo; // 회원번호
	private String chatContent; // 채팅내용
	private Date regDate; // 등록일자
}
