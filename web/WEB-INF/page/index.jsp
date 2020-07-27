<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kaikeba.invoice.entity.Students" %><%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2020/7/4
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Hello-World</title>
</head>
<body>
<h1 align="center">测试:${message}</h1>


<div>


    <table border="2" align="center">
        <tr>
            <th style="width: 100px">学员学号</th>
            <th style="width: 100px">学员姓名</th>
            <th style="width: 100px">可申请总额</th>
        </tr>

    <%
        ArrayList list = (ArrayList)request.getAttribute("lists");
        for(int i = 0; i < list.size(); i++){
            Students  clazz = (Students)list.get(i);
    %>
    <tr>
        <td align="center"><%=clazz.getNum()%></td>
        <td align="center"><%=clazz.getName()%></td>
        <td align="center"><%=clazz.getSum()%></td>
    </tr>
    <%
        }
    %>



</div>
</body>
</html>
