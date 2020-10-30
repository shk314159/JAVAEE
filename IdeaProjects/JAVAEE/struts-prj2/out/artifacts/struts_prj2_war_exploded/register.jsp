<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
    <s:head theme="xhtml"/>
    <sx:head parseContent="true" extraLocales="UTF-8"/>
</head>
<body>
<s:fielderror/>
<s:actionerror/>
<s:actionmessage/>
<s:form action="register" method="post" namespace="/">
    <s:textfield name="loginUser.account" key = "用户名"/>
    <s:password name="loginUser.password" key = "密码" />
    <s:password name = "loginUser.repassword" key = "重复密码"/>
    <s:radio name="loginUser.sex" list="#{1: '男',0: '女'}" key = "性别"/>
<%--    <sx:datetimepicker name="loginUser.birthday" displayFormat--%>
<%--            ="yyyy-MM-dd" key = "生日" language="en"/>--%>
    <s:textfield name="loginUser.birthday" key = "生日"/>
        <s:textfield name = "loginUser.address" key = "地址"/>
        <s:textfield name = "loginUser.phone" key = "电话"/>
        <s:textfield name = "loginUser.email" key = "电子邮箱"/>
        <s:submit value = "登录"/>
        <s:reset  value = "重置"/>
    </s:form>
    </body>
    </html>