/*Javascript for exam function
 * lingxuan create
 * 2013-4-23
 * http://www.lingxuanweb.com
*/

/**
 * string.trim;
**/
function  trim(str){
    for(var  i  =  0  ;  i<str.length  &&  str.charAt(i)=="  "  ;  i++  )  ;
    for(var  j  =str.length;  j>0  &&  str.charAt(j-1)=="  "  ;  j--)  ;
    if(i>j)  return  "";  
    return  str.substring(i,j);  
}

/**
 * checkEmpty
 * show error
**/
function checkEmpty(formId){
	 var inputs = $(formId+" input.noEmpty");
	 var chkresult = true;
	 // $("span.reg-error").hide();
	 inputs.each(function(){
		if($(this).next("span.reg-error").html() == "不能为空"){
			$(this).next("span.reg-error").hide();
		}
		if(trim($(this).val()) == ""){
			$(this).next("span.reg-error").html("不能为空");
			$(this).next("span.reg-error").show();	
			chkresult = false;
		}
	 });
	 return chkresult;
}

function changeEmpty(formId){
	var inputs = $(formId+" input.noEmpty");
	 // $("span.reg-error").hide();
	 inputs.each(function(){
		$(this).blur(function (){
			if($(this).next("span.reg-error").html() == "不能为空"){
				$(this).next("span.reg-error").hide();
			}
			if(trim($(this).val()) == ""){
				$(this).next("span.reg-error").html("不能为空");
				$(this).next("span.reg-error").show();	
			}
		});
		
	 });
}
/**
*禁用鼠标复制
*******************************************/
$(document).ready(function(){
	 $(document).bind("contextmenu", function(){return false;});  
	 $(document).bind("selectstart", function(){return false;});  
});