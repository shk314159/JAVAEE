<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 86198
  Date: 2020/11/5
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030"
         import="com.opensymphony.xwork2.util.ValueStack,
java.util.List,java.util.Iterator,
cn.edu.zjut.bean.Item"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:property value="#session.user"/>�����ã�
<center>��Ʒ�б�</center>
<table border=1>
    <tr>
        <th>���</th><th>����</th><th>˵��</th><th>����</th>
    </tr>
    <s:iterator value="items" >
        <tr>
            <td><s:property value="itemID"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="description"/></td>
            <td><s:property value="cost"/></td>
        </tr>
    </s:iterator>
</table>
�۸���� 20 Ԫ����Ʒ�У�<br>
<s:iterator value="items.{?#this.cost<20}" >
    <li><s:property value="name"/>��
        <s:property value="cost" />Ԫ</li>
</s:iterator>
<p>
    ����Ϊ��JAVAEE ����ʵ��ָ���̡̳�����Ʒ�ļ۸�Ϊ��
    <s:property value="items.{?#this.name=='JAVAEE ����ʵ��ָ���̳�'}.{cost}[0]"/>Ԫ


<br>
    <s:url value="items.{name}[0]"/><br>
    <s:url value="%{items.{name}[0]}"/>
</body>
