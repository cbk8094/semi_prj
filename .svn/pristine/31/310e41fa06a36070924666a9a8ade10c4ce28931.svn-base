<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<!-- head 부분 분리 -->
<jsp:include page="../common/head.jsp"></jsp:include>
</head>

<body id="page-top">

	<!-- 전체 Wrapper 시작 -->
	<div id="wrapper">

		<!-- 사이드바 분리 -->
		<jsp:include page="../common/sidebar.jsp"></jsp:include>

		<!-- 컨텐츠 Wrapper 시작 -->
		<div id="content-wrapper" class="d-flex flex-column bg-custom-blue">

			<!-- 메인 컨텐츠 시작 -->
			<div id="content">

				<!-- 탑바 분리 -->
				<jsp:include page="../common/topbar.jsp"></jsp:include>

				<!-- 페이지 컨텐츠 시작 -->
				<div class="container">

					<!-- 여기 내부 부분을 작업하면 됩니다 -->
					
					<div class="game_view_wrap my-5 mx-auto row">
						
						<h3 class="col-12 mb-3 text-light font-weight-bold"><c:out value="${game.gameName }"></c:out></h3>
						<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
					
						<!-- 게임 동영상 및 설명 등 -->
						<div class="game_view_left_wrap col-12 col-lg-8">
						
							<!-- 이미지 부분 -->
							<div class="game_image_wrap">
								<div class="swiper game-image-swiper mb-2" style="-swiper-navigation-color: #fff; - -swiper-pagination-color: #fff">
									<div class="swiper-wrapper">
									
										<div class="swiper-slide w-100">
											<div class="embed-responsive embed-responsive-16by9" style="user-select: auto;">
												<iframe class="embed-responsive-item" src="${game.gameVideoUrl }" style="user-select: auto;"></iframe>
											</div>
										</div>
									
										<!-- 여기에 이미지 리스트를 긁어와서 똑같이 보여져야 함 -->
										<c:forEach items="${game.gameImageList }" var="image">
											<!-- is가 붙은 프로퍼티의 경우 is~~()로 불러와야 함 (컬럼명 때문에 그럼) -->
											<c:if test="${image.isThumbnail() != 'true'}">
												<div class="swiper-slide w-100">
													<img src="${cp }/resources/upload/<c:out value="${image.storedFileName}"></c:out>" class="img-fluid w-100 aspect-ratio-custom"  role="button" />
												</div>
											</c:if>
										</c:forEach>
										
									</div>
									
									<div class="swiper-button-next"></div>
									<div class="swiper-button-prev"></div>
								</div>
								
								<div class="swiper game-image-thumb-swiper" thumbsSlider="">
									<div class="swiper-wrapper">
										<div class="swiper-slide">
											<img src="${cp }/resources/img/youtube-logo.png" class="img-fluid aspect-ratio-custom bg-white d-none" role="button" id="youtube-logo" />
										</div>
										
										<c:forEach items="${game.gameImageList }" var="image">
												
											<c:if test="${image.isThumbnail() != 'true'}">
												<div class="swiper-slide">
													<img src="${cp }/resources/upload/<c:out value="${image.storedFileName}"></c:out>" class="img-fluid aspect-ratio-custom" role="button" />
												</div>
											</c:if>
										</c:forEach>
										
									</div>
								</div>
							</div>
							
							<!-- 작을 때만 나옴 (고정형) -->
							<div class="game_view_right_sub_wrap2 d-block d-lg-none top-70-custom">
							
								<!-- 게임 이미지 --> 
								<img class="d-none d-lg-block card-img-top card-img-top-custom rounded-0" src="${cp }/resources/upload/<c:out value="${game.gameImageList[0].storedFileName}"></c:out>" alt="게임 이미지" /> 
								
								<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-4">
								
								<ul class="game_view_ul p-0">
									<li class="row mb-1 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">정가</div>
										<div class="col-8">
											<h6 class="font-weight-bold m-0 <c:if test="${game.saleVO == null}">h5 text-light</c:if><c:if test="${game.saleVO != null}">line-through-custom text-secondary</c:if>"><fmt:formatNumber value="${game.gamePrice}" pattern="#,###" /> 원</h6>
										</div>
									</li>
	
									<c:if test="${game.saleVO != null }">								
										<li class="row align-items-center">
											<div class="col-4 text-light font-weight-bold game-info-text-custom">할인가</div>
											<div class="col-8 d-flex">
												<span class="badge badge-danger font-size-85-custom mr-2"> <c:out
													value="${game.saleVO.saleRate }%"></c:out>
												</span>
												<h5 class="font-weight-bold m-0 text-danger"><fmt:formatNumber value="${game.discountedPrice}" pattern="#,###" /> 원</h5>
											</div>
										</li>
									</c:if>
								</ul>
								
								<hr class="col-12 hr border-color-custom border-width-custom mb-3">
								
								<ul class="game_view_ul p-0">
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">평가</div>
										<div class="col-8">
											<a href="#gameReview" class="d-flex text-decoration-none align-items-center text-warning">
												<span class="rating-star-container d-block">
								                    <span class="rating-star-num" style="width: ${reviewScoreAvg * 20}%"></span>
								                </span>
								                <span class="d-block ml-1 game-info-text-custom">(${game.reviewList.size() })</span>
							                </a>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">출시일</div>
										<div class="col-8 game-info-text-custom">
											<fmt:formatDate value="${game.gameReleaseDate}" pattern="yyyy년 MM월 dd일"/>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">개발자</div>
										<div class="col-8 game-info-text-custom">
											<span>${game.gameDeveloper }</span>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">배급사</div>
										<div class="col-8 game-info-text-custom">
											<span>${game.publisherVO.publisherName }</span>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">장르</div>
										<div class="col-8 game-info-text-custom">
											<span>${game.genreVO.genreName }</span>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">언어</div>
										<div class="col-8 game-info-text-custom game-language-list">
											<span>
												<c:forEach items="${game.gameLanguageList }" var="gameLanguage" varStatus="status">
													${gameLanguage.languageName }<c:if test="${!status.last }">, </c:if>
												</c:forEach>
											<span>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">연령제한</div>
										<div class="col-8 game-info-text-custom">
											<img src="${cp }/resources/img/age_${game.gameAgeLimit }.gif" />
										</div>
									</li>
									
								</ul>
								
								<hr class="col-12 hr border-color-custom border-width-custom mb-3">
								
								<div class="game_view_button_wrap row w-100 m-0 justify-content-around">
									<c:if test="${isCarted == true}">
										<button type="button" id="viewCartButton" class="btn btn-info btn-lg col-12 font-weight-bold mb-3">장바구니 보기</button>
									</c:if>
									<c:if test="${isCarted != true}">
										<c:if test="${isBought == true }">
											<button type="button" class="btn btn-primary btn-lg col-12 font-weight-bold mb-3">게임 보유 중</button>
										</c:if>
										<c:if test="${isBought != true }">
											<button type="button" id="addCartButton" class="btn btn-warning btn-lg col-12 font-weight-bold mb-3">장바구니에 담기</button>
										</c:if>
									</c:if>
									
									
									<c:if test="${isBought == true }">
										<button type="button" id="addWishlistButton" class="btn btn-secondary btn-lg col-12 bg-light font-weight-bold text-dark"><i class="wishlist_icon mr-2 far fa-heart"></i><span class="wishlist_text">이미 보유중입니다</span></button>
									</c:if>
									<c:if test="${isBought != true }">
										<c:if test="${isWished == true}">
											<button type="button" id="addWishlistButton" class="btn btn-secondary btn-lg col-12 bg-light font-weight-bold text-dark"><i class="wishlist_icon mr-2 fa-heart fas"></i><span class="wishlist_text">위시리스트에 있음</span></button>
										</c:if>
										<c:if test="${isWished != true}">
											<button type="button" id="addWishlistButton" class="btn btn-secondary btn-lg col-12 bg-light font-weight-bold text-dark"><i class="wishlist_icon mr-2 far fa-heart"></i><span class="wishlist_text">위시리스트에 추가</span></button>
										</c:if>
									</c:if>
								</div>
								
							</div>
							
							<div class="game_desc_wrap my-5">
								<h4 class="col-12 mb-3 text-light font-weight-bold">게임에 대해</h4>
								<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
								
								${game.gameDesc }
							</div>
							
							<div id="expandButtonWrap" class="d-none mb-5">
								<a href="javascript:;" id="expandButton" class="d-flex justify-content-center align-items-center text-decoration-none p-2 bg-custom-gray text-light rounded">펼치기<i class="fas fa-chevron-down ml-2"></i></a>
							</div>
							
							<div class="game_require_wrap mb-5">
								<h4 class="col-12 mb-3 text-light font-weight-bold">시스템 요구 사항</h4>
								<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
								
								${game.gameSpec }
							</div>
							
							
							<div id="gameReview" class="game_review_wrap mb-5">
								<h4 class="col-12 mb-3 text-light font-weight-bold">사용자 평가</h4>
								<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
								
								<div class="game_review_score d-flex align-items-center text-light mb-3">
									<svg width="2rem" height="2rem" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg">
										<linearGradient id="half">
											<stop offset="50%" stop-color="#fdbd00"></stop>
											<stop offset="0" stop-color="#ffffff"></stop>
										</linearGradient>
										<path d="M7.12095 11.3897C7.04568 11.3481 6.95432 11.3481 6.87905 11.3897L3.0935 13.4823C3.05697 13.5025 3.01324 13.4717 3.01996 13.4305L3.74674 8.975C3.75951 8.89669 3.73435 8.81696 3.67894 8.76016L0.586662 5.59082C0.558242 5.56169 0.574668 5.51262 0.614898 5.50648L4.87464 4.85565C4.95705 4.84305 5.02777 4.79021 5.06319 4.71474L6.95474 0.684808C6.97273 0.646468 7.02727 0.646467 7.04526 0.684808L8.93681 4.71474C8.97223 4.79021 9.04295 4.84305 9.12536 4.85565L13.3851 5.50648C13.4253 5.51262 13.4418 5.56169 13.4133 5.59082L10.3211 8.76016C10.2656 8.81696 10.2405 8.89669 10.2533 8.975L10.98 13.4305C10.9868 13.4717 10.943 13.5025 10.9065 13.4823L7.12095 11.3897Z" fill="#fdbd00" stroke="#E7AC00" stroke-width="0.5" stroke-linejoin="round">
										</path>
									</svg>
									
									<span class="ml-2 mt-1">
										<span class="h2 font-weight-bolder"><fmt:formatNumber value="${reviewScoreAvg }" pattern="#,###.#" /></span>/5
									</span>
									
								</div>
								
								<ul class="game_review_list p-0">
									<%-- <li class="row p-3 px-2 m-0 bg-custom-review mt-3">
										<div class="game_review_left p-0 col-12 col-xl-4 d-flex align-items-start">
											<img src="${cp }/resources/img/profile-no-image.webp" class="w-custom-50 mr-2" />
											<div class="mt-1">
												<a href="${cp }/member/mypage?memberNo=1" class="text-light text-decoration-none">
													<h6 class="mb-1 font-weight-bold">나구팔</h6>
												</a>
												<a href="${cp }/review/list?memberNo=1" class="text-light text-decoration-none">
													<span class="font-smaller-custom">평가 3개</span>
												</a>
											</div>
										</div>
										<div class="game_review_right p-0 col-12 col-xl-8 mt-3 mt-xl-0">
											<div class="game_review_stars clearfix mb-2">
												<svg class="float-left mr-1-custom" width="1.2rem" height="1.2rem" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg">
													<linearGradient id="half">
														<stop offset="50%" stop-color="#fdbd00"></stop>
														<stop offset="0" stop-color="#ffffff"></stop>
													</linearGradient>
													<path d="M7.12095 11.3897C7.04568 11.3481 6.95432 11.3481 6.87905 11.3897L3.0935 13.4823C3.05697 13.5025 3.01324 13.4717 3.01996 13.4305L3.74674 8.975C3.75951 8.89669 3.73435 8.81696 3.67894 8.76016L0.586662 5.59082C0.558242 5.56169 0.574668 5.51262 0.614898 5.50648L4.87464 4.85565C4.95705 4.84305 5.02777 4.79021 5.06319 4.71474L6.95474 0.684808C6.97273 0.646468 7.02727 0.646467 7.04526 0.684808L8.93681 4.71474C8.97223 4.79021 9.04295 4.84305 9.12536 4.85565L13.3851 5.50648C13.4253 5.51262 13.4418 5.56169 13.4133 5.59082L10.3211 8.76016C10.2656 8.81696 10.2405 8.89669 10.2533 8.975L10.98 13.4305C10.9868 13.4717 10.943 13.5025 10.9065 13.4823L7.12095 11.3897Z" fill="#fdbd00" stroke="#E7AC00" stroke-width="0.5" stroke-linejoin="round">
													</path>
												</svg>
												<svg class="float-left mr-1-custom" width="1.2rem" height="1.2rem" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg">
													<linearGradient id="half">
														<stop offset="50%" stop-color="#fdbd00"></stop>
														<stop offset="0" stop-color="#ffffff"></stop>
													</linearGradient>
													<path d="M7.12095 11.3897C7.04568 11.3481 6.95432 11.3481 6.87905 11.3897L3.0935 13.4823C3.05697 13.5025 3.01324 13.4717 3.01996 13.4305L3.74674 8.975C3.75951 8.89669 3.73435 8.81696 3.67894 8.76016L0.586662 5.59082C0.558242 5.56169 0.574668 5.51262 0.614898 5.50648L4.87464 4.85565C4.95705 4.84305 5.02777 4.79021 5.06319 4.71474L6.95474 0.684808C6.97273 0.646468 7.02727 0.646467 7.04526 0.684808L8.93681 4.71474C8.97223 4.79021 9.04295 4.84305 9.12536 4.85565L13.3851 5.50648C13.4253 5.51262 13.4418 5.56169 13.4133 5.59082L10.3211 8.76016C10.2656 8.81696 10.2405 8.89669 10.2533 8.975L10.98 13.4305C10.9868 13.4717 10.943 13.5025 10.9065 13.4823L7.12095 11.3897Z" fill="#fdbd00" stroke="#E7AC00" stroke-width="0.5" stroke-linejoin="round">
													</path>
												</svg>
											</div>
											
											<div class="game_review_content_wrap">
												<div class="game_review_date_wrap mb-1">
													<span class="game_review_date font-smaller-custom">게시일: 2023년 10월 22일</span>
												</div>
												<div class="game_review_content text-light">
													갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 갓겜입니다! 
												</div>
											</div>
										</div>
									</li> --%>
								</ul>
							</div>
							
							<!-- ajax 로딩 시 보여줄 것 -->
							<div class="ajax-loading-spinner-wrap fixed-top position-fixed align-items-center d-none h-100 justify-content-center">
								<div class="spinner-border ajax-loading-spinner mt-5" style="width: 5rem; height: 5rem;" role="status">
									<span class="sr-only">Loading...</span>
								</div>
							</div>
							
						</div>
								
						<!-- 게임 정보 및 버튼 -->
						<div class="game_view_right_wrap col-12 col-lg-4 overflow-hidden position-relative">
						
							<div class="game_view_right_sub_wrap d-none d-lg-block top-70-custom">
								<div class="d-none game_view_right_title position-relative">
									<h3 class="col-12 mb-3 text-light font-weight-bold two-line-ellipsis"><c:out value="${game.gameName }"></c:out></h3>
									<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
								</div>
							
								<!-- 게임 이미지 --> 
								<img class="d-none d-lg-block card-img-top card-img-top-custom rounded-0" src="${cp }/resources/upload/<c:out value="${game.gameImageList[0].storedFileName}"></c:out>" alt="게임 이미지" /> 
								
								<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-4">
								
								<ul class="game_view_ul p-0">
									<li class="row mb-1 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">정가</div>
										<div class="col-8">
											<h6 class="font-weight-bold m-0 <c:if test="${game.saleVO == null}">h5 text-light</c:if><c:if test="${game.saleVO != null}">line-through-custom text-secondary</c:if>">
												<c:choose>
													<c:when test="${game.gamePrice == 0}">무료</c:when>
													<c:otherwise><fmt:formatNumber value="${game.gamePrice}" pattern="#,###" />원</c:otherwise>
												</c:choose>
											</h6>
										</div>
									</li>
	
									<c:if test="${game.saleVO != null }">								
										<li class="row align-items-center">
											<div class="col-4 text-light font-weight-bold game-info-text-custom">할인가</div>
											<div class="col-8 d-flex">
												<span class="badge badge-danger font-size-85-custom mr-2"> <c:out
													value="${game.saleVO.saleRate }%"></c:out>
												</span>
												<h5 class="font-weight-bold m-0 text-danger">
													<c:choose>
														<c:when test="${game.discountedPrice == 0}">무료</c:when>
														<c:otherwise><fmt:formatNumber value="${game.discountedPrice}" pattern="#,###" />원</c:otherwise>
													</c:choose>
												</h5>
											</div>
										</li>
									</c:if>
								</ul>
								
								<hr class="col-12 hr border-color-custom border-width-custom mb-3">
								
								<ul class="game_view_ul p-0">
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">평가</div>
										<div class="col-8">
											<a href="#gameReview" class="d-flex text-decoration-none align-items-center text-warning">
												<span class="rating-star-container d-block">
								                    <span class="rating-star-num" style="width: ${reviewScoreAvg * 20}%"></span>
								                </span>
								                <span class="d-block ml-1 game-info-text-custom">(${game.reviewList.size() })</span>
							                </a>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">출시일</div>
										<div class="col-8 game-info-text-custom">
											<fmt:formatDate value="${game.gameReleaseDate}" pattern="yyyy년 MM월 dd일"/>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">개발자</div>
										<div class="col-8 game-info-text-custom">
											<span>${game.gameDeveloper }</span>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">배급사</div>
										<div class="col-8 game-info-text-custom">
											<span>${game.publisherVO.publisherName }</span>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">장르</div>
										<div class="col-8 game-info-text-custom">
											<span>${game.genreVO.genreName }</span>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">언어</div>
										<div class="col-8 game-info-text-custom game-language-list">
											<span>
												<c:forEach items="${game.gameLanguageList }" var="gameLanguage" varStatus="status">
													${gameLanguage.languageName }<c:if test="${!status.last }">, </c:if>
												</c:forEach>
											<span>
										</div>
									</li>
									<li class="row mb-2 align-items-center">
										<div class="col-4 text-white font-weight-bold game-info-text-custom">연령제한</div>
										<div class="col-8 game-info-text-custom">
											<img src="${cp }/resources/img/age_${game.gameAgeLimit }.gif" />
										</div>
									</li>
									
								</ul>
								
								<hr class="col-12 hr border-color-custom border-width-custom mb-3">
								
								<div class="game_view_button_wrap row w-100 m-0 justify-content-around">
									<c:if test="${isCarted == true}">
										<button type="button" id="viewCartButton" class="btn btn-info btn-lg col-12 font-weight-bold mb-3">장바구니 보기</button>
									</c:if>
									<c:if test="${isCarted != true}">
										<c:if test="${isBought == true }">
											<button type="button" class="btn btn-primary btn-lg col-12 font-weight-bold mb-3">게임 보유 중</button>
										</c:if>
										<c:if test="${isBought != true }">
											<button type="button" id="addCartButton" class="btn btn-warning btn-lg col-12 font-weight-bold mb-3">장바구니에 담기</button>
										</c:if>
									</c:if>
									
									<c:if test="${isWished == true}">
										<button type="button" id="addWishlistButton" class="btn btn-secondary btn-lg col-12 bg-light font-weight-bold text-dark"><i class="wishlist_icon mr-2 fa-heart fas"></i><span class="wishlist_text">위시리스트에 있음</span></button>
									</c:if>
									<c:if test="${isWished != true}">
										<button type="button" id="addWishlistButton" class="btn btn-secondary btn-lg col-12 bg-light font-weight-bold text-dark"><i class="wishlist_icon mr-2 far fa-heart"></i><span class="wishlist_text">위시리스트에 추가</span></button>
									</c:if>
								</div>
								
							</div>
							
						</div>
						<!-- game_view_right_wrap 끝 -->
						
					</div>
					<!-- game_view_wrap 끝 -->
					
					<script>
					
						// IIFE
						$(function(){
							var contextPath = '${cp}'; // ContextPath
							var loadMoreData = true; // 더 불러올 데이터 있는지 여부
							var nowLoading = false; // 현재 로딩 중 여부
							
							moment.locale('ko'); // moment 라이브러리 로케일을 한국어로 설정
							
							// 패턴에 따라 날짜 형식화
							function formatDate(dateString) {
								const dateObject = new Date(dateString);
								
								return formattedDate = moment(dateObject).format('YYYY-MM-DD HH:mm:ss');
							}
							
							adjustGameViewRightPosition();
							adjustRightViewWidth();
							makeExpandButton();
							getReviewList();
							
							/* 이미지 썸네일 스와이퍼 */
							var imageSwiper = new Swiper(".game-image-thumb-swiper", {
								spaceBetween : 10,
								slidesPerView : 5,
								freeMode : true,
								watchSlidesProgress : true,
							});
						
							/* 이미지 스와이퍼 */
							var imageThumbSwiper = new Swiper(".game-image-swiper", {
								spaceBetween : 10,
								navigation : {
									nextEl : ".swiper-button-next",
									prevEl : ".swiper-button-prev",
								},
								thumbs : {
									swiper : imageSwiper,
								},
								on: {
							        afterInit: function(){
							            $("#youtube-logo").removeClass("d-none");
							        },
							    },
							});
							
							// right view를 상단 wrap의 너비에 의해 동적 조절
							function adjustRightViewWidth(){
								const parentWidth = $(".game_view_right_wrap").width();
								
								$(".game_view_right_sub_wrap").css("width", parentWidth);
							}
							
							// 윈도우 크기 변경을 감지하여 조절
							$(window).resize(function(){
								adjustRightViewWidth();
							});
							
							// 스크롤 감지하여 일정 스크롤 이하가 될 시 오른쪽 부분을 fixed함
							$(window).scroll(function(){
								adjustGameViewRightPosition();
							});

							// 게임 우측 설명 위치 조정
							function adjustGameViewRightPosition(){

								let documentHeight = $(document).height(); // 전체 문서의 높이
								let scrollPosition = $(window).scrollTop(); // 현재 스크롤 위치
								let windowHeight = $(window).height(); // 창의 높이
								
								// 문서의 총 길이가 창의 길이보다 크다면 그 차이만큼 스크롤 길이가 형성된다
								
								// 스크롤이 상단에서 얼마나 떨어졌는지 체크
								if(scrollPosition >= 400){
									// 일정 이상 떨어지면 position-fixed를 준다.
									// 아니면 다시 없앤다

									$(".game_view_right_sub_wrap").addClass("position-fixed");
									$(".game_view_right_title").removeClass("d-none");
									
								}else{
									$(".game_view_right_sub_wrap").removeClass("position-fixed");
									$(".game_view_right_title").addClass("d-none");
								}
							}
							
							// 리뷰 목록 조회
							function getReviewList(){
								
								$.ajax({
									url: contextPath + "/review/list",
									type: "POST",
									data: {
										gameNo: '${game.gameNo}',
									},
									beforeSend: function(){
										$(".ajax-loading-spinner-wrap").removeClass("d-none").addClass("d-flex");
										nowLoading = true;
									},
									complete: function(){
										$(".ajax-loading-spinner-wrap").addClass("d-none").removeClass("d-flex");
										nowLoading = false;
									},
									success: function(res){
										console.log(res);
										
										let str = "";
										let starStr = `<svg class="float-left mr-1-custom" width="1.2rem" height="1.2rem" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg">
											<linearGradient id="half">
												<stop offset="50%" stop-color="#fdbd00"></stop>
												<stop offset="0" stop-color="#ffffff"></stop>
											</linearGradient>
											<path d="M7.12095 11.3897C7.04568 11.3481 6.95432 11.3481 6.87905 11.3897L3.0935 13.4823C3.05697 13.5025 3.01324 13.4717 3.01996 13.4305L3.74674 8.975C3.75951 8.89669 3.73435 8.81696 3.67894 8.76016L0.586662 5.59082C0.558242 5.56169 0.574668 5.51262 0.614898 5.50648L4.87464 4.85565C4.95705 4.84305 5.02777 4.79021 5.06319 4.71474L6.95474 0.684808C6.97273 0.646468 7.02727 0.646467 7.04526 0.684808L8.93681 4.71474C8.97223 4.79021 9.04295 4.84305 9.12536 4.85565L13.3851 5.50648C13.4253 5.51262 13.4418 5.56169 13.4133 5.59082L10.3211 8.76016C10.2656 8.81696 10.2405 8.89669 10.2533 8.975L10.98 13.4305C10.9868 13.4717 10.943 13.5025 10.9065 13.4823L7.12095 11.3897Z" fill="#fdbd00" stroke="#E7AC00" stroke-width="0.5" stroke-linejoin="round">
											</path>
										</svg>`;
										
										res.data.reviewList.forEach(review => {
											let imgSrc = ``;

											if(review.memberVO.memberImageVO == null){
												imgSrc = "img/profile-no-image.webp";
											}else{
												imgSrc = "upload/" + review.memberVO.memberImageVO.storedFileName;
											}
											
											str += `
												<li class="row p-3 px-2 m-0 bg-custom-gray mt-3">
													<div class="game_review_left p-0 col-12 col-md-4 col-lg-12 col-xl-4 d-flex align-items-start">
														<img src="${cp }/resources/\${imgSrc}" class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom mr-2 border border-secondary border-width-custom-2" />
														<div class="mt-1">
															<a href="${cp }/member/profile?memberNo=\${review.memberNo}" class="text-light text-decoration-none">
																<h6 class="mb-1 font-weight-bold">\${review.memberVO.memberNickname}</h6>
															</a>
															<a href="${cp }/review/list?memberNo=\${review.memberNo}" class="text-light text-decoration-none">
																<span class="font-smaller-custom">평가 \${review.memberVO.reviewCount}개</span>
															</a>
														</div>
													</div>
													<div class="game_review_right p-0 col-12 col-md-8 col-lg-12 col-xl-8 mt-3 mt-md-0 mt-lg-3 mt-xl-0">
														<div class="game_review_stars clearfix mb-2">
															\${starStr.repeat(review.reviewScore)}
														</div>
														
														<div class="game_review_content_wrap">
															<div class="game_review_date_wrap mb-1">
																<span class="game_review_date font-smaller-custom">게시일: \${formatDate(review.regDate)}</span>
															</div>
															<div class="game_review_content text-light">
																\${review.reviewContent}
															</div>
														</div>
													</div>
												</li>
											`;
										});
										
										$(".game_review_list").append(str);
									},
									error: function(err){
										console.error(err);
									}
								});
							}
							
							// 장바구니에 담기 버튼
							$(".game_view_button_wrap").on("click", "#addCartButton", function(){
								addCart();
							});
							
							// 장바구니 보기 버튼
							$(".game_view_button_wrap").on("click", "#viewCartButton", function(){
								location.href = `${cp}/cart`;
							});
							
							// 위시리스트에 추가 버튼
							$(".game_view_button_wrap").on("click", "#addWishlistButton", function(){
								addWishlist();
							});
							
							// 장바구니에 담기
							function addCart(){
								$.ajax({
									url: contextPath + "/cart/add",
									type: "POST",
									data: {
										gameNo: '${game.gameNo}',
										// memberNo는 세션으로 파악할 것
									},
									beforeSend: function(){
										$(".ajax-loading-spinner-wrap").removeClass("d-none").addClass("d-flex");
										nowLoading = true;
									},
									complete: function(){
										$(".ajax-loading-spinner-wrap").addClass("d-none").removeClass("d-flex");
										nowLoading = false;
									},
									success: function(res){
										
										console.log(res);
										
										if(res.success === false){
											// 모달창 띄움
											if(res.errorType == 2){
												$("#addCartModal .modal-body").html(res.message);
												$("#addCartModal").modal("show");
											}else if(res.errorType == 5){
												alert(res.message);
												location.href = "${cp}/member/login";
											}else{
												alert(res.message);
											}
											
										}else{
											// 장바구니 담기 성공
											$("#addCartModal .modal-body").html(res.message);
											$("#addCartModal").modal("show");
											
											let viewCartButtonText = `<button type="button" id="viewCartButton" class="btn btn-info btn-lg col-12 font-weight-bold mb-3">장바구니 보기</button>`;
											
											$("#addCartButton").replaceWith(viewCartButtonText);
										}
										
									},
									error: function(err){
										console.error(err);
									}
								});
							}
							
							// 위시리스트에 추가/삭제
							function addWishlist(){
								$.ajax({
									url: contextPath + "/wish/add",
									type: "POST",
									data: {
										gameNo: '${game.gameNo}',
										// memberNo는 세션으로 파악할 것
									},
									beforeSend: function(){
										$(".ajax-loading-spinner-wrap").removeClass("d-none").addClass("d-flex");
										nowLoading = true;
									},
									complete: function(){
										$(".ajax-loading-spinner-wrap").addClass("d-none").removeClass("d-flex");
										nowLoading = false;
									},
									success: function(res){
										console.log(res);
										
										if(res.success === false){
											if(res.errorType == 5){
												alert(res.message);
												location.href = "${cp}/member/login";
											}else{
												alert(res.message);
											}
										}else{
											// 1이면 방금 추가 성공, 2이면 방금 삭제 성공
											if(res.message == '1'){
												$(".wishlist_icon").removeClass("far").addClass("fas");
												$(".wishlist_text").text("위시리스트에 있음");
											}else{
												$(".wishlist_icon").removeClass("fas").addClass("far");
												$(".wishlist_text").text("위시리스트에 추가");
											}
										}
									},
									error: function(err){
										console.error(err);
									}
								});
							}
							
							// 특정 회원의 위시리스트에 있는지 체크
							function isWished(){
								$.ajax({
									url: contextPath + "/wish",
									type: "POST",
									data: {
										gameNo: '${game.gameNo}',
										// memberNo는 세션으로 파악할 것
									},
									beforeSend: function(){
										$(".ajax-loading-spinner-wrap").removeClass("d-none").addClass("d-flex");
										nowLoading = true;
									},
									complete: function(){
										// $(".ajax-loading-spinner-wrap").addClass("d-none").removeClass("d-flex");
										// nowLoading = false;
									},
									success: function(res){
										console.log(res);
										
										if(res.success === false){
											alert("위시리스트에 있는지 확인 실패");
										}else{
											// 1이면 있음, 2이면 없음
											if(res.message == '1'){
												$(".wishlist_icon").removeClass("far").addClass("fas");
												$(".wishlist_text").text("위시리스트에 있음");
											}
										}
									},
									error: function(err){
										console.error(err);
									}
								});
							}
							
							// game_desc의 세로의 길이가 특정 길이가 넘으면 펼치기 버튼 만든다
							function makeExpandButton(){
								let gameDescHeight = $(".game_desc_wrap").height(); // 전체 문서의 높이

								// 넘으면 접고 펼치기 만듦
								if(gameDescHeight > 500){
									$(".game_desc_wrap").addClass("expand-custom-500").addClass("mt-5").removeClass("my-5");
									$("#expandButtonWrap").removeClass("d-none").addClass("d-block");
								}
							}
							
							// 펼치기 버튼 눌렀을 때
							$(".game_view_wrap").on("click", "#expandButton", function(){
								expandGameDesc();
							});
							
							// 펼치기 버튼 처리
							function expandGameDesc(){
								$(".game_desc_wrap").removeClass("expand-custom-500").removeClass("mt-5").addClass("my-5");
								$("#expandButtonWrap").removeClass("d-block").addClass("d-none");
							}
							
						}); // IIFE END
					
						
					</script>

				</div>
				<!-- 페이지 컨텐츠 끝 -->

			</div>
			<!-- 메인 컨텐츠 끝 -->

		</div>
		<!-- 컨텐츠 Wrapper 끝 -->

	</div>
	<!-- 전체 Wrapper 끝 -->

	<!-- 맨 위로 스크롤 버튼 -->
	<a class="scroll-to-top rounded" href="#page-top"> <i class="fas fa-angle-up"></i>
	</a>

	<!-- 모달 JSP 삽입 -->
	<jsp:include page="../common/modal.jsp"></jsp:include>

</body>

</html>
