package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 채팅방 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomVO { // 채팅방
	private Long chatRoomNo; // 채팅방번호
	private boolean isDeleted; // 삭제여부
	private Date regDate; // 등록일자
	private Date updateDate; // 최신일자
}
