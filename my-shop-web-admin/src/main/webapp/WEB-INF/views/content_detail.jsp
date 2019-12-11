<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>我的商城 | 内容详情</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="box-body">
        <table class="table table-hover">
            <tbody>
            <tr>
                <td>内容ID</td>
                <td>${tbContent.id}</td>
            </tr>
            <tr>
                <td>标题</td>
                <td>${tbContent.title}</td>
            </tr>
            <tr>
                <td>子标题</td>
                <td>${tbContent.subTitle}</td>
            </tr>
            <tr>
                <td>标题描述</td>
                <td>${tbContent.titleDesc}</td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td><fmt:formatDate value="${tbContent.created}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
            </tr>
            <tr>
                <td>更新时间</td>
                <td><fmt:formatDate value="${tbContent.updated}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
            </tr>
            </tbody>
        </table>
        <br>
    </div>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>
