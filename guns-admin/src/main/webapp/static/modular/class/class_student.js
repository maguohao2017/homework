
$(function () {

    var ajax = new $ax(Feng.ctxPath + "/class/getClassMap", function (data) {
        console.log(data);
        $("input").each(function(){
            var key = $(this).attr("id");
            var value = data[key];
            if(!value){
                value = "暂无班级信息";
            }
            $(this).val(value);
        });
    }, function (data) {
        $("input").each(function(){
            var key = $(this).attr("id");
            var value = data[key];
            if(!value){
                value = "暂无班级信息";
            }
            $(this).val(value);
        });
    });
    ajax.start();


});
