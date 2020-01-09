<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="modal" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="includes/header.jsp"/>
    <title>我的商城 | 内容管理</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="includes/nav.jsp"/>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <jsp:include page="includes/menu.jsp"/>
        <!-- /.sidebar -->
    </aside>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i>首页</a></li>
                <li class="active">内容列表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!--内容-->
            <div class="row">
                <div class="col-xs-12">
                    <div class="alert ${baseResult.status==200?"alert-success":"alert-danger"} alert-dismissible" ${baseResult.msg==null?"style='display: none'":"" }>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <div class="alertMessage">${baseResult.msg}</div>
                    </div>
                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header with-border">
                            <h5 class="box-title">搜索</h5>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <div class="box-body">
                            <div class="row form-horizontal">
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="title" class="col-sm-4 control-label">标题</label>
                                        <div class="col-sm-8">
                                            <input id="title" class="form-control" placeholder="标题"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group ">
                                        <label for="subTitle" class="col-sm-4 control-label">子标题</label>
                                        <div class="col-sm-8">
                                            <input id="subTitle" class="form-control" placeholder="子标题"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="titleDesc" class="col-sm-4 control-label">标题描述</label>
                                        <div class="col-sm-8">
                                            <input id="titleDesc" class="form-control" placeholder="标题描述"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button onclick="search()" class="btn btn-info pull-right">搜索</button>
                        </div>
                        <!-- /.box-footer -->
                    </div>
                    <!-- /.box -->
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                            <div class="row box-body">
                                <div class="col">
                                    <a href="/content/form" type="button" class="btn btn-sm btn-default" style="margin-left: 10px"><i class="fa fa-plus"></i>新增</a>
                                    <a type="button" class="btn btn-sm btn-default" onclick="App.deleteMulti('/content/delete')" style="margin-left: 10px"><i class="fa fa-trash-o"></i>删除</a>
                                    <a href="" type="button" class="btn btn-sm btn-default" style="margin-left: 10px"><i class="fa fa-upload"></i>导入</a>
                                    <a href="" type="button" class="btn btn-sm btn-default" style="margin-left: 10px"><i class="fa fa-download"></i>导出</a>
                                    <a type="button" class="btn btn-sm btn-primary"
                                       onclick="$('.box-info-search').toggle()" style="margin-left: 10px"><i class="fa fa-search"></i>搜索</a>
                                </div>
                            </div>

                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal check_master" value=""/></th>
                                    <th>ID</th>
                                    <th>标题</th>
                                    <th>子标题</th>
                                    <th>标题描述</th>
                                    <th>链接</th>
                                    <th>图片1</th>
                                    <th>图片2</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>


    <!-- /.content-wrapper -->
    <jsp:include page="includes/copyright.jsp"/>
</div>


<jsp:include page="includes/footer.jsp"/>

<modal:modal-msg message=""/>
<modal:detail/>
<script>
    $(function () {
        dataTable = drawTable();
    });
    var dataTable;
    function showDetail(id) {
        $.ajax({
            url: "/content/detail?id=" + id,
            type: "get",
            contentType: "html",
            success: function (data) {
                $("#detail-body").html(data);
                $("#modal-detail").modal("show");
            }
        });

    }

    function search() {
        var title = $("#title").val();
        var subTitle = $("#subTitle").val();
        var titleDesc = $("#titleDesc").val();
        var param = {
            "title": title,
            "subTitle": subTitle,
            "titleDesc": titleDesc
        };
        dataTable.settings()[0].ajax.data = param;
        dataTable.ajax.reload();
    }

    function drawTable() {
        var columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input type="checkbox" class="minimal" value="' + row.id + '"/>';
                }
            },
            {"data": "id"},
            {"data": "title"},
            {"data": "subTitle"},
            {"data": "titleDesc"},
            {
                "data": function (row, type, val, meta) {
                    return "<a href='" + row.url + "' target='_blank'>查看</a>"
                }
            },
            {
                "data": function (row, type, val, meta) {
                    return row.pic ? "<a href='"+row.pic+"' target='_blank'>查看</a>" : '';
                }
            },
            {
                "data": function (row, type, val, meta) {
                    return row.pic2 ? "<a href='"+row.pic2+"' target='_blank'>查看</a>" : '';
                }
            },
            {"data": "updated"},
            {
                "data": function (row, type, val, meta) {
                    return '<a onclick="showDetail( \'' + row.id + '\' )" style="margin-right: 10px;" class="btn  btn-default btn-sm"><i class="fa fa-search"></i> 查看</a>' +
                        '<a href="/content/form?id=' + row.id + '" style="margin-right: 10px;" class="btn  btn-primary btn-sm"><i class="fa fa-edit"></i>编辑</a>' +
                        '<a onclick="App.deleteSingle(\'' + '/content/delete' + '\',\'' + row.id + '\')" style="margin-right: 10px;" class="btn  btn-danger btn-sm"><i class="fa fa-trash"></i>删除</a>';
                }
            }
        ];
        var url = "/content/page";
        return App.initDataTables(url, '#dataTable', columns);
    }
</script>

</body>
</html>