<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>書城首頁</title>
	<%@include file="/pages/common/head.jsp"%></head>
	<%--script要放到靜態包含下面--%>
	<script type="text/javascript">

	$(function () {

		//添加到購物車
		$("button.addToCart").click(function(){

			var bookId = $(this).attr("bookId");

			location.href = "${basePath}cartServlet?action=addItem&id=" + bookId;
		});

	})

</script>

<body>

<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
	<span class="wel_word">書卷香</span>
	<div>
	<c:if test="${not empty sessionScope.user}">
		<span>歡迎<span class="um_span">${sessionScope.user.username}</span>光臨書卷香</span>
		<a href="pages/order/order.jsp">我的訂單</a>
		<a href="userServlet?action=logout">登出</a>&nbsp;&nbsp;
	</c:if>
	<c:if test="${empty sessionScope.user}">
		<a href="pages/user/login.jsp">登錄</a> |
		<a href="pages/user/regist.jsp">註冊</a> &nbsp;&nbsp;
	</c:if>
	<a href="pages/cart/cart.jsp">購物車</a>
	<a href="pages/manager/manager.jsp">後台管理</a>
	</div>

</div>
<div id="main">
	<div id="book">
		<div class="book_cond">
			<form action="client/bookServlet" method="get">
				<input type="hidden" name="action" value="pageByPrice"/>
				價格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
				<input id="max" type="text" name="max" value="${param.max}"> 元
				<input type="submit" value="查詢" />
			</form>
		</div>
		<div style="text-align: center">
			<span>您的購物車中有3件商品</span>
			<div>
				您剛剛將<span style="color: red">時間簡史</span>加入到了購物車中
			</div>
		</div>

		<c:forEach items="${requestScope.page.items}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/default.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">書名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">價格:</span>
						<span class="sp2">${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">銷量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">庫存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button bookId="${book.id}" class="addToCart">加入購物車</button>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

<%@ include file="/pages/common/page_nav.jsp"%>
</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>