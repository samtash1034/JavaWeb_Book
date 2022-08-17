<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">
    <%--如果頁碼大於第一頁，才顯示首頁及上一頁--%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <%--複製book_manager.jsp得過來，href記得修改成client/...--%>
        <a href="${requestScope.page.url}&pageNo=1">首頁</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一頁</a>
    </c:if>

    <%--頁碼輸出的開始--%>
    <c:choose>
        <%--情況1：如果總頁碼小於等於5 的情況，頁碼的範圍是：1-總頁碼--%>
        <c:when test="${ requestScope.page.pageTotal <= 5 }">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <%--情況2：總頁碼大於5 的情況--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%--小情況1：當前頁碼為前面3 個：1，2，3 的情況，頁碼範圍是：1-5.--%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--小情況2：當前頁碼為最後3 個，8，9，10，頁碼範圍是：總頁碼減4 - 總頁碼--%>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <%--小情況3：4，5，6，7，頁碼範圍是：當前頁碼減2 - 當前頁碼加2--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%--頁碼輸出的結束--%>

    <%--如果頁碼小於最後一頁，則顯示下一頁及末頁--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一頁</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末頁</a>
    </c:if>

    共${requestScope.page.pageTotal}頁，${requestScope.page.pageTotalCount}條記錄 到第<input value="${param.pageNo}" name="pn" id="pn_input"/>頁
    <input id="searchPageBtn" type="button" value="確定">

    <script type="text/javascript">

        $(function () {

            $("#searchPageBtn").click(function () {

                var pageNo = $("#pn_input").val();

                /*

                //獲取總頁碼
                var pageTotal = ${requestScope.page.pageTotal};

							if(pageNo < 1 || pageNo > pageTotal){
								alert("輸入的頁碼不存在數據，請重新輸入");
							}else{
								location.href="${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
							}

							*/

                //javaScript提供了一個location地址欄對象
                //href屬性可以獲取當前瀏覽器中的地址
                //href屬性可讀，可寫
                location.href="${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;


            });

        });

    </script>
</div>