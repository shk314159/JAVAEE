<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
    <s:head theme="xhtml"/>
    <sx:head parseContent="true" extraLocales="UTF-8"/>
</head>
<body>
<s:form action="register" method="post" namespace="/">
    <s:textfield name="registerUser.account" key = "login.account.label"/>
    <s:password name="registerUser.password" key = "login.password.label" />
    <s:password name = "registerUser.repassword" key = "register.repassword.label"/>
    <s:radio name="registerUser.sex" list="#{1:getText('register.sex.male'),0: getText('register.sex.female')}" key = "register.sex.label"/>
    <sx:datetimepicker name="registerUser.birthday" displayFormat
            ="yyyy-MM-dd" key = "register.birthday.label" language="en"/>
    <s:textfield name = "registerUser.address" key = "register.address.label"/>
    <s:textfield name = "registerUser.phone" key = "register.phone.label"/>
    <s:textfield name = "registerUser.email" key = "register.email.label"/>
    <s:submit key = "register.submit.button"/>
    <s:reset  key = "register.reset.button"/>
</s:form>
</body>
</html>