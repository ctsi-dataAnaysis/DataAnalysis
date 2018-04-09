function checkfile(){
    $.ajax({
        type:"POST",
        url:"/userdata/upload",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify(fileData),
        success:function (data) {
            if (data == '1') {
                window.location.href = "/userdata";
                // window.location.href = "/user/" + username;
            } else if (data == '0') {
                alert("文件已存在")
            } else if (data == '2') {
                alert("请登录");
                window.location.href = "/";
            } else if (data == '-1') {
                alert("文件为空");
            }
        },
    error:function (data) {
        alert("error:" + data)
        }
    })
}
$(function(){
    $("#checkfilevalid").click(function(){
        checkfile();
        return false;
    })
})