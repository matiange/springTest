<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kaikeba.invoice.entity.Students" %>
<style type="text/css" src="../static/public"></style>
<%--
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Hello-World</title>
    <link rel="stylesheet" type="text/css" href="/static/public.css"/>
</head>
<body>
<div id="indexResult" style="background-color: yellow;height: 100%">
    <img src="/images/kaikeba.png" style="height: 60px">

    <h1 align="center" style="color:deepskyblue">测试:${message}</h1>

    <div style="display: block;margin-left: 400px; font-size: 30px">
        <input id="buttonCn" class="buttonIndex" type="button" onclick="query()" value="查询" />
        <input id="buttonUs" class="buttonIndex" type="button" onclick="exporExcel()" value="导出" />
        <%--<a class="buttonIndex" href="download">下载</a>--%>
        <%--<input id="buttonUs" class="buttonIndex" type="button" href="download" value="下载" />--%>

        <input id="buttonReset"  class="buttonIndex" type="button" onclick="window.location.href='invoice/uploadJsp'" value="上传" />
<%--        <input id="buttonBack"  class="buttonIndex" type="button" name="Submit" οnclick="javascript:history.back(-1);" value="返回">--%>
        <%--<div class="buttonIndex">
            <form action="/invoice/download"
                  method="get">
                <input class="buttonIndex" type="submit" value="下载">
            </form>
        </div>--%>
    </div>


    <div style="height: 10px"></div>
    <div class="c1">
        <table border="2" align="center" width="100%">
            <tr>
                <th style="width: 100px">学员学号</th>
                <th style="width: 100px">学员姓名</th>
                <th style="width: 50px">性别</th>
                <th style="width: 100px">可申请总额</th>
                <th style="width: 100px">银行卡号</th>
                <th style="width: 100px">手机号</th>
            </tr>

            <c:forEach items="${lists}" var="item">
                <tr>
                    <td align="center">${item.num}</td>
                    <td align="center">${item.name}</td>
                    <td align="center">${item.sexy}</td>
                    <td align="center">${item.sum}</td>
                    <td align="center">${item.bankNum}</td>
                    <td align="center">${item.mobilePhoneNum}</td>
                </tr>

            </c:forEach>
            <%--<%
                ArrayList list = (ArrayList)request.getAttribute("lists");
        /*if(list!=null && list.size()!=5){
            int u = 5-list.size();
            for(int i=0;i<u;i++){
                list.add(new Students());
            }
        }*/
                for(int i = 0; i < list.size(); i++){
                    Students  clazz = (Students)list.get(i);
            %>

            <%
                }
            %>--%>
        </table>

    </div>
</div>

</body>
</html>
<script language=JavaScript>
    function exporExcel() {
        window.location.href = "/invoice/download";
    }

    function query(){
        createXmlHttpRequest();

//指明准备状态改变时回调的函数名
        xmlHttpReq.onreadystatechange=handle;
//尝试以异步的get方式访问某个URL
//请求服务器端的一个servlet
        var url = "/invoice/test";
        xmlHttpReq.open("get",url,true);
//向服务器发送请求
        xmlHttpReq.send(null);
        // $.ajax({
        //     url : "http://localhost:8080/main/test",
        //     params:{
        //         code:obj
        //     },
        //     success:function (response) {
        //
        //     }
        // });
    }

    //创建一个XmlHttpRequest对象
    function createXmlHttpRequest()
    {
        if(window.XMLHttpRequest)
        {
            xmlHttpReq = new XMLHttpRequest();//非IE浏览器
        }else
        {
            xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");//IE浏览器
        }
    }


    //状态发生改变时回调的函数
    function handle(){
//准备状态为4
        if(xmlHttpReq.readyState==4)
        {
            //响应状态码为200，代表一切正常
            if(xmlHttpReq.status==200)
            {
                var res = xmlHttpReq.responseText;
                var result = document.getElementById("indexResult");//.style.color = "red"
                // location.reload([true])
                result.innerHTML = res;
                /*String base = request.getContextPath();
                alert(base);*/
            }
        }
    }
</script>
<style type="text/css">
    .button{
        COLOR: black;
        BACKGROUND-COLOR: aqua;
        BORDER-RIGHT: #999999 1px solid;
        BORDER-TOP: #ffffff 1px solid;
        FONT-SIZE: 10pt;
        BORDER-LEFT: #ffffff 1px solid;
        WIDTH: 40px;
        BORDER-BOTTOM: #999999 1px solid;
        HEIGHT: 18px;
    }
    .buttonIndex {
        width: 60px;
        height: 30px;
        border-radius: 5px;
        background: rgb(107, 250, 254);
        line-height: 30px;
        text-align: center;
        color: black;
        font-size: 13px;
        border:0px;
        align:center;
    }
    .logoImg{
        background-image:url(/images/kaikeba.png);
        background-repeat: no-repeat;
        background-position: center center;
        height: 50px;
        width: 220px;
        display: inline-block;
        margin-left:20px;
        background-size:100% 100%;
    }
    .divCoustom {
        margin: 40px 40px 30px 40px
    }

    .c1{
        width: 620px;
        height: 200px;
        background-color: white;
        margin: 0 auto;
        /*position: relative;*/
        /* padding-top: 40px;*/
    }
    .c2{
        width: 100px;
        height: 100px;
        margin-left: 70px;
        background-color: green;
        /* margin-top: 40px;*/
    }
</style>