
<%--
  Created by IntelliJ IDEA.
  User: 29615
  Date: 2020/10/19
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<s:form action="UserAction!login" method="post" namespace="/">
    <s:textfield name = "loginUser.account" key = "用户名"/>
    <s:password name = "loginUser.password" key = "密码"/>
    <s:submit name="submit" value="登录"/>
</s:form>
</body>
</html>
