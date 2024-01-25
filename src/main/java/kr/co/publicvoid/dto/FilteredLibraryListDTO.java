package kr.co.publicvoid.dto;

import java.util.List;

import kr.co.publicvoid.vo.LibraryVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilteredLibraryListDTO {
	private List<LibraryVO> libraryList;
	private boolean mine;
}
