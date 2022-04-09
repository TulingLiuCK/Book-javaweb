<%--
  Created by IntelliJ IDEA.
  User: LiuChongKang
  Date: 2021/12/7
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">
    <%--大于首页才显示--%>
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <%--        <a href="#">3</a>--%>
    【${requestScope.page.pageNo}】
    <%--        <a href="#">5</a>--%>
    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBth" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            $("#searchPageBth").click(function () {
                var pageNo = $("#pn_input").val();
                if (pageNo<1||pageNo>${requestScope.page.pageTotal}){
                    alert("你个大傻福，输入的页码有误");
                }
                //JavaScript语言中提供了一个location地址栏对象
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo="+pageNo;

            });
        });
    </script>
</div>
