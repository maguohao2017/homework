var homework_add = {
    init:function(){

    },
    addSubmit:function(){
        var params = {};
        $("input,select").each(function(){
            var key = $(this).attr("id");
            params[key] = $(this).val();
        });
        console.log(params)
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/homework/inserthomework/"+JSON.stringify(params), function (data) {
            Feng.success("添加成功!");
            homework_add.close();
            window.parent.homework.table.refresh();
        }, function (data) {
            Feng.error("添加失败!");
        });
        ajax.start();
    },
    /**
     * 关闭此对话框
     */
    close:function(){
        window.parent.homework.table.refresh();
        parent.layer.close(window.parent.homework.layerIndex);
    },

};
$(function(){
    homework_add.init();
});

