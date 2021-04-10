// JavaScript Document
function regist_form_check(){
	frm = document.getElementById( "frm_regist" );

	var userAccount = document.getElementById( "userAccount" ).value;
	var userPsw = document.getElementById( "userPsw" ).value;
	var userPsw_confirm = document.getElementById( "userPsw_confirm" ).value;
	var userName = document.getElementById( "userName" ).value;
	var userIdentity = document.getElementById( "userIdentity" ).value;
	var userIdentity_confirm = document.getElementById( "userIdentity_confirm" ).value;
	var userSex = document.getElementById( "userSex" ).value;
	var userSex_id = document.getElementById( "userSex" ).value;
	var userEmail = document.getElementById( "userEmail" ).value;
	var userCellphone = document.getElementById( "userCellphone" ).value;
	var userPhone = document.getElementById( "userPhone" ).value;
	var userProvince = document.getElementById( "userProvince" ).value;
	var userSchool = document.getElementById( "userSchool" ).value;
	var userSchool_2 = document.getElementById( "userSchool_2" ).value;
	var userMajor = document.getElementById( "userMajor" ).value;
	var userYear = document.getElementById( "userYear" ).value;
	var userDegree = document.getElementById( "userDegree" ).value;
	var userCityType = document.getElementById( "userCityType" ).value;
	var userPosition = document.getElementById( "userPosition" ).value;
	var city = document.getElementById( "city" ).value;
	
	var al = true;
	for( var i=0;i<frm.userSex.length;i++  ){
		if(frm.userSex[i].checked){ 
			al=false;
		}
	}	

	if( userAccount == '' || userPsw == '' || userPsw_confirm == '' || userName == '' || al || userIdentity == '' || userIdentity_confirm =='' || userEmail == '' || 
		userCellphone == '' || userMajor == '' || userProvince == ''  || userYear == ''  || userDegree == ''  || 
		userCityType == '' || userPosition == ''  || city == '0' ){
		alert( "请填写所有带 * 信息" );
		return false;
	}else{
		if( userSchool == '' && userSchool_2 == '' ){
			alert( "请选择或填写您所在的学校" );
			return false;
		}

		/* 登录名称验证 */
		if( rightID( userAccount ) ){

		}else{
			alert( "请输入正确的登录名称格式，限用字母、数字及下划线！" );
			return false;
		}

		if( userAccount.length < 6 || userAccount.length > 20 ){
			alert( "登录名称长度至少大于6位，小于20位！" );
			return false;
		}

		/* 真实姓名验证 */
		if( !isChn( userName ) ){

		}else{
			alert( "请输入正确中文名字！" );
			return false;
		}

		/* 身份证验证 */
		if( userIdentity != userIdentity_confirm ){
			alert( "身份证和身份证确认不一致，请从新输入！" );
			document.getElementById( "userIdentity" ).value = '';
			document.getElementById( "userIdentity_confirm" ).value = '';
			return false;
		}

		tmp = checkId( userIdentity );
		if( tmp == userIdentity ){
		}else{
			alert(tmp);
			return false;
		}

		/* 密码验证 */
		if( userPsw != userPsw_confirm ){
			alert( "密码和密码确认不一致，请从新输入！" );
			document.getElementById( "userPsw" ).value = '';
			document.getElementById( "userPsw_confirm" ).value = '';
			return false;
		}

		if( rightID( userPsw ) ){

		}else{
			alert( "请输入正确的密码格式，限用字母、数字及下划线！" );
			return false;
		}

		if( userPsw.length < 6 || userPsw.length > 20 ){
			alert( "登录密码长度至少大于6位，小于20位！" );
			return false;
		}

		/* 电话验证 
		shouji = checkMobile( userCellphone );
		if( shouji ){
		}else{
			alert( "错误的手机号码！" );
			return false;
		} */

		if( userCellphone.length != 11 ){
			alert( "请输入11位的手机号码" );
			return false;
		}

		/* 邮箱验证 */	
		if( !isEmail( userEmail ) ){
			alert( "请输入正确的邮箱地址格式！" );
			return false;
		}

	}

	frm.submit();
}

function detail_form_check(){
	frm = document.getElementById( "frm_view_detail" );

	var userPsw = document.getElementById( "userPsw" ).value;
	var userPsw_confirm = document.getElementById( "userPsw_confirm" ).value;
	var userEmail = document.getElementById( "userEmail" ).value;
	var userCellphone = document.getElementById( "userCellphone" ).value;
	// var userCity = document.getElementById( "userCitys" ).value;
	//var userPhone = document.getElementById( "userPhone" ).value;

	if( userEmail == '' || userCellphone == '' ){
		alert( "请填写所有带 * 信息" );
		return false;
	}else{
		if( userPsw != '' ){
			if( userPsw != userPsw_confirm ){
				alert( "密码和密码确认不一致，请从新输入！" );
				document.getElementById( "userPsw" ).value = '';
				document.getElementById( "userPsw_confirm" ).value = '';
				return false;
			}

			if( userPsw.length < 6 || userPsw.length > 20 ){
				alert( "登录密码长度至少大于6位，小于20位！" );
				return false;
			}

			if( rightID( userPsw ) ){

			}else{
				alert( "请输入正确的密码格式，限用字母、数字及下划线！" );
				return false;
			}
		}

		/*
		shouji = checkMobile( userCellphone );
		if( shouji ){
		}else{
			alert( "错误的手机号码！" );
			return false;
		} */

		if( userCellphone.length != 11 ){
			alert( "请输入11位的手机号码" );
			return false;
		}

		if( !isEmail( userEmail ) ){
			alert( "请输入正确的邮箱地址格式！" );
			return false;
		}
	}

	 frm.submit();
}

function login_frm_check(){
	frm = document.getElementById( "login_form" );

	var name = document.getElementById( "name" ).value;
	var password = document.getElementById( "password" ).value;
	var txtVcode = document.getElementById( "txtVcode" ).value;
	
	if( name == '' || password == '' || txtVcode == '' ){
		alert( "请输入所有账号信息！" );
		return false;
	}else{
		if( rightID( name ) ){

		}else{
			alert( "请输入正确的登录名称格式，限用字母、数字及下划线！" );
			return false;
		}

		if( name.length < 1 || name.length > 20 ){
			alert( "登录名称不能为空！" );
			return false;
		}

		if( rightID( password ) ){

		}else{
			alert( "请输入正确的密码格式，限用字母、数字及下划线！" );
			return false;
		}

		if( password.length < 6 || password.length > 20 ){
			alert( "登录密码长度至少大于6位，小于20位！" );
			return false;
		}
	}

	return true;
}

function isChn(str){
      var reg = /[^\u4E00-\u9FA5]/g;
      if(!reg.test(str)){
       return false;
      }
      return true;
}

function rightID(ID){  
  var   re = /^\w+$/;  
  return re.test(ID);  
}

function isEmail(str) {
  // are regular expressions supported?
  var supported = 0;
  if (window.RegExp) {
    var tempStr = "a";
    var tempReg = new RegExp(tempStr);
    if (tempReg.test(tempStr)) supported = 1;
  }
  if (!supported) 
    return (str.indexOf(".") > 2) && (str.indexOf("@") > 0);
  var r1 = new RegExp("(@.*@)|(\\.\\.)|(@\\.)|(^\\.)");
  var r2 = new RegExp("^.+\\@(\\[?)[a-zA-Z0-9\\-\\.]+\\.([a-zA-Z]{2,3}|[0-9]{1,3})(\\]?)$");
  return (!r1.test(str) && r2.test(str));
}

function page_change( page ){
	document.location = page;
}

function check_exites( obj ){
    reg = /.*true.*/;
    if(reg.test(obj)){    
        return 1;   
    }
    
    reg = /.*false.*/;
    if(reg.test(obj)){
        return 0;
    } 
}

function regist_user_check(){
	var account = document.getElementById("userAccount").value;
	if( account != '' ){
		if( rightID( account ) ){

		}else{
			alert( "请输入正确的登录名称格式，限用字母、数字及下划线！" );
			return false;
		}

		if( account.length < 1 || account.length > 20 ){
			alert( "登录名称长度至少大于1位，小于20位！" );
			return false;
		}

		$.ajax({
			type: "POST",
			url: "ajax_regist_check.php",
			data:   "account="+escape( account ),
			success: function( text ){
				if( check_exites( text )==1){
					alert( "该登录名称已经存在，请用其他登录名称！" );
					return false;
				}else{
					alert( "该登录名称可用" );
					return true;
				}
			}
		});
	}else{
		alert( "请输入登录名称" );
		return false;
	}
}

function regist_user_all_check(){
	var account = document.getElementById("userAccount").value;
	var userIdentity = document.getElementById("userIdentity").value;
	var userCellphone = document.getElementById("userCellphone").value;
	var userEmail = document.getElementById("userEmail").value;

	$.ajax({
		type: "POST",
		url: "ajax_regist_all_check.php",
		data:   "account="+escape( account )+"&userIdentity="+escape( userIdentity )+"&userCellphone="+escape( userCellphone )+"&userEmail="+escape( userEmail ),
		success: function( text ){
			if( check_exites( text )==1 ){	
				alert( "该登录名称,或身份证，或手机，或Email,已经存在，请重新输入！" );
				return false;
			}else{
				return true;
			}
		}
	});
}

function login_form_check(){
	frm = document.getElementById( "frm_login" );

	var name = document.getElementById( "name" ).value;
	var password = document.getElementById( "password" ).value;
	var code = document.getElementById( "txtVcode" ).value;

}

function recruit_change(){
	var type = document.getElementById("userCityType").value;
	
	$.ajax({
		type: "POST",
		url: "ajax_recruit_change.php",
		data:   "type="+escape( type ), //传入招聘类别编号
		success: function( text ){ //理论上text应该包括city和position值
			//alert(text);
			var arr = text.split("#");
			positionstr = '<select id="userPosition" class="select-box"  datatype="*" name="userPosition" class="recruit_selete">';
			$("#position_id").empty();  
			$("#position_id").html( positionstr + arr[0] );

			$("#city_id").empty();
			$("#city_id").html( arr[1] );

			if(arr[2]=="2"){//社会招聘
				$("#ApplyInvitor").css("display","");
				$("#ApplyPosition").css("display","");
				//$("#ApplyCity").css("display","none");
			}else{//校园招聘
				$("#ApplyInvitor").css("display","none");
				$("#ApplyPosition").css("display","none");
				$("#ApplyCity").css("display","");
			}
		}	
	});
}

function recruit_change2(){
	var type = document.getElementById("userCityType2").value;
	
	$.ajax({
		type: "POST",
		url: "ajax_recruit_change.php",
		data:   "type="+escape( type ), //传入招聘类别编号
		success: function( text ){ //理论上text应该包括city和position值
			//alert(text);
			var arr = text.split("#");
			positionstr = '<select id="userPosition2" class="select-box" name="userPosition2" class="recruit_selete">';
			$("#position_id2").empty();  
			$("#position_id2").html( positionstr + arr[0] );

			$("#city_id2").empty();
			$("#city_id2").html( arr[1] );

			if(arr[2]=="2"){//社会招聘
				$("#ApplyInvitor").css("display","");
				$("#ApplyPosition").css("display","");
				//$("#ApplyCity").css("display","none");
			}else{//校园招聘
				$("#ApplyInvitor").css("display","none");
				$("#ApplyPosition").css("display","none");
				$("#ApplyCity").css("display","");
			}
		}	
	});
}

function invitorCheck(){
	var invitor = $("#invitor").val();
	if(invitor=="" || isChn(invitor)){
		alert("请填写正确的邀请人中文姓名");
		$("#invitor").val("");
		$("#invitor").focus();
		//alert("okay");
		return false;
	}
	return true;
}

function province_change(){
	var province = document.getElementById("userProvince").value;
	var times = new Date().getTime();
	$.ajax({
		type: "POST",
		url: "ajax_province_change.php",
		data:{province:escape( province ), tm:times},
		timeout:5000,
		success: function( text ){
			$("#school_id").empty();  
	        $("#school_id").html( text );
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert("系统检测网络设置存在问题，将自动跳转至另一页面完成注册。");
			window.location.href="https://exam.cvte.cn/online/regist.php";
			return false;
		}
	});
}

function question( id ){
	$('#ajax_loader_img').html('<img src="includes/images/ajax-loader.gif"/>');
	$.ajax({
		type: "POST",
		url: "ajax_question_change.php",
		data:   "id_question="+escape( id ),
		success: function( text ){
			$("#exam_content").empty();  
	        $("#exam_content").html( text );
		}
	});
	$('#ajax_loader_img').html('');
}

function confirm_one_test( id ){
	var obj;   
	check = true;
	choice = '';
	obj=document.getElementsByName(id);   
	if(obj!=null){   
		var i;
		if( obj.length > 1 ){
			for(i=0;i<obj.length;i++){   
				if(obj[i].checked){   
				choice = obj[i].value; 
				check = false;
				}   
			} 
		}else{
			choice = document.getElementById(id).value;
			if( choice!= '' ){
				check = false;
			}
		}
	} 
	var quesType = $("#question_type").val();
	if( check ){
		alert( "请选择答案!" );
		return false;
	}else{
		$('#ajax_loader_img').html('<img src="includes/images/ajax-loader.gif"/>');
		$.ajax({
			type: "POST",
			url: "ajax_confirm.php",
			data:   "confirm="+escape( id )+"&choice="+choice+"&pause=0"+"&t="+quesType,
			success: function( text ){
				if (text == 1) {
					$("#showSubmit").bPopup({
						fadeSpeed: 'slow',
						zIndex: '9999',
						closeClass:'closeBtn'
					});
				}else{
					$("#exam_content").empty();  
					$("#exam_content").html( text );
				}
			}
		});
		$('#ajax_loader_img').html('');
	}
}

function confirm_one_test_soft( id,id2 ){
	var obj;   
	check = true;
	choice = '';
	choice2 = '';
	
	obj=document.getElementsByName(id);   

	if(obj!=null){   
		var i;
		if( obj.length > 1 ){
			for(i=0;i<obj.length;i++){   
				if(obj[i].checked){   
				choice = obj[i].value; 
				check = false;
				}   
			} 
		}else{
			choice = document.getElementById(id).value;
			if( choice!= '' ){
				//if(checknumber(choice))
			    //{
			     // alert("答案只允许输入数字!");
			     // return  false;
			    //}
				
				check = false;
			}else{
				alert( "请填写答案!" );
				return false;
			}
			
			if(document.getElementById(id2)){
				choice2 = document.getElementById(id2).value;
				if( choice2!= '' ){
					check = false;
				}else{
					alert( "请附上源代码，谢谢!" );
					return false;
				}
			}
		}
	} 
	
	if( check ){
		alert( "请填写答案!" );
		return false;
	}else{
		choice=filter(choice);
		choice2=filter(choice2);
		$('#ajax_loader_img').html('<img src="includes/images/ajax-loader.gif"/>');
		$.ajax({
			type: "POST",
			url: "ajax_confirm_soft.php",
			data:   "confirm="+escape( id )+"&choice="+choice+"&choice2="+choice2+"&pause=0",
			success: function( text ){
				if (text == 1) {
					$("#showSubmit").bPopup({
						fadeSpeed: 'slow',
						zIndex: '9999',
						closeClass:'closeBtn'
					});
				}else{
					$("#exam_content").empty();  
					$("#exam_content").html( text );
				}
			}
		});
		$('#ajax_loader_img').html('');
	}
}

function confirm_one_test_and_pause( id ){
	var obj;   
	check = true;
	choice = '';
	obj=document.getElementsByName(id);   
	if(obj!=null){   
		var i;
		if( obj.length > 1 ){
			for(i=0;i<obj.length;i++){   
				if(obj[i].checked){   
				choice = obj[i].value; 
				check = false;
				}   
			} 
		}else{
			choice = document.getElementById(id).value;
			if( choice!= '' ){
				check = false;
			}
		}
	} 
	
	if( check ){
		alert( "请选择答案!" );
		return false;
	}else{
		$('#ajax_loader_img').html('<img src="includes/images/ajax-loader.gif"/>');
		$.ajax({
			type: "POST",
			url: "ajax_confirm.php",
			data:   "confirm="+escape( id )+"&choice="+choice+"&pause=1",
			success: function( text ){
				$("#exam_content").empty();  
				$("#exam_content").html( text );
				clearTimeout(t);
			}
		});
		$('#ajax_loader_img').html('');
	}
}

function confirm_one_test_soft_and_pause( id,id2 ){
	var obj;   
	check = true;
	choice = '';
	choice2 = '';
	
	obj=document.getElementsByName(id);   

	if(obj!=null){   
		var i;
		if( obj.length > 1 ){
			for(i=0;i<obj.length;i++){   
				if(obj[i].checked){   
				choice = obj[i].value; 
				check = false;
				}   
			} 
		}else{
			choice = document.getElementById(id).value;
			if( choice!= '' ){
				//if(checknumber(choice))
			    //{
			     // alert("答案只允许输入数字!");
			     // return  false;
			    //}
				
				check = false;
			}else{
				alert( "请填写答案!" );
				return false;
			}
			
			if(document.getElementById(id2)){
				choice2 = document.getElementById(id2).value;
				if( choice2!= '' ){
					check = false;
				}else{
					alert( "请附上源代码，谢谢!" );
					return false;
				}
			}
		}
	} 
	
	if( check ){
		alert( "请填写答案!" );
		return false;
	}else{
		choice=filter(choice);
		choice2=filter(choice2);
		$('#ajax_loader_img').html('<img src="includes/images/ajax-loader.gif"/>');
		$.ajax({
			type: "POST",
			url: "ajax_confirm_soft.php",
			data:   "confirm="+escape( id )+"&choice="+choice+"&choice2="+choice2+"&pause=1",
			success: function( text ){
				$("#exam_content").empty();  
				$("#exam_content").html( text );
				clearTimeout(t);
			}
		});
		$('#ajax_loader_img').html('');
	}
}

function resume_from_pause(){
	$('#ajax_loader_img').html('<img src="includes/images/ajax-loader.gif"/>');
	$.ajax({
		type: "POST",
		url: "ajax_confirm.php",
		data:   "pause=2",
		success: function( text ){
			$("#exam_content").empty();  
			$("#exam_content").html( text );
			t=setTimeout("GetRTime()",1000);
		}
	});
	$('#ajax_loader_img').html('');
}

function resume_from_pause_soft(){
	$('#ajax_loader_img').html('<img src="includes/images/ajax-loader.gif"/>');
	$.ajax({
		type: "POST",
		url: "ajax_confirm_soft.php",
		data:   "pause=2",
		success: function( text ){
			$("#exam_content").empty();  
			$("#exam_content").html( text );
			t=setTimeout("GetRTime()",1000);
		}
	});
	$('#ajax_loader_img').html('');
}

function filter(str)
{
    str = str.replace(/\+/g,"%2B");
    str = str.replace(/\&/g,"%26");
    return str;
}

function action_check(){
	var msg = "我已确认安装好编译环境,现在开始答题?"; 
	if (confirm(msg)==true){ 
		return true;
	}else{
		return false;
	}
}

function test_frm_submit( url,tmp,type,exam_type){//type=1校招，2社招, 4免费讲座测试
	// $("#q_content").css('visibility','hidden');
	$('#test_submit').attr("disabled","disabled");
	$("#test_submit").val("正在提交职业倾向测评...");
	if(exam_type == undefined){
		exam_type_post = "hardware";
	}else{
		exam_type_post = exam_type;
	}
	var ques;
	if ($("#question_type").length > 0) {
		ques = $("#question_type").val();
	} else{
		ques = "";
	};
	$.ajax({
		type: "POST",
		url: "ajax_test_submit.php",
		data: {confirm:"yes", getType: exam_type_post, quesType: ques},
		success: function( text ){
			console.log(text);
			if( check_exites( text )== 1 ){
				$("#showSubmit-content p").html( "您的测评已经提交，感谢您的参与。" );
				if(type=="1" && tmp == "2" ){ //校招硬件类
					window.location.href=url+"online/professional_exam_note.php";
				}else if(type=="1" && tmp == "3" ){ //校招软件开发类
					window.location.href=url+"online/professional_exam_note.php";
				}else{//校招文职类，以及所有的社招
					window.location.href=url+"online/index.php";
				}
				return true;
			}else{
				alert( "请填写至少一个答案" );
				//alert("提交失败，请重试！");
				return false;
			}
		}
	});
		return true; 
}

function test_frm_submit_soft( url,tmp ){
	// var msg = "您确定要结束测评，提交答案吗？"; 
		//$("#test_submit").css('visibility','hidden');
		//结束职业倾向测评，提交答案
		$("#test_submit").val("正在提交专业能力测试...");
		$('#test_submit').attr("disabled","disabled")
		$.ajax({
			type: "POST",
			url: "ajax_test_submit_soft.php",
			data:   "confirm=yes",
			success: function( text ){
				if( check_exites( text )== 1 ){
					$("#showSubmit-content p").html( "您的测评已经提交，感谢您的参与。" );
					window.location.href=url+"online/index.php";
					return true;
				}else{
					$("#showSubmit-content p").html( "请填写至少一个答案" );
					return false;
				}
			}
		});
		return true; 
}

function test_frm_submit_auto( url,tmp,exam_type){//基础题自动提交，默认全部跳转至个人主页
	if(exam_type == undefined){
		exam_type_post = "hardware";
	}else{
		exam_type_post = exam_type;
	}
	var ques;
	if ($("#question_type").length > 0) {
		ques = $("#question_type").val();
	} else{
		ques = "";
	};
	$.ajax({
		type: "POST",
		url: "ajax_test_submit.php",
		data: {confirm:"yes", getType: exam_type_post, quesType: ques},
			success: function( text ){
			console.log(text);
			if( check_exites( text )==1 ){
				alert( "测试时间已经结束，您的测评已经提交，感谢您的参与。" );
				if( tmp == '1' ){
					//window.location.href=url+"user/online_application.php";
					window.location.href=url+"online/index.php";
				}else{
					//window.location.href=url+"user/professional_online_exam.php";
					window.location.href=url+"online/index.php";
				}
				return true;
			}else{
				alert( "测试时间已经结束，谢谢你的参与。" );
				window.location.href=url+"online/index.php";
				return true;
			}
		}
	});
	return true; 
}

function test_frm_submit_auto_soft( url,tmp ){
	$.ajax({
		type: "POST",
		url: "ajax_test_submit_soft.php",
		data:   "confirm=yes",
			success: function( text ){
			if( check_exites( text )==1 ){
				alert( "测试时间已经结束，您的测评已经提交，感谢您的参与。" );
				window.location.href=url+"online/index.php";
				return true;
			}else{
				alert( "测试时间已经结束，谢谢你的参与。" );
				window.location.href=url+"online/index.php";
				return true;
			}
		}
	});
	return true; 
}

function forget_password(){
	frm = document.getElementById( "frm_password" );

	var userAccount = document.getElementById( "userAccount" ).value;
	var userEmail = document.getElementById( "userEmail" ).value;

	if( userAccount == '' || userEmail == '' ){
		alert( "请填写完全您的登录名称和电子邮箱，谢谢！" );
		return false;
	}else{
		if( !isEmail( userEmail ) ){
			alert( "请输入正确的邮箱地址格式！" );
			return false;
		}
	}

	frm.submit();
}

function resetBasicTest(type){
	$.ajax({
		type: "POST",
		url: "ajax_reset_basic_test.php",
		data:   "type="+type,
		success: function( text ){
			console.log(text);
			if (text) {
				window.location = window.location;
			}else{
				alert("操作失败");
			}
		}
	});
}

function checkId(pId){ 
//检查身份证号码 Go_Rush(阿舜) from http://ashun.cnblogs.com 
	if( pId.length == 7 ){
		return pId;
	}else if( pId.length == 10 || pId.length == 12 ){
		return pId;
	}

    var arrVerifyCode = [1,0,"X",9,8,7,6,5,4,3,2]; 
    var Wi = [7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2]; 
    var Checker = [1,9,8,7,6,5,4,3,2,1,1]; 
    if(pId.length != 15 && pId.length != 18)    return "身份证号共有 15 码或18位"; 
    var Ai=pId.length==18 ?  pId.substring(0,17)   :   pId.slice(0,6)+"19"+pId.slice(6,16); 
    if (!/^\d+$/.test(Ai))  return "身份证除最后一位外，必须为数字！"; 
    var yyyy=Ai.slice(6,10) ,  mm=Ai.slice(10,12)-1  ,  dd=Ai.slice(12,14); 
    var d=new Date(yyyy,mm,dd) ,  now=new Date(); 
     var year=d.getFullYear() ,  mon=d.getMonth() , day=d.getDate(); 
    if (year!=yyyy || mon!=mm || day!=dd || d>now || year<1940) return "身份证输入错误！"; 
    for(var i=0,ret=0;i<17;i++)  ret+=Ai.charAt(i)*Wi[i];     
    Ai+=arrVerifyCode[ret %=11];      
    return pId.length ==18 && pId != Ai?"身份证输入错误！":Ai;         
}

function checkMobile( mobile ){ 
     var reg0=/^13\d{5,9}$/; //130--139。至少7位 
     var reg1=/^153\d{8}$/; //联通153。至少7位 
     var reg2=/^159\d{8}$/; //移动159。至少7位 
     var reg3=/^158\d{8}$/; 
     var reg4=/^150\d{8}$/; 
	 var reg5=/^155\d{8}$/; 
	 var reg6=/^188\d{8}$/; 
	 var reg7=/^189\d{8}$/;
	 var reg8=/^151\d{8}$/; 
     var my=false; 
     if (reg0.test(mobile))my=true; 
     if (reg1.test(mobile))my=true; 
     if (reg2.test(mobile))my=true; 
     if (reg3.test(mobile))my=true; 
     if (reg4.test(mobile))my=true; 
	 if (reg5.test(mobile))my=true; 
     if (reg6.test(mobile))my=true;
	 if (reg7.test(mobile))my=true;
	 if (reg8.test(mobile))my=true;
     if (!my){ 
        return false;
     }else{ 
        return true;
     } 
} 

function save_apply_content( type ){
	frm = document.getElementById( "application_frm" );

	if( type == 1 ){//保存草稿
		document.getElementById( "save_apply" ).value = '1';
	}else if( type == 2 ){//提交
		document.getElementById( "save_apply" ).value = '2';
	}

	frm.submit();
}

function checknumber(String)
{
  var letters = "1234567890";
  var i;
  var c;
  for(i=0;i<String.length;i++)
  {
     c = String.charAt(i);
     if(letters.indexOf(c)==-1)
     {
       return true;
     }
  }
  return false;
}
