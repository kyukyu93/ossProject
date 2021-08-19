<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>worrior</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<link rel="stylesheet" type="text/css" href="/resources/worrior/css/intro/intro.css">
<link rel="stylesheet" type="text/css" href="/resources/worrior/css/common.css" />

<script type="text/javascript" src="/resources/worrior/js/nav.js"></script>
<script type="text/javascript" src="/resources/worrior/js/jquery-3.5.1.js"></script>

<script>
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top - 300
			}, 500);
		});
	});
</script>

</head>
<body>

	<div class="wrap">
		<!-- 스킵 네비게이션 -->
		<!-- header -->
		<div class="header">
			<jsp:include page="../../common/worrior_nav.jsp" flush="false" />
		</div>
		<div class="item-block"></div>
		<div class="container">
			<div class="left-nav">
				<jsp:include page="../../common/left_nav.jsp" flush="false" />
			</div>
			<div class="content" id="content">

				<div class="intro-area">
				
					<div class="block-area"></div>
					
					<div class="intro-icons">
						<div>
							<div class="icons-header">
								<h2>나도 설마?</h2>

								<hr class="icons-divider">
								<p>
									동해물과 백도산이 마르고 닳도록 <br>
									하느님이 보우하사 우리나라 만세
								</p>
							</div>

							<div class="icons-div">
								<div class="icons-item">
									<img class="icon-img" />
									<h3>
										<a href="#item1" class="scroll">기능 1</a>
									</h3>
									<p>기능 1의 설명</p>
								</div>
							</div>

							<div class="icons-div">
								<div class="icons-item">
									<img class="icon-img" />
									<h3>
										<a href="#item2" class="scroll">기능 2</a>
									</h3>
									<p>기능 2의 설명</p>
								</div>
							</div>

							<div class="icons-div">
								<div class="icons-item">
									<img class="icon-img" />
									<h3>
										<a href="#item3" class="scroll">기능 3</a>
									</h3>
									<p>기능 3의 설명</p>
								</div>
							</div>

							<div class="icons-div">
								<div class="icons-item">
									<img class="icon-img" />
									<h3>
										<a href="#item4" class="scroll">기능 4</a>
									</h3>
									<p>기능 4의 설명</p>
								</div>
							</div>

							<div class="icons-div">
								<div class="icons-item">
									<img class="icon-img" />
									<h3>
										<a href="#item5" class="scroll">기능 5</a>
									</h3>
									<p>
										기능5<br>설명
									</p>
								</div>
							</div>

							<div class="icons-div">
								<div class="icons-item">
									<img class="icon-img" />
									<h3>
										<a href="#item6" class="scroll">기능6</a>
									</h3>
									<p>
										기능 6의 설명
									</p>
								</div>
							</div>

							<div class="icons-div">
								<div class="icons-item">
									<img class="icon-img" />
									<h3>
										<a href="#item7" class="scroll">기능7</a>
									</h3>
									<p>
										기능7의 설명
									</p>
								</div>
							</div>

							<div class="icons-div">
								<div class="icons-item">
									<img class="icon-img" />
									<h3>
										<a href="#item8" class="scroll">기능8</a>
									</h3>
									<p>
										기능8의 설명
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="block-area"></div>

				<div class="intro-area">
					<div class="intro-row">
						<div class="intro-text">
							<h2 class="intro-text-head">
								새로운 서비스 <span class="intro-text-highlight">
									나도 설마?</span>
							</h2>
							<p class="intro-text-body">
								동해물과 백도산이 마르고 닳도록 하느님이 보우하사 우리나라 만세
							</p>
						</div>
						<div>
							<img class="intro-image" />
						</div>
					</div>

					<hr class="intro-divider">


					<div class="intro-row" id="item1">
						<div class="intro-text rightarea">
							<h2 class="intro-text-head">
								새로운 <span class="intro-text-highlight"> 기능</span>
							</h2>
							<p class="intro-text-body">
								새로운 기능
							</p>
						</div>
						<div class="intro-image-div">
							<img class="intro-image" />
						</div>
					</div>

					<hr class="intro-divider">


					<div class="intro-row" id="item2">
						<div class="intro-text">
							<h2 class="intro-text-head">
								기능 <span class="intro-text-highlight">기능</span>
							</h2>
							<p class="intro-text-body">
								기능
							</p>
						</div>
						<div class="intro-image-div">
							<img class="intro-image" />
						</div>
					</div>

					<hr class="intro-divider">

					<div class="intro-row" id="item3">
						<div class="intro-text rightarea">
							<h2 class="intro-text-head">
								안심하고 이용하세요 <span class="intro-text-highlight"> 기능
									인증</span>
							</h2>
							<p class="intro-text-body">
								기능
							</p>
						</div>
						<div>
							<img class="intro-image" />
						</div>
					</div>

					<hr class="intro-divider">

					<div class="intro-row" id="item4">
						<div class="intro-text">
							<h2 class="intro-text-head">
								함께하는 효율적인 <span class="intro-text-highlight"> 기능</span>
							</h2>
							<p class="intro-text-body">
								기능<br> <span class="alert">기능</span><br>
							</p>
						</div>
						<div>
							<img class="intro-image" />
						</div>
					</div>

					<hr class="intro-divider">


					<div class="intro-row" id="item5">
						<div class="intro-text rightarea">
							<h2 class="intro-text-head">
								기능 <span class="intro-text-highlight">
									기능</span>
							</h2>
							<p class="intro-text-body">
								기능 <br>
							</p>
						</div>
						<div>
							<img class="intro-image" />
						</div>
					</div>

					<hr class="intro-divider">


					<div class="intro-row" id="item6">
						<div class="intro-text">
							<h2 class="intro-text-head">
								모두 함께하는 <span class="intro-text-highlight"> 기능</span>
							</h2>
							<p class="intro-text-body">
								기능
							</p>
						</div>
						<div>
							<img class="intro-image" />
						</div>
					</div>

					<hr class="intro-divider">


					<div class="intro-row" id="item7">
						<div class="intro-text rightarea">
							<h2 class="intro-text-head">
								기능 <span class="intro-text-highlight"> 기능</span>
							</h2>
							<p class="intro-text-body">
								기능
							</p>
						</div>
						<div>
							<img class="intro-image" />
						</div>
					</div>

					<hr class="intro-divider">


					<div class="intro-row" id="item8">
						<div class="intro-text">
							<h2 class="intro-text-head">
								간편한 <span class="intro-text-highlight"> 기능</span>
							</h2>
							<p class="intro-text-body">
								기능
							</p>
						</div>
						<div>
							<img class="intro-image" />
						</div>
					</div>

					<hr class="intro-divider">
					<!-- /END THE FEATURETTES -->

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
