function login(){
    var id=$("#id").val().trim();
    var password=$("#password").val().trim();
    var ok=true;
    if(id==""||id==null){
        ok=false;
        alert("账号不能为空")
    }else if(password==""||password==null){
        ok=false;
        alert("密码不能为空")
    }
    if(ok){
        $.ajax({
            type:"post",
            url:"http://localhost:8888/login",
            async:false,
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify({
                "id":id,
                "password":password
            }),
            dataType:"json",
            success:function(resultBean){
                //resultBean是服务器返回的json结果
                if(resultBean.code==200){
                    //将用户信息保存到cookie中
                    //var uesrId=result.data.cn_user_id;
                    //addCookie("userId",userId,2),
                    //跳转页面
                    window.location.href="/action.html";
                }
            },
            error:function(resultBean){
                if(resultBean.code!=200){
                    alert(resultBean.message,resultBean.code);
                }
            }
        });
    }

}
