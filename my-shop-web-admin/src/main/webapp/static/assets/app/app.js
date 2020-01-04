var App = function () {
    //全选框集合
    var check_masters;
    //单选框集合
    var check_box;
    //多选的数据ID数组
    var _idArray;
    /**
     * 私有方法 初始化iCheck
     */
    var handlerInitICheck = function () {
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });
        check_masters = $('input[type="checkbox"].check_master');
        check_box = $('input[type="checkbox"].minimal');

    };


    /**
     * 全选 反选事件
     */
    var handlerAllCheck = function () {
        check_masters.on("ifChanged", function (e) {
            if (e.target.checked) {
                check_box.iCheck("check")
            } else {
                check_box.iCheck("uncheck")
            }

        });
    };

    /**
     * 删除数据
     * @param url
     * @param ids
     */
    var handlerDeleteData = function (url) {
        var btnModalOk = $("#btnModalOk");
        // 请求成功后，无论是成功或是失败都需要弹出模态框进行提示，所以这里需要先解绑原来的 click 事件
        btnModalOk.unbind("click");
        $("#modal-msg").modal("hide");
        if (!_idArray && _idArray.length > 0) {
            return;
        }
        setTimeout(function () {
            $.ajax({
                type: 'POST',
                url: url,
                data: {"ids": _idArray},
                success: function (data) {
                    if (data.status && data.status === 200) {
                        // 刷新页面
                        btnModalOk.bind("click", function () {
                            window.location.reload();
                        });
                    } else {
                        // 确定按钮的事件改为隐藏模态框
                        btnModalOk.bind("click", function () {
                            $("#modal-msg").modal("hide");
                        });
                    }
                    // 因为无论如何都需要提示信息，所以这里的模态框是必须调用的
                    $("#modalMessage").html(data.msg);
                    $("#modal-msg").modal("show");
                }
            });
        },500);
    };

    /**
     * 删除单笔记录
     * @param url 删除链接
     * @param id 需要删除数据的 ID
     * @param msg 弹出消息
     */
    var handlerDeleteSingle = function (url, id, msg) {
        // 可选参数
        if (!msg) msg = null;

        // 将 ID 放入数组中，以便和批量删除通用
        _idArray = [];
        _idArray.push(id);

        $("#modalMessage").html(msg == null ? "您确定删除数据项吗？" : msg);
        $("#modal-msg").modal("show");
        // 如果用户选择了数据项则调用删除方法
        $("#btnModalOk").bind("click", function () {
            handlerDeleteData(url)
        });
    };

    /**
     *  根据ids删除数据
     * @param url
     * @param ids
     */
    var handlerDeleteMulti = function (url, ids) {
        _idArray = [];
        if (ids) {
            _idArray = [ids];
        } else {
            // 将选中元素的 ID 放入数组中
            check_box.each(function () {
                var _id = $(this).val();
                if (_id && $(this).is(":checked")) {
                    _idArray.push(_id);
                }
            });
        }

        // 判断用户是否选择了数据项
        if (_idArray && _idArray.length > 0) {
            $("#modalMessage").text("您确定要删除所选的" + _idArray.length + "条数据吗？");
        } else {
            $("#modalMessage").text("您还没选择任何数据项，请至少选择一项！");
        }

        // 点击删除按钮时弹出模态框
        $("#modal-msg").modal("show");

        // 如果用户选择了数据项则调用删除方法
        // 如果用户选择了数据项则调用删除方法
        $("#btnModalOk").bind("click", function () {
            handlerDeleteData(url)
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
        $("#btnModalOk").click(
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
        paramName: "dropFiles",
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
        return $(defaultDropzoneOpts.id).dropzone(defaultDropzoneOpts);
    };

    return {
        initiCheck: function () {
            handlerInitICheck();
            handlerAllCheck();
        },
        getCheckChilds: function () {
            return check_box;
        },
        deleteSingle: function (url, id, msg) {
            handlerDeleteSingle(url, id, msg);
        },
        deleteMulti: function (url) {
            handlerDeleteMulti(url);
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