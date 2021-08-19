<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<!doctype html>
<html lang="kr">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>당신의 새로운 라이프스타일, worrior</title>

<script type="text/javascript">
$(document).ready(function () {
	$('#signIn').on('click', function() {
		var param = new Object();
		param.userId = $("#inputEmail").val();
		param.userPw = $("#inputPassword").val();
		param.userFrom = '1';
		
 		var callBack = "login_callback";
		
	});
	$('#signUp').on('click', function() {
// 		location.href = '/member/signup.do'
		location.href = '/member/types.do'
	});
	
});

function login_callback(result) {
	console.log(result);
	if(result.result == "success") {
		location.replace('/worrior/home/home.do');
	}
	else {
		alert(result.msg);
	}
}
</script>

</head>
<body class="text-center">
	<form class="form-signin" style="min-width: 800px;">
		<div style="float: left; width: 35%; min-height: 200px; min-width: 150px; padding-top: 7%; padding-right: 30px;">
<!-- 		<div style="float: left; width: 35%; min-height: 200px; min-width: 150px; padding-top: 3%; padding-right: 30px;"> -->
			<a style="font-size: 32px; font-style: italic; color: #0a69af; font-weight: 700;">내가 설마?</a>
			<a style="font-size: 18px; font-style: italic; color: #e6e6e6; font-weight: 800;">BETA</a>
			<p style="font-size: 18px; font-style: italic; color: #000000; font-weight: 800;">새로운 건강 체크의 시작</p>
		</div>
		<div style="float: right; width: 64%; min-height: 200px; min-width: 400px;">
			<div style="float: left; width: 69%;">
				<label for="inputEmail" class="sr-only">ID</label> 
				<input type="email" id="inputEmail" class="form-control" placeholder="ID" required autofocus> 
				<label for="inputPassword" class="sr-only">PW</label> 
				<input type="password" id="inputPassword" class="form-control" placeholder="PW" required style="margin-bottom: 0px;">
				<div style="float: left; margin-bottom:20px;">
					<a href="#" id="signUp" style="font-weight: 600; color: black;">회원가입</a>
					<a href="#" id="findAccount" style="margin-left:15px; color: black;">아이디/비밀번호찾기</a>
				</div>
			</div>
			<div style="float: right; width: 29%;">
				<input type="button" class="btn btn-lg btn-primary btn-block" id="signIn" value="로그인" style="height:90px;"> 
			</div>
			
			<div style="border-style:none; width:100%; float:left;">
				<input type="button" class="" id="" value="네이버 로그인" style="border-style:none; width:49%; float:left; margin-bottom:5px; margin-right:1%; height:35px;">
				<input type="button" class="" id="" value="카카오 로그인" style="border-style:none; width:49%; float:left; margin-bottom:5px; margin-right:1%; height:35px;">
				<input type="button" class="" id="" value="애플 로그인" style="border-style:none; width:49%; float:left; margin-bottom:5px; margin-right:1%; height:35px;">
				<input type="button" class="" id="" value="구글 로그인" style="border-style:none; width:49%; float:left; margin-bottom:5px; margin-right:1%; height:35px;">
				<input type="button" class="" id="" value="페이스북 로그인" style="border-style:none; width:49%; float:left; margin-bottom:5px; margin-right:1%; height:35px;">
			</div>
<!-- 			<input type="button" class="btn btn-lg btn-primary btn-block" id="signIn" value="로그인">  -->
<!-- 				<input type="button" class="btn btn-lg btn-success btn-block" id="signUp" value="회원가입"> -->
		</div>

	</form>
</body>
</html>