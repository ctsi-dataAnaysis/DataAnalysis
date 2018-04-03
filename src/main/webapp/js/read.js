function read(btn){

    //获取td内容
    var tds = btn.parentElement.parentElement.children;
    var td = (tds[2]).innerHTML ;


    alert("测试是否获取到本行第一个表格的值: " + td);


    $.ajax({
        data:{"filename":td},
        type:'post',
        url:'/userdata/read',
        async:false,
        success:function(data){
        }
    });

    window.open("/userdata/read/file");

}