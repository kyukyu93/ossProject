/**
 * common.js 구현
 * 2020.12.10
 */
get_ajax = function(requestUrl, parameter, functionCallBack){
	$.ajax({
		 type        : "GET"
	    ,url         : requestUrl
	    ,dataType    : "json"
		,data        : parameter
		,error       : function(error){
			console.log("ajax : " + requestUrl +"\n" + error);
		}
	    ,success     : function(result){
	    	if(typeof functionCallBack === "function"){
	    		functionCallBack(result);
			}
	    	else if(typeof functionCallBack === "string"){
				eval(functionCallBack + "(result)");
			}
	    }
	    ,beforeSend:function(){
	    	//$('worrior_loading').fadeIn(200);
	        
	    	//$(".worrior_loading").fadeTo(1000,1);
	    	//$('.worrior_loading').removeClass('hide_bg');

	    	$(".worrior_loading").fadeTo(1000, 1, function() {
	    		$('.worrior_loading').removeClass('hide_bg');
	    		$('.worrior_loading').show();
			});
	    }
	    ,complete:function(){
	    	$(".worrior_loading").fadeTo(1000, 0, function() {
	    		$('.worrior_loading').addClass('hide_bg');
	    		$('.worrior_loading').hide();
			});
	    	//$(".worrior_loading").fadeTo(1000,0);
	    	//$('.worrior_loading').addClass('hide_bg');
	    }
	    ,error:function(e){
	    }
	});
};

request_ajax = function(requestUrl, parameter, functionCallBack){
	$.ajax({
		 type        : "POST"
	    ,url         : requestUrl
	    ,dataType    : "json"
		,data        : parameter
		,error       : function(error){
			console.log("ajax : " + requestUrl +"\n" + error);
		}
	    ,success     : function(result){
	    	if(typeof functionCallBack === "function"){
	    		functionCallBack(result);
			}
	    	else if(typeof functionCallBack === "string"){
				eval(functionCallBack + "(result)");
			}
	    }
	    ,beforeSend:function(){
	    	//$('worrior_loading').fadeIn(200);
	        
	    	//$(".worrior_loading").fadeTo(1000,1);
	    	//$('.worrior_loading').removeClass('hide_bg');

	    	$(".worrior_loading").fadeTo(1000, 1, function() {
	    		$('.worrior_loading').removeClass('hide_bg');
	    		$('.worrior_loading').show();
			});
	    }
	    ,complete:function(){
	    	$(".worrior_loading").fadeTo(1000, 0, function() {
	    		$('.worrior_loading').addClass('hide_bg');
	    		$('.worrior_loading').hide();
			});
	    	//$(".worrior_loading").fadeTo(1000,0);
	    	//$('.worrior_loading').addClass('hide_bg');
	    }
	    ,error:function(e){
	    }
	});
};

search_ajax = function(requestUrl, parameter, functionCallBack){
	$.ajax({
		 type        : "POST"
	    ,url         : requestUrl
	    ,dataType    : "json"
		,data        : parameter
		,cache		 : false
		,error       : function(error){
			console.log("ajax : " + requestUrl +"\n" + error);
		}
	    ,success     : function(result){
	    	if(typeof functionCallBack === "function"){
	    		functionCallBack(JSON.stringify(response));
			}
	    	else if(typeof functionCallBack === "string"){
				eval(functionCallBack + "(result)");
			}
	    }
	});
};
