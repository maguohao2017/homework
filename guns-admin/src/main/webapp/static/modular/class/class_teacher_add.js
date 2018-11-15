var class_add = {
    init:function(){

    },
    addSubmit:function(){
        var params = {};
        $("input").each(function(){
            var key = $(this).attr("id");
            params[key] = $(this).val();
        });
        console.log(params)
        // $.ajax({
        //     url : Feng.ctxPath + "/class/insertClass",
        //     type : "POST",
        //     async : true,
        //     data : {params : params},
        //     success : function(data) {
        //         Feng.success("添加成功!");
        //         class_add.close();
        //         window.parent.classNo.table.refresh();
        //     },
        //     error:function(XMLHttpRequest, textStatus, errorThrown){
        //         Feng.info("失败！");
        //     }
        // });
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/class/insertClass/"+JSON.stringify(params), function (data) {
            Feng.success("添加成功!");
            class_add.close();
            window.parent.classNo.table.refresh();
        }, function (data) {
            Feng.error("添加失败!");
        });
        ajax.start();
    },
    /**
     * 关闭此对话框
     */
    close:function(){
        parent.layer.close(window.parent.classNo.layerIndex);
    },

};
$(function(){
    class_add.init();
});

