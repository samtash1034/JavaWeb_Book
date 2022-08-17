<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>歡迎<span class="um_span">${sessionScope.user.username}</span>光臨書卷香</span>
    <a href="pages/order/order.jsp">我的訂單</a>
    <a href="userServlet?action=logout">登出</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
