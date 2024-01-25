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
                	<div class="review_list_wrap my-5 col-12 mx-auto">
						<h3 class="col-12 col-lg-6 mb-3 text-light font-weight-bold">
							<a href="${cp }/member/profile?memberNo=${member.memberNo}" class="d-inline-block mr-2 text-decoration-none text-primary">
								<c:if test="${member.memberImageVO ne null }">
		                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom  border border-secondary border-width-custom-2" src="${cp }/resources/upload/${member.memberImageVO.storedFileName}">
	                			</c:if>
	                			<c:if test="${member.memberImageVO eq null }">
		                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom  border border-secondary border-width-custom-2" src="${cp }/resources/img/profile-no-image.webp">
	                			</c:if>
								<span>${member.memberNickname }</span>
							</a><span class="h4">님의 리뷰 목록</span>
						</h3>
						<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
						
						<ul class="review_list row gx-4 row-cols-1 row-cols-lg-2 m-0 justify-content-left list-unstyled w-100 mb-4">
						
							<c:if test="${reviewList.size() == 0 }">
								<h5 class="mt-4">평가한 게임이 없습니다</h5>
							</c:if>

							<c:if test="${reviewList.size() > 0 }">
								<c:forEach items="${reviewList }" var="review" varStatus="status">
									<div class="review_wrap col p-0 <c:if test="${status.index % 2 == 0 }">pr-lg-3</c:if>">
										<li class="review mt-3 p-3 px-2 d-flex align-items-center bg-custom-gray">
											<div class="w-100 row p-0 m-0">
												<div class="game_review_left p-0 pr-3 col-12 col-md-5 col-lg-12 col-xl-5 d-flex align-items-start">
													<a href="${cp}/game/view?gameNo=${review.gameVO.gameNo}" class="w-100 d-lg-flex align-items-center text-decoration-none text-light font-weight-bold">
														<div class="game_info_wrap w-100 d-flex align-items-center">
															<img src="${cp }/resources/upload/${review.gameVO.gameImageList[0].storedFileName}" class="w-custom-100 mr-3 d-none d-sm-inline-block" />
															<span class="game_name one-line-ellipsis">${review.gameVO.gameName }</span>
														</div>
													</a>
												</div>
											
												<div class="game_review_right p-0 col-12 col-md-7 col-lg-12 col-xl-7 mt-3 mt-md-0 mt-lg-3 mt-xl-0">
													<div class="game_review_stars clearfix mb-2">
														<c:forEach begin="1" end="${review.reviewScore }">
															<svg class="float-left mr-1-custom" width="1.2rem" height="1.2rem" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg">
																<linearGradient id="half">
																	<stop offset="50%" stop-color="#fdbd00"></stop>
																	<stop offset="0" stop-color="#ffffff"></stop>
																</linearGradient>
																<path d="M7.12095 11.3897C7.04568 11.3481 6.95432 11.3481 6.87905 11.3897L3.0935 13.4823C3.05697 13.5025 3.01324 13.4717 3.01996 13.4305L3.74674 8.975C3.75951 8.89669 3.73435 8.81696 3.67894 8.76016L0.586662 5.59082C0.558242 5.56169 0.574668 5.51262 0.614898 5.50648L4.87464 4.85565C4.95705 4.84305 5.02777 4.79021 5.06319 4.71474L6.95474 0.684808C6.97273 0.646468 7.02727 0.646467 7.04526 0.684808L8.93681 4.71474C8.97223 4.79021 9.04295 4.84305 9.12536 4.85565L13.3851 5.50648C13.4253 5.51262 13.4418 5.56169 13.4133 5.59082L10.3211 8.76016C10.2656 8.81696 10.2405 8.89669 10.2533 8.975L10.98 13.4305C10.9868 13.4717 10.943 13.5025 10.9065 13.4823L7.12095 11.3897Z" fill="#fdbd00" stroke="#E7AC00" stroke-width="0.5" stroke-linejoin="round">
																</path>
															</svg>
														</c:forEach>
													</div>
													
													<div class="game_review_content_wrap">
														<div class="game_review_date_wrap mb-1">
															<span class="game_review_date font-smaller-custom">
																게시일: <fmt:formatDate value="${review.regDate }" pattern="yyyy-MM-dd HH:mm:ss" />
															</span>
														</div>
														<div class="game_review_content text-light">
															<c:out value="${review.reviewContent }"></c:out>
														</div>
													</div>
												</div>
												
											</div>
										</li>
									</div>
								</c:forEach>
							</c:if>
						</ul>
						
						<div class="paging_wrap d-flex justify-content-center">
							<ul class="pagination pagination-custom">
								<li class="page-item ${pageDTO.prevs ? '' : 'disabled' }"><a
									class="page-link"
									href="${cp}/review/list?memberNo=${member.memberNo }&pageNum=${pageDTO.startPage - 1}"><i
										class="fas fa-solid fa-angle-double-left"></i></a></li>
								<li class="page-item ${pageDTO.prev ? '' : 'disabled' }"><a
									class="page-link"
									href="${cp}/review/list?memberNo=${member.memberNo }&pageNum=${pageDTO.criteria.pageNum - 1}"><i
										class="fas fa-solid fa-angle-left"></i></a></li>
								<c:forEach begin="${pageDTO.startPage }" end="${pageDTO.endPage }" var="i">
									<li class="page-item ${pageDTO.criteria.pageNum eq i ? 'active' : '' }">
										<a class="page-link" href="${cp}/review/list?memberNo=${member.memberNo }&pageNum=${i }">${i }</a>
									</li>
								</c:forEach>
								<li class="page-item ${pageDTO.next ? '' : 'disabled' }"><a
									class="page-link"
									href="${cp}/review/list?memberNo=${member.memberNo }&pageNum=${pageDTO.criteria.pageNum + 1}"><i
										class="fas fa-solid fa-angle-right"></i></a></li>
								<li class="page-item ${pageDTO.nexts ? '' : 'disabled' }"><a
									class="page-link"
									href="${cp}/review/list?memberNo=${member.memberNo }&pageNum=${pageDTO.endPage + 1}"><i
										class="fas fa-solid fa-angle-double-right"></i></a></li>
							</ul>
						</div>
                	</div>

                </div>
                
                <script type="text/javascript">
                
                	// IIFE
                	$(function(){

    					var contextPath = '${cp}'; // ContextPath
    					var loadMoreData = true; // 더 불러올 데이터 있는지 여부
    					var nowLoading = false; // 현재 로딩 중 여부
    					
    					moment.locale('ko'); // moment 라이브러리 로케일을 한국어로 설정
    					
    					// 패턴에 따라 날짜 형식화
    					function formatDate(dateString) {
    						const dateObject = new Date(dateString);
    						
    						return formattedDate = moment(dateObject).format('YYYY. M. D.');
    					}
    					
                	});
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
