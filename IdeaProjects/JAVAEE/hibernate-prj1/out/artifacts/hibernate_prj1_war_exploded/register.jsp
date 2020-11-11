<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%--
  Created by IntelliJ IDEA.
  User: 29615
  Date: 2020/11/11
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<s:form action="register" method="post" namespace="/">
    <s:textfield name="loginUser.account" label="请输入用户名"/>
    <s:password name="loginUser.password" label="请输入密码"/>
    <s:password name = "loginUser.repassword" label="请重复密码"/>
    <s:radio name="loginUser.sex" list="#{1:'男', 0:'女'}" label="请输入性别"/>
    <s:textfield name="loginUser.birthday"  label="请输入生日" />
    <s:textfield name = "loginUser.contactInfo.address" label="请输入地址"/>
    <s:textfield name = "loginUser.contactInfo.phone" label="请输入联系电话"/>
    <s:textfield name = "loginUser.contactInfo.email" label="请输入联系邮箱"/>
    <s:submit value="注册"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>
