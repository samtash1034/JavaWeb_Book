<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>會員註冊頁面</title>
	<%@include file="/pages/common/head.jsp"%>

	<script type="text/javascript">

		$(function () {

			//變換驗證碼
			$("#code_img").click(function () {
				//火狐和IE只能點一次，因為當發起請求時，會直接從緩存中找(緩存名稱由最後的資源名和參數組成)，因此我們後面給他一個隨機的時間參數
				this.src = "${bastPath}kaptcha.jpg?d=" + new Date();
			});

			//註冊按鈕
			$("#sub_btn").click(function () {

				//用戶名
				var usernameText = $("#username").val();
				var usernamePatt = /^\w{5,12}$/;;
				if(!usernamePatt.test(usernameText)){
					$("span.errorMsg").text("用戶名格式錯誤！");
					return false;//點擊註冊頁面才不會跳轉
				}

				//密碼
				var passwordText = $("#password").val();
				var passwordPatt = /^\w{5,12}$/;
				if(!passwordPatt.test(passwordText)){
					$("span.errorMsg").text("密碼格式錯誤！");
					return false;
				}

				//驗證兩組密碼
				var repwdText = $("#repwd").val();
				if(passwordText　!= repwdText){
					$("span.errorMsg").text("密碼和確認密碼不相同！");
					return false;
				}

				//信箱
				var emailText = $("#email").val();
				var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if(!emailPatt.test(emailText)){
					$("span.errorMsg").text("信箱格式不正確！");
					return false;
				}

				//驗證碼
				var codeText = $("#code").val();

				codeText = codeText.trim();

				if(codeText == null || codeText == ""){
					$("span.errorMsg").text("請輸入驗證碼！");
					return false;
				}

				$("span.errorMsg").text("");//如果頁面加載過慢才不會出現紅色提示訊息
			});



		});

	</script>

	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
</head>
<body>
<div id="login_header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
</div>

<div class="login_banner">

	<div id="l_content">
		<span class="login_word">歡迎註冊</span>
	</div>

	<div id="content">
		<div class="login_form">
			<div class="login_box">
				<div class="tit">
					<h1>註冊書卷香會員</h1>
					<span class="errorMsg">
						${empty requestScope.msg? "" : requestScope.msg}
					</span>
				</div>
				<div class="form">
					<form action="userServlet" method="post">
						<input type="hidden" name="action" value="regist">
						<label>用戶名稱：</label>
						<input class="itxt" type="text" placeholder="請輸入用戶名"
							   autocomplete="off" tabindex="1" name="username" id="username"
							   value="${requestScope.username}"
						/>
						<br />
						<br />
						<label>用戶密碼：</label>
						<input class="itxt" type="password" placeholder="請輸入密碼"
							   autocomplete="off" tabindex="1" name="password" id="password" />
						<br />
						<br />
						<label>確認密碼：</label>
						<input class="itxt" type="password" placeholder="確認密碼"
							   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
						<br />
						<br />
						<label>電子郵件：</label>
						<input class="itxt" type="text" placeholder="請輸入郵箱地址"
							   autocomplete="off" tabindex="1" name="email" id="email"
							   value="${requestScope.email}"
						/>
						<br />
						<br />
						<label>驗證碼：</label>
						<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
						<img id="code_img" src="kaptcha.jpg" style="width: 110px; height: 30px">
						<br />
						<br />
						<input type="submit" value="註冊" id="sub_btn" />

					</form>
				</div>

			</div>
		</div>
	</div>
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>