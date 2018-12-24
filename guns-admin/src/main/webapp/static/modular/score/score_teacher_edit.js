var score_edit = {
    init:function(){
        $("input").each(function(){
            var key = $(this).attr("id");
            $(this).val($("#edit_"+key).text());
        });
    },
    editSubmit:function(){
        var params = {};
        $("input").each(function(){
            var key = $(this).attr("id");
            params[key] = $(this).val();
        });
        console.log(params);
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/score/updateScore/"+JSON.stringify(params), function (data) {
            Feng.success("修改成功!");
            score_edit.close();
            window.parent.score.table.refresh();
        }, function (data) {
            Feng.error("修改失败!");
        });
        ajax.start();
    },
    /**
     * 关闭此对话框
     */
    close:function () {
        parent.layer.close(window.parent.score.layerIndex);
    },

};
$(function(){
    score_edit.init();
});
