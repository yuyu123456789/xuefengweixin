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
            type:"get",
            url:"/login",
            data:{"id":id,"password":password},
            dataType:"json",
            success:function(result){
                //result是服务器返回的json结果
                if(result.code==200){
                    //将用户信息保存到cookie中
                    //var uesrId=result.data.cn_user_id;
                    //addCookie("userId",userId,2),
                    //跳转页面
                    window.location.href="/action.html";

                }
            },
            error:function(result){
                    alert(result.message);
            }
        });
    }

}