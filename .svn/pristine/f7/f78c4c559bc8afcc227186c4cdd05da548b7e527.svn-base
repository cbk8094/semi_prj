package kr.co.publicvoid.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.publicvoid.mapper.CartItemMapper;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.CartItemVO;

public class CartItemService {
	public static final CartItemService INSTANCE = new CartItemService();

	private CartItemService() {}
	
	public static CartItemService getInstance() {
		return INSTANCE;
	}
	
	// 장바구니 번호로 목록 조회
	public List<CartItemVO> getListByCartNo(Long cartNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			CartItemMapper cartItemMapper = sqlSession.getMapper(CartItemMapper.class);
			return cartItemMapper.selectListByCartNo(cartNo);
		}
	}
	
	// 장바구니 아이템 번호로 단일 조회
	public CartItemVO getOne(Long cartItemNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			CartItemMapper cartItemMapper = sqlSession.getMapper(CartItemMapper.class);
			return cartItemMapper.selectOne(cartItemNo);
		}
	}

	// 장바구니 번호, 게임 번호로 단일 조회
	public CartItemVO getOneByCartNoAndGameNo(Long cartNo, Long gameNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			CartItemMapper cartItemMapper = sqlSession.getMapper(CartItemMapper.class);
			return cartItemMapper.selectOneByCartNoAndGameNo(cartNo, gameNo);
		}
	}

	// 장바구니 상품 추가
	public int register(CartItemVO cartItemVO) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession()) {
			CartItemMapper cartItemMapper = sqlSession.getMapper(CartItemMapper.class);
			int result = cartItemMapper.insert(cartItemVO);

			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return result;
		}
	}
	
	// 장바구니에서 상품 삭제
	public int delete(Long cartItemNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession()) {
			CartItemMapper cartItemMapper = sqlSession.getMapper(CartItemMapper.class);
			int result = cartItemMapper.delete(cartItemNo);

			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return result;
		}
	}
}










