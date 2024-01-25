<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
					<div class="main_wrap my-5 mx-auto row">
						<!-- <h3 class="col-12 mb-3 text-light font-weight-bold">
							메인 페이지
						</h3>
						<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1"> -->
						
						<div class="main_top_nav_wrap col col-12 col-md-9 col-lg-6">
							<form action="${cp }/game/list" class="searchbar" id="searchForm">
					        	<input type="text" name="searchWord" class="search_input text-light font-large-custom" placeholder="상점 검색">
					        	<a href="javascript:;" class="search_icon"><i class="fas fa-search"></i></a>
					        </form>
						</div>
						
                		<div class="main_game_list_wrap mt-4 w-100 row m-0 mb-5">
                			<div class="rounded swiper game-desc-swiper w-75-20-custom mr-20-custom" style="-swiper-navigation-color: #fff; - -swiper-pagination-color: #fff">
								<div class="swiper-wrapper">
									<c:forEach items="${mainGameList }" var="game">
										<c:set var="foundImage" value="false" />
										
										<c:forEach items="${game.gameImageList }" var="image">
											<c:if test="${not foundImage and image.isThumbnail() != true}">
												<div class="swiper-slide w-100 position-relative">
													<img src="${cp }/resources/upload/<c:out value="${image.storedFileName}"></c:out>" class="swiper_image img-fluid w-100 aspect-ratio-custom"  role="button" />
													
													<div class="game_desc_overlay_text position-absolute absolute-0-custom w-100 h-100">
														<a href="${cp }/game/view?gameNo=${game.gameNo}" class="d-flex w-100 h-100 text-decoration-none position-relative p-4 p-lg-5 text-light justify-content-end flex-column">
															<h4 class="text-light font-weight-bold text-shadow-custom">${game.gameName }</h4>
															<div class="d-flex align-items-center w-100">
																<h5 class="text-shadow-custom d-inline font-weight-bold one-line-ellipsis text-light text-right m-0 <c:if test="${not empty game.saleVO}">line-through-custom text-dark</c:if>"><fmt:formatNumber value="${game.gamePrice}"
																		pattern="#,###" />원</h5>
																
																<c:if test="${not empty game.saleVO}">
																	<span class="text-shadow-custom ml-2 badge badge-danger"> <c:out
																			value="${game.saleVO.saleRate }%"></c:out>
																	</span>
																	<h5
																		class="text-shadow-custom d-inline font-weight-bold one-line-ellipsis text-right m-0 ml-1 text-danger">
																		<fmt:formatNumber
																			value="${game.discountedPrice}"
																			pattern="#,###" />
																		원
																	</h5>
																</c:if>
															</div>
															
															<button type="button" class="btn btn-light p-3 mt-3 w-custom-200">지금 구매</button>															
														</a>														
													</div>
												</div>
												<c:set var="foundImage" value="true" />
											</c:if>
										</c:forEach>
									</c:forEach>
								</div>
								
								<div class="swiper-button-next"></div>
								<div class="swiper-button-prev"></div>
							</div>
							
							<div class="swiper game-list-swiper d-none d-xl-block w-25">
								<div class="swiper-wrapper">
									<c:forEach items="${mainGameList }" var="game">
										<c:forEach items="${game.gameImageList }" var="image">
												
											<c:if test="${image.isThumbnail() == true}">
												<div class="rounded swiper-slide w-100">
													<div class="d-flex w-100 h-100 p-2 align-items-center" role="button">
														<img src="${cp }/resources/upload/<c:out value="${image.storedFileName}"></c:out>" class="swiper_image img-fluid d-none rounded w-custom-100" role="button" />
														<span class="text-light two-line-ellipsis pl-3">${game.gameName }</span>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</c:forEach>
								</div>
							</div>
							
                		</div>
                		
                		<div class="sale_game_list_wrap mt-3 w-100 row m-0">
                			<h4 class="text-light mb-3">놓치지 마세요! 최대 할인 게임</h4>
                			<div class="game_list row gx-4 gx-lg-5 row-cols-1 row-cols-sm-2 row-cols-md-2 row-cols-lg-4 row-cols-xl-4 justify-content-left">
	                			<c:forEach items="${saleGameList }" var="game">
	                				<div class="col mb-5">
										<div
											class="card rounded-0 h-100 border-0 box-shadow-custom bg-custom-black hover-box-shadow-white">
											<a href="${cp}/game/view?gameNo=${game.gameNo}" class="text-decoration-none text-light">
												<!-- 게임 이미지 --> 
												<img class="card-img-top card-img-top-custom rounded-0"
												src="${cp }/resources/upload/${game.gameImageList[0].storedFileName}" alt="게임 이미지" /> 
												
												<!-- 게임 정보 -->
												<div class="card-body p-4 bg-custom-black">
													<div class="text-center clearfix">
													
														<!-- 게임명 -->
														<h6 class="two-line-ellipsis h-custom-40 text-left">
															<c:out value="${game.gameName }"></c:out>
														</h6>
														
														<!-- 게임 가격 -->
														<h6
															class="font-weight-bold one-line-ellipsis text-right m-0 <c:if test="${not empty game.saleVO}">line-through-custom text-dark mb-1</c:if>">
															<c:choose>
																<c:when test="${game.gamePrice == 0}">무료</c:when>
																<c:otherwise><fmt:formatNumber value="${game.gamePrice}" pattern="#,###" />원</c:otherwise>
															</c:choose>
														</h6>
	
														<c:if test="${not empty game.saleVO}">
															<div class="d-flex float-right">
																<span class="badge badge-danger"> <c:out
																		value="${game.saleVO.saleRate }%"></c:out>
																</span>
																<h6
																	class="font-weight-bold one-line-ellipsis text-right m-0 ml-2 text-danger">
																	<c:choose>
																		<c:when test="${game.discountedPrice == 0}">무료</c:when>
																		<c:otherwise><fmt:formatNumber value="${game.discountedPrice}" pattern="#,###" />원</c:otherwise>
																	</c:choose>
																</h6>
															</div>
														</c:if>
													</div>
												</div>
											</a>
										</div>
									</div>
	                			</c:forEach>
                			</div>
                		</div>
                		
                		<div class="recent_game_list_wrap mt-3 w-100 row m-0">
                			<h4 class="text-light mb-3">따끈따끈한 신작 게임!</h4>
                			<div class="game_list row gx-4 gx-lg-5 row-cols-1 row-cols-sm-2 row-cols-md-2 row-cols-lg-4 row-cols-xl-4 justify-content-left">
	                			<c:forEach items="${recentGameList }" var="game">
	                				<div class="col mb-5">
										<div
											class="card rounded-0 h-100 border-0 box-shadow-custom bg-custom-black hover-box-shadow-white">
											<a href="${cp}/game/view?gameNo=${game.gameNo}" class="text-decoration-none text-light">
												<!-- 게임 이미지 --> 
												<img class="card-img-top card-img-top-custom rounded-0"
												src="${cp }/resources/upload/${game.gameImageList[0].storedFileName}" alt="게임 이미지" /> 
												
												<!-- 게임 정보 -->
												<div class="card-body p-4 bg-custom-black">
													<div class="text-center clearfix">
													
														<!-- 게임명 -->
														<h6 class="two-line-ellipsis h-custom-40 text-left">
															<c:out value="${game.gameName }"></c:out>
														</h6>
														
														<!-- 발매일 -->
														<h6 class="text-warning one-line-ellipsis text-right m-0 mb-1">
															<fmt:formatDate value="${game.gameReleaseDate}" pattern="yyyy. M. d. 발매" />
														</h6>
														
														<!-- 게임 가격 -->
														<h6
															class="font-weight-bold one-line-ellipsis text-right m-0 <c:if test="${not empty game.saleVO}">line-through-custom text-dark mb-1</c:if>">
															<fmt:formatNumber value="${game.gamePrice}"
																pattern="#,###" />
															원
														</h6>
	
														<c:if test="${not empty game.saleVO}">
															<div class="d-flex float-right">
																<span class="badge badge-danger"> <c:out
																		value="${game.saleVO.saleRate }%"></c:out>
																</span>
																<h6
																	class="font-weight-bold one-line-ellipsis text-right m-0 ml-2 text-danger">
																	<fmt:formatNumber
																		value="${game.discountedPrice}"
																		pattern="#,###" />
																	원
																</h6>
															</div>
														</c:if>
													</div>
												</div>
											</a>
										</div>
									</div>
	                			</c:forEach>
                			</div>
                		</div>
                	
                		<div class="free_game_list_wrap mt-3 w-100 row m-0">
                			<h4 class="text-light mb-3">무료 게임을 선물합니다!</h4>
                			<div class="game_list row gx-4 gx-lg-5 row-cols-1 row-cols-sm-2 row-cols-md-2 row-cols-lg-4 row-cols-xl-4 justify-content-left">
	                			<c:forEach items="${freeGameList }" var="game">
	                				<div class="col mb-5">
										<div
											class="card rounded-0 h-100 border-0 box-shadow-custom bg-custom-black hover-box-shadow-white">
											<a href="${cp}/game/view?gameNo=${game.gameNo}" class="text-decoration-none text-light">
												<!-- 게임 이미지 --> 
												<img class="card-img-top card-img-top-custom rounded-0"
												src="${cp }/resources/upload/${game.gameImageList[0].storedFileName}" alt="게임 이미지" /> 
												
												<!-- 게임 정보 -->
												<div class="card-body p-4 bg-custom-black">
													<div class="text-center clearfix">
													
														<!-- 게임명 -->
														<h6 class="two-line-ellipsis h-custom-40 text-left">
															<c:out value="${game.gameName }"></c:out>
														</h6>
														
														<!-- 게임 가격 -->
														<h6
															class="font-weight-bold one-line-ellipsis text-right m-0 <c:if test="${not empty game.saleVO}">line-through-custom text-dark mb-1</c:if>">
															<c:choose>
																<c:when test="${game.gamePrice == 0}">무료</c:when>
																<c:otherwise><fmt:formatNumber value="${game.gamePrice}" pattern="#,###" />원</c:otherwise>
															</c:choose>
														</h6>
	
														<c:if test="${not empty game.saleVO}">
															<div class="d-flex float-right">
																<span class="badge badge-danger"> <c:out
																		value="${game.saleVO.saleRate }%"></c:out>
																</span>
																<h6
																	class="font-weight-bold one-line-ellipsis text-right m-0 ml-2 text-danger">
																	<c:choose>
																		<c:when test="${game.discountedPrice == 0}">무료</c:when>
																		<c:otherwise><fmt:formatNumber value="${game.discountedPrice}" pattern="#,###" />원</c:otherwise>
																	</c:choose>
																</h6>
															</div>
														</c:if>
													</div>
												</div>
											</a>
										</div>
									</div>
	                			</c:forEach>
                			</div>
                		</div>
                		
                		<div class="popular_and_review_game_wrap w-100 row m-0">
	                		<div class="popular_game_list_wrap mt-3 col-12 col-lg-6 p-0 pr-lg-3">
	                			<h4 class="text-light mb-3">최고 인기작을 만나보세요!</h4>
	                			<c:forEach items="${popularGameList }" var="game">
	                			
	                				<li class="game row m-0 bg-custom-gray mb-3 p-3 px-2 d-flex align-items-center">
										<a href="${cp}/game/view?gameNo=${game.gameNo}" class="w-100 d-flex align-items-center text-decoration-none text-light font-weight-bold">
											<div class="game_info_wrap w-75 d-flex align-items-center">
												<img src="${cp }/resources/upload/${game.gameImageList[0].storedFileName}" class="w-custom-100 mr-3 d-none d-sm-inline-block" />
												<div class="game_info_name_sale_wrap d-flex flex-column w-100-100-custom">
													<span class="d-block w-100 game_name one-line-ellipsis mb-1">${game.gameName }</span>
													<div class="d-flex align-items-center w-100">
														<h6 class="d-inline font-weight-bold one-line-ellipsis text-right m-0 <c:if test="${not empty game.saleVO}">line-through-custom text-dark</c:if>"><fmt:formatNumber value="${game.gamePrice}"
																pattern="#,###" />원</h6>
														
														<c:if test="${not empty game.saleVO}">
															<span class="ml-2 badge badge-danger"> <c:out
																	value="${game.saleVO.saleRate }%"></c:out>
															</span>
															<h6
																class="d-inline font-weight-bold one-line-ellipsis text-right m-0 ml-1 text-danger">
																<fmt:formatNumber
																	value="${game.discountedPrice}"
																	pattern="#,###" />
																원
															</h6>
														</c:if>
													</div>
												</h6>
												</div>
											</div>
								
											<div class="game_sale_count_wrap m-lg-auto w-25 text-right text-secondary pr-1">
												<span class="text-warning">
													<fmt:formatNumber
													value="${game.gameSaleCount}"
													pattern="#,###" />점
												</span>
											</div>
										</a>
									</li>
	                			</c:forEach>
	                		</div>
	                		
	                		<div class="review_game_list_wrap mt-3 col-12 col-lg-6 p-0 pl-lg-3">
	                			<h4 class="text-light mb-3">가장 높은 평점의 게임!</h4>
	                			<c:forEach items="${reviewGameList }" var="game">
	                				<li class="game row m-0 bg-custom-gray mb-3 p-3 px-2 d-flex align-items-center">
										<a href="${cp}/game/view?gameNo=${game.gameNo}" class="w-100 d-flex align-items-center text-decoration-none text-light font-weight-bold">
											<div class="game_info_wrap w-75 d-flex align-items-center">
												<img src="${cp }/resources/upload/${game.gameImageList[0].storedFileName}" class="w-custom-100 mr-3 d-none d-sm-inline-block" />
												<div class="game_info_name_sale_wrap d-flex flex-column w-100-100-custom">
													<span class="d-block w-100 game_name one-line-ellipsis mb-1">${game.gameName }</span>
													<div class="d-flex align-items-center w-100">
														<h6 class="d-inline font-weight-bold one-line-ellipsis text-right m-0 <c:if test="${not empty game.saleVO}">line-through-custom text-dark</c:if>"><fmt:formatNumber value="${game.gamePrice}"
																pattern="#,###" />원</h6>
														
														<c:if test="${not empty game.saleVO}">
															<span class="ml-2 badge badge-danger"> <c:out
																	value="${game.saleVO.saleRate }%"></c:out>
															</span>
															<h6
																class="d-inline font-weight-bold one-line-ellipsis text-right m-0 ml-1 text-danger">
																<fmt:formatNumber
																	value="${game.discountedPrice}"
																	pattern="#,###" />
																원
															</h6>
														</c:if>
													</div>
												</div>
											</div>
								
											<div class="game_review_score_wrap m-lg-auto w-25 text-right text-secondary d-flex align-items-center justify-content-end">
												<svg width="1.4rem" height="1.4rem" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg">
													<linearGradient id="half">
														<stop offset="50%" stop-color="#fdbd00"></stop>
														<stop offset="0" stop-color="#ffffff"></stop>
													</linearGradient>
													<path d="M7.12095 11.3897C7.04568 11.3481 6.95432 11.3481 6.87905 11.3897L3.0935 13.4823C3.05697 13.5025 3.01324 13.4717 3.01996 13.4305L3.74674 8.975C3.75951 8.89669 3.73435 8.81696 3.67894 8.76016L0.586662 5.59082C0.558242 5.56169 0.574668 5.51262 0.614898 5.50648L4.87464 4.85565C4.95705 4.84305 5.02777 4.79021 5.06319 4.71474L6.95474 0.684808C6.97273 0.646468 7.02727 0.646467 7.04526 0.684808L8.93681 4.71474C8.97223 4.79021 9.04295 4.84305 9.12536 4.85565L13.3851 5.50648C13.4253 5.51262 13.4418 5.56169 13.4133 5.59082L10.3211 8.76016C10.2656 8.81696 10.2405 8.89669 10.2533 8.975L10.98 13.4305C10.9868 13.4717 10.943 13.5025 10.9065 13.4823L7.12095 11.3897Z" fill="#fdbd00" stroke="#E7AC00" stroke-width="0.5" stroke-linejoin="round">
													</path>
												</svg>
												<span class="text-warning ml-1-custom">
													<span class="h4 font-weight-bolder"><fmt:formatNumber value="${game.reviewAvg }" pattern="#,###.#" /></span>/5
												</span>
											</div>
										</a>
									</li>
	                			</c:forEach>
	                		</div>
                		</div>
                	</div>

                </div>
                
				<script>
					// IIFE
					$(function(){
						var contextPath = '${cp}'; // ContextPath
						var loadMoreData = true; // 더 불러올 데이터 있는지 여부
						var nowLoading = false; // 현재 로딩 중 여부
						
						moment.locale('ko'); // moment 라이브러리 로케일을 한국어로 설정

						adjustSwiperSlideHeight();
						
						// 패턴에 따라 날짜 형식화
						function formatDate(dateString) {
							const dateObject = new Date(dateString);
							
							return formattedDate = moment(dateObject).format('YYYY-MM-DD HH:mm:ss');
						}
						
						/* 게임 리스트 스와이퍼 */
						var gameListSwiper = new Swiper(".game-list-swiper", {
							spaceBetween : 20,
							slidesPerView : 5,
							freeMode : true,
							watchSlidesProgress : true,
      						direction: "vertical",
						});
					
						/* 게임 상세 스와이퍼 */
						var gameDescSwiper = new Swiper(".game-desc-swiper", {
							navigation : {
								nextEl : ".swiper-button-next",
								prevEl : ".swiper-button-prev",
							},
							thumbs : {
								swiper : gameListSwiper,
							},
							on: {
						        afterInit: function(){
						            $(".swiper_image").removeClass("d-none");
						        },
						    },
						    autoplay: {
						        delay: 5000,
						    },
						    loop: true,
						});
						
						// 윈도우 크기 변경을 감지하여 조절
						$(window).resize(function(){
							adjustSwiperSlideHeight();
						});
						
						// right view를 상단 wrap의 너비에 의해 동적 조절
						function adjustSwiperSlideHeight(){
							const descSwiperWidth = $(".game-desc-swiper").width();
							$(".game-desc-swiper").css("height", descSwiperWidth * 9 / 16);
							
							const descSwiperHeight = $(".game-desc-swiper").height();
							$(".game-list-swiper").css("height", descSwiperHeight);
						}
						
						$(".main_wrap").on("click", ".search_icon", function(){
							$("#searchForm").submit();
						});
							
						
					}); // IIFE END
				
					
				</script>
					
                <!-- 페이지 컨텐츠 끝 -->

            </div>
            <!-- 메인 컨텐츠 끝 -->

        </div>
        <!-- 컨텐츠 Wrapper 끝 -->

    </div>
    <!-- 전체 Wrapper 끝 -->

    <!-- 맨 위로 스크롤 버튼 -->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

	<!-- 모달 JSP 삽입 -->
	<jsp:include page="../common/modal.jsp"></jsp:include>

</body>

</html>
