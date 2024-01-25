package kr.co.publicvoid.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO {
	private final int PAGE_COUNT = 5;
	private CriteriaNew criteria;
	
	private int totalCount;
	private int nowPage;
	private int startPage;
	private int endPage;
	private int realEndPage;

	private boolean next;
	private boolean prev;
	private boolean nexts;
	private boolean prevs;
	
	public PageDTO(CriteriaNew criteria, int totalCount) {
		this.criteria = criteria;
		this.totalCount = totalCount;
		this.nowPage = criteria.getPageNum();
		this.realEndPage = (int) Math.ceil((double)totalCount / criteria.getAmount());

		this.endPage = ((int)Math.ceil((double)criteria.getPageNum() / this.PAGE_COUNT)) * (this.PAGE_COUNT);
		this.startPage = endPage - this.PAGE_COUNT + 1;
		
		if(this.endPage > realEndPage) {
			this.endPage = realEndPage;
		}

		if(this.nowPage > 1) {
			this.prev = true;
		}
		if(this.nowPage < this.realEndPage) {
			this.next = true;
		}
		
		if(this.startPage > 1) {
			this.prevs = true;
		}
		if(this.endPage < this.realEndPage) {
			this.nexts = true;
		}
	}
	
}
