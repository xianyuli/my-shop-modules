var App = function () {
    var checkmaster;
    var checkboxs;
    /**
     * 私有方法 初始化iCheck
     */
    var handlerInitICheck = function () {
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });
        checkmaster = $('input[type="checkbox"].checkmaster');
        checkboxs = $('input[type="checkbox"].minimal');

    };
    var handlerAllCheck = function () {
        checkmaster.on("ifChanged", function (e) {
            console.log(e.target.checked);
            if (e.target.checked) {
                checkboxs.iCheck("check")
            } else {
                checkboxs.iCheck("uncheck")
            }

        });
    };

    var handlerInitDataTables = function (url, tableName, columns) {
        var dataTable = $(tableName).DataTable({
            "serverSide": true,
            "deferRender": true,
            "searching": false,
            "ordering": false,
            "lengthChange": false,
            "info": true,
            "paging": true,
            "Dom": "<''p>",
            "ajax": {
                "url": url,
                "data": {}
            },
            "columns": columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function (settings) {
                handlerInitICheck();
                handlerAllCheck();
            }
        });
        return dataTable;
    };

    return {
        initiCheck: function () {
            handlerInitICheck();
            handlerAllCheck();
        },
        getCheckChilds: function () {
            return checkboxs;
        },
        initDataTables: function (url, tableName, columns) {
            return handlerInitDataTables(url, tableName, columns);
        }
    }
}();
$(document).ready(function () {
    App.initiCheck();
});