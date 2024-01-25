package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 구매내역 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseVO { // 구매내역
	private Long purchaseNo; // 구매내역번호 
	private Long memberNo; // 회원번호
	private Long gameNo; // 게임번호
	private int purchasePrice; // 구매가격
	private Date purchaseDate; // 구매일자
	private boolean isRefund; // 환불여부
	private Long refundPurchaseNo; // 환불했으면 그 환불한 구매내역 번호
	private Date regDate; // 등록일자
	
	private GameVO gameVO; // 게임 정보
	private boolean hasRefund; // 환불내역을 보유한 구매내역인지 여부
}
