<%--
  Created by IntelliJ IDEA.
  User: ZG
  Date: 2019/11/8
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游戏得分！</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>    <!-- 引用外部插件 -->
    <script src="/static/js/gameResult.js" type="text/javascript"></script>  <!--调用外部js文件-->
    <link href="/static/css/gameResult.css" rel="stylesheet" type="text/css" />  <!-- 调用外部css文件 -->
</head>
<body>
<div id="container">
    <div id="front">
        <h2 style="font-family: 华文彩云;">黄金点游戏</h2>
    </div>

    <div id="index" style="align-content: center">
        <button id="getResult" class="btn" onclick="isOver()">查看结果</button>
        <button id="back" class="btn" onclick="back()" style="display: none">返回</button>

        <table id="result" border="1" style="margin:auto">

        </table>
    </div>

    <div id="footer">

    </div>
</div>

</body>
</html>
