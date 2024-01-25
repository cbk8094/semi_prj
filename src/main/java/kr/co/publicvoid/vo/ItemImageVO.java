package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 포인트상점 아이템 이미지 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemImageVO { // 포인트상점 아이템 이미지
	private Long fileNo; // 파일번호
	private Long itemNo; // 아이템번호
	private String originFileName; // 원본파일명
	private String storedFileName; // 저장파일명
	private Date regDate; // 등록일자
}
