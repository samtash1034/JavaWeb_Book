<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>編輯圖書</title>
	<%@include file="/pages/common/head.jsp"%>
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color:red;
		}

		input {
			text-align: center;
		}
	</style>
</head>
<body>
<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
	<span class="wel_word">編輯圖書</span>
	<%@ include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
	<form action="manager/bookServlet" method="get">
		<%--添加完跳到最後一頁--%>
		<input type="hidden" name="pageNo" value="${param.pageNo}">
		<%--修改參數有給id，新增沒有，因此利用這點來判斷--%>
		<input type="hidden" name="action" value="${empty param.id? "add" : "update"}"/>
		<%--修改方法必須透過id來判斷是哪條數據--%>
		<input type="hidden" name="id" value="${requestScope.book.id}"/>
		<table>
			<tr>
				<td>名稱</td>
				<td>價格</td>
				<td>作者</td>
				<td>銷量</td>
				<td>庫存</td>
				<td colspan="2">操作</td>
			</tr>
			<tr>
				<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
				<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
				<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
				<td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
				<td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
				<td><input type="submit" value="提交"/></td>
			</tr>
		</table>
	</form>


</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>