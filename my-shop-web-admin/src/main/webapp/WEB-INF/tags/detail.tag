<%@ tag language="java" pageEncoding="utf-8" %>
<%@ attribute name="title" description="模态框标题"  required="false" type="java.lang.String" %>
<%@ attribute name="content" description="模态框内容"  required="false" type="java.lang.String" %>

<div class="modal fade" id="modal-detail" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">${title==null?"查看详情":title}</h4>
            </div>
            <div id="detail-body">
                ${content}
            </div>
            <br>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->