var score = {
    id: "scoreTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    init:function(){
        //初始化
        var defaultColunms = score.initColumn();
        var table = new BSTable(score.id, "/score/getScoreList", defaultColunms);
        table.setPaginationType("client");
        table.init();
        score.table = table;
    },

    check:function(){
        var selected = $('#' + this.id).bootstrapTable('getSelections');
        if (selected.length == 0) {
            Feng.info("请先选中表格中的某一记录！");
            return false;
        } else {
            score.seItem = selected[0];
            return true;
        }
    },

    add:function(){
        var index = layer.open({
            type: 2,
            title: '添加分數',
            area: ['800px', '360px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/score/score_add'
        });
        this.layerIndex = index;
    },

    edit:function(){
        if (this.check()) {
            var index = layer.open({
                type: 2,
                title: '编辑分数',
                area: ['800px', '360px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/score/score_edit/' + this.seItem.id
            });
            this.layerIndex = index;
        }
    },

    delete:function(){
        if (this.check()) {
            var operation = function(){
                var id = score.seItem.id;
                var ajax = new $ax(Feng.ctxPath + "/score/deleteScore/"+id, function () {
                    Feng.success("删除成功!");
                    score.table.refresh();
                }, function (data) {
                    Feng.error("删除失败!");
                });
                ajax.start();
            };

            Feng.confirm("是否删除?",operation);
        }
    },

    initColumn:function(){
        var columns = [
            {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', align: 'center', valign: 'middle', sortable: true},
            {title: '成绩分数', field: 'score', align: 'center', valign: 'middle', sortable: true},
            {title: '状态', field: 'status', align: 'center', valign: 'middle', sortable: true},
            {title: '批改时间', field: 'perusalTime', align: 'center', valign: 'middle', sortable: true},
            {title: '作业名称', field: 'homeworkName', align: 'center', valign: 'middle', sortable: true},
            {title: '备注', field: 'remark', align: 'center', valign: 'middle', sortable: true}
            ];
        return columns;
    },
};
$(function(){
    score.init();
});
