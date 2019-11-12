<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZG
  Date: 2019/11/3
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Our Game!</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>    <!-- 引用外部插件 -->
    <script src="js/jquery.min.js" type="text/javascript"></script>  <!-- 引用外部插件 -->
    <link href="/static/css/index.css" rel="stylesheet" type="text/css" />  <!-- 调用外部css文件 -->
    <script src="/static/js/getRoomList.js" type="text/javascript"></script>  <!--调用外部js文件-->
    <%--<script src="/js/test.js" type="text/javascript"></script>  <!--调用外部js文件-->--%>
</head>
<body>
<div id="container">

    <div id="front">
        <label style="float: right;margin-right: 100px;font-family: 微软雅黑;margin-top: 50px">你好!  ${u.userName}</label>
    </div>

    <div id="index">
        <div id="roomList">
            <div id="all">

            </div>
            <div id="page">
                <a id="down" href="#" onClick="change1(--pageno)">上一页</a>　　
                <span id="a3"></span><a id="up" href="#" onClick="change1(++pageno)">下一页</a>
                <span class="ho">第<span id="a2"></span>/<span id="a1"></span>页</span>
            </div>

            <div style="display: none;" id="p"></div>
        </div>

    </div>

    <div id="footer">

    </div>
</div>
</body>
</html>
