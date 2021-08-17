<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>HEALTHER</title>
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
			<jsp:include page="../common/worrior_nav.jsp" flush="false" />
		</div>
		<!-- 			<hr class="div_contents" /> -->
		<div class="item-block"></div>
		<div class="container">
			<div class="left-nav">
				<jsp:include page="../common/left_nav.jsp" flush="false" />
			</div>
			<div class="content" id="content">
				<!-- 타이틀 영역 -->
				<div class="title_area">
					<h3>프로걱정러 소개</h3>
					<span><a href="/">Home</a> &gt; 소개 &gt; 프로걱정러</span>
				</div>
				<!-- 자료실 -->
				<div class="table_search_area">
					<p class="total_count">
						총 <span id="total">1</span> 건
						<span></span>
					</p>
					<div class="table_top_side">
						<select name="searchType" id="searchType" class="cb_box w100">
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="total">제목+내용</option>
						</select> 
						<input type="text" name="searchText" id="searchText" value="" class="in_text w150 mr5" maxlength="100"> 
						<a href="#" id="btnSearch" class="search_btn input_btn">검색</a>
					</div>
				</div>
				<table class="list_table">
					<colgroup>
						<col style="width: 15%">
						<col style="width: 65%">
						<col style="width: 20%">
					</colgroup>
					<thead>
						<tr class="first">
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">등록일</th>
						</tr>
					</thead>
					<tbody id="boardList">
						
					</tbody>
				</table>
				<!-- 하단 영역 -->
				<div class="btm_area">
					<div class="util_paging">
						<a href="#" class="pg_first"></a>
						<a href="#" class="pg_prev"></a> 
						<a href="#" class="num active">1</a>
						<a href="#" class="pg_next"></a> 
						<a href="#" class="pg_last"></a>
					</div>
				</div>
				<div class="footer_button_area3">
					<span><a href="#" id="addBoard" class="search_btn input_btn w60">등록</a></span>
				</div>
				<!-- 내용 입력 -->
			</div>
		</div>
		<div class="footer">
			<jsp:include page="../common/worrior_footer.jsp"
				flush="false" />
		</div>
	</div>
</body>
</html>
