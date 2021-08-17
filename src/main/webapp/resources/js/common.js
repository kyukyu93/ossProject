/**
 * common.js 구현
 * 2020.12.10
 */

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
	    	//$('healther_loading').fadeIn(200);
	        
	    	//$(".healther_loading").fadeTo(1000,1);
	    	//$('.healther_loading').removeClass('hide_bg');

	    	$(".healther_loading").fadeTo(1000, 1, function() {
	    		$('.healther_loading').removeClass('hide_bg');
	    		$('.healther_loading').show();
			});
	    }
	    ,complete:function(){
	    	$(".healther_loading").fadeTo(1000, 0, function() {
	    		$('.healther_loading').addClass('hide_bg');
	    		$('.healther_loading').hide();
			});
	    	//$(".healther_loading").fadeTo(1000,0);
	    	//$('.healther_loading').addClass('hide_bg');
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
