<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.Date" %>
<%
  Date now = new Date();
  pageContext.setAttribute("now", now);
%>

<!DOCTYPE html>
<html lang="ko">
<script type="text/javascript" src="<c:url value="/ckeditor/ckeditor.js" />"></script>
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
           		<h3 class="board-title"><strong>문의하기</strong></h3>
               
<!--               	<form method="post" enctype="multipart/form-data" action="/board/boardwrite"> -->
              	<form method="post" action="/board/boardmodify">
						<input type="hidden" name="amount" value = "${boardPageDto.cri.amount}">
						<input type="hidden" name="pageNum" value = "${boardPageDto.cri.pageNum}">
						<div class="mb-3 mt-5">
					  		<label for="exampleFormControlInput1" class="form-label">작성자</label>
					  		<!--임시 input  -->
					  		<input name="memberNo" value="${member.memberNo}" type="hidden">
					  		<h5 class="text-light">관리자</h5> <!--${member} -->

						</div>
					
					 <hr class="bg-dark">
					<div class="mb-3">
					  <label for="exampleFormControlInput1" class="form-label">작성일</label>
					  
					  <h5 class="text-light">
					  <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>
					  </h5>
					
					</div>
					 <hr class="bg-dark">
					<div class="mb-3">
					  <label for="exampleFormControlTextarea1" class="form-label">제목</label>
				 	  <input id="boardTitle" name="boardTitle" class="form-control" value="${board.boardTitle}">
					</div>
					 <hr class="bg-dark">
					<div class="mb-3">
					  <label for="exampleFormControlTextarea1" class="form-label">문의내용</label>
					  <textarea name="boardContent" class="form-control" id="boardContent" rows="7">${board.boardContent}</textarea>
						
						<script>
						CKEDITOR.replace('boardContent', {height: '500px'}
						);
						</script>
					</div>
					<input type="hidden" name="boardTitle" value="${baord.boardTitle}">
					<input type="hidden" name=boardNo value="${board.boardNo}">
					<input type="hidden" name=boardNo value="${board.boardcategory}">
					<input type="hidden" name="boardContent" value="${baord.boardContent}">
					<div class="float-right">
						<button type="submit" class="btn btn-lg btn-primary" >확인</button>
						<button onclick="/board/event"class="btn btn-secondary btn-lg">취소</button>
					</div>
					
				</form>
				
                <!-- 페이지 컨텐츠 끝 -->
					
            </div>
            <!-- 메인 컨텐츠 끝 -->

        </div>
        <!-- 컨텐츠 Wrapper 끝 -->

    </div>
    <!-- 전체 Wrapper 끝 -->
	</div>
    <!-- 맨 위로 스크롤 버튼 -->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

	<!-- 모달 JSP 삽입 -->
	<jsp:include page="../common/modal.jsp"></jsp:include>

</body>
<script>
function goBack() {
    window.history.back();
}
</script>

</html>
