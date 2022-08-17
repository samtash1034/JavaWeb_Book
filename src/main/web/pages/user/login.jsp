<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>書卷香會員登錄頁面</title>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
<div id="login_header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
</div>

<div class="login_banner">

	<div id="l_content">
		<span class="login_word">歡迎登錄</span>
	</div>

	<div id="content">
		<div class="login_form">
			<div class="login_box">
				<div class="tit">
					<h1>書卷香會員</h1>
					<a href="regist.jsp">立即註冊</a>
				</div>
				<div class="msg_cont">
					<b></b>
					<span class="errorMsg">
						${empty requestScope.msg? "請輸入用戶名和密碼" : requestScope.msg}
					</span>
				</div>
				<div class="form">
					<form action="userServlet" method="post">
						<input type="hidden" name="action" value="login">
						<label>用戶名稱：</label>
						<input class="itxt" type="text" placeholder="請輸入用戶名" autocomplete="off" tabindex="1" name="username"
						value="${requestScope.username}"
						/>
						<br />
						<br />
						<label>用戶密碼：</label>
						<input class="itxt" type="password" placeholder="請輸入密碼" autocomplete="off" tabindex="1" name="password" />
						<br />
						<br />
						<input type="submit" value="登錄" id="sub_btn" />
					</form>
				</div>

			</div>
		</div>
	</div>
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>