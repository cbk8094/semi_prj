package kr.co.publicvoid.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.publicvoid.dto.AdminSearchDTO;
import kr.co.publicvoid.dto.Criteria;
import kr.co.publicvoid.dto.GameSearchDTO;
import kr.co.publicvoid.mapper.GameImageMapper;
import kr.co.publicvoid.mapper.GameLanguageMapper;
import kr.co.publicvoid.mapper.GameMapper;
import kr.co.publicvoid.mapper.GenreMapper;
import kr.co.publicvoid.mapper.PublisherMapper;
import kr.co.publicvoid.mapper.ReviewMapper;
import kr.co.publicvoid.mapper.SaleMapper;
import kr.co.publicvoid.util.MybatisUtils;
import kr.co.publicvoid.vo.GameImageVO;
import kr.co.publicvoid.vo.GameLanguageVO;
import kr.co.publicvoid.vo.GameVO;
import kr.co.publicvoid.vo.GenreVO;
import kr.co.publicvoid.vo.PublisherVO;
import kr.co.publicvoid.vo.ReviewVO;
import kr.co.publicvoid.vo.SaleVO;

public class GameService {
	private static final GameService INSTANCE = new GameService();

	private GameService() {
	}

	public static GameService getInstance() {
		return INSTANCE;
	}

	// 그냥 리스트
	public List<GameVO> getList() {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			List<GameVO> gameList = gameMapper.selectList();

			for (GameVO gameVO : gameList) {
				getReqGameInfo(sqlSession, gameVO);
			}

			return gameList;
		}
	}
	
	// 할인 게임 할인율 높은 순으로 4개
	public List<GameVO> getListOrderBySaleRate(){
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			List<GameVO> gameList = gameMapper.selectListOrderBySaleRate();

			for (GameVO gameVO : gameList) {
				getReqGameInfo(sqlSession, gameVO);
			}

			return gameList;
		}
	}

	// 최신 게임 (가장 최근에 나온 순) 4개
	public List<GameVO> getListOrderByReleaseDate(){
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			List<GameVO> gameList = gameMapper.selectListOrderByReleaseDate();

			for (GameVO gameVO : gameList) {
				getReqGameInfo(sqlSession, gameVO);
			}

			return gameList;
		}
	}
	
	// 무료 게임 4개
	public List<GameVO> getListFree(){
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			List<GameVO> gameList = gameMapper.selectListFree();

			for (GameVO gameVO : gameList) {
				getReqGameInfo(sqlSession, gameVO);
			}

			return gameList;
		}
	}
	
	// 판매량 높은 순으로 5개 (세로로 배열)
	public List<GameVO> getListOrderBySaleCount(){
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			List<GameVO> gameList = gameMapper.selectListOrderBySaleCount();

			for (GameVO gameVO : gameList) {
				getReqGameInfo(sqlSession, gameVO);
			}

			return gameList;
		}
	}
	
	// 평균 리뷰 점수 높은 순으로 5개 (세로로 배열)
	public List<GameVO> getListOrderByReviewAvg(){
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			List<GameVO> gameList = gameMapper.selectListOrderByReviewAvg();

			for (GameVO gameVO : gameList) {
				getReqGameInfo(sqlSession, gameVO);
			}

			return gameList;
		}
	}

	// 조건이 포함된 리스트
	public List<GameVO> getFilteredAndPagingList(GameSearchDTO gameSearchDTO) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			List<GameVO> gameList = gameMapper.selectListByFilterAndPaging(gameSearchDTO);

			for (GameVO gameVO : gameList) {
				getReqGameInfo(sqlSession, gameVO);
			}

			return gameList;
		}
	}

	// 관리자 페이지 조회 페이징처리
	public List<GameVO> getFilteredAndPagingList(AdminSearchDTO AdminSearchDTO) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			List<GameVO> gameList = gameMapper.selectListByFilterAndPagingAdmin(AdminSearchDTO);

			for (GameVO gameVO : gameList) {
				getAllGameInfo(sqlSession, gameVO);
			}

			return gameList;
		}
	}
	
	// 필요한 정보만 읽어서 단일 조회
	public GameVO getOneReq(Long gameNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			GameVO gameVO = gameMapper.selectOne(gameNo);

			return getReqGameInfo(sqlSession, gameVO);
		}
	}

	// 모든 정보를 읽어서 단일 조회
	public GameVO getOne(Long gameNo) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			GameVO gameVO = gameMapper.selectOne(gameNo);

			return getAllGameInfo(sqlSession, gameVO);
		}
	}

	// 게임 정보에 제한된 정보를 넣어서 조회
	private GameVO getReqGameInfo(SqlSession sqlSession, GameVO gameVO) {
		GameImageMapper gameImageMapper = sqlSession.getMapper(GameImageMapper.class);
		List<GameImageVO> gameImageList = gameImageMapper.selectListByGameNo(gameVO.getGameNo());
		gameVO.setGameImageList(gameImageList);

		SaleMapper saleMapper = sqlSession.getMapper(SaleMapper.class);
		SaleVO saleVO = saleMapper.selectOneByGameNoNow(gameVO.getGameNo());
		gameVO.setSaleVO(saleVO);

		return gameVO;
	}

	// 게임 정보에 추가 정보 넣어서 조회
	private GameVO getAllGameInfo(SqlSession sqlSession, GameVO gameVO) {
		GameImageMapper gameImageMapper = sqlSession.getMapper(GameImageMapper.class);
		List<GameImageVO> gameImageList = gameImageMapper.selectListByGameNo(gameVO.getGameNo());
		gameVO.setGameImageList(gameImageList);

		GameLanguageMapper gameLanguageMapper = sqlSession.getMapper(GameLanguageMapper.class);
		List<GameLanguageVO> gameLanguageList = gameLanguageMapper.selectListByGameNo(gameVO.getGameNo());
		gameVO.setGameLanguageList(gameLanguageList);

		ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		List<ReviewVO> reviewList = reviewMapper.selectListByGameNo(gameVO.getGameNo());
		gameVO.setReviewList(reviewList);

		SaleMapper saleMapper = sqlSession.getMapper(SaleMapper.class);
		SaleVO saleVO = saleMapper.selectOneByGameNoNow(gameVO.getGameNo());
		gameVO.setSaleVO(saleVO);

		PublisherMapper publisherMapper = sqlSession.getMapper(PublisherMapper.class);
		PublisherVO publisherVO = publisherMapper.selectOne(gameVO.getPublisherNo());
		gameVO.setPublisherVO(publisherVO);

		GenreMapper genreMapper = sqlSession.getMapper(GenreMapper.class);
		GenreVO genreVO = genreMapper.selectOne(gameVO.getGenreNo());
		gameVO.setGenreVO(genreVO);

		return gameVO;
	}

	// 관리자 페이지 페이징 처리 목록 구현
	public List<GameVO> getListAdmin(Criteria criteria) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			List<GameVO> gameList = gameMapper.getListWithPaging(criteria);

			// 조건이 포함된 리스트
			for (GameVO gameVO : gameList) {
				getAllGameInfo(sqlSession, gameVO);
			}

			return gameList;
		}
	}

	public int getTotal(Criteria criteria) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			int gameList = gameMapper.getTotal(criteria);

			return gameList;
		}
	}

	// 관리자 페이지 등록
	public void insert(GameVO gameVO) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			gameMapper.insert(gameVO);
		}
	}

	// 관리자 페이지 수정
	public void update(GameVO gameVO) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			gameMapper.update(gameVO);
		}
	}
	// 관리자 페이지 수정
	public void delete(GameVO gameVO) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession(true)) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
			gameMapper.delete(gameVO.getGameNo());
		}
	}

	// 판매량 수정
	public int updateSaleCount(Long gameNo, int saleCount) {
		try (SqlSession sqlSession = MybatisUtils.sqlSessionFactory().openSession()) {
			GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);

			int result = gameMapper.updateSaleCount(gameNo, saleCount);

			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return result;
		}
	}
}