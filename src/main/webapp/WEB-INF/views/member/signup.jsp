<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<title>헬서 파트너쉽 등록</title>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <!-- daum 도로명주소 찾기 api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script src="/resources/js/common.js" ></script>

<script type="text/javascript">
	//모든 공백 체크 정규식
	var empJ = /\s/g;
	//아이디 정규식
	var idJ = /^[a-z0-9][a-z0-9_\-]{4,19}$/;
	// 비밀번호 정규식
	var pwJ = /^[A-Za-z0-9]{4,12}$/;
	// 이름 정규식
	var nameJ = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
	// 이메일 검사 정규식
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 휴대폰 번호 정규식
	var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;

	
	var ifIdCheck = false;
	$(document).ready(function() {
		// 취소
		var address = $('#userAddress2');
		
		$("#userId").on("change keyup paste", function() {
			ifIdCheck = false;
		});
	})

	function fn_idChk() {
		if (idJ.test($('#userId').val()) != true) {
			alert('4~12자의 영문, 숫자만 사용 가능합니다');
			$('#userId').val('');
			return;
		} else if ($('#userId').val() == '') {
			alert('ID를 입력해주세요');
			return;
		}
		var param = new Object();
		param.userId = $("#userId").val();
		
 		var callBack = "idChk_callback";
		request_ajax("/member/idChk.ajax", param, callBack);
	}

	function idChk_callback(result) {
		if(result.result == "success") {
			alert(result.msg);
			ifIdCheck = true;
		}
		else {
			alert(result.msg);
			$("#userId").val('');
		}
	}
	
	function fn_signUpId() {
		if($("#userPw").val() != $("#userPw2").val()) {
			alert("비밀번호가 일치하지 않습니다");
			$("#userPw").val('');
			$("#userPw2").val('');
			return;
		}
		
		if(!ifIdCheck) { alert("ID 중복  체크를 먼저 해주세요"); return; }
		if($("#userId").val() == "") {alert('ID를 입력해주세요'); return; }
		if($("#userPw").val() == "") {alert('비밀번호를 입력해주세요'); return; }
		if($("#userName").val() == "") {alert('사용자 이름을 입력해주세요'); return; }
		if($("#userEmail").val() == "") {alert('이메일을 입력해주세요'); return; }
		if($("#userPhone").val() == "") {alert('휴대폰 번호를 입력해주세요'); return; }
		if($("#userAddress").val() == "") {alert('주소를 입력해주세요'); return; }
		if($("#userAddress2").val() == "") {alert('상세 주소를 입력해주세요'); return; }
		if($("#userBirth").val() == "") {alert('생년월일을 입력해주세요'); return; }

		var param = new Object();
		param.userId = $("#userId").val();
		param.userPw = $("#userPw").val();
		param.userName = $("#userName").val();
		param.userEmail = $("#userEmail").val();
		param.userPhone = $("#userPhone").val();
		param.userAddress = $("#userAddress").val() + " " + $("#userAddress2").val();
		param.userBirth = $('#userBirth').val().replace(/-/gi,'');
		
 		var callBack = "signup_callback";
		request_ajax("/login/signup.ajax", param, callBack);
		
	}
	function signup_callback(result) {
		if(result.result == "success") {
			alert(result.msg);
			location.replace("/worrior/home.do");
		}
		else {
			alert(result.msg);
		}
	}
	function execPostCode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
				var extraRoadAddr = ''; // 도로명 조합형 주소 변수
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraRoadAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraRoadAddr += (extraRoadAddr !== '' ? ', '
							+ data.buildingName : data.buildingName);
				}
				// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraRoadAddr !== '') {
					extraRoadAddr = ' (' + extraRoadAddr + ')';
				}
				// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
				if (fullRoadAddr !== '') {
					fullRoadAddr += extraRoadAddr;
				}
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				console.log(data.zonecode);
				console.log(fullRoadAddr);
				/* var a = console.log(data.zonecode);
				var b = console.log(fullRoadAddr);
				if(a == null || b = null){
				alert("주소를 확인하세요.");
				return false;
				} */
				$("#userAddress").val(data.zonecode);
				$("#userAddress2").val(fullRoadAddr);
				//document.getElementById('mem_detailaddress').value = data.jibunAddress;
			}
		}).open();
	}

	function testFunction() {
		//alert("테스트 function");
	}
	
	

</script>

</head>
<body class="bg-light">
	<div class="container">
		<div class="py-5 text-center">
			<h2>회원가입</h2>
			<p class="lead">내가 설마?에 가입하여 모든 서비스를 이용해보세요!</p>
		</div>

		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-muted">이용 가능 서비스</span> <span
						class="badge badge-secondary badge-pill">2</span>
				</h4>
				<ul class="list-group mb-3">
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<h6 class="my-0">내가 설마?</h6>
							<small class="text-muted">모든 서비스</small>
						</div> <span class="text-muted">일반</span>
					</li>
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<h6 class="my-0">COVID-19 현황</h6>
							<small class="text-muted">알림 서비스</small>
						</div> <span class="text-muted">모바일</span>
					</li>
				</ul>
			</div>
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">사용자 정보</h4>
				<form class="needs-validation" novalidate>
					<div class="row">
						<div class="col-md-10 mb-3">
							<label for="userID">사용할 ID</label>
							<div class="input-group">
								<input type="text" class="form-control" id="userId"
									name="userId" placeholder="사용자 이름" required>
								<div class="invalid-feedback" id="check_id" style="width: 100%;"></div>
							</div>
						</div>

						<div class="col-md-2 mb-3">
							<div class="input-group">
								<label for="idChk">ID 확인</label>
								<button class="btn btn-warning" type="button" id="idChk"
									name="idChk" onclick="fn_idChk();"">중복확인</button>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="userPw">비밀번호</label> <input type="text"
								class="form-control" id="userPw" name="userPw" placeholder=""
								value="" required>
							<div class="invalid-feedback" id="check_pw"></div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="userPw2">비밀번호 </label> <span class="text-muted">(재확인)</span>
							<input type="text" class="form-control" id="userPw2"
								name="userPw2" placeholder="" value="" required>
						</div>
					</div>
					
					<div class="mb-3">
						<label for="username">사용자 이름</label>
						<div class="input-group">
							<input type="text" class="form-control" id="userName"
								name="userName" placeholder="사용자 이름" required>
							<div class="invalid-feedback" id="check_name"
								style="width: 100%;"></div>
						</div>
					</div>

					<div class="mb-3">
						<label for="userEmail">이메일</label> <input type="email"
							class="form-control" id="userEmail"
							placeholder="service@tuenti7.co.kr">
						<div class="invalid-feedback" id="check_email"></div>
					</div>
					
					<div class="mb-3">
						<label for="userBirth">생일</label> <input type="date"
							class="form-control" id="userBirth">
						<div class="invalid-feedback" id="check_birth"></div>
					</div>

					<div class="mb-3">
						<label for="userAddress">주소</label> <input type="text"
							class="form-control" id="userAddress" placeholder="도로명"
							readonly="readonly" onclick="execPostCode();">
						<div class="invalid-feedback" id="check_address"></div>
					</div>
					<div class="mb-3">
						<label for="userAddress2">상세 주소</label> <input type="text"
							class="form-control" id="userAddress2" placeholder="건물명"
							readonly="readonly">
					</div>

					<div class="mb-3">
						<label for="userAddress2">연락처</label> <input type="text"
							class="form-control" id="userPhone" placeholder="010-0000-0000">
					</div>

					<div class="mb-3">
						<label for="country">서비스 국가</label> <select
							class="custom-select d-block w-100" id="country" required>
							<option>대한민국 (South Korea)</option>
						</select>
						<div class="invalid-feedback">Please select a valid country.</div>
					</div>

					<hr class="mb-4">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="agree-account"> <label class="custom-control-label"
							for="agree-account">회원약관 <span class="text-muted">(필수)</span></label>
					</div>
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="agree-privacy"> <label class="custom-control-label"
							for="agree-privacy">개인정보 수집 및 이용 동의 <span
							class="text-muted">(필수)</span></label>
					</div>
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="agree-macketing"> <label class="custom-control-label"
							for="agree-macketing">마케팅/홍보의 수집 및 이용 동의 <span
							class="text-muted">(선택)</span></label>
					</div>

					<hr class="mb-4">
					<!--<button class="btn btn-primary btn-lg btn-block" type="submit">회원가입</button> -->
					<button class="btn btn-primary btn-lg btn-block" type="button"
						id="signUpId" onclick="fn_signUpId();">회원가입</button>
				</form>
			</div>
		</div>

		<footer class="my-5 pt-5 text-muted text-center text-small">
			<p class="mb-1">&copy; 2021 프로걱정러, Korea</p>
			<ul class="list-inline">
				<li class="list-inline-item"><a href="#">개인정보보호</a></li>
				<li class="list-inline-item"><a href="#">관련법률</a></li>
				<li class="list-inline-item"><a href="#">고객지원</a></li>
			</ul>
		</footer>
	</div>
</body>
</html>
