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
                
                	<img alt="테스트" src="${pageContext.request.contextPath }/resources/img/main_image.jpg" class="w-100">

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
