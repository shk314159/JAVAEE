<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/15
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>seccess</title>
</head>
<body>
    <s:property value="loginUser.account"/>，登录成功<br/>
    <a href="./allItems">查看所有商品信息</a>
</body>
</html>
