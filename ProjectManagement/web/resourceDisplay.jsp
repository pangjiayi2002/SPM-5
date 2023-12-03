<%@ page import="java.util.ArrayList" %>
<%@ page import="Pojo.Resource" %><%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/2
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${sessionScope.type}</title>
</head>
<body>
<h1>欢迎来到${sessionScope.type}界面</h1>
<%
    ArrayList<Resource> ResourceList= (ArrayList<Resource>) session.getAttribute("ResourceList");
%>
<ul>
    <%
        for(Resource resource:ResourceList){
    %>
    <li>

        <a href=<%=resource.getSrc()%>><%=resource.getName()%></a>
    </li>
    <%
        }
    %>
</ul>

</body>
</html>
