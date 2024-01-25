package kr.co.publicvoid.dto;


import lombok.Data;


// 게임 조건에 대한 DTO

@Data
public class AdminSearchDTO {
	
	private final int SHOW_PAGE_COUNT = 10;
	
	private Criteria cri;
	private int total;

	private int startPage;
	private int endPage;

	private boolean next;
	private boolean prev;

	private boolean nexts;
	private boolean prevs;
	
	public AdminSearchDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		endPage = (cri.getPageNum() + (SHOW_PAGE_COUNT-1)) / SHOW_PAGE_COUNT * SHOW_PAGE_COUNT;
		startPage = endPage - (SHOW_PAGE_COUNT-1);
		
		int realEnd = (total + (cri.getAmount()-1)) / cri.getAmount();
		
		if(endPage > realEnd) {
			endPage = realEnd;
		}
		
		next=cri.getPageNum()<realEnd;
		prev=cri.getPageNum()>1&&cri.getPageNum()<=realEnd;
		
		prevs = startPage > 1;
		nexts = endPage < realEnd;
	}
	
}
