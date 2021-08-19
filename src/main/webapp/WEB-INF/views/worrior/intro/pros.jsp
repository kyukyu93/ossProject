<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>worrior</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<link rel="stylesheet" type="text/css" href="/resources/worrior/css/common.css" />
<script type="text/javascript" src="/resources/worrior/js/nav.js"></script>
<script type="text/javascript" src="/resources/worrior/js/jquery-3.5.1.js"></script>
</head>
<body>

	<div class="wrap">
		<!-- 스킵 네비게이션 -->
		<!-- header -->
		<div class="header">
			<jsp:include page="../../common/worrior_nav.jsp" flush="false" />
		</div>
		<!-- 			<hr class="div_contents" /> -->
		<div class="item-block"></div>
		<div class="container">
			<div class="left-nav">
				<jsp:include page="../../common/left_nav.jsp" flush="false" />
			</div>
			<div class="content" id="content">
				<!-- 타이틀 영역 -->
				<div class="title_area">
					<h3>프로걱정러 팀 소개</h3>
					<span><a href="/">Home</a> &gt; 소개 &gt; 프로걱정러</span>
				</div>
				
				<!-- 내용 입력 -->
			</div>
		</div>
		<div class="footer">
			<jsp:include page="../../common/worrior_footer.jsp"
				flush="false" />
		</div>
	</div>
</body>
</html>
