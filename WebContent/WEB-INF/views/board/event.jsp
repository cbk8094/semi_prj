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
                	
                	
                	<input name="memberNo" value="${member.memberNo}" type="hidden">
                    <h3 class="board-title"><strong>이벤트</strong></h3>
                    <h5>현재 진행중인 다양한 이벤트 혜택을 받아보세요!</h5>
                    
                    <div style="display: flex; justify-content: flex-end;">
                        <button type="button" class="btn btn-primary qna-write">
                        <a  class="text-light text-decoration-none" href="/board/eventwrite"><!--?{param.name} 필요한 변수명전달 -->
                        글 작성</a></button>
                    </div>
                    <table class="table table-hover">
                        <thead class="board-table-title" style="border-bottom: 0;">
                          <tr>
                            <th scope="col" class="col-1">번호</th>
                            <th scope="col" class="col-9">제목</th>
                            <th scope="col" class="col-2">현황</th>
                            
                          </tr>
                        </thead>
                        <tbody class="clearfix">
                        	<c:forEach items="${boardList}" var="b">
                          <tr class="line py-2">
                            <td class= "d-flex justify-content-center"><a class="text-light text-decoration-none text-align-center" href="/board/eventdetail?boardNo=${b.boardNo}&rowNum=${b.rowNum}&${BoardPageDto.cri.qs}">${b.rowNum}</a></td>
                            <td><a class="text-light text-decoration-none" href="/board/eventdetail?boardNo=${b.boardNo}&rowNum=${b.rowNum}&${BoardPageDto.cri.qs}"><c:out value="${b.boardTitle}"/></a></td>
                            <td class="wait-answer ${b.isAnswer == '1'? 'bg-success' : 'bg-danger'} py-0" >${b.isAnswer == '1' ? '진행중' : '종료'}</td>
                          </tr>
                        	</c:forEach>
                          
                        </tbody>
                      </table>
                       <div class="pagination d-flex justify-content-center">
						    <!-- 이전 페이지 -->
						    <c:if test="${BoardPageDTO.prevs}">
						        <a class="direct" href="?pageNum=${BoardPageDTO.startPage-1}&${BoardPageDto.cri.qs}" title="이전 페이지 구역으로"><i class="fas fa-angle-double-left"></i></a>
						    </c:if>
						    
						    <!-- 이전 페이지로 -->
						    <c:if test="${BoardPageDTO.prev}">
						        <a class="direct" href="?pageNum=${BoardPageDTO.cri.pageNum - 1}&${BoardPageDto.cri.qs}" title="이전 페이지로"><i class="fas fa-angle-left"></i></a>
						    </c:if>
						    
						    <!-- 페이지 번호 -->
						    <c:forEach begin="${BoardPageDTO.startPage}" end="${BoardPageDTO.endPage}" var="i">
						        <a class="${i == BoardPageDTO.cri.pageNum ? 'active' : '' }" href="?pageNum=${i}&${BoardPageDto.cri.qs}" title="${i} 페이지">${i}</a>
						    </c:forEach>
						    
						    <!-- 다음 페이지로 -->
						    <c:if test="${BoardPageDTO.next}">
						        <a class="direct" href="?pageNum=${BoardPageDTO.cri.pageNum + 1}&${BoardPageDto.cri.qs}" title="다음 페이지로"><i class="fas fa-angle-right"></i></a>
						    </c:if>
						    
						    <!-- 다음 페이지 -->
						    <c:if test="${BoardPageDTO.nexts}">
						        <a class="direct" href="?pageNum=${BoardPageDTO.endPage + 1}&${BoardPageDto.cri.qs}" title="다음 페이지 구역으로"><i class="fas fa-angle-double-right"></i></a>
						    </c:if>
						</div>
						<input type="hidden" name="amount" value = "${BoardPageDTO.cri.amount}">
						<input type="hidden" name="pageNum" value = "${BoardPageDTO.cri.pageNum}">
                <!-- 페이지 컨텐츠 끝 -->
						<!-- <div class="reply-showmore-area">
                            <button class="btn btn-primary btn-block">더보기</button>
                          </div> -->
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