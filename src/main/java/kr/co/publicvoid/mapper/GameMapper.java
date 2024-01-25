package kr.co.publicvoid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.publicvoid.dto.AdminSearchDTO;
import kr.co.publicvoid.dto.Criteria;
import kr.co.publicvoid.dto.GameSearchDTO;
import kr.co.publicvoid.vo.GameVO;
import kr.co.publicvoid.vo.GenreVO;

public interface GameMapper {
	// 등록
	int insert(GameVO gameVO);
	
	// 수정
	int update(GameVO gameVO);
	
	// 삭제
	int delete(Long gameNo);
	
	// 목록 조회
	List<GameVO> selectList();
	
	// 단일 조회
	GameVO selectOne(Long gameNo);
	
	// 할인 게임 할인율 높은 순으로 4개
	List<GameVO> selectListOrderBySaleRate();
	
	// 최신 게임 (가장 최근에 나온 순) 4개
	List<GameVO> selectListOrderByReleaseDate();
	
	// 무료 게임 4개
	List<GameVO> selectListFree();
	
	// 판매량 높은 순으로 5개
	List<GameVO> selectListOrderBySaleCount();
	
	// 평균 리뷰 점수 높은 순으로 5개
	List<GameVO> selectListOrderByReviewAvg();

	// 게임 판매량 수정
	int updateSaleCount(@Param("gameNo") Long gameNo, @Param("saleCount") int saleCount);
	
	// 조건으로 목록 필터링하여 조회
	List<GameVO> selectListByFilterAndPaging(GameSearchDTO gameSearchDTO);
	
	// 조건으로 목록 필터링하여 조회 관리자 페이지 조회
	List<GameVO> selectListByFilterAndPagingAdmin(AdminSearchDTO adminSearchDTO);
	
	List<GameVO> getListWithPaging(Criteria criteria);
	
	// 게임넘버를 통해서 장르이름을 뽑아먹는 쿼리
	List<GameVO> selectGameGenre(GameVO gameVO, GenreVO genreVO);
	
	// 관리자페이지 페이징처리 
	int getTotal(Criteria criteria);
	
}
