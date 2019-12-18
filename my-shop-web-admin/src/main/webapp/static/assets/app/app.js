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
    /**
     * 全选 反选事件
     */
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
    /**
     * 初始化zTree
     * @param url
     * @param autoParam
     * @param callback
     */
    var handlerInitZtree = function (url, autoParam, callback) {
        var _setting = {
            view: {
                selectedMulti: false
            },
            async: {
                enable: true,
                type: "get",
                url: url,
                autoParam: autoParam,
            }
        };

        function selectNode() {
            var zTree = $.fn.zTree.getZTreeObj("treeData");
            var selectedNodes = zTree.getSelectedNodes();
            if (!selectedNodes || selectedNodes.length === 0) {
                alert("请选择一个节点");
                return false;
            } else {
                return callback(selectedNodes);
            }
        }

        $.fn.zTree.init($("#treeData"), _setting);
        $(".modal-footer .btn-primary").click(
            function () {
                return selectNode();
            }
        );
    };
    /**
     * 初始化table控件
     * @param url
     * @param tableName
     * @param columns
     * @returns {jQuery}
     */
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
    // 默认的 Dropzone 参数
    var defaultDropzoneOpts = {
        url: "",
        paramName: "dropFile",
        maxFiles: 1, // 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1, // 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传 1 个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消",
        dictRemoveFile: "删除文件"
    };
    var handlerInitDropzone = function (opts) {
        $.extend(defaultDropzoneOpts, opts);
        return  $(defaultDropzoneOpts.id).dropzone(defaultDropzoneOpts);
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
        },
        initZtree: function (url, autoParam, callback) {
            return handlerInitZtree(url, autoParam, callback);
        },
        initDropzone: function (opts) {
            return handlerInitDropzone(opts);
        }
    }
}();
$(document).ready(function () {
    App.initiCheck();
});