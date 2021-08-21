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
	

	$('#post').on('click', function() {
		var param = new Object();
		param.param1 = $("#param1").val();
		param.param2 = $("#param2").val();

		$.ajax({
// 			url:'/api/board/1',
			url:'/api/tracking',
			headers: {'WorriorAuthKey' : '7c13af54895a363820b454255aa7b9f7'},
			type:'POST',
			data:param,
			success:function(data){
				console.log(data);
			},
			error : function(e){
				console.log(e);
			}
		});
	}); 
	
	$('#get').on('click', function() {
		var param = new Object();
		param.param1 = $("#param1").val();
		param.param2 = $("#param2").val();
		
		$.ajax({
			url:'/api/tracking',
			headers: {'WorriorAuthKey' : '7c13af54895a363820b454255aa7b9f7'},
			type:'GET',
			data:param,
			success:function(data){
				console.log(data);
			},
			error : function(e){
				console.log(e);
			}
		});
	}); 
	$('#delete').on('click', function() {
		var param = new Object();
		param.param1 = $("#param1").val();
		param.param2 = $("#param2").val();
		
		$.ajax({
			url:'/api/board/1',
			headers: {'WorriorAuthKey' : '7c13af54895a363820b454255aa7b9f7'},
			type:'DELETE',
			data:param,
			success:function(data){
				console.log(data);
			},
			error : function(e){
				console.log(e);
			}
		});
	}); 
	$('#put').on('click', function() {
		var param = new Object();
		param.param1 = $("#param1").val();
		param.param2 = $("#param2").val();
		
		$.ajax({
			url:'/api/board/1',
			headers: {'WorriorAuthKey' : '7c13af54895a363820b454255aa7b9f7'},
			type:'PUT',
			data:param,
			success:function(data){
				console.log(data);
			},
			error : function(e){
				console.log(e);
			}
		});
	}); 
});

</script>

</head>
<body class="text-center">
	<form class="form-signin" style="min-width: 800px;">
		<div style="float: left; width: 35%; min-height: 200px; min-width: 150px; padding-top: 7%; padding-right: 30px;">
<!-- 		<div style="float: left; width: 35%; min-height: 200px; min-width: 150px; padding-top: 3%; padding-right: 30px;"> -->
			<a style="font-size: 32px; font-style: italic; color: #0a69af; font-weight: 700;">내가 설마?</a>
			<a style="font-size: 18px; font-style: italic; color: #e6e6e6; font-weight: 800;">TEST</a>
			<p style="font-size: 18px; font-style: italic; color: #000000; font-weight: 800;">API 테스트페이지</p>
		</div>
		<div style="float: right; width: 64%; min-height: 200px; min-width: 400px;">
			<div style="float: left; width: 69%;">
				<label for="param1" class="sr-only">Parameter1</label> 
				<input type="text" id="param1" class="form-control" placeholder="Parameter1" required autofocus> 
				<label for="param2" class="sr-only">Parameter2</label> 
				<input type="text" id="param2" class="form-control" placeholder="Parameter2" required style="margin-bottom: 0px;">
				<div style="float: left; margin-bottom:20px;">
					<a href="#" id="post" style="font-weight: 600; color: black;">POST</a>
					<a href="#" id="get" style="font-weight: 600; color: black;">GET</a>
					<a href="#" id="put" style="font-weight: 600; color: black;">PUT</a>
					<a href="#" id="delete" style="font-weight: 600; color: black;">DELETE</a>
				</div>
			</div>
		</div>

	</form>
</body>
</html>