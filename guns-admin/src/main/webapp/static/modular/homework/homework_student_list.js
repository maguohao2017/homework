var homework = {
    id: "homeworkTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    init:function(){
        //初始化
        var defaultColunms = homework.initColumn();
        var table = new BSTable(homework.id, "/homework/getHomeworkList/"+$("#id").val(), defaultColunms);
        table.setPaginationType("client");
        table.init();
        homework.table = table;
    },

    check:function(){
        var selected = $('#' + this.id).bootstrapTable('getSelections');
        if (selected.length == 0) {
            Feng.info("请先选中表格中的某一记录！");
            return false;
        } else {
            homework.seItem = selected[0];
            return true;
        }
    },

    download:function(folderId){
        if (this.check()) {
            var ajax = new $ax(Feng.ctxPath + "/homework/downLoadFile", function (data) {
                console.log("data",data);
                Feng.success("下载成功!");
                homework.table.refresh();
            }, function (data) {
                Feng.success("下载成功!");
                homework.table.refresh();
            });
            ajax.start();
        }
    },


    initColumn:function(){
        var columns = [
            {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '作业名称', field: 'homeworkName', align: 'center', valign: 'middle', sortable: true},
            {title: '路径', field: 'filePath', align: 'center', valign: 'middle', sortable: true},
            {title: '作业大小', field: 'fileSize', align: 'center', valign: 'middle', sortable: true},
            {title: '作业类型', field: 'fileType', align: 'center', valign: 'middle', sortable: true},
            {title: '作业状态', field: 'status', align: 'center', valign: 'middle', sortable: true},
            {title: '作业目录', field: 'folderName', align: 'center', valign: 'middle', sortable: true},
            {title: '创建时间', field: 'createTime', align: 'center', valign: 'middle', sortable: true}
            ];
        return columns;
    },
};
$(function(){
    homework.init();
});
