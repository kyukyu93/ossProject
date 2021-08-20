<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/common/mobile/common.jsp"%>
<!doctype html>
<html lang="kr">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="/resources/css/mobile/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/mobile/bootstrap-theme.min.css">
<link rel="stylesheet" href="/resources/css/mobile/tracking.css">

<script type="text/javascript">
$(document).ready(function () {
	writeTracking();
	
});

function login_callback(result) {
	console.log(result);
	if(result.result == "success") {
		location.replace('/worrior/home.do');
	}
	else {
		alert(result.msg);
	}
}

function writeTracking() {
// 	$('#timelines').html('');
	var str = "";
// 	for(i in 10) {
		
		str += '<div class="vertical-timeline-item vertical-timeline-element">';
		str += '<div>';
		str += '<span class="vertical-timeline-element-icon bounce-in"> ';
		str += '<i class="badge badge-dot badge-dot-xl badge-success"></i>'; // badge-warning / badge-danger / badge-primary
		str += '</span>';
		str += '<div class="vertical-timeline-element-content bounce-in">';
		str += '<h4 class="timeline-title">'; /*제목 param*/
		str += '</h4>';
		str += '<p>';
		str += 'Meeting with USA Client, today at'; /*내용*/
		str += '<a href="javascript:void(0);" data-abc="true">';
		str += '12:00 PM'; /*시간*/
		str += '</a>';
		str += '</p>';
		str += '<span class="vertical-timeline-element-date">9:30 AM</span>';
		str += '</div>';
		str += '</div>';
		str += '</div>';
		
// 	}
// 	$('#timelines').html(str);
}
</script>


<title>나도 설마? 모바일</title>
<body>
<div id="map" style="width:100%;height:400px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=#"></script>

<script type="text/javascript">
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

</script>
	<div class="row d-flex justify-content-center">
		<div class="col-md-6">
			<div class="main-card mb-3 card">
				<div class="card-body">
					<h5 class="card-title">2021년 8월 20일</h5>
					<div class="vertical-timeline vertical-timeline--animate vertical-timeline--one-column" id="timelines">
						<div class="vertical-timeline-item vertical-timeline-element">
							<div>
								<span class="vertical-timeline-element-icon bounce-in"> <i
									class="badge badge-dot badge-dot-xl badge-success"></i>
								</span>
								<div class="vertical-timeline-element-content bounce-in">
									<h4 class="timeline-title">GPS 추적 시작</h4>
									<p>
										서울시 선릉로 부근
									</p>
									<span class="vertical-timeline-element-date">9:30 AM</span>
								</div>
							</div>
						</div>
						<div class="vertical-timeline-item vertical-timeline-element">
							<div>
								<span class="vertical-timeline-element-icon bounce-in"> <i
									class="badge badge-dot badge-dot-xl badge-warning"> </i>
								</span>
								<div class="vertical-timeline-element-content bounce-in">
									<p>
										서울시 가신디지털로 확진자 발생 <b class="text-danger">3:00 PM</b>
									</p>
									<p> 방문 이력 <span class="text-success">1일 3시간 전</span>
									</p>
									<span class="vertical-timeline-element-date">12:25 PM</span>
								</div>
							</div>
						</div>
						<div class="vertical-timeline-item vertical-timeline-element">
							<div>
								<span class="vertical-timeline-element-icon bounce-in"> <i
									class="badge badge-dot badge-dot-xl badge-danger"> </i>
								</span>
								<div class="vertical-timeline-element-content bounce-in">
									<h4 class="timeline-title">서울시 구로디지털단지역</h4>
									<p>역학조사 완료</p>
									<span class="vertical-timeline-element-date">6:00 PM</span>
								</div>
							</div>
						</div>
						<div class="vertical-timeline-item vertical-timeline-element">
							<div>
								<span class="vertical-timeline-element-icon bounce-in"> <i
									class="badge badge-dot badge-dot-xl badge-primary"> </i>
								</span>
								<div class="vertical-timeline-element-content bounce-in">
									<h4 class="timeline-title text-success">서울시 선릉로</h4>
									<p>확진자 동선 확인 중 </p>
									<span class="vertical-timeline-element-date">9:00 AM</span>
								</div>
							</div>
						</div>
						<div class="vertical-timeline-item vertical-timeline-element">
							<div>
								<span class="vertical-timeline-element-icon bounce-in"> <i
									class="badge badge-dot badge-dot-xl badge-success"> </i>
								</span>
								<div class="vertical-timeline-element-content bounce-in">
									<h4 class="timeline-title">서울시 고속터미널역 부근</h4>
									<p> 방역 조치가 완료된 지역입니다. 
									<a href="javascript:void(0);" data-abc="true">10:00 AM</a>
									</p>
									<span class="vertical-timeline-element-date">10:30 PM</span>
								</div>
							</div>
						</div>
						<div class="vertical-timeline-item vertical-timeline-element">
							<div>
								<span class="vertical-timeline-element-icon bounce-in"> <i
									class="badge badge-dot badge-dot-xl badge-warning"> </i>
								</span>
								<div class="vertical-timeline-element-content bounce-in">
									<p> Another conference call today, at <b class="text-danger">11:00 AM</b>
									</p>
									<p>
										Yet another one, at <span class="text-success">1:00 PM</span>
									</p>
									<span class="vertical-timeline-element-date">12:25 PM</span>
								</div>
							</div>
						</div>
						<div class="vertical-timeline-item vertical-timeline-element">
							<div>
								<span class="vertical-timeline-element-icon bounce-in"> <i
									class="badge badge-dot badge-dot-xl badge-warning"> </i>
								</span>
								<div class="vertical-timeline-element-content bounce-in">
									<p>
										Another meeting with UK client today, at <b
											class="text-danger">3:00 PM</b>
									</p>
									<p>
										Yet another one, at <span class="text-success">5:00 PM</span>
									</p>
									<span class="vertical-timeline-element-date">12:25 PM</span>
								</div>
							</div>
						</div>
						<div class="vertical-timeline-item vertical-timeline-element">
							<div>
								<span class="vertical-timeline-element-icon bounce-in"> <i
									class="badge badge-dot badge-dot-xl badge-danger"> </i>
								</span>
								<div class="vertical-timeline-element-content bounce-in">
									<h4 class="timeline-title">Discussion with team about new
										product launch</h4>
									<p>meeting with team mates about the launch of new product.
										and tell them about new features</p>
									<span class="vertical-timeline-element-date">6:00 PM</span>
								</div>
							</div>
						</div>
						<div class="vertical-timeline-item vertical-timeline-element">
							<div>
								<span class="vertical-timeline-element-icon bounce-in"> <i
									class="badge badge-dot badge-dot-xl badge-primary"> </i>
								</span>
								<div class="vertical-timeline-element-content bounce-in">
									<h4 class="timeline-title text-success">Discussion with
										marketing team</h4>
									<p>Discussion with marketing team about the popularity of
										last product</p>
									<span class="vertical-timeline-element-date">9:00 AM</span>
								</div>
							</div>
						</div>
						<div class="vertical-timeline-item vertical-timeline-element">
							<div>
								<span class="vertical-timeline-element-icon bounce-in"> <i
									class="badge badge-dot badge-dot-xl badge-success"> </i>
								</span>
								<div class="vertical-timeline-element-content bounce-in">
									<h4 class="timeline-title">Purchase new hosting plan</h4>
									<p>
										Purchase new hosting plan as discussed with development team,
										today at <a href="javascript:void(0);" data-abc="true">10:00
											AM</a>
									</p>
									<span class="vertical-timeline-element-date">10:30 PM</span>
								</div>
							</div>
						</div>
						<div class="vertical-timeline-item vertical-timeline-element">
							<div>
								<span class="vertical-timeline-element-icon bounce-in"> <i
									class="badge badge-dot badge-dot-xl badge-warning"> </i>
								</span>
								<div class="vertical-timeline-element-content bounce-in">
									<p>
										Another conference call today, at <b class="text-danger">11:00
											AM</b>
									</p>
									<p>
										Yet another one, at <span class="text-success">1:00 PM</span>
									</p>
									<span class="vertical-timeline-element-date">12:25 PM</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>