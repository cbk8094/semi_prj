<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

                <!-- 탑바 시작 -->
                <nav class="navbar navbar-expand navbar-light bg-custom-black topbar mb-4 static-top shadow">

                    <!-- 탑바에 있는 사이드바 토글 버튼 -->
                    <form class="form-inline">
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                    </form>

                    <!-- 검색 부분 -->
                    <!-- <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="검색어를 입력해주세요"
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form> -->

                    <!-- 탑바 내비게이션 -->
                    <ul class="navbar-nav ml-auto">

                        <!-- 검색 드롭다운 (Visible Only XS, 작은 너비에서만 보임) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="javascript:;" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- 드롭다운 - 메시지 -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>
                        
                        <!-- 회원 정보 -->
						<c:if test="${sessionScope.member eq null }">
							<div class="login_buttons_wrap d-flex align-items-center mr-lg-3">
			                	<a class="text-light p-2" href="${cp}/member/login">
			                    	<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
		                        	로그인
			                    </a>
			                    <a class="text-light p-2 ml-2 d-none d-lg-block" href="${cp}/member/contract">
			                    	<i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
									회원가입
								</a>
							</div>
						</c:if>
						<c:if test="${loginMember ne null }">
							<li class="nav-item dropdown no-arrow">
	                            <a class="nav-link dropdown-toggle" href="javascript:;" id="userDropdown" role="button"
	                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                			<c:if test="${loginMember.memberImageVO ne null }">
			                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom border border-secondary border-width-custom-2" src="${cp }/resources/upload/${loginMember.memberImageVO.storedFileName}">
		                			</c:if>
		                			<c:if test="${loginMember.memberImageVO eq null }">
			                			<img class="img-profile rounded-circle img-fluid w-custom-50 h-custom-50 object-fit-contain-custom border border-secondary border-width-custom-2" src="${cp }/resources/img/profile-no-image.webp">
		                			</c:if>
	                                <span class="ml-3 mr-2 d-none d-lg-inline text-left">
	                                	 <i class="fas fa-list fa-sm fa-fw mr-1"></i>
	                                	 메뉴
	                                </span>
								</a>
								<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
	                                <a class="dropdown-item font-small-custom" href="${cp}/member/profile<c:if test="${loginMember ne null}">
									?memberNo=${loginMember.memberNo }</c:if>">
	                                    <i class="fas fa-user fa-sm fa-fw mr-2"></i>
	                                    프로필
	                                </a>
	                                <a class="dropdown-item font-small-custom" href="javascript:;" data-toggle="modal" data-target="#logoutModal">
	                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2"></i>
	                                    로그아웃
	                                </a>
								</div>
	                        </li>
						</c:if>
                    </ul>
                </nav>
                <!-- 탑바 끝 -->