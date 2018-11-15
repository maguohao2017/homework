var class_edit = {
    init:function(){
        $("input").each(function(){
            var key = $(this).attr("id");
            $(this).val($("#"+key).text());
        });
    },
    editSubmit:function(){
        var params = {};
        $("input").each(function(){
            var key = $(this).attr("id");
            params.key = $(this).val();
        });
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/class/updateClass/"+JSON.stringify(params), function (data) {
            Feng.success("修改成功!");
            window.parent.classNo.table.refresh();
        }, function (data) {
            Feng.error("修改失败!");
        });
        ajax.start();
    },
    /**
     * 关闭此对话框
     */
    close:function () {
        parent.layer.close(window.parent.classNo.layerIndex);
    },

};
$(function(){
    class_edit.init();
});
