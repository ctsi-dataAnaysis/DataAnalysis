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
        success:function (data) {
            if (data == '0'){
                window.location.href = "/user/" + username;
                // window.location.href = "/user/" + username;
                alert("欢迎使用CTSI数据分析平台");
            }else if (data == '-1'){
                alert("用户不存在")
            }else if (data == '-2'){
                alert("密码错误")
            }
        },
        error:function (res) {
            alert("error:" + res)
        }
        // error:function (res) {
        //     // alert(res)
        //     $("#login_form").removeClass('shake_effect');
        //     setTimeout(function()
        //     {
        //         $("#login_form").addClass('shake_effect')
        //     },1);
        // }
    })
}
function check_register(){
    var name = $("#r_user_name").val();
    var pass = $("#r_password").val();
    var email = $("#r_email").val();
    var registerData = {"username":name,"password":pass,"email":email}
    $.ajax({
        type:"POST",
        url:"/register",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify(registerData),
        success:function (data) {
            if (data == '0'){
                alert("注册成功")
            }else if (data == '-1'){
                alert("用户名已存在")
            }else if (data == '-2'){
                alert("邮箱已被注册")
            }
        },
        error:function (data) {
            alert("error:" + data);
        }
    })

    // if(name!="" && pass=="" && email != "")
    // {
    //     alert("注册成功！");
    //     $("#user_name").val("");
    //     $("#password").val("");
    // }
    // else
    // {
    //     $("#login_form").removeClass('shake_effect');
    //     setTimeout(function()
    //     {
    //         $("#login_form").addClass('shake_effect')
    //     },1);
    // }
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