<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="modal" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="includes/header.jsp"/>
    <!--treeTable-->
    <link rel="stylesheet" href="/static/assets/plugins/treeTable/themes/vsStyle/treeTable.css">
    <title>我的商城 | 分类管理</title>
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
                <li class="active">内容分类</li>
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
                    <!-- /.box -->
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">内容分类</h3>
                            <div class="row box-body">
                                <div class="col">
                                    <a href="/category/form" type="button" class="btn btn-sm btn-default"
                                       style="margin-left: 10px"><i class="fa fa-plus"></i>新增</a>
                                    <a href="" type="button" class="btn btn-sm btn-default" style="margin-left: 10px"><i
                                            class="fa fa-upload"></i>导入</a>
                                    <a href="" type="button" class="btn btn-sm btn-default" style="margin-left: 10px"><i
                                            class="fa fa-download"></i>导出</a>
                                </div>
                            </div>

                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="treeTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>名称</th>
                                    <th>排序</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbContentCategories}" var="tbContentCategory">
                                    <tr id="${tbContentCategory.id}"  pId="${tbContentCategory.parent.id}">
                                        <td>${tbContentCategory.id}</td>
                                        <td>${tbContentCategory.name}</td>
                                        <td>${tbContentCategory.sortOrder}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/category/form?id=${tbContentCategory.id}" type="button"
                                               class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;
                                            <button type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle('/category/delete','${tbContentCategory.id}')">
                                                <i class="fa fa-trash-o"></i> 删除
                                            </button>&nbsp;&nbsp;&nbsp;
                                            <a href="${pageContext.request.contextPath}/category/form?parent.id=${tbContentCategory.id}&parent.name=${tbContentCategory.name}"
                                               type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i>
                                                添加下级菜单</a>
                                        </td>
                                    </tr>
                                </c:forEach>
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
<!--treeTable-->
<script src="/static/assets/plugins/treeTable/jquery.treeTable.js"></script>
<script>
    $(function () {
        $("#treeTable").treeTable({
            expandLevel: 2,
            column: 1
        });

    });
</script>

</body>
</html>