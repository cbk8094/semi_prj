package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 포인트상점 아이템 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemVO { // 포인트상점 아이템
	private Long itemNo; // 아이템번호
	private String itemName; // 아이템명
	private int itemType; // 아이템유형 (0: 프로필액자, 1: 프로필배경)
	private int itemPrice; // 아이템가격
	private boolean isDeleted; // 삭제여부
	private Date regDate; // 등록일자
}
