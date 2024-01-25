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
               
                	<div class="card border-0 my-5">
			            <div class="card-body p-5 bg-custom-blue">
			                <!-- Nested Row within Card Body -->
			                <div class="row">
			                    <div class="col-lg-12">
			                        <div class="p-5 bg-custom-blue">
			                            <div class="text-center">
			                                <h1 class="h4 text-light mb-4">회원 등록</h1>
			                            </div>
			                         	<form class="user" id="signupForm" method="post">
			                            	<div class="form-group input-group">
			                                    <div class="col-md-12 px-1 input-group">
				                                    <input type="text" class="form-control bg-light border-0 small" id="memberNickname" name="memberNickname" value="${MemberVO.memberNickname}" placeholder="닉네임을 입력해주세요" required="required">
			                                    </div>
			                                </div>

			                            	<div class="form-group input-group">
			                                    <div class="col-md-8 px-1 input-group">
													<input type="email" class="form-control" id="memberId" name="memberId" placeholder="아이디(Email 형식)를 입력해주세요" required="required"> </div>
												<div class="col-md-4 px-1 input-group ls-tight">
													<button class="form-control btn btn-outline-secondary" id="duplicateIdBtn" type="button" >중복확인</button>
			                                    </div>
			                                </div>

			                                <div class="form-group input-group">
			                                    <div class="col-md-6 px-1 form-group input-group">
			                                        <input type="password" class="form-control bg-light border-0 small"
			                                            id="memberPw" name="memberPw" placeholder="비밀번호를 입력해주세요" required="required">
			                                    </div>
			                                    <div class="col-md-6 px-1 input-group">
			                                        <input type="password" class="form-control bg-light border-0 small"
			                                            id="memberPwChk" name="memberPwChk" placeholder="비밀번호를 다시 입력해주세요" required="required">
			                                    </div>
			                                </div>
			                                <div class="px-1">
			                                	<button class="btn btn-primary btn-block" id="memberSubmitBtn">회원 등록</button>
			                            	</div>
			                            </form>
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
	
	<script>
	
	$(function () {
	    var duplicateChk = false;

	    $("#duplicateIdBtn").click(function () {
	        const memberId = $("#memberId").val();
	
	        $.ajax({
	            url: "${cp}//member/duplicateId",
	            method: "POST",
	            data: {
	                memberId: memberId,
	            },
	            beforeSend: function () {
	                if (!emailPtnChk("memberId")) {
	                    return false;
	                }
	            },
	            success: function (res) {
	                console.log(res);
	                if (res.success) {
	                    alert('사용가능한 아이디입니다')
	                    duplicateChk = true;
	                    $("#memberPw").focus();
	                } else {
	                    alert('중복된 아이디입니다')
	                    $("#memberId").val('');
	                    duplicateChk = false;
	                    $("#memberId").focus();
	                }
	            },
	            error: function (err) {
	                console.error(err);
	            }
	        });
	    });

	    // 회원 등록 버튼 클릭 이벤트
	    $("#memberSubmitBtn").click(function () {
	    	if ($("#memberId").val().trim() === "") {
	    	    alert('아이디를 입력해주세요.');
	    	    return false;
	    	}
	        if (!duplicateChk) {
	            alert('아이디 중복 확인을 먼저 진행해주세요.');
	            return false;
	        }
	    });
	    
	    // 아이디입력 란을 바꾸면 중복 확인 상태를 초기화
	    // 중복 확인으로 true를 얻고, 중복된 아이디로 변경하여 submit을 하는 것을 방지
	    $("#memberId").on("input", function () {
	    	duplicateChk = false;
	    });

	});
	
	// 이메일 유효성 검사
	function emailPtnChk(data) {
	    const memberId = (typeof data === 'string') ? document.getElementById(data) : data;
	    if (memberId && 'value' in memberId) {
	        const pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	        if (!memberId.value.match(pattern)) {
	            alert('올바른 이메일 주소를 입력해주세요.');
	            memberId.value = '';
	            memberId.focus();
	            return false;
	        }
	        return true;
	    } else {
	        console.error(err);
	        return false;
	    }
	}
	
	</script>

</body>

</html>
