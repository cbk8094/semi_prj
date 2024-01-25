package kr.co.publicvoid.dto;

import java.util.List;

import kr.co.publicvoid.vo.ReviewVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewListDTO {
	// 페이징 정보를 포함한 리뷰 목록 DTO
	private List<ReviewVO> reviewList;
	private PageDTO pageDTO;
}
