package kr.co.publicvoid.dto;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CriteriaNew {
	@Builder.Default
	private int pageNum = 1;
	@Builder.Default
	private int amount = 12;
	
	public int getOffset(){
		return (pageNum - 1) * amount;
	}
	
}
