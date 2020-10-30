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
    <title>success</title>
</head>
<body>
<s:actionmessage></s:actionmessage>
登录成功！<br/>

第<s:property value="count"></s:property>次登录
</body>
</html>
