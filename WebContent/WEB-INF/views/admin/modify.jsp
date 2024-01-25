<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html lang="ko">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/ckeditor/ckeditor.js" />"></script>
<script>
$(document).ready(function () {
    var isDeletedInput = $("input[name='isDeleted']");
    var currentValue = isDeletedInput.val() === "1"; // Boolean 값으로 설정

    function toggleButtons() {
        if (currentValue) {
            $('.btn.btn-danger').show();
            $('.btn.btn-primary').hide();
        } else {
            $('.btn.btn-danger').hide();
            $('.btn.btn-primary').show();
        }
    }

    toggleButtons(); // 초기 버튼 가시성 설정

    $('.btn.btn-danger').on('click', function() {
        currentValue = !currentValue; // 값 토글
        isDeletedInput.val(currentValue ? "1" : "0"); // 값을 다시 input에 설정
        localStorage.setItem('isDeleted', currentValue ? "1" : "0"); // 로컬 스토리지에 저장
        toggleButtons(); // 버튼 가시성 변경
    });

    $('#startServiceButton').on('click', function() {
        $.ajax({
            type: "POST",
            url: "/steam/admin/modify?gameNo=" + data.gameNo,
            data: { isDeleted: isDeletedInput.val() },
            success: function(data) {
                console.log("서비스가 시작되었습니다!");
                currentValue = isDeletedInput.val() === "1"; // 서비스 시작 후 값 업데이트
                toggleButtons(); // 버튼 가시성 변경
            },
            error: function(xhr, status, error) {
                console.error("오류:", error);
            }
        });
    });
});
</script>

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
                	
                		<div class="wrap my-5">
                       <form method="post" action="modify" >
                	
                	 <h1 class="h3 mb-2 text-gray-800">게임 수정/삭제 페이지</h1>
						<hr class="col-12 hr border-color-custom border-width-custom mb-3 mt-1">
						<div class="card shadow mb-4 bg-dark bg-gradient">
                        <div class="card-header py-3 bg-dark bg-gradient">
                        
                       
                            <h6 class="m-0 font-weight-bold  text-white">gameNo ${gameList.gameNo}</h6>
                        </div>
                        <div class="card-body">
                        
                        	
								  <div class="d-flex flex-row justify-content-between">
								  <div class="form-group col-sm-8 col-lg-5">
                        	 		<label for="genreSelect"
												class="form-group">장르선택</label>
											<select class="game_search_input form-control col-sm-8 col-lg-10" id="genreSelect"
												role="button" name= "category">
												<c:forEach items="${genreList}" var="c">
													<option value="${c.genreNo}" ${c.genreNo == gameList.genreNo ? 'selected' : '' }>${c.genreName}</option>
													</c:forEach>
												</select>
											</div>
										  
									  <div class="form-group col-sm-8 col-lg-5 float-right">
					       				<label for="gameDeveloper">개발사</label>
					       				<input type="text"class="form-control" id="gameDeveloper" name="gameDeveloper" value="${gameList.gameDeveloper}" >
					       			</div>
								  
                  			  </div>
									
									
                        	
			       			
                        	<div class="form-group">
			       				<label for="gameName">게임 제목</label>
			       				<input type="text"class="form-control" id="gameName" name="gameName" value="${gameList.gameName}" >
			       			</div>
			       			<div class="form-group">
			       			<!-- ck 에디터 적용  -->
				       		 <h6>게임 설명</h6>
		        				 
		        				  <textarea name="gameDesc" cols="80" rows="10" style="overflow: scroll; height: 1500px;">${gameList.gameDesc}</textarea>
									<script>
									
									CKEDITOR.replace('gameDesc', { height: '500px'}
									);
									</script>
	      					 </div> 
	      					 
                        	<div>
                       		</div>
                       		<input type="hidden" name="gameNo" value="${gameList.gameNo}"> 
                       	 	<input type="hidden" name="genreNo" value="${gameList.genreNo}"> 
                       	 	<input type="hidden" name="publisherNo" value="${gameList.publisherNo}"> 
                       		<%-- <input type="hidden" name="gameName" value="${gameList.gameName}"> --%>
                       	 <%-- <input type="hidden" name="gameDesc" value="${gameList.gameDesc}">  --%>
                       	 <input type="hidden" name="gameVideoUrl" value="${gameList.gameVideoUrl}"> 
                       	 <input type="hidden" name="gamePrice" value="${gameList.gamePrice}"> 
                       		<%-- <input type="hidden" name="gameDeveloper" value="${gameList.gameDeveloper}"> --%>
                       		<input type="hidden" name="gameReleaseDate" value="${gameList.gameReleaseDate}">
                       		<input type="hidden" name="gameAgeLimit" value="${gameList.gameAgeLimit}"> 
                       		<input type="hidden" name="gameSaleCount" value="${gameList.gameSaleCount}"> 
                       		<input type="hidden" name="isDeleted" value="<%-- ${gameList.isDeleted} --%>">  
                       		
                       		<button class="btn btn-warning" formaction="modify" id="btnBoardSubmit">Modify</button>
                       		
                       		<button class="btn btn-danger" formaction="delete">서비스종료</button>
							<button class="btn btn-primary" id="startServiceButton" formaction="modify" style="display: none;">서비스시작</button>


                       		<a class="btn btn-info"href="${pageContext.request.contextPath}/admin" >List</a>
                       		</form>
                        </div>
                    </div>
                     <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">File Attach</h6>
                        </div>
                        <div class="card-body">
	                       <div class="input-group">
		                        	<div class="custom-file">
										<input type="file" class="custom-file-input" id="files" name="files" multiple>
										<label for="files" class="custom-file-label">Choose File</label>
									</div>
								</div>
							</div>
							<div class="upload-wrapper">
								<div class="uploadResult mt-3"> 
									<ul class="list-group">
									</ul>
								</div>
								<div class="thumbResult mt-3" >
									<ul class="row d-flex justify-content-around list-unstyled">
									</ul>
								</div>
							</div>
                      		</div>
                 


                		</div>
                	</div>

                </div>
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
