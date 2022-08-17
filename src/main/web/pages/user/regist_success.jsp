<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@include file="/pages/common/head.jsp"%>
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color:red;
		}
	</style>
</head>
<body>
<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
	<span class="wel_word"></span>

</div>

<div id="main">

	<h1>註冊成功! <a href="../../index.jsp">轉到主頁</a></h1>
	<%@include file="/pages/common/login_success_menu.jsp"%>
</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>