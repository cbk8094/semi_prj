package kr.co.publicvoid.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 할인 VO
 * 
 * @author 황정민
 * 231017
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleVO { // 할인
	private Long saleNo; // 할인번호
	private Long gameNo; // 게임번호
	private int saleRate; // 할인율
	private Date saleStartDate; // 할인시작일
	private Date saleEndDate; // 할인종료일
	private Date regDate; // 등록일자
}
