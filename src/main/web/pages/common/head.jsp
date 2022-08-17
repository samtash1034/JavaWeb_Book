<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022/8/7
  Time: 上午 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String basePath = request.getScheme()//http
                    +"://"
                    +request.getServerName()//ip
                    +":"
                    +request.getServerPort()//8080
                    +request.getContextPath()// /工程路徑(前面有/後面沒有/)
                    +"/";

    pageContext.setAttribute("basePath", basePath);
%>

<base href="<%=basePath%>>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>