var folder_edit = {
    init:function(){
        $("input").each(function(){
            var key = $(this).attr("id");
            $(this).val($("#edit_"+key).text());
        });
    },
    editSubmit:function(){
        Feng.success("正在做~~~~~~!");
        return;
        var params = {};
        $("input").each(function(){
            var key = $(this).attr("id");
            params[key] = $(this).val();
        });
        console.log(params);
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/folder/updatefolder/"+JSON.stringify(params), function (data) {
            Feng.success("修改成功!");
            folder_edit.close();
            window.parent.folder.table.refresh();
        }, function (data) {
            Feng.error("修改失败!");
        });
        ajax.start();
    },
    /**
     * 关闭此对话框
     */
    close:function () {
        parent.layer.close(window.parent.folder.layerIndex);
    },

};
$(function(){
    folder_edit.init();
});
