<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
   <!-- 로그아웃 모달 (예시) -->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="logoutModal"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">로그아웃</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">로그아웃을 하시겠습니까?</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                    <a class="btn btn-primary" href="${cp }/member/logout">로그아웃</a>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 장바구니 담기 모달 -->
    <div class="modal fade" id="addCartModal" tabindex="-1" role="dialog" aria-labelledby="addCartModal"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">장바구니</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body"></div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">계속 쇼핑하기</button>
                    <a class="btn btn-primary" href="${cp }/cart">장바구니 이동</a>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 닉네임 변경 모달 -->
    <div class="modal fade" id="modifyNicknameModal" tabindex="-1" role="dialog" aria-labelledby="modifyNicknameModal"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">닉네임 변경</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                	<label for="nicknameInput" class="d-block">변경할 닉네임을 입력해주세요</label>
                	<input type="text" name="member_nickname" id="nicknameInput" class="w-100">
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                    <a href="javascript:;" id="modifyNicknameButton" class="btn btn-primary">닉네임 변경</a>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 자기소개 변경 모달 -->
    <div class="modal fade" id="modifyIntroduceModal" tabindex="-1" role="dialog" aria-labelledby="modifyIntroduceModal"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">자기소개 변경</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                	<label for="nicknameInput" class="d-block">변경할 자기소개를 입력해주세요</label>
                	<textarea rows="" cols="" name="member_introduce" id="introduceInput" class="w-100 resize-none-custom"></textarea>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                    <a href="javascript:;" id="modifyIntroduceButton" class="btn btn-primary">자기소개 변경</a>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 환불 모달 -->
    <div class="modal fade" id="refundModal" tabindex="-1" role="dialog" aria-labelledby="refundModal"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">환불하기</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                	<input type="hidden" id="purchaseNoInput" value="">
                	정말 환불하시겠습니까?
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                    <a href="javascript:;" id="refundButton" class="btn btn-primary">환불하기</a>
                </div>
            </div>
        </div>
    </div>
    
    
    