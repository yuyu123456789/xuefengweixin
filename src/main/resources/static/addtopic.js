function userPut(){
	var sort=$("#sort").val().trim();
	var text=$("#text").val().trim();
	var context=$("#context").val().trim();
	var ok=true;
	if(text==""){
		ok=false;
		alert("标题不能为空")
	}else if(context==""){
		ok=false;
		alert("内容不能为空")
	}
	if(ok){
		$.ajax({
			type:"put",
			url:"/addtopic",
			data:{"sort":sort,"title":title,"context":context},
			dataType:"json",
			success:function(result){
						//result是服务器返回的json结果
						if(result.code==200){
							alert("发表成功")
							//将用户信息保存到cookie中
							//var uesrId=result.data.cn_user_id;
							//addCookie("userId",userId,2),
							//跳转页面
							//window.location.href="edit.html";
						}						
					},
					error:function(){
						alert("发表失败")
					}
		});
	}
	
}
