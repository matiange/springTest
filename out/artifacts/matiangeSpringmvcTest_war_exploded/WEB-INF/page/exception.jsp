<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2020/7/22
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String base = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <div id="result" style="background-color: yellow;height: 100%">
       <%-- <img src="<%=request.getContextPath()%>/images/kaikeba.png">--%>
        <img src="/images/kaikeba.png" style="height: 60px">
           <h1  align="center">${msgTitle}:${message}</h1>
        <div align="center" style="display: block;font-size: 30px">
            <input id="buttonCn" class="button2" type="button" onclick="test('CN')" value="中文" />
            <input id="buttonUs" class="button2" type="button" onclick="test('US')" value="英文" />
            <input id="buttonReset" class="button2" type="button" onclick="test('')" value="重置" />
            <input id="buttonUpload" class="button2" type="button" onclick="window.location.href='uploadJsp'" value="返回" />
        </div>
        <div class="divCoustom" style="background-color: white;height: 50%"></div>
    </div>
</head>
<body>

</body>
</html>
<script language=JavaScript>
    function test(obj){
        createXmlHttpRequest();

//指明准备状态改变时回调的函数名
        xmlHttpReq.onreadystatechange=handle;
//尝试以异步的get方式访问某个URL
//请求服务器端的一个servlet
        var url = "/main/test/?code="+obj;
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
                var result = document.getElementById("result");//.style.color = "red"
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
    .button2 {
        width: 60px;
        height: 30px;
        border-radius: 5px;
        background: rgb(107, 250, 254);
        line-height: 30px;
        text-align: center;
        color: black;
        font-size: 13px;
        border:0px;
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
</style>
