<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>圖書管理</title>
	<%@include file="/pages/common/head.jsp"%>

	<script type="text/javascript">

		$(function(){

			$("a.deleteClass").click(function () {
				confirm("您確定要刪除【" + $(this).parent().parent().find("td:first").text() + "】嗎？");

				//因為點擊取消則代表返回false，因此不必另外寫
				// return false;
			});

		});

	</script>

</head>
<body>

<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
	<span class="wel_word">圖書管理系統</span>
	<%@ include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">

	<table>
		<tr>
			<td>名稱</td>
			<td>價格</td>
			<td>作者</td>
			<td>銷量</td>
			<td>庫存</td>
			<td colspan="2">操作</td>
		</tr>
		<c:forEach items="${requestScope.page.items}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.price}</td>
				<td>${book.author}</td>
				<td>${book.sales}</td>
				<td>${book.stock}</td>
				<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
				<td><a href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}" class="deleteClass">刪除</a></td>
			</tr>
		</c:forEach>

		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加圖書</a></td><!--添加完跳到最後一頁-->
		</tr>

	</table>
	<%@include file="/pages/common/page_nav.jsp"%>

</div>


<%@include file="/pages/common/footer.jsp"%>
</body>
</html>