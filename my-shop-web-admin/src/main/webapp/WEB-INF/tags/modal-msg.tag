<%@ tag language="java" pageEncoding="utf-8" %>
<%@ attribute name="title" description="模态框标题"  required="false" type="java.lang.String" %>
<%@ attribute name="message" description="模态框消息"  required="true" type="java.lang.String" %>

<div class="modal fade" id="modal-msg">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">${title==null?"温馨提示":title}</h4>
            </div>
            <div class="modal-body">
                <p id="modalMessage"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

