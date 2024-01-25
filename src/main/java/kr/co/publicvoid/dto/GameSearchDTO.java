package kr.co.publicvoid.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 게임 조건에 대한 DTO

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameSearchDTO {
	@Builder.Default
	private int nowPage = 1; // 현재 페이지 번호 (기본값 1)
	private Long genreNo; // 장르번호
	@Builder.Default
	private int priceLimit = Integer.MAX_VALUE; // 지정 안하면 최대값 (모두)
	private List<String> languageNoList; // 지원언어 리스트
	private boolean isSale; // 할인상품 여부
	private String keyword; // 검색어
	private int offset; // 페이지당 개수
	
	public GameSearchDTO(int nowPage) {
		this.nowPage = nowPage;
		this.offset = (nowPage - 1) * 16;
	}
}
