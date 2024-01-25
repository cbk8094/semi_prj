package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 알림 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotifyVO { // 알림
	private Long notifyNo; // 알림번호
	private Long memberNo; // 회원번호
	private String notifyContent; // 알림내용
	private boolean isRead; // 읽은여부
	private boolean isDeleted; // 삭제여부
	private Date regDate; // 등록일자
}
