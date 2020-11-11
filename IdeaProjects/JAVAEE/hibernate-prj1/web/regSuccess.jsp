<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 29615
  Date: 2020/11/11
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<s:property value="loginUser.name"/>

<s:if test="%{loginUser.sex==\"1\"}">
    <s:text name="先生，"/>
</s:if>
<s:else>
    <s:text name="女士，"/>
</s:else>
您注册成功了！
<!-- 数据标签set -->
<s:set name="user" value="loginUser" scope="session"/>
</body>
</html>
