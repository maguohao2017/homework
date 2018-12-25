var class_edit = {
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
        var ajax = new $ax(Feng.ctxPath + "/class/updateClass/"+JSON.stringify(params), function (data) {
            Feng.success("修改成功!");
            class_edit.close();
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
