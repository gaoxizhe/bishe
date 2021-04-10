
$(function(){
	//alert($("#subt").text());
	var btn =  $("#subt");
	var checks = $("input[name='orderfood']");
	
	checks.bind('click',function(){
		btn.removeAttr("disabled"); 
	});
	btn.bind('click',function(){
		
		var relateIds = 0;
		var qty = 0;
		var idArr = [];
		var qtyArr = [];
		$("input[name=orderfood]:checked").each(function(i){  
			
		  idArr.push ( $(this).val());
		  qtyArr.push( $(this).parents('tr').find('#qty').find('option:selected').text());
		
		});//each语句

		if(idArr.length==0){
			btn.attr("disabled","disabled"); return false;
		}
		$.ajax({
			type: "POST",
			url: "viewdetails/cart/",
			dataType:"json",
			data: {
				id:JSON.stringify(idArr),
				qty:JSON.stringify(qtyArr)
			},
			timeout:8000,//ajax请求超时时间8秒 
			success : function(data, textStatus){
				//var myText=data.join(",");
				//var data = eval('('+data+')');
				if(data['s'] == 1)
				{
					btn.addClass("btn-success");
					btn.text("订餐成功");
					btn.unbind('click');
					//alert("订餐成功");
				}
				else if(data['s'] == 2){
					alert("请先登录");
				}else{
					alert('订餐失败'+'请等待'+data['s']+'秒');
				}
			},
			error : function(XMLHttpRequest,textStatus,errorThrown){
				 alert('error状态文本值:'+textStatus+" 异常信息:"+errorThrown); 
			},
			complete : function(){
				//setTimeout("location.href='"+url+"'",5000);return false;
			}
		 })//ajax						 		 				
	})//click事件
});

				