<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 29615
  Date: 2020/11/18
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<s:property value="#request.tip"/><p>
    <s:form action="login" method="post" namespace="/">
        <s:textfield name="loginUser.account" label="请输入用户名"/>
        <s:password name="loginUser.password" label="请输入密码"/>
        <s:submit value="登录"/>
    </s:form>
</body>
</html>
