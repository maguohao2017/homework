var folder_add = {
    init:function(){

    },
    addSubmit:function(){
        Feng.success("正在做~~~~~~!");
        return;
        var params = {};
        $("input").each(function(){
            var key = $(this).attr("id");
            params[key] = $(this).val();
        });
        console.log(params)
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/folder/insertfolder/"+JSON.stringify(params), function (data) {
            Feng.success("添加成功!");
            folder_add.close();
            window.parent.folder.table.refresh();
        }, function (data) {
            Feng.error("添加失败!");
        });
        ajax.start();
    },
    /**
     * 关闭此对话框
     */
    close:function(){
        parent.layer.close(window.parent.folder.layerIndex);
    },

};
$(function(){
    folder_add.init();
});

