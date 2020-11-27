<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 86198
  Date: 2020/11/27
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hjy~YYDS(bushi</title>
</head>
<body>
<%--<table border=1>--%>
<%--    <tr>--%>
<%--        <th>书籍数</th>--%>
<%--    </tr>--%>
<%--    <s:iterator value="items" id="count">--%>
<%--        <tr>--%>
<%--            <td><s:property value="count"/></td>--%>
<%--        </tr>--%>
<%--    </s:iterator>--%>
<%--</table>--%>

<%--<table border=1>--%>
<%--    <tr> <th>书名</th> <th>单价</th> </tr>--%>
<%--    <s:iterator value="items" id="object">--%>
<%--        <tr>--%>
<%--            <td><s:property value="#object[0]"/></td>--%>
<%--            <td><s:property value="#object[1]"/></td>--%>
<%--        </tr>--%>
<%--    </s:iterator>--%>
<%--</table>--%>

<%--<table border=1>--%>
<%--    <tr> <th>书名</th> </tr>--%>
<%--    <s:iterator value="items" id="object">--%>
<%--        <tr>--%>
<%--            <td><s:property value="object"/></td>--%>
<%--        </tr>--%>
<%--    </s:iterator>--%>
<%--</table>--%>
<center>商品列表</center>
<table border=1>
    <tr>
        <th>编号</th>
        <th>书名</th>
        <th>说明</th>
        <th>单价</th>
    </tr>
    <s:iterator value="items" >
        <tr>
            <td><s:property value="itemID"/></td>
            <td><s:property value="title"/></td>
            <td><s:property value="description"/></td>
            <td><s:property value="cost"/></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
