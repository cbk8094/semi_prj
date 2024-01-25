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
					
					<div class="cart_wrap my-5 mx-auto row">
						
						<div class="cart_top_wrap w-100 d-flex">
							<h3 class="col-12 col-lg-6 mb-3 text-light font-weight-bold">
								<a href="${cp }/member/profile?memberNo=${loginMember.memberNo}" class="d-inline-block mr-2 text-decoration-none text-primary">
									<c:if test="${loginMember.memberImageVO ne null }">
			                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom border border-secondary border-width-custom-2" src="${cp }/resources/upload/${loginMember.memberImageVO.storedFileName}">
		                			</c:if>
		                			<c:if test="${loginMember.memberImageVO eq null }">
			                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom border border-secondary border-width-custom-2" src="${cp }/resources/img/profile-no-image.webp">
		                			</c:if>
									<span>${loginMember.memberNickname }</span>
								</a><span class="h4">님의 장바구니</span>
							</h3>
							
							<!-- (PC에서만 보임) 로그인했을 경우, 현재 보고 있는 유저가 나인 경우 여기서 갈 수도 있음 -->
							<div class="d-none d-lg-flex col-6 mb-3 text-light align-items-center justify-content-end">
								<a href="${cp }/cart" class="text-light font-weight-bold mr-3 font-larger-custom text-decoration-none">장바구니</a>
								<a href="${cp }/wish/list?memberNo=${loginMember.memberNo}" class="text-secondary font-larger-custom text-decoration-none">위시리스트</a>
							</div>
						</div>
						<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
						
						<%-- ${cartItemList } --%>
						
						<div class="cart_item_wrap w-100 clearfix mt-3">
							<c:if test="${cartItemList.size() == 0 }">
							
								<!-- 장바구니에 상품이 없을 때 -->
								<div class="cart_item_left_wrap col-12 col-lg-8 p-0 pr-0 pr-lg-4 float-left">
									<div class="no_cart_item_wrap">
										<h5>장바구니에 상품이 없습니다</h5>
									</div>
								</div>
							</c:if>
							<c:if test="${cartItemList.size() > 0 }">
								<!-- 장바구니 아이템 리스트 -->
								<div class="cart_item_left_wrap col-12 col-lg-8 p-0 pr-0 pr-lg-4 float-left">
								
									<!-- ajax 로딩 시 보여줄 것 -->
									<div class="ajax-loading-spinner-wrap fixed-top position-fixed align-items-center d-none h-100 justify-content-center">
										<div class="spinner-border ajax-loading-spinner mt-5" style="width: 5rem; height: 5rem;" role="status">
											<span class="sr-only">Loading...</span>
										</div>
									</div>
								
									<div class="cart_item_list col-12 p-0">
										<c:forEach items="${cartItemList }" var="cartItem">
											<div class="cart_item col-12 p-3 mb-4 bg-custom-gray border-radius-4-custom clearfix" data-itemno='${cartItem.cartItemNo }'>
												<div class="cart_item_image_wrap w-30-custom float-left">
													<a href="${cp }/game/view?gameNo=${cartItem.gameVO.gameNo}" class="d-block hover-bright-custom">
														<img src="${cp }/resources/upload/<c:out value="${cartItem.gameVO.gameImageList[0].storedFileName}"></c:out>" class="img-fluid w-100 border-radius-4-custom"  role="button" />
													</a>
												</div>
												<div class="cart_item_info_wrap w-70-custom float-right pl-3 pr-1">
													<div class="cart_item_game_name mb-2">
														<a href="${cp }/game/view?gameNo=${cartItem.gameVO.gameNo}" class="d-block text-decoration-none text-light">
															<span class="font-large-custom font-weight-bold game_name">${cartItem.gameVO.gameName }</span>
														</a>
													</div>
													
													<div class="cart_item_sale_info d-flex mb-1">
													
														<c:if test="${cartItem.gameVO.saleVO != null }">								
															<span class="badge badge-danger font-size-85-custom mr-2"> <c:out
																value="${cartItem.gameVO.saleVO.saleRate }%"></c:out>
															</span>
														</c:if>
													
														<div class="cart_item_left_price d-flex align-items-center">
															<span class="m-0 mr-2 <c:if test="${cartItem.gameVO.saleVO != null}">line-through-custom text-secondary</c:if><c:if test="${cartItem.gameVO.saleVO == null}">text-light</c:if>">₩<fmt:formatNumber value="${cartItem.gameVO.gamePrice}" pattern="#,###" /></span>
															
															<c:if test="${cartItem.gameVO.saleVO != null }">
																<span class="m-0 text-danger">₩<fmt:formatNumber value="${cartItem.gameVO.discountedPrice}" pattern="#,###" /></span>
															</c:if>
														</div>
													</div>
													
													<c:if test="${cartItem.gameVO.saleVO != null }">
														<div class="cart_item_sale_limit">
															<span class="cart_item_sale_limit_text text-light font-size-85-custom">
																<fmt:formatDate value="${cartItem.gameVO.saleVO.saleEndDate}" pattern="yyyy. M. d. 00:00"></fmt:formatDate> 할인 종료
															</span>
														</div>
													</c:if>
													
													<div class="cart_item_sale_sub_info d-flex mt-3 text-light clearfix">
														<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" class="svg-icon-20-custom">
															<path fill-rule="evenodd" clip-rule="evenodd" d="M10 20C15.5228 20 20 15.5228 20 10C20 4.47715 15.5228 0 10 0C4.47715 0 0 4.47715 0 10C0 15.5228 4.47715 20 10 20ZM10.3827 3.07523C10.2512 2.71987 9.74862 2.71987 9.61712 3.07523L8.69694 5.562C8.1595 7.01439 7.01439 8.1595 5.562 8.69694L3.07523 9.61712C2.71987 9.74862 2.71987 10.2512 3.07523 10.3827L5.562 11.3029C7.01439 11.8403 8.1595 12.9855 8.69694 14.4378L9.61712 16.9246C9.74862 17.28 10.2512 17.28 10.3827 16.9246L11.3029 14.4378C11.8403 12.9855 12.9855 11.8403 14.4378 11.3029L16.9246 10.3827C17.28 10.2512 17.28 9.74862 16.9246 9.61712L14.4378 8.69694C12.9855 8.1595 11.8403 7.01439 11.3029 5.562L10.3827 3.07523Z" fill="currentColor"></path>
														</svg>
														<span class="font-smaller-custom ml-1">포인트 5% 적립</span>
														
														<a href="javascript:;" id="deleteCartItemButton" class="font-smaller-custom ml-auto text-secondary">삭제</a>
													</div>
												</div>
											</div>
										</c:forEach>
										
									</div>
								</div>
							</c:if>
							
							<!-- 장바구니 아이템 합계 등 정보 -->
							<div class="cart_item_right_wrap col-12 col-lg-4 p-0 float-right">
								<h3 class="col-12 mb-5 text-light font-weight-bold">게임 합계</h3>
								
								<ul class="cart_item_price_wrap text-light list-unstyled font-large-custom mb-3">
									<li class="clearfix d-flex">
										<div class="w-50">
											가격
										</div>
										<div class="w-50 text-right">
											₩<fmt:formatNumber value="${totalPrice}" pattern="#,###" />
										</div>
									</li>
									<li class="clearfix d-flex mt-3">
										<div class="w-50">
											할인 금액
										</div>
										<div class="w-50 text-right">
											-₩<fmt:formatNumber value="${discountedPrice}" pattern="#,###" />
										</div>
									</li>
									<hr class="col-12 hr border-color-custom border-width-custom my-3">
									
									<li class="clearfix d-flex font-weight-bold">
										<div class="w-50">
											소계
										</div>
										<div class="w-50 text-right text-weight-bold">
											₩<fmt:formatNumber value="${totalSalePrice}" pattern="#,###" />
										</div>
									</li>
								</ul>
									
								<div class="cart_item_button_wrap row w-100 m-0 justify-content-around">
									<button type="button" id="orderButton" class="btn btn-info btn-lg col-12 font-weight-bold">구매하기</button>
								</div>
							</div>
						</div>
					</div>
					
					<script type="text/javascript">
						$(function(){
							var contextPath = '${cp}'; // ContextPath
							var nowLoading = false; // 현재 로딩 중 여부
							
							moment.locale('ko'); // moment 라이브러리 로케일을 한국어로 설정
							
							// 패턴에 따라 날짜 형식화
							function formatDate(dateString) {
								const dateObject = new Date(dateString);
								
								return formattedDate = moment(dateObject).format('YYYY. M. d. 00:00');
							}

							// 패턴에 따라 숫자 형식화
							function formatNumber(number) {
							    return new Intl.NumberFormat('ko-KR').format(number);
							}

							// 장바구니에서 삭제 버튼
							$(".cart_item_wrap").on("click", "#deleteCartItemButton", function(){
								const cartItemNo = $(this).closest(".cart_item").data("itemno");
								
								deleteCartItem(cartItemNo);
							});
							
							// 구매하기 버튼
							$(".cart_item_wrap").on("click", "#orderButton", function(){
								let confirmResult = confirm("정말 구매하시겠습니까?");
								
								if(!confirmResult){
									return;
								}
								
								orderCartItem();
							});
							
							// 구매하기 처리
							function orderCartItem(){
								console.log("구매하기");
								
								$.ajax({
									url: contextPath + "/cart/order",
									type: "POST",
									data: {
										// 회원 정보는 세션에서 읽기로 함
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
											if(res.errorType == 2){
												alert("라이브러리에 이미 존재하는 상품이 있습니다");
												location.reload(); // 새로고침
												return;
											}else{
												alert(res.message);
											}
										}else{
											// 라이브러리로 가게 함
											alert("게임 구매에 성공했습니다");
											location.href = "${cp}/library/list?memberNo=${member.memberNo}";
										}
										
									},
									error: function(err){
										console.error(err);
									}
								});
							}
							
							// 장바구니 상품 불러오기
							function getCartItemList(){
								
								$.ajax({
									url: contextPath + "/cart",
									type: "POST",
									data: {
										// 회원 정보는 세션에서 읽기로 함
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
										
										let cartItemListStr = "";
										let cartItemList = res.data.cartItemList;
										
										cartItemList.forEach(cartItem => {
											let saleText = "";
											
											if(cartItem.gameVO.saleVO){ // 세일인 상품일 때
												saleText = `
													<div class="cart_item_sale_info d-flex mb-1">							
														<span class="badge badge-danger font-size-85-custom mr-2">\${cartItem.gameVO.saleVO.saleRate }%
														</span>
													
														<div class="cart_item_left_price d-flex align-items-center">
															<span class="m-0 mr-2 line-through-custom text-secondary">
																₩\${formatNumber(cartItem.gameVO.gamePrice)}
															</span>
															
															<span class="m-0 text-danger">
																₩\${formatNumber(cartItem.gameVO.discountedPrice)}
															</span>
														</div>
													</div>
													
													<div class="cart_item_sale_limit">
														<span class="cart_item_sale_limit_text text-light font-size-85-custom">
															\${formatDate(cartItem.gameVO.saleVO.saleEndDate)} 할인 종료
														</span>
													</div>
												`;
											}else{ // 아닐 때

												saleText = `
													<div class="cart_item_sale_info d-flex mb-1">
														<div class="cart_item_left_price d-flex align-items-center">
															<span class="m-0 mr-2 text-light">
																₩\${formatNumber(cartItem.gameVO.gamePrice)}
															</span>
														</div>
													</div>
												`;
											}
											
											cartItemListStr += `
												<div class="cart_item col-12 p-3 mb-4 bg-custom-gray border-radius-4-custom clearfix" data-itemno='\${cartItem.cartItemNo }'>
												<div class="cart_item_image_wrap w-30-custom float-left">
													<a href="${cp }/game/view?gameNo=\${cartItem.gameVO.gameNo}" class="d-block hover-bright-custom">
														<img src="${cp }/resources/upload/\${cartItem.gameVO.gameImageList[0].storedFileName}" class="img-fluid w-100 border-radius-4-custom"  role="button" />
													</a>
												</div>
												<div class="cart_item_info_wrap w-70-custom float-right pl-3 pr-1">
													<div class="cart_item_game_name mb-2">
														<a href="${cp }/game/view?gameNo=\${cartItem.gameVO.gameNo}" class="d-block text-decoration-none text-light">
															<span class="font-large-custom font-weight-bold game_name">\${cartItem.gameVO.gameName }</span>
														</a>
													</div>
													
													\${saleText}
													
													<div class="cart_item_sale_sub_info d-flex mt-3 text-light clearfix">
														<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" class="svg-icon-20-custom">
															<path fill-rule="evenodd" clip-rule="evenodd" d="M10 20C15.5228 20 20 15.5228 20 10C20 4.47715 15.5228 0 10 0C4.47715 0 0 4.47715 0 10C0 15.5228 4.47715 20 10 20ZM10.3827 3.07523C10.2512 2.71987 9.74862 2.71987 9.61712 3.07523L8.69694 5.562C8.1595 7.01439 7.01439 8.1595 5.562 8.69694L3.07523 9.61712C2.71987 9.74862 2.71987 10.2512 3.07523 10.3827L5.562 11.3029C7.01439 11.8403 8.1595 12.9855 8.69694 14.4378L9.61712 16.9246C9.74862 17.28 10.2512 17.28 10.3827 16.9246L11.3029 14.4378C11.8403 12.9855 12.9855 11.8403 14.4378 11.3029L16.9246 10.3827C17.28 10.2512 17.28 9.74862 16.9246 9.61712L14.4378 8.69694C12.9855 8.1595 11.8403 7.01439 11.3029 5.562L10.3827 3.07523Z" fill="currentColor"></path>
														</svg>
														<span class="font-smaller-custom ml-1">포인트 5% 적립</span>
														
														<a href="javascript:;" id="deleteCartItemButton" class="font-smaller-custom ml-auto text-secondary">삭제</a>
													</div>
												</div>
											</div>
											`;
										});
										
										let priceInfoText = "";
										
										priceInfoText = `
											<li class="clearfix d-flex">
												<div class="w-50">
													가격
												</div>
												<div class="w-50 text-right">
													₩\${formatNumber(res.data.totalPrice)}
												</div>
											</li>
											<li class="clearfix d-flex mt-3">
												<div class="w-50">
													할인 금액
												</div>
												<div class="w-50 text-right">
													-₩\${formatNumber(res.data.discountedPrice)}
												</div>
											</li>
											<hr class="col-12 hr border-color-custom border-width-custom my-3">
											
											<li class="clearfix d-flex font-weight-bold">
												<div class="w-50">
													소계
												</div>
												<div class="w-50 text-right text-weight-bold">
													₩\${formatNumber(res.data.totalSalePrice)}
												</div>
											</li>										
										`;
										
										$(".cart_item_price_wrap").html(priceInfoText);
										$(".cart_item_list").html(cartItemListStr);
									},
									error: function(err){
										console.error(err);
									}
								});
							}
							
							// 장바구니에서 삭제
							function deleteCartItem(cartItemNo){
								$.ajax({
									url: contextPath + "/cart/delete",
									type: "POST",
									data: {
										cartItemNo: cartItemNo,
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
											alert(res.message);
											
											$(".ajax-loading-spinner-wrap").addClass("d-none").removeClass("d-flex");
											nowLoading = false;
										}
										
										// ajax로 다시 불러옴
										getCartItemList();
									},
									error: function(err){
										console.error(err);
									}
								});
							}
							
						});
						
						
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
