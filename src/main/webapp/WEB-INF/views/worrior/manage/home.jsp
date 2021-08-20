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
			
			<div class="mon_banner" style="background-color: aliceblue; height: 150px; width: 100%; display: inline-block;">
				<div class="mon1" style="float: left;width: 23%;display: inline-block;height: 100%;padding: 1%;background-color: lightgray; cursor: pointer;">
					<div style="display: inline-block; width: 100%;">
						<div style="display: block; margin-bottom: 30px; font-weight: bold; font-size: 1.3em; float: left;">프로세스 모니터링</div>
						<div style="display: block; margin-bottom: 30px; font-weight: bold; font-size: 1.3em; float: right;">
							<button>새로고침</button>
						</div>
					</div>
					<div>
						<table>
							<thead>
								<tr>
									<th>호출</th>
									<th>정상</th>
									<th>오류</th>
									<th>응답률</th>
								</tr>
							</thead>
							<tbody style="text-align: center;">
								<tr>
									<td>1,000</td>
									<td>970</td>
									<td>30</td>
									<td>97.00%</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div style="display: block; margin-top: 30px; text-align: right;">2021-07-18 16:01:00</div>
				</div>

				<div class="mon2" style="float: left;width: 23%;display: inline-block;height: 100%;padding: 1%;background-color: navajowhite; cursor: pointer;">
					<div style="display: inline-block; width: 100%;">
						<div style="display: block; margin-bottom: 30px; font-weight: bold; font-size: 1.3em; float: left;">API 모니터링</div>
						<div style="display: block; margin-bottom: 30px; font-weight: bold; font-size: 1.3em; float: right;">
							<button>새로고침</button>
						</div>
					</div>
					<div>
						<table>
							<thead>
								<tr>
									<th>호출</th>
									<th>정상</th>
									<th>오류</th>
									<th>응답률</th>
								</tr>
							</thead>
							<tbody style="text-align: center;">
								<tr>
									<td>1,000</td>
									<td>970</td>
									<td>30</td>
									<td>97.00%</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div style="display: block; margin-top: 30px; text-align: right;">2021-07-18 16:01:00</div>
				</div>
				
				<div class="mon3" style="float: left;width: 23%;display: inline-block;height: 100%;padding: 1%;background-color: steelblue; cursor: pointer;">
					<div style="display: inline-block; width: 100%;">
						<div style="display: block; margin-bottom: 30px; font-weight: bold; font-size: 1.3em; float: left;">보안 모니터링</div>
						<div style="display: block; margin-bottom: 30px; font-weight: bold; font-size: 1.3em; float: right;">
							<button>새로고침</button>
						</div>
					</div>
					<div>
						<table>
							<thead>
								<tr>
									<th>오늘</th>
									<th>누적</th>
								</tr>
							</thead>
							<tbody style="text-align: center;">
								<tr>
									<td>0</td>
									<td>3</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div style="display: block; margin-top: 30px; text-align: right;">2021-07-18 16:01:00</div>
				</div>
				
				<div class="mon4" style="float: left;width: 23%;display: inline-block;height: 100%;padding: 1%;background-color: cornsilk; cursor: pointer;">
					<div style="display: inline-block; width: 100%;">
						<div style="display: block; margin-bottom: 30px; font-weight: bold; font-size: 1.3em; float: left;">메세지 모니터링</div>
						<div style="display: block; margin-bottom: 30px; font-weight: bold; font-size: 1.3em; float: right;">
							<button>새로고침</button>
						</div>
					</div>
					<div>
						<table>
							<thead>
								<tr>
									<th>총 건수</th>
									<th>응답</th>
									<th>미응답</th>
									<th>응답률</th>
								</tr>
							</thead>
							<tbody style="text-align: center;">
								<tr>
									<td>3,700</td>
									<td>3,500</td>
									<td>200</td>
									<td>94.59%</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div style="display: block; margin-top: 30px; text-align: right;">2021-07-18 16:01:00</div>
				</div>
			</div>
			<div class="item-block"></div>
			
			<div class="table_search_area">
					<div class="table_top_side">
						<select name="searchType" id="searchType" class="cb_box w100">
							<option value="userId">사용자ID</option>
							<option value="useType">호출구분</option>
							<option value="useSuccess">성공여부</option>
						</select> 
						<input type="text" name="searchText" id="searchText" value="" class="in_text w150 mr5" maxlength="100"> 
						<a href="#" id="btnSearch" class="search_btn input_btn">검색</a>
					</div>
					<div class="item-block"></div>
				</div>
				<table class="list_table">
					<colgroup>
						<col width="100">
						<col width="*">
						<col width="300">
						<col width="100">
						<col width="100">
						<col width="300">
					</colgroup>
					<thead>
						<tr class="first">
							<th scope="col">ID</th>
							<th scope="col">URL</th>
							<th scope="col">IP</th>
							<th scope="col">호출구분</th>
							<th scope="col">성공여부</th>
							<th scope="col">호출일자</th>
						</tr>
					</thead>
					<tbody id="boardList">
<!-- 					TODO 삭제 -->
						<tr>
							<td>test1</td>
							<td>TEST/TEST</td>
							<td>0.0.0.1</td>
							<td>API</td>
							<td>성공</td>
							<td>2021.08.21</td>
						</tr>
						
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
		</div>
		<div class="footer">
			<jsp:include page="../../common/worrior_footer.jsp"
				flush="false" />
		</div>
	</div>
</body>
</html>
