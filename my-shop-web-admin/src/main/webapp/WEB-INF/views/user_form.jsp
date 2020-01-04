<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="includes/header.jsp"/>
    <title>我的商城 | 用户管理</title>
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
                <li class="active">${tbUser.id==null?"新增":"编辑"}用户</li>
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
                            <h3 class="box-title">${tbUser.id==null?"新增":"编辑"}用户</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form id="inputForm" cssClass="form-horizontal" action="/user/save" method="post" modelAttribute="tbUser">
                            <!--用户ID-->
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label">邮箱</label>
                                    <div class="col-sm-8">
                                        <form:input cssClass="form-control required email" path="email" placeholder="请输入邮箱地址"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-sm-2 control-label">密码</label>

                                    <div class="col-sm-8">
                                        <form:password cssClass="form-control required" path="password" placeholder="请输入密码"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="username" class="col-sm-2 control-label">姓名</label>

                                    <div class="col-sm-8">
                                        <form:input cssClass="form-control required" path="username" placeholder="请输入姓名"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="phone"  class="col-sm-2 control-label">手机</label>

                                    <div class="col-sm-8">
                                        <form:input cssClass="form-control required mobile" path="phone" placeholder="请输入姓名"/>
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

</body>
</html>