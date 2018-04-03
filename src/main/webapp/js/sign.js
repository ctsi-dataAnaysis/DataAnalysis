function changesign(sign){
    $.ajax({
        url:'/userdata/upload',
        data:{"sign":sign},
        type:'post',
        success:function(data){

        }
    });
}
