<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/16
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<%--<s:property value = "loginUser.sex"/>--%>
<s:if test="%{registerUser.sex==\"1\"}">s
    <s:text name="先生，"/>
</s:if>
<s:else>
    <s:text name="女士，"/>
</s:else>
您注册成功了！
<s:set name="user" value="registerUser" scope="session"/>
</body>
</html>
