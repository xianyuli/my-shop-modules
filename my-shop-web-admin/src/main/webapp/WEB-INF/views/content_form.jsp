<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="modal" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="includes/header.jsp"/>
    <link rel="stylesheet" href="/static/asserts/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css">
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
                内容管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i>首页</a></li>
                <li class="active">${tbContent.id==null?"新增":"编辑"}内容</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="alert ${baseResult.status==200?"alert-success":"alert-danger"} alert-dismissible" ${baseResult.msg==null?"style='display: none'":"" }>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        ${baseResult.msg}
                    </div>
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbContent.id==null?"新增":"编辑"}内容</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form id="contentForm" cssClass="form-horizontal" action="/content/save" method="post"
                                   modelAttribute="tbContent">
                            <!--用户ID-->
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="categoryId" class="col-sm-2 control-label">父级类目</label>
                                    <div class="col-sm-8">
                                        <form:hidden path="categoryId"/>
                                        <input class="form-control required" id="categoryName" placeholder="请选择"
                                               readonly="true" data-toggle="modal" data-target="#modal-detail"/>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="justify-content-md-center box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>
                    </div>
                </div>
                <!-- /.box -->
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="includes/copyright.jsp"/>
</div>


<jsp:include page="includes/footer.jsp"/>
<modal:detail title="请选择" content="<ul id='treeData' class='ztree'></ul>"/>
<script src="/static/asserts/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script>
    $(function () {
        App.initZtree("/category/tree/data", ["id"], function (selectedNodes) {
            var selectedNode = selectedNodes[0];
            $("#categoryId").val(selectedNode.id);
            $("#categoryName").val(selectedNode.name);
            return true;
        });
    })
</script>
</body>
</html>