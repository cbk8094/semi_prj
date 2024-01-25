package kr.co.publicvoid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.publicvoid.dto.LibraryFilterDTO;
import kr.co.publicvoid.vo.LibraryVO;

public interface LibraryMapper {
	// 등록
	int insert(LibraryVO libraryVO);
	
	// 수정
	int update(LibraryVO libraryVO);
	
	// 삭제
	int delete(Long libraryNo);
	
	// 목록 조회
	List<LibraryVO> selectList();
	
	// 단일 조회
	LibraryVO selectOne(Long libraryNo);
	
	// 회원 번호로 목록 조회
	List<LibraryVO> selectListByMemberNo(Long memberNo);

	// 회원 번호로 목록 조회 (3개만)
	List<LibraryVO> selectListByMemberNoLimit3(Long memberNo);
	
	// 회원 번호로 개수 조회
	int selectCountByMemberNo(Long memberNo);
	
	// 회원 번호와 게임 번호로 단일 조회
	LibraryVO selectOneByMemberNoAndGameNo(@Param("memberNo") Long memberNo, @Param("gameNo") Long gameNo);
	
	// libraryFilterDTO로 목록 조회
	List<LibraryVO> selectListByLibraryFilterDTO(LibraryFilterDTO libraryFilterDTO);
	
	// 라이브러리 업데이트 (숨김 처리)
	int updateSetHidden(Long libraryNo);
	
	// 라이브러리 업데이트 (숨김 해제 처리)
	int updateUnsetHidden(Long libraryNo);

	// 라이브러리 업데이트 (즐겨찾기 처리)
	int updateSetFavorite(Long libraryNo);

	// 라이브러리 업데이트 (즐겨찾기 해제 처리)
	int updateUnsetFavorite(Long libraryNo);
	
}




