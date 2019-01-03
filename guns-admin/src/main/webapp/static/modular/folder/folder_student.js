var folder = {
    id: "folderTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    init:function(){
        //初始化
        var defaultColunms = folder.initColumn();
        var table = new BSTable(folder.id, "/folder/getFolderList", defaultColunms);
        table.setPaginationType("client");
        table.init();
        folder.table = table;
    },

    check:function(){
        var selected = $('#' + this.id).bootstrapTable('getSelections');
        if (selected.length == 0) {
            Feng.info("请先选中表格中的某一记录！");
            return false;
        } else {
            folder.seItem = selected[0];
            return true;
        }
    },

    list:function(){
        if (this.check()) {
            var id = folder.seItem.id;
            var index = layer.open({
                type: 2,
                title: '作业列表',
                area: ['1000px', '600px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/homework/student_list/' + this.seItem.id
            });
            this.layerIndex = index;
        }
    },

    upload:function(){
        if (this.check()) {
            var id = folder.seItem.id;
            var index = layer.open({
                type: 2,
                title: '上传作业',
                area: ['1000px', '600px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/homework/upload_student_list/' + this.seItem.id
            });
            this.layerIndex = index;
        }
    },

    initColumn:function(){
        var columns = [
            {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '目录名称', field: 'folderName', align: 'center', valign: 'middle', sortable: true},
            {title: '类型', field: 'folderType', align: 'center', valign: 'middle', sortable: true},
            {title: '备注', field: 'remark', align: 'center', valign: 'middle', sortable: true},
            {title: '创建时间', field: 'createTime', align: 'center', valign: 'middle', sortable: true},
            {title: '班号', field: 'classNo', align: 'center', valign: 'middle', sortable: true}
        ];
        return columns;
    },
};
$(function(){
    folder.init();
});
