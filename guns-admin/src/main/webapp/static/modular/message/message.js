
$(function () {

    alert(111);
    var ajax = new $ax(Feng.ctxPath + "/message/map", function (data) {
        Feng.success("查询成功!");
        console.log(data);
        $("input").each(function(){
            $(this).val(data[$(this).attr("id")]);
        });
    }, function (data) {
        Feng.error("查询失败!");
    });
    ajax.start();


});
