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

    add:function(){
        Feng.success("正在做~~~~~~!");
        return;
        var index = layer.open({
            type: 2,
            title: '添加作业',
            area: ['800px', '360px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/homework/homework_add'
        });
        this.layerIndex = index;
    },

    edit:function(){
        if (this.check()) {
            Feng.success("正在做~~~~~~!");
            return;
            var index = layer.open({
                type: 2,
                title: '编辑作业',
                area: ['800px', '360px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/homework/homework_edit/' + this.seItem.id
            });
            this.layerIndex = index;
        }
    },

    delete:function(){
        if (this.check()) {
            var operation = function(){
                var id = homework.seItem.id;
                var ajax = new $ax(Feng.ctxPath + "/homework/deletehomework/"+id, function () {
                    Feng.success("删除成功!");
                    homework.table.refresh();
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
