<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 29615
  Date: 2020/11/18
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register_shk</title>
</head>
<body>
<s:form action="register" method="post" namespace="/">
    <s:textfield name="loginUser.customerId" label="请输入用户编号"/>
    <s:textfield name="loginUser.account" label="请输入用户名"/>
    <s:password name="loginUser.password" label="请输入密码"/>
    <s:textfield name="loginUser.name" label="请输入真实姓名"/>
    <s:radio name="loginUser.sex" list="#{1:'男', 0:'女'}" label="请输入性别"/>
    <s:textfield name="loginUser.birthday" label="请输入生日"/>
    <s:textfield name="loginUser.phone" label="联系电话"/>
    <s:textfield name="loginUser.email" label="电子邮箱"/>
    <s:textfield name="loginUser.address" label="联系地址"/>
    <s:textfield name="loginUser.zipcode" label="邮政编码"/>
    <s:textfield name="loginUser.fax" label="传真号码"/>
    <s:submit value="注册"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>
