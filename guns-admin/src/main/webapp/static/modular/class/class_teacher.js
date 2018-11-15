var classNo = {
    id: "classNoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    init:function(){
        //初始化
        var defaultColunms = classNo.initColumn();
        var table = new BSTable(classNo.id, "/class/getClassList", defaultColunms);
        table.setPaginationType("client");
        table.init();
        classNo.table = table;
    },

    check:function(){
        var selected = $('#' + this.id).bootstrapTable('getSelections');
        if (selected.length == 0) {
            Feng.info("请先选中表格中的某一记录！");
            return false;
        } else {
            classNo.seItem = selected[0];
            return true;
        }
    },

    add:function(){
        var index = layer.open({
            type: 2,
            title: '添加班级',
            area: ['800px', '360px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/class/class_add'
        });
        this.layerIndex = index;
    },

    edit:function(){
        if (this.check()) {
            var index = layer.open({
                type: 2,
                title: '编辑班级',
                area: ['800px', '360px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/class/class_edit/' + this.seItem.id
            });
            this.layerIndex = index;
        }
    },

    delete:function(){
        if (this.check()) {
            var operation = function(){
                var id = classNo.seItem.id;
                var ajax = new $ax(Feng.ctxPath + "/class/deleteClass/"+id, function () {
                    Feng.success("删除成功!");
                    classNo.table.refresh();
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
            {title: '班号', field: 'classNo', align: 'center', valign: 'middle', sortable: true},
            {title: '年级', field: 'classGrade', align: 'center', valign: 'middle', sortable: true},
            {title: '入学年份', field: 'classYear', align: 'center', valign: 'middle', sortable: true},
            {title: '创建时间', field: 'createTime', align: 'center', valign: 'middle', sortable: true},
            {title: '创建人', field: 'userName', align: 'center', valign: 'middle', sortable: true}];
        return columns;
    },
};
$(function(){
    classNo.init();
});
