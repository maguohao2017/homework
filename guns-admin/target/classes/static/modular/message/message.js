
$(function () {

    var ajax = new $ax(Feng.ctxPath + "/message/map", function (data) {
        Feng.success("查询成功!");
        console.log(data);
        $("input").each(function(){
            var key = $(this).attr("id");
            $(this).val(data.user[key]);
        });
        $("#citySel").val(data.dept.fullname);
        $("#roleid").val(data.role.name);
        if(data.user.sex == 1){
            $("#sex").val("男");
        }else{
            $("#sex").val("女");
        }
    }, function (data) {
        Feng.error("查询失败!");
    });
    ajax.start();


});
