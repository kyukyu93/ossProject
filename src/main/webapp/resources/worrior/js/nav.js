// nav-menu
function chk() {
	
	if (cc == 1) {
		$("#nav-menu ul li ul").slideDown(300);
		$(".nav-menu-bg").slideDown(300);
	} else {
		$("#nav-menu ul li ul").slideUp(200);
		$(".nav-menu-bg").slideUp(200);
	}
}

$(function() {

	$('#nav-menu>ul>li').mouseover(function() {
		setTimeout(chk, 100);
		cc = 1;
		$(this).addClass('active');
	});

	$('#nav-menu').mouseout(function() {
		setTimeout(chk, 400);
		cc = 0;
		$('#nav-menu ul li').removeClass('active');
	});

	$('#nav-menu ul li a').focus(function() {
		setTimeout(chk, 100);
		cc = 1;
		$(this).parent().addClass('active');
	});

	$('#nav-menu ul li a').blur(function() {
		setTimeout(chk, 100);
		cc = 0;
		$('#nav-menu ul li').removeClass('active');

	});

});