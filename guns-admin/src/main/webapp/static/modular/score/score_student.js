var score = {
    id: "scoreTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    init:function(){
        //初始化
        var defaultColunms = score.initColumn();
        var table = new BSTable(score.id, "/score/getScoreStudentList", defaultColunms);
        table.setPaginationType("client");
        table.init();
        score.table = table;
    },

    initColumn:function(){
        var columns = [
            {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', align: 'center', valign: 'middle', sortable: true},
            {title: '成绩分数', field: 'score', align: 'center', valign: 'middle', sortable: true},
            {title: '状态', field: 'status', align: 'center', valign: 'middle', sortable: true},
            {title: '批改时间', field: 'perusaTime', align: 'center', valign: 'middle', sortable: true},
            {title: '作业名称', field: 'homeworkName', align: 'center', valign: 'middle', sortable: true},
            {title: '备注', field: 'remark', align: 'center', valign: 'middle', sortable: true}
            ];
        return columns;
    },
};
$(function(){
    score.init();
});
