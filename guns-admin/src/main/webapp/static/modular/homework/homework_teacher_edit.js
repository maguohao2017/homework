var homework_edit = {
    init:function(){
        $("input,select").each(function(){
            var key = $(this).attr("id");
            $(this).val($("#edit_"+key).text());
        });
    },
    editSubmit:function(){
        var params = {};
        $("input,select").each(function(){
            var key = $(this).attr("id");
            params[key] = $(this).val();
        });
        console.log(params);
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/homework/updatehomework/"+JSON.stringify(params), function (data) {
            Feng.success("修改成功!");
            homework_edit.close();
            window.parent.homework.table.refresh();
        }, function (data) {
            Feng.error("修改失败!");
        });
        ajax.start();
    },
    /**
     * 关闭此对话框
     */
    close:function () {
        parent.layer.close(window.parent.homework.layerIndex);
    },

};
$(function(){
    homework_edit.init();
});
