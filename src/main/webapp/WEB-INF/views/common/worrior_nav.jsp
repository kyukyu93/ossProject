<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/worrior/js/nav.js"></script>
<script src="/resources/js/common.js" ></script>
<link rel="stylesheet" type="text/css" href="/resources/worrior/css/common/header.css" />
<script>
$(document).ready(function () {
	$('#signIn').on('click', function() {
		location.href = '/member/login.do';
	});
	
	$('#logout').on('click', function() {
		var param = new Object();
 		var callBack = "logout_callback";
		request_ajax("/member/logout.ajax", param, callBack);
	});
});

function logout_callback(result) {
	if(result.result == "success") {
		alert(result.msg);
		location.replace('/worrior/home.do');
	}
	else {
		alert(result.msg);
	}
}
</script>



<title>Insert title here</title>
</head>
<body>
	<div class="nav-bar">
		<div class="nav-contents" id="nav-menu">
		<div class="nav-brand"><a href="/worrior/home.do">내가 설마?</a></div>
			<ul class="nav-items">
				<c:forEach items="${navList}" var="navList" varStatus="status">
					<c:choose>
						<c:when test="${navList.menuUpperCd eq navList.menuCd}">
							<li id ="menu${status.count}">
								<a href="<c:out value="${navList.menuPath}" />" class="dep01"><c:out value="${navList.menuNm}" /></a>
								<ul style="display: none;">
								<c:forEach items="${navList2}" var="navList2" varStatus="status">
									<c:choose>
										<c:when test="${navList2.menuUpperCd eq navList.menuUpperCd}">
											<c:if test="${navList2.menuUpperCd ne navList2.menuCd}">
												<li><a href="<c:out value="${navList2.menuPath}" />"><c:out value="${navList2.menuNm}" /></a></li>
											</c:if>
										</c:when>
									</c:choose>
								</c:forEach>
								</ul>
							</li>
						</c:when>
					</c:choose>
				</c:forEach>
			</ul>
			<div class="comm">
			<c:choose>
				<c:when test="${userChk eq 0 || empty userChk}">
					<a href="/member/login.do" id="signIn">로그인</a> <a href="#">회원가입</a>
				</c:when>
				<c:otherwise>
					<a href="#"> ${userName}님</a> <a href="#" id="logout">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</div>
		</div>
		<!-- GNB -->
	</div>
	<!--// header_con -->
	<div class="nav-menu-bg">
		<span></span>
	</div>

</body>
</html>