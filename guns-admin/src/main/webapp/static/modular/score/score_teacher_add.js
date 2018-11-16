var score_add = {
    init:function(){

    },
    addSubmit:function(){
        var params = {};
        $("input").each(function(){
            var key = $(this).attr("id");
            params[key] = $(this).val();
        });
        console.log(params)
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/score/insertscore/"+JSON.stringify(params), function (data) {
            Feng.success("添加成功!");
            score_add.close();
            window.parent.score.table.refresh();
        }, function (data) {
            Feng.error("添加失败!");
        });
        ajax.start();
    },
    /**
     * 关闭此对话框
     */
    close:function(){
        parent.layer.close(window.parent.score.layerIndex);
    },

};
$(function(){
    score_add.init();
});

