<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                	<div class="d-flex justify-content-start align-items-center ">
                		<div class="">
                    		<h3 class="board-title"><strong>${board.boardTitle}</strong></h3>
                			<h5>이벤트</h5>
                		</div>
                	</div>
						
						<div class="mt-3 nav-item dropdown no-arrow px-0 py-0 d-flex justify-content-between align-items-center ">
							<div>
	                            <a class="nav-link dropdown-toggle px-0 py-0 " href="javascript:;" id="userDropdown"
	                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
	                            <img class="px-0 py-0 mr-2 col-1 img-profile rounded-circle "
	                                   src="${pageContext.request.contextPath}/resources/sbadmin2/img/undraw_profile.svg">
	                                   <!-- 아이디 수정 예정-->
	                                   <input name="memberNo" value="${member.memberNo}" type="hidden"></input>
	                               <p class="pr-2 d-none d-lg-inline text-light border-right border-secondary border-4">관리자</p>
	                           	<span class="d-none d-lg-inline text-gray-600">${board.regDate}</span>
                         	</div>
                         	<div class="d-flex align-items-center">
                         		
                         		<button type="button" class="btn btn-secondary text-light" disabled>No.${param.rowNum}</button> 
           						
           						<div class="d-flex align-items-center">
								  <div class="position-relative">
									    <a class="fas fa-ellipsis-v ml-4 tooltip-button" style="color:#2970ff"></a>
									    <div class="position-absolute bg-light tooltip" style="display: none;">
									        <button type="button" class="bg-dark text-light edit-button">수정</button>
									        <button type="button" class="bg-dark text-light delete-button">삭제</button>
									    </div>
									</div>
								</div>
                        	</div>
                        </div>
                        <hr class="bg-dark">
                        <div class="text-light">
	                        <p>${board.boardContent}</p>
                   		</div>
                  		<hr class="bg-dark">
                  		
               		
                  			
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
	<!--스크립트  -->
	<script type="text/javascript">
	  const tooltipButtons = document.querySelectorAll('.tooltip-button');
	  const tooltips = document.querySelectorAll('.tooltip');
	  const editButtons = document.querySelectorAll('.edit-button ');
	  const deleteButtons = document.querySelectorAll('.delete-button');

	  tooltipButtons.forEach((button, index) => {
	    button.addEventListener('click', () => {
	      // 툴팁 표시/숨김 토글
	      if (tooltips[index].style.display === 'block') {
	        tooltips[index].style.display = 'none';
	      } else {
	        tooltips[index].style.display = 'block';
	      }
	    });

	    // 삭제 버튼 클릭 시
	    deleteButtons[index].addEventListener('click', () => {
	      	event.preventDefault();
	    	if (!confirm('삭제하시겠습니까?')) {
	        // 삭제 확인 시 서버로 삭제 요청 보내고 성공하면 리로드 또는 다른 동작 수행
	       	return;
	      }
	    	window.location.href = '/board/delete?boardNo=${board.boardNo}'
	    });

	    // 수정 버튼 클릭 시
	    editButtons[index].addEventListener('click', () => {
	      // 수정 동작 구현
	      if(!confirm('수정하시겠습니까?')){
	    	  return;
	      }
	      /*수정 미구현  */
	      window.location.href = '/board/board?boardNo=${board.boardNo}';
	    });
	  });
	</script>
</body>

</html>
