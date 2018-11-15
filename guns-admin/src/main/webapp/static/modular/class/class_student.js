
$(function () {

    var ajax = new $ax(Feng.ctxPath + "/calss/getClassMap", function (data) {
        Feng.success("查询成功!");
        console.log(data);
        $("input").each(function(){
            var key = $(this).attr("id");
            var value = data[key];
            if(!!value){
                value = "暂无班级信息";
            }
            $(this).val(value);
        });
    }, function (data) {
        Feng.error("查询失败!");
    });
    ajax.start();


});
