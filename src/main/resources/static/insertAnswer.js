function insertAnswer(){
	var content=$("#textarea").val().trim();
	//var idTopic=$("#idTopic").val().trim();
	//var id_topic=[[${topic.id}]];

	//alert(content +" . "+idTopic+ " . "+idUser);
	$.ajax({
		type:"post",
		url:"http://localhost:8888/answer",
		async:true,
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify({
			"idTopic": idTopic,
			"idUser": idUser,
			"content":content
		}),
		dataType:"json",
		success:function(resultBean){
			if(resultBean.code==200){
				alert("回复成功");

			}
		},
		error:function (resultBean) {

		},
	});
}
