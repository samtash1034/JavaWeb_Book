<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>購物車</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">

		$(function () {

			$("a.deleteItem").click(function (){
				return confirm("確定要刪除【" + $(this).parent().parent().find("td:first").text() + "】嗎");
			});

			$("a.clearItem").click(function () {
				return confirm("確定清空購物車嗎？");
			});

		});

	</script>
</head>
<body>

<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
	<span class="wel_word">購物車</span>
	<%@include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">

	<table>
		<tr>
			<td>商品名稱</td>
			<td>數量</td>
			<td>單價</td>
			<td>總金額</td>
			<td>操作</td>
		</tr>

		<c:if test="${empty sessionScope.cart.items}">
			<tr>
				<td colspan="5"><a href="index.jsp">當前購物車為空，請去購買商品！</a></td>
			</tr>
		</c:if>

		<c:if test="${not empty sessionScope.cart.items}">
			<c:forEach items="${sessionScope.cart.items}" var="items">
				<tr>
					<td>${items.value.name}</td>
					<td>${items.value.count}</td>
					<td>${items.value.price}</td>
					<td>${items.value.totalPrice}</td>
					<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${items.value.id}">刪除</a></td>
				</tr>
			</c:forEach>
		</c:if>

	</table>

	<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">購物車中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">總金額<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a class="clearItem" href="cartServlet?action=clearItem">清空購物車</a></span>
			<span class="cart_span"><a href="pages/cart/checkout.jsp">去結賬</a></span>
		</div>
	</c:if>


</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>