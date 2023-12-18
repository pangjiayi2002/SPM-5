<%@ page import="service.notice.NoticeService" %>
<%@ page import="service.notice.NoticeServiceImpl" %>
<%@ page import="Pojo.Notice" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        .zhezhao {
            position: fixed; /* 或 absolute */
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5); /* 半透明背景 */
            display: none; /* 默认不显示 */
            z-index: 10; /* 确保在其他元素之上 */
        }

        .remove {
            position: fixed; /* 或 absolute */
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%); /* 居中定位 */
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            z-index: 11; /* 比遮罩层高 */
            display: none; /* 默认不显示 */
        }
             /* 样式链接文本的颜色为蓝色 */
        #add  {
             color: #007bff;
             text-decoration: none; /* 去除下划线 */
             font-weight: bold; /* 加粗文本 */
         }

        /* 当鼠标悬停在链接上时，修改颜色 */
        #add:hover {
            color: #0056b3;
        }
        body {
            background-color: #f5f5f5; /* 设置页面背景颜色 */
        }
        .container {
            background-color: #fff; /* 设置容器背景颜色 */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .page-title {
            font-size: 24px;
            margin-bottom: 20px;
        }
        #fanhui {
            margin-top: 10px; /* 调整按钮与标题的垂直间距 */
        }
    </style>

    <meta charset="UTF-8">
    <title>通知公告</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
    NoticeService noticeService=new NoticeServiceImpl();
    List<Notice> notices = noticeService.getAll();
%>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <h1 class="page-title">通知公告</h1>
        </div>
        <div class="col-md-4 text-right">
            <a class="btn btn-primary" id="fanhui" href="homeTeacher.jsp">返回首页</a>
        </div>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>标题</th>
            <th>创建时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="notice" items="<%=notices%>">
            <tr>
                <td>${notice.title}</td>
                <td>${notice.createTime}</td>
                <td>
                    <span><a class="viewNotice" href="noticeDetail.jsp?id=${notice.id}"><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
                    <span><a class="modifyNotice" href="noticeModify.jsp?id=${notice.id}" ><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
                    <span><a class="deleteNotice" href="${pageContext.request.contextPath}/NoticeDeleteServlet?id=${notice.id}" title=${notice.title}><img src="${pageContext.request.contextPath}/images/schu.png" alt="删除" title="删除"/></a></span>
<%--                    <span><a class="deleteNotice" href="/NoticeDeleteServlet" id=${notice.id } title=${notice.title }><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="noticeAdd.jsp" id="add" >添加公告</a>
</div>

<%--<!-- 确认删除弹窗 -->--%>
<%--<div class="zhezhao"></div>--%>
<%--<div class="remove" id="removeNo">--%>
<%--    <div class="removerChid">--%>
<%--        <h2>提示</h2>--%>
<%--        <div class="removeMain">--%>
<%--            <p>你确定要删除该公告吗？</p>--%>
<%--            <a href="javascript:;" id="yes">确定</a>--%>
<%--            <a href="javascript:;" id="no">取消</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script>--%>
<%--    var noticeToDelete;--%>

<%--    // 显示删除确认弹窗--%>
<%--    function showDeleteConfirmDialog(obj) {--%>
<%--        $('.zhezhao, #removeNo').show();--%>
<%--        noticeToDelete = obj; // 保存要删除的公告信息--%>
<%--    }--%>

<%--    // 取消删除操作--%>
<%--    function cancelDelete() {--%>
<%--        $('.zhezhao, #removeNo').hide();--%>
<%--    }--%>

<%--    // 执行删除操作--%>
<%--    function executeDelete() {--%>
<%--        $.ajax({--%>
<%--            type: "POST",--%>
<%--            url: "${pageContext.request.contextPath}/NoticeDeleteServlet",--%>
<%--            data: {--%>
<%--                method: "delnotice",--%>
<%--                id: noticeToDelete.attr("id")--%>
<%--            },--%>
<%--            dataType: "json",--%>
<%--            success: function(data) {--%>
<%--                if(data.delResult == "true") {--%>
<%--                    alert("删除成功");--%>
<%--                    noticeToDelete.parents("tr").remove();--%>
<%--                } else {--%>
<%--                    alert("删除失败");--%>
<%--                }--%>
<%--                cancelDelete();--%>
<%--            },--%>
<%--            error: function() {--%>
<%--                alert("删除操作出现错误");--%>
<%--                cancelDelete();--%>
<%--            }--%>
<%--        });--%>
<%--    }--%>

<%--    $(document).ready(function() {--%>
<%--        // 绑定删除图标的点击事件--%>
<%--        $('.deleteNotice').click(function() {--%>
<%--            showDeleteConfirmDialog($(this));--%>
<%--        });--%>

<%--        // 绑定确认删除弹窗的按钮事件--%>
<%--        $('#yes').click(executeDelete);--%>
<%--        $('#no').click(cancelDelete);--%>
<%--    });--%>
<%--</script>--%>

