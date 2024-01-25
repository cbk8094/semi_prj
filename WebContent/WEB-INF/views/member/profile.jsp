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
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		
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
                		
					<div class="profile_wrap my-5 mx-auto row">
					
						<!-- ajax 로딩 시 보여줄 것 -->
						<div class="ajax-loading-spinner-wrap fixed-top position-fixed align-items-center d-none h-100 justify-content-center">
							<div class="spinner-border ajax-loading-spinner mt-5" style="width: 5rem; height: 5rem;" role="status">
								<span class="sr-only">Loading...</span>
							</div>
						</div>
						
						<h3 class="col-12 mb-3 text-light font-weight-bold">
							<a href="${cp }/member/profile?memberNo=${member.memberNo}" class="d-inline-block mr-2 text-decoration-none text-primary">
								<c:if test="${member.memberImageVO ne null }">
		                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom border border-secondary border-width-custom-2" src="${cp }/resources/upload/${member.memberImageVO.storedFileName}">
	                			</c:if>
	                			<c:if test="${member.memberImageVO eq null }">
		                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom border border-secondary border-width-custom-2" src="${cp }/resources/img/profile-no-image.webp">
	                			</c:if>
								<span>${member.memberNickname }</span>
							</a><span class="h4">님의 마이페이지</span>
						</h3>
						<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
                		
                		<div class="profile_sub_wrap col-12 mt-3 row p-0 m-0">
	                		<div class="profile_left_wrap col-12 col-lg-8 p-0 pr-4">
		                		<div class="profile_top_wrap d-flex align-items-flex-start w-100 mb-5">
		                		
		                			<div class="profile_image_wrap w-custom-150">
				               			<c:if test="${mine == true}">
				                			<a href="javascript:;" class="position-relative d-inline-block w-100" id="changeProfileButton">
				                				<div class="w-100 h-100 position-absolute bg-white d-none opacity-50 justify-content-center align-items-center rounded-circle" id="changeProfileIcon"><i class="far fa-edit text-dark"></i></div>
				                			
					                			<c:if test="${loginMember.memberImageVO ne null }">
						                			<img class="img-profile img-fluid w-custom-150 h-custom-150 object-fit border border-secondary border-width-custom-2 object-fit-contain-custom rounded-circle" src="${cp }/resources/upload/${loginMember.memberImageVO.storedFileName}">
					                			</c:if>
					                			<c:if test="${loginMember.memberImageVO eq null }">
						                			<img class="img-profile img-fluid w-custom-150 h-custom-150 object-fit border border-secondary border-width-custom-2 object-fit-contain-custom rounded-circle" src="${cp }/resources/img/profile-no-image.webp">
					                			</c:if>
				                			</a>
				                			<input type="file" class="d-none" name="profileImage" id="profileImageInput">
				               			</c:if>
				               			<!-- 자기꺼 아닐 때 -->
				               			<c:if test="${mine != true}">
				               				<div class="w-custom-150">
					                			<c:if test="${member.memberImageVO ne null }">
						                			<img class="img-profile img-fluid w-custom-150 h-custom-150 object-fit border border-secondary border-width-custom-2 object-fit-contain-custom rounded-circle" src="${cp }/resources/upload/${member.memberImageVO.storedFileName}">
					                			</c:if>
					                			<c:if test="${member.memberImageVO eq null }">
						                			<img class="img-profile img-fluid w-custom-150 h-custom-150 object-fit border border-secondary border-width-custom-2 object-fit-contain-custom rounded-circle" src="${cp }/resources/img/profile-no-image.webp">
					                			</c:if>
				                			</div>
				               			</c:if>
		                			</div>
									
									<div class="profile_info_wrap w-100-150-custom h-100 pt-3 pl-3">
										<div class="profile_nickname_wrap d-flex align-items-center mb-1">
											<h5 id="memberNicknameText" class="m-0 text-light font-weight-bold font-extra-large-custom">${member.memberNickname }</h5>
											<c:if test="${mine == true }">
												<a href="javascript:;" id="modifyNicknameModalButton" class="ml-2 text-light">
													<i class="far fa-edit"></i>
												</a>
											</c:if>
										</div>
										
										<div class="profile_introduce_wrap d-flex align-items-center w-100">
											<pre id="memberIntroduceText" class="m-0 text-secondary five-line-ellipsis-custom-introduce font-normal-custom"><c:out value="${member.memberIntroduce}" /></pre>
											<c:if test="${mine == true }">
												<a href="javascript:;" id="modifyIntroduceModalButton" class="ml-2 text-light">
													<i class="far fa-edit"></i>
												</a>
											</c:if>
										</div>
										
									</div>
								</div>
								
								<div class="profile_library_wrap w-100 bg-custom-black p-4 mb-5">
	                				<h4 class="p-0 col-12 mb-3 text-light d-flex align-items-end">
	                					라이브러리
	                					<a href="${cp }/library/list?memberNo=${member.memberNo}" class="h6 text-light m-0 ml-auto">더보기</a>
	                				</h4>
									<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
									
									<ul class="library_list p-0 m-0 list-unstyled w-100 mb-4">
						
										<c:if test="${libraryList.size() == 0 }">
											<h5 class="mt-4">라이브러리에 게임이 없습니다</h5>
										</c:if>
									
										<c:if test="${libraryList.size() > 0 }">
											<c:forEach items="${libraryList }" var="library">
												<li class="library row m-0 mt-3 p-3 px-2 d-flex align-items-center bg-custom-gray">
													<div class="w-100">
														<a href="${cp}/game/view?gameNo=${library.gameVO.gameNo}" class="w-100 d-lg-flex align-items-center text-decoration-none text-light font-weight-bold">
															<div class="game_info_wrap w-100 d-flex align-items-center">
																<img src="${cp }/resources/upload/${library.gameVO.gameImageList[0].storedFileName}" class="w-custom-100 mr-3 d-none d-sm-inline-block" />
																<span class="game_name one-line-ellipsis">${library.gameVO.gameName }</span>
															</div>
														</a>
													</div>
												</li>
											</c:forEach>
										</c:if>
									</ul>
									
									<div class="library_info row">
										<div class="library_game_count_wrap col-5 col-lg-3 d-flex flex-column">
											<h3 class="text-light mb-1">${libraryCount }</h3>
											<h5 class="text-secondary p-0 m-0">게임 보유</h5>
										</div>
										<div class="library_purchase_amount_wrap col-7 col-lg-9 d-flex flex-column">
											<h3 class="text-light mb-1"><fmt:formatNumber value="${member.memberPurchase}" pattern="#,###" /></span>원</h3>
											<h5 class="text-secondary p-0 m-0">누적 구매금액</h5>
										</div>
									</div>
								</div>
								
								<div class="profile_review_wrap w-100 bg-custom-black p-4 mb-5">
	                				<h4 class="p-0 col-12 mb-3 text-light d-flex align-items-end">
	                					평가
	                					<a href="${cp }/review/list?memberNo=${member.memberNo}" class="h6 text-light m-0 ml-auto">더보기</a>
	                				</h4>
									<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
									
									<ul class="review_list p-0 m-0 list-unstyled w-100 mb-4">
						
										<c:if test="${reviewList.size() == 0 }">
											<h5 class="mt-4">평가한 게임이 없습니다</h5>
										</c:if>
									
										<c:if test="${reviewList.size() > 0 }">
											<c:forEach items="${reviewList }" var="review">
												<li class="review row m-0 mt-3 p-3 px-2 d-flex align-items-center bg-custom-gray">
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
											</c:forEach>
										</c:if>
									</ul>
									
									<div class="review_info row">
										<div class="review_game_count_wrap col-5 col-lg-3 d-flex flex-column">
											<h3 class="text-light mb-1">${reviewCount }</h3>
											<h5 class="text-secondary p-0 m-0">평가 개수</h5>
										</div>
										<div class="review_purchase_amount_wrap col-7 col-lg-9 d-flex flex-column">
											<div class="review_score_wrap d-flex align-items-center">
												<svg width="1.5rem" height="1.5rem" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg" class="mb-1 mr-1">
													<linearGradient id="half">
														<stop offset="50%" stop-color="#fdbd00"></stop>
														<stop offset="0" stop-color="#ffffff"></stop>
													</linearGradient>
													<path d="M7.12095 11.3897C7.04568 11.3481 6.95432 11.3481 6.87905 11.3897L3.0935 13.4823C3.05697 13.5025 3.01324 13.4717 3.01996 13.4305L3.74674 8.975C3.75951 8.89669 3.73435 8.81696 3.67894 8.76016L0.586662 5.59082C0.558242 5.56169 0.574668 5.51262 0.614898 5.50648L4.87464 4.85565C4.95705 4.84305 5.02777 4.79021 5.06319 4.71474L6.95474 0.684808C6.97273 0.646468 7.02727 0.646467 7.04526 0.684808L8.93681 4.71474C8.97223 4.79021 9.04295 4.84305 9.12536 4.85565L13.3851 5.50648C13.4253 5.51262 13.4418 5.56169 13.4133 5.59082L10.3211 8.76016C10.2656 8.81696 10.2405 8.89669 10.2533 8.975L10.98 13.4305C10.9868 13.4717 10.943 13.5025 10.9065 13.4823L7.12095 11.3897Z" fill="#fdbd00" stroke="#E7AC00" stroke-width="0.5" stroke-linejoin="round">
													</path>
												</svg>
												<h3 class="text-light mb-1">
													<fmt:formatNumber value="${reviewAvgScore }" pattern="#,###.#" /><span class="h5">/5</span>
												</h3>
											</div>
											<h5 class="text-secondary p-0 m-0">평균 평점</h5>
										</div>
									</div>
								</div>
								
								<div class="profile_guestbook_wrap w-100 bg-custom-black p-4 mb-5">
	                				<h4 class="p-0 col-12 mb-3 text-light d-flex align-items-end">
	                					방명록
	                				</h4>
									<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
									
									<ul class="guestbook_list p-0 m-0 list-unstyled w-100">
						
										<c:if test="${guestbookList.size() == 0 }">
											<h5 class="mt-4">방명록을 남긴 회원이 없습니다</h5>
										</c:if>
									
										<c:if test="${guestbookList.size() > 0 }">
											<c:forEach items="${guestbookList }" var="guestbook">
												<li class="guestbook row m-0 mt-3 p-3 px-2 d-flex align-items-center bg-custom-gray">
													<div class="w-100 row p-0 m-0">
													
														<div class="guestbook_image_wrap w-custom-50">
															<a href="${cp }/member/profile?memberNo=${guestbook.memberVO.memberNo}">
																<c:if test="${guestbook.memberVO.memberImageVO ne null }">
										                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom border border-secondary border-width-custom-2" src="${cp }/resources/upload/${guestbook.memberVO.memberImageVO.storedFileName}">
									                			</c:if>
									                			<c:if test="${guestbook.memberVO.memberImageVO eq null }">
										                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom border border-secondary border-width-custom-2" src="${cp }/resources/img/profile-no-image.webp">
									                			</c:if>
								                			</a>
							                			</div>
							                			<div class="guestbook_content_wrap d-flex flex-column w-100-50-custom pl-3">
															<div class="guestbook_content_top_wrap mb-1">
																<a href="${cp }/member/profile?memberNo=${guestbook.memberVO.memberNo}" class="font-large-custom text-light text-decoration-none mr-2">${guestbook.memberVO.memberNickname}</a>
																<span class="text-secondary">
																	<fmt:formatDate value="${guestbook.regDate }" pattern="yyyy-MM-dd HH:mm:ss" />
																</span>
															</div>
															<div class="guestbook_content_bottom_wrap">
																<span class="five-line-ellipsis-custom-introduce">${guestbook.guestbookContent }</span>
															</div>				
							                			</div>
														
													</div>
												</li>
											</c:forEach>
										</c:if>
									</ul>
									
								</div>
							</div>
							
	                		<div class="profile_right_wrap d-none d-lg-block col-lg-4 m-0 p-0">
	                			<div class="profile_status_wrap w-100 bg-custom-black p-4 mb-5 bg-custom-black">
		                			<h4 class="p-0 col-12 mb-4 text-primary">온라인 상태</h4>
		                			
		                			<a href="${cp }/library/list?memberNo=${member.memberNo}" class="mb-2 d-block text-light text-decoration-none">
		                				<span class="text-light font-large-custom mr-1">게임</span>
		                				<span class="h4 text-secondary font-extra-large-custom">${libraryCount}</span>
		               				</a>
		                			<a href="${cp }/wish/list?memberNo=${member.memberNo}" class="mb-2 d-block text-light text-decoration-none">
		                				<span class="text-light font-large-custom mr-1">위시리스트</span>
		                				<span class="h4 text-secondary font-extra-large-custom">${wishCount}</span>
		               				</a>
		                			<a href="${cp }/review/list?memberNo=${member.memberNo}" class="mb-2 d-block text-light text-decoration-none">
		                				<span class="text-light font-large-custom mr-1">평가</span>
		                				<span class="h4 text-secondary font-extra-large-custom">${reviewCount}</span>
		               				</a>
	               				</div>
	               				
	               				<div class="profile_wish_wrap w-100 bg-custom-black p-4 mb-5">
	                				<h4 class="p-0 col-12 mb-3 text-light d-flex align-items-end">
	                					위시리스트
	                					<a href="${cp }/wish/list?memberNo=${member.memberNo}" class="h6 text-light m-0 ml-auto">더보기</a>
	                				</h4>
									<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
									
									<ul class="wish_list p-0 m-0 list-unstyled w-100">
						
										<c:if test="${wishList.size() == 0 }">
											<h5 class="mt-4">라이브러리에 게임이 없습니다</h5>
										</c:if>
									
										<c:if test="${wishList.size() > 0 }">
											<c:forEach items="${wishList }" var="wish">
												<li class="wish row m-0 mt-3 p-3 px-2 d-flex align-items-center bg-custom-gray">
													<div class="w-100">
														<a href="${cp}/game/view?gameNo=${wish.gameVO.gameNo}" class="w-100 d-lg-flex align-items-center text-decoration-none text-light font-weight-bold">
															<div class="game_info_wrap w-100 d-flex align-items-center">
																<img src="${cp }/resources/upload/${wish.gameVO.gameImageList[0].storedFileName}" class="w-custom-100 mr-3 d-none d-sm-inline-block" />
																<span class="game_name one-line-ellipsis">${wish.gameVO.gameName }</span>
															</div>
														</a>
													</div>
												</li>
											</c:forEach>
										</c:if>
									</ul>
									
								</div>
	                			
	                		</div>
                		
                		</div>
							
					</div>
				</div>
                
				<script>
				$(function() { // IIFE
					
					var contextPath = '${cp}'; // ContextPath
					var loadMoreData = true; // 더 불러올 데이터 있는지 여부
					var nowLoading = false; // 현재 로딩 중 여부
					
					moment.locale('ko'); // moment 라이브러리 로케일을 한국어로 설정
					
					// 패턴에 따라 날짜 형식화
					function formatDate(dateString) {
						const dateObject = new Date(dateString);
						
						return formattedDate = moment(dateObject).format('YYYY. M. D.');
					}
					
					// 닉네임 수정 모달 버튼
					$(".profile_wrap").on("click", "#modifyNicknameModalButton", function(){
						console.log("test");
						
						$("#modifyNicknameModal").modal("show");
					});
					
					// 자기소개 수정 모달 버튼
					$(".profile_wrap").on("click", "#modifyIntroduceModalButton", function(){
						console.log("test");
						$("#modifyIntroduceModal").modal("show");
					});
					
					// 닉네임 수정 버튼
					$("#modifyNicknameModal").on("click", "#modifyNicknameButton", function(){
						modifyNickname();
					});
					
					// 자기소개 수정 버튼
					$("#modifyIntroduceModal").on("click", "#modifyIntroduceButton", function(){
						modifyIntroduce();
					});
					
					// 닉네임 수정 처리
					function modifyNickname(){

						const memberNickname = $("#nicknameInput").val();
						
						$.ajax({
							url : "${cp}/member/profile", 
							method : "POST",
							data: {
								memberNickname: memberNickname,
								memberNo: '${member.memberNo}'
							},
							beforeSend: function(){
								$(".ajax-loading-spinner-wrap").removeClass("d-none").addClass("d-flex");
								nowLoading = true;
							},
							complete: function(){
								$(".ajax-loading-spinner-wrap").addClass("d-none").removeClass("d-flex");
								nowLoading = false;
							},
							success : function(res){
								console.log(res);
								
								if(res.success === true){
									alert("닉네임이 수정되었습니다");
									$("#memberNicknameText").text(memberNickname);
									
									// 모달창의 input 비우고 닫음
									$("#nicknameInput").val("");
									$("#modifyNicknameModal").modal("hide");
								}else{
									alert(res.message);
								}
							},
							error: function(err){
								console.error(err);
							}
					 	});	
					}
					
					// 자기소개 수정 처리
					function modifyIntroduce(){
const memberIntroduce = $("#introduceInput").val();
						
						$.ajax({
							url : "${cp}/member/profile", 
							method : "POST",
							data: {
								memberIntroduce: memberIntroduce,
								memberNo: '${member.memberNo}'
							},
							beforeSend: function(){
								$(".ajax-loading-spinner-wrap").removeClass("d-none").addClass("d-flex");
								nowLoading = true;
							},
							complete: function(){
								$(".ajax-loading-spinner-wrap").addClass("d-none").removeClass("d-flex");
								nowLoading = false;
							},
							success : function(res){
								console.log(res);
								
								if(res.success === true){
									alert("자기소개가 수정되었습니다");
									$("#memberIntroduceText").text(memberIntroduce);

									// 모달창의 input 비우고 닫음
									$("#introduceInput").val("");
									$("#modifyIntroduceModal").modal("hide");
									
								}else{
									alert(res.message);
								}
								
							},
							error: function(err){
								console.error(err);
							}
					 	});	
					}
					
					// 프사 변경 버튼에 마우스 올라갔을 때
					$(".profile_wrap").on("mouseover", "#changeProfileButton", function(){
						$("#changeProfileIcon").removeClass("d-none").addClass("d-flex");
					});

					// 프사 변경 버튼에 마우스 내려갔을 때
					$(".profile_wrap").on("mouseleave", "#changeProfileButton", function(){
						$("#changeProfileIcon").addClass("d-none").removeClass("d-flex");
					});
					
					// 프로필 사진 변경 버튼 클릭
					$(".profile_wrap").on("click", "#changeProfileButton", function(){
						// 프로필사진 변경
						console.log("프사 변경 누름");
						
						// input type file을 숨겨놓을 것임.
						$("#profileImageInput").trigger("click");
					});
					
					// 프사 파일 input 변경 시
					$(".profile_wrap").on("change", "#profileImageInput", function(){
						// 프사 변경됨
						console.log("프사 변경됨");
					    const file = this.files[0];
					    const formData = new FormData();
					    formData.append("file", file);
					    
					    // FormData는 직접적으로 확인이 안 될 수 있다.
					    uploadProfileImage(formData);
					    
					});
					
					function uploadProfileImage(formData){
						$.ajax({
							url: "${cp}/member/upload",
							type: "POST",
							data: formData,
							processData: false, // 데이터 처리하지 않도록 설정
					        contentType: false, // 컨텐츠 타입 설정하지 않도록 설정
							beforeSend: function(){
								$(".ajax-loading-spinner-wrap").removeClass("d-none").addClass("d-flex");
								nowLoading = true;
							},
							complete: function(){
								$(".ajax-loading-spinner-wrap").addClass("d-none").removeClass("d-flex");
								nowLoading = false;
							},
							success: function(res){
								if(res.success === true){
									$(".img-profile").attr("src", "${cp }/resources/upload/" + res.data.uuid);
									alert("프로필 사진을 변경했습니다");
								}else{
									alert(res.message);
								}
							},
							error: function(err){
								console.error(err);
							}
						});
						
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
