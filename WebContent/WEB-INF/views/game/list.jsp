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
					<div class="game_list_wrap my-5 col-12 mx-auto">
						<div class="row search_wrap col-12 col-lg-10 col-xl-8">
							<h3 class="mb-4 text-light font-weight-bold">검색 옵션</h3>
							<form id="searchForm" class="mb-5">
								<!-- 이 값들은 뒤로가기해도 값이 남아있음 -->
								<input type="hidden" id="nowPageInput" value="1">
								<input type="hidden" id="titleInput" value="${searchWord }">
								<input type="hidden" id="genreInput">
								<input type="hidden" id="priceInput">
								<input type="hidden" id="languageInput">
								<input type="hidden" id="saleInput">
								<div class="form-group row mb-2">
									<label for="titleSelect"
										class="text-light col-sm-4 col-lg-3 col-form-label">제목검색</label>
									<input type="text" class="game_search_input form-control col-sm-8 col-lg-9" id="titleSelect" placeholder="제목을 입력해주세요" value="${searchWord }">
								</div>
								<div class="form-group row mb-2">
									<label for="genreSelect"
										class="text-light col-sm-4 col-lg-3 col-form-label">장르선택</label>
									<select class="game_search_input form-control col-sm-8 col-lg-9" id="genreSelect"
										role="button">
										<option value="0">전체</option>
										<c:forEach items="${genreList}" var="genre">
											<option value="${genre.genreNo}">
												<c:out value="${genre.genreName }"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group row mb-2">
									<label for="priceSelect"
										class="text-light col-sm-4 col-lg-3 col-form-label">가격범위</label>
										
									<div class="range_wrap row no-gutters col-sm-8 col-lg-9 p-0">
										<input type="range" class="game_search_input form-range w-100 h-custom-40"
										id="priceSelect" min="0" max="21" value="21" role="button">
										<div class="range_text text-light w-100 text-center h-custom-30">모든 가격</div>
									</div>
								</div>
								<div class="form-group row mb-2">
									<label class="text-light col-sm-4 col-lg-3 col-form-label">지원언어</label>

									<div class="checkbox-wrap-custom col-sm-8 col-lg-9 px-1 py-0 pb-1">
										<div class="language_wrap row no-gutters">
											<c:forEach items="${languageList}" var="language">
												<div class="form-check form-check-inline col-6 col-md-4 col-lg-3 m-0 py-1 custom-control custom-checkbox">
													<input type="checkbox" class="game_search_input form-check-input custom-control-input languageCheckbox" id="language${language.languageNo }" data-language="${language.languageNo }" role="button"> 
													<label class="form-check-label custom-control-label text-light" for="language${language.languageNo }" role="button">${language.languageName }</label>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="text-light col-sm-4 col-lg-3 col-form-label">기타옵션</div>
									<div class="col-sm-8 col-lg-9 px-1 py-2 custom-control custom-checkbox">
										<div class="form-check form-check-inline m-0 p-0 mb-2 d-flex align-items-center">
										
											<label class="custom-switch m-0" for="saleCheckbox" role="button">
												<input type="checkbox" class="game_search_input default" id="saleCheckbox" role="button">
												<span class="custom-slider round"></span>
											</label>
											<span class="text-light ml-2">할인상품</span>
											
											<!-- <input type="checkbox" class="game_search_input form-check-input custom-control-input saleCheckbox" id="saleCheckbox" role="button"> 
											<label class="form-check-label custom-control-label text-light" for="saleCheckbox" role="button">할인상품만 보기</label> -->
										</div>
									</div>
								</div>
							</form>
						</div>

						<h3 class="mb-4 text-light font-weight-bold">게임 목록</h3>

						<div class="game_list row gx-4 gx-lg-5 row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4 justify-content-left">
							<c:forEach items="${gameList}" var="game">
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
						
						<!-- ajax 로딩 시 보여줄 것 -->
						<div class="ajax-loading-spinner-wrap fixed-top position-fixed align-items-center d-none h-100 justify-content-center">
							<div class="spinner-border ajax-loading-spinner mt-5" style="width: 5rem; height: 5rem;" role="status">
								<span class="sr-only">Loading...</span>
							</div>
						</div>

					</div>
					
					<script type="text/javascript">
						$(function(){
							
							// 처음값은 loadMoreData값을 true로 한다.
							// 이 loadMoreData가 true이면 추가로 불러올 수 있는 데이터가 있음을 나타낸다
							var contextPath = '${cp}'; // ContextPath
							var loadMoreData = true; // 어차피 해당 IIFE 스코프 내에서만 적용됨
							var nowLoading = false; // 현재 로딩 중 여부

							// 패턴에 따라 숫자 형식화
							function formatNumber(number) {
							    return new Intl.NumberFormat('ko-KR').format(number);
							}
							
							// 게임 리스트 ajax로 받아오는 함수
							function getGameList(data){
								
								console.log(data);
								
								// 현재 로딩 중이면 리턴
								if(nowLoading){
									return;
								}
								
								$.ajax({
									url: "${cp}/game/list",
									type: "POST",
									data: data,
									beforeSend: function(){
										// ajax 시작하면 먼저 game_list 비우고 로딩 이미지 보여준다
										if(!data.isPaging){ // 페이징이 아닌 경우 game_list 비움
											$(".game_list").html("");
										}
										
										// 로딩 중에는 다시 로딩 못 하게 하기
										
										$(".ajax-loading-spinner-wrap").removeClass("d-none").addClass("d-flex");
										nowLoading = true; // 현재 로딩 중
									},
									complete: function(){
										$(".ajax-loading-spinner-wrap").addClass("d-none").removeClass("d-flex");
										nowLoading = false;
									},
									success: function(res){
										// 여기서 game_list 내를 비워서 변경된 것들을 출력한다
										
										// 새로 불러온 데이터의 개수가 한 페이지(16개) 미만일 시 loadMoreData를 false로 바꾼다.
										if(res.length < 16){
											loadMoreData = false;
										}else{
											loadMoreData = true;
										}
										
										let newDataStr = "";
										
										res.forEach(function(e){
											
											// 포맷팅된 할인 가격 표시
											
											let formattedPrice = "";
											let formattedSalePrice = "";
											if(e.gamePrice == 0){
												formattedPrice = "무료";
											}else{
												formattedPrice = formatNumber(e.gamePrice) + "원";
											}
											
											if(e.discountedPrice == 0){
												formattedSalePrice = "무료";
											}else{
												formattedSalePrice = formatNumber(e.discountedPrice) + "원";
											}
											
											let formattedSalePriceText = "";
											
											if(e.saleVO){
												formattedPriceText = `
													<h6 class="font-weight-bold one-line-ellipsis text-right m-0 line-through-custom text-dark mb-1">
														\${formattedPrice}
													</h6>
												`;
												
												formattedSalePriceText = `
													<div class="d-flex float-right">
														<span class="badge badge-danger"> 
															\${e.saleVO.saleRate}%
														</span>
														<h6
															class="font-weight-bold one-line-ellipsis text-right m-0 ml-2 text-danger">
															\${formattedSalePrice}
														</h6>
													</div>
												`;
											}else{
												formattedPriceText = `
													<h6 class="font-weight-bold one-line-ellipsis text-right m-0">
														\${formattedPrice}
													</h6>
												`;
											}
											
											newDataStr += `
												<div class="col mb-5">
												<div
													class="card rounded-0 h-100 border-0 box-shadow-custom bg-custom-black hover-box-shadow-white">
													<a href="\${contextPath}/game/view?gameNo=\${e.gameNo}" class="text-decoration-none text-light">
														<img class="card-img-top card-img-top-custom rounded-0" 
														src="${cp }/resources/upload/\${e.gameImageList[0].storedFileName}" alt="게임 이미지" />
														<div class="card-body p-4 bg-custom-black">
															<div class="text-center clearfix">
																<h6 class="two-line-ellipsis h-custom-40 text-left">
																	<c:out value="\${e.gameName }"></c:out>
																</h6>
																\${formattedPriceText}
																\${formattedSalePriceText}
															</div>
														</div>
													</a>
												</div>
											</div>
											`;
										});
										
										if(data.isPaging){
											$(".game_list").append(newDataStr);
										}else{
											$(".game_list").html(newDataStr);
										}
									},
									error: function(err){
										console.error(err);
									}
								});
							}
							
							// 기본 submit 막음
							$("#searchForm").on("submit", function(){
								return false;
							});
							
							// 뭔가 필터링 조건이 변경되었을 때
							$(".game_list_wrap").on("change", ".game_search_input", function(){
								
								// 해당 필터링된 추가로 불러올 데이터 여부를 true로 한다.
								loadMoreData = true;

								// 해당 필터링된 페이지를 다시 1로 한다
								$("#nowPageInput").val("1");
								
								const nowPage = $("#nowPageInput").val();
								const title = $("#titleSelect").val();
								const genre = $("#genreSelect").val();
								const price = $("#priceSelect").val() * 5000; // 0은 무료 게임만 표시, 21은 제한 없음

								let rangePriceText = "";
								
								if(price <= 0){
									rangePriceText = "무료";
								}else if(price > 100000){
									rangePriceText = "모든 가격";
								}else{
									rangePriceText = formatNumber(price) + "원 이하";
								}
								
								$(".range_text").html(rangePriceText);
								
								// 선택한 언어들
								let selectedLanguages = [];
								
								$(".languageCheckbox").each(function(){
									if($(this).prop("checked") === true){
										selectedLanguages.push($(this).data("language"));
									}
								});
								
								const language = selectedLanguages.join("|");
								const sale = $("#saleCheckbox").prop("checked") ? "1" : "0";
								const isPaging = false;
								
								// 값 바꿀 시 input hidden에 값 저장
								// 이후로 더보기 요청할 때마다 추가로 읽음
								
								$("#titleInput").val($("#titleSelect").val());
								$("#genreInput").val($("#genreSelect").val());
								$("#priceInput").val($("#priceSelect").val());
								$("#languageInput").val(language);
								$("#saleInput").val(sale);
								
								const data = {nowPage, title, genre, price, language, sale, isPaging};
								
								getGameList(data);
							});
							
							// 스크롤 감지해서 바닥에서부터 5개 이하이면 현재 페이지 +1 처리를 한 후 추가로 불러온다
							$(window).scroll(function(){
								if(!loadMoreData){ // 추가로 불러올 데이터가 없을 시
									return;
								}
								
								// 현재 로딩 중이면 리턴
								if(nowLoading){
									return;
								}
								
								let documentHeight = $(document).height(); // 전체 문서의 높이
								let scrollPosition = $(window).scrollTop(); // 현재 스크롤 위치
								let windowHeight = $(window).height(); // 창의 높이
								
								// 문서의 총 길이가 창의 길이보다 크다면 그 차이만큼 스크롤 길이가 형성된다
								
								// 스크롤이 하단에서 50px 이하로 떨어져있는지 체크
								let heightDiff = documentHeight - (scrollPosition + windowHeight);
								
								if(heightDiff <= 300){
									
									// 여기서 함수화한 부분을 진행할 것
									
									// 필요한 검색 조건 가져옴
									// 이 조건 가져오는 부분도 함수화해야 좋을 것 같음 (추후에 할 것)
									let nowPage = (Number)($("#nowPageInput").val());
									$("#nowPageInput").val(nowPage + 1); // input hidden에 1을 추가해놓는다
									nowPage++;
									
									console.log(nowPage);

									const title = $("#titleSelect").val();
									const genre = $("#genreSelect").val();
									const price = $("#priceSelect").val() * 5000;
									
									// 선택한 언어들
									let selectedLanguages = [];
									
									$(".languageCheckbox").each(function(){
										if($(this).prop("checked") === true){
											selectedLanguages.push($(this).data("language"));
										}
									});
									const language = selectedLanguages.join("|");
									const sale = $("#saleCheckbox").prop("checked") ? "1" : "0";
									const isPaging = true;
									
									const data = {nowPage, title, genre, price, language, sale, isPaging};

									getGameList(data); // 게임 데이터
								}
								
							});
							
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
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- 모달 JSP 삽입 -->
	<jsp:include page="../common/modal.jsp"></jsp:include>

</body>

</html>
