(function($){
			
	$.getUrlParam = function(numerber)
	{
		var url = window.location.href;
		var ary = rul.split("/");//用“/”将URL分割成几部分存入数组
		if (ary !=null) return ary[numerber];
		else return null;
	}
	var error = $.getUrlParam('1');
	if(!error)
	{
		$(this).removeClass("active"); 
	}
	else
	{
		var navs = $(".nav li");
		navs.each(function(i,obj){  
			//其中obj 就是this  

			if($(this).text() == error)
			{
				$(this).addClass("active"); 
			}
			else
			{
				$(this).removeClass("active"); 
			}
		});  
	}
			
})(jQuery);