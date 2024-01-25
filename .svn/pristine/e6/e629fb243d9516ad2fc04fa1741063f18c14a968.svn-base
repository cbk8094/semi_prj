package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 장바구니 상품 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemVO { // 장바구니 상품
	private Long cartItemNo; // 장바구니상품번호
	private Long cartNo; // 장바구니번호
	private Long gameNo; // 게임번호
	private Date regDate; // 등록일자
	
	// 추후 DTO로 분리
	private GameVO gameVO;
}
