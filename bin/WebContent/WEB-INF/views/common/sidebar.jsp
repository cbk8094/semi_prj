<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <!-- 사이드바 시작 -->
        <ul class="navbar-nav bg-custom-black sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- 메인 로고 -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath }/">
				<img alt="메인 로고" src="${pageContext.request.contextPath }/resources/img/steam-logo.png" class="sidebar-brand-icon w-25 filter-invert">
				<div class="sidebar-brand-text text-capitalize">Stream</div>
            </a>

            <!-- 분리선 -->
            <hr class="sidebar-divider my-0">

            <!-- 사이드바 내비게이션 -->
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath }/">
                    <i class="fas fa-fw fa-home"></i>
                    <span>홈</span>
                </a>
                <a class="nav-link" href="${pageContext.request.contextPath }/store">
                    <i class="fas fa-fw fa-home"></i>
                    <span>상점</span>
                </a>
                <a class="nav-link" href="${pageContext.request.contextPath }/board/list?category=notify">
                    <i class="fas fa-fw fa-home"></i>
                    <span>공지사항</span>
                </a>
                <a class="nav-link" href="${pageContext.request.contextPath }/board/list?category=event">
                    <i class="fas fa-fw fa-home"></i>
                    <span>이벤트</span>
                </a>
                <a class="nav-link" href="${pageContext.request.contextPath }/board/list?category=qna">
                    <i class="fas fa-fw fa-home"></i>
                    <span>고객지원</span>
                </a>
            </li>

            <!-- 분리선 -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- 사이드바 토글 버튼 -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
            
            <!-- 푸터 분리 -->
			<jsp:include page="./footer.jsp"></jsp:include>

        </ul>
        <!-- 사이드바 끝 -->
        
        
        