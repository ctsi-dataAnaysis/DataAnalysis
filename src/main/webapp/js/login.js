function check_login(){
    var username=$("#user_name").val();
    var password=$("#password").val();
    var loginData = {"username":username,"password":password}
    //发送username和password
    $.ajax({
        type:"POST",
        url:"/login",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify(loginData),
        success:function (res) {
            // alert(res);

        },
        error:function (res) {
            // alert(res)
            $("#login_form").removeClass('shake_effect');
            setTimeout(function()
            {
                $("#login_form").addClass('shake_effect')
            },1);
        }
    })

    // if(name=="www.htmleaf.com" && pass=="www.htmleaf.com"){
    //     alert("登录成功！");
    //     $("#user_name").val("");
    //     $("#password").val("");
    // }
    // else{
    //     $("#login_form").removeClass('shake_effect');
    //     setTimeout(function()
    //     {
    //         $("#login_form").addClass('shake_effect')
    //     },1);
    // }
}
function check_register(){
    var name = $("#r_user_name").val();
    var pass = $("#r_password").val();
    var email = $("#r_email").val();
    var registerData = {"username":name,"password":pass,"email":email}
    // JSON.stringify({"username":name,"password":pass,"email":email})
    // $.post("/register",JSON.stringify(registerData),function (data, state) {
    //     alert(data)
    //     alert(state)
    // },"JSON") // 发送post请求
    $.ajax({
        type:"POST",
        url:"/register",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify(registerData)
    })
    alert("已发送post请求")

    if(name!="" && pass=="" && email != "")
    {
        alert("注册成功！");
        $("#user_name").val("");
        $("#password").val("");
    }
    else
    {
        $("#login_form").removeClass('shake_effect');
        setTimeout(function()
        {
            $("#login_form").addClass('shake_effect')
        },1);
    }
}

$(function(){
    $("#create").click(function(){
        check_register();
        return false;
    })
    $("#login").click(function(){
        check_login();
        return false;
    })
    $('.message a').click(function () {
        $('form').animate({
            height: 'toggle',
            opacity: 'toggle'
        }, 'slow');
    });
})