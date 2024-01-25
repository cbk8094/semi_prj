package kr.co.publicvoid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.publicvoid.vo.CartItemVO;

public interface CartItemMapper {
	// 등록
	int insert(CartItemVO cartItemVO);
	
	// 수정
	int update(CartItemVO cartItemVO);
	
	// 삭제
	int delete(Long cartItemNo);
	
	// 목록 조회
	List<CartItemVO> selectList();
	
	// 단일 조회
	CartItemVO selectOne(Long cartItemNo);
	
	// 장바구니 번호로 목록 조회
	List<CartItemVO> selectListByCartNo(Long cartNo);

	// 장바구니 번호, 게임 번호로 단일 조회
	CartItemVO selectOneByCartNoAndGameNo(@Param("cartNo") Long cartNo, @Param("gameNo") Long gameNo);
}
