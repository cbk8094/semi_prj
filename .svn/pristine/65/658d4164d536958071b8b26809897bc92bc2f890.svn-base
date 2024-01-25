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
					
					<div class="purchase_list_wrap my-5 mx-auto row">
						
						<div class="purchase_list_top_wrap w-100 d-flex">
							<h3 class="col-12 col-lg-6 mb-3 text-light font-weight-bold">
								<a href="${cp }/member/profile?memberNo=${loginMember.memberNo}" class="d-inline-block mr-2 text-decoration-none text-primary">
									<c:if test="${loginMember.memberImageVO ne null }">
			                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom border border-secondary border-width-custom-2" src="${cp }/resources/upload/${loginMember.memberImageVO.storedFileName}">
		                			</c:if>
		                			<c:if test="${loginMember.memberImageVO eq null }">
			                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom border border-secondary border-width-custom-2" src="${cp }/resources/img/profile-no-image.webp">
		                			</c:if>
									<span>${loginMember.memberNickname }</span>
								</a><span class="h4">님의 구매내역</span>
							</h3>
							
							<!-- (PC에서만 보임) 로그인했을 경우, 현재 보고 있는 유저가 나인 경우 여기서 갈 수도 있음 -->
							<div class="d-none d-lg-flex col-6 mb-3 text-light align-items-center justify-content-end">
								<a href="${cp }/library/list?memberNo=${loginMember.memberNo}" class="text-secondary mr-3 font-larger-custom text-decoration-none">라이브러리</a>
								<a href="${cp }/purchase/list" class="text-light font-weight-bold font-larger-custom text-decoration-none">구매내역</a>
							</div>
						</div>
							
						<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
						
						<!-- ajax 로딩 시 보여줄 것 -->
						<div class="ajax-loading-spinner-wrap fixed-top position-fixed align-items-center d-none h-100 justify-content-center">
							<div class="spinner-border ajax-loading-spinner mt-5" style="width: 5rem; height: 5rem;" role="status">
								<span class="sr-only">Loading...</span>
							</div>
						</div>
							
						<div class="purchase_list_sub_wrap w-100 mt-3">
							<table class="table-height-custom purchase_list_table table table-dark bg-custom-gray table-striped table-layout-fixed-custom">
							  	<thead class="text-center">
							    	<tr>
							    		<!-- 날짜는 md 크기, 환불은 PC 크기에서만 보임 -->
										<th scope="col" class="w-15-custom d-none d-md-table-cell">날짜</th>
										<th scope="col" class="w-40-custom">아이템</th>
										<th scope="col" class="w-10-custom">종류</th>
										<th scope="col" class="w-15-custom">합계</th>
										<th scope="col" class="w-7-custom d-none d-xl-table-cell">환불</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${purchaseList }" var="purchase">
									    <tr data-purchaseno="${purchase.purchaseNo }">
											<td class="text-center d-none d-md-block one-line-ellipsis text-secondary align-middle">
												<div class="purchase_date one-line-ellipsis">
													<fmt:formatDate value="${purchase.purchaseDate}" pattern="yyyy. M. d."></fmt:formatDate>
												</div>
												<div class="purchase_time one-line-ellipsis">
													<fmt:formatDate value="${purchase.purchaseDate}" pattern="HH:mm:ss"></fmt:formatDate>
												</div>
												
											</td>
											<td class="one-line-ellipsis align-middle">
												<a href="${cp }/game/view?gameNo=${purchase.gameVO.gameNo}" class="text-decoration-none text-light font-weight-bold">${purchase.gameVO.gameName }</a>
											</td>
											
											<td class="text-center one-line-ellipsis align-middle <c:if test="${purchase.hasRefund == true and purchase.isRefund() != true }">line-through-custom text-secondary</c:if>">${!purchase.isRefund() ? "구매" : "환불" }</td>
											<td class="text-center one-line-ellipsis align-middle <c:if test="${purchase.hasRefund == true and purchase.isRefund() != true }">line-through-custom text-secondary</c:if>">₩<fmt:formatNumber value="${purchase.purchasePrice}" pattern="#,###" /></td>
											<td class="text-center align-middle d-none d-xl-table-cell">
												<c:if test="${purchase.hasRefund != true && purchase.isRefund() != true }">
													<a href="javascript:;" id="refundModalButton" class="d-inline-block text-center text-decoration-none text-secondary">
														<i class="fas fa-receipt w-100 fa-lg"></i>
													</a>
												</c:if>
											</td>
										</tr>
									</c:forEach>
							  	</tbody>
							</table>
						</div>
						
					</div>
					<!-- wish_list_wrap 끝 -->
					
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
							
							// 환불 버튼 누름
							$(".purchase_list_wrap").on("click", "#refundModalButton", function(){
								const purchaseNo = $("#refundModal #purchaseNoInput").val($(this).closest("tr").data("purchaseno"));
								
								$("#refundModal").modal("show");
							});
							
							// 환불 처리
							$("#refundModal").on("click", "#refundButton", function(){
								const purchaseNo = $("#refundModal #purchaseNoInput").val();
								
								refund(purchaseNo);
							});
							
							function refund(purchaseNo){

								$.ajax({
									url: "${cp}/purchase/refund",
									type: "POST",
									data: {
										// 로그인한 회원 정보는 서버에서 체크
										purchaseNo: purchaseNo,
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
										if(res.success === true){
											console.log(res);
											
											// 새로고침으로 처리함
											alert("환불을 완료했습니다");
											location.reload();
										}else{
											alert(res.message);
										}
										
									},
									error: function(err){
										console.error(err);
									}
								});
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
