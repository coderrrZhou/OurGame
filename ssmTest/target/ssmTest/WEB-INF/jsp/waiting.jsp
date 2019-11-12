<%--
  Created by IntelliJ IDEA.
  User: ZG
  Date: 2019/11/7
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>一起来快乐！</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>    <!-- 引用外部插件 -->
    <script src="/static/js/waiting.js" type="text/javascript"></script>  <!--调用外部js文件-->
    <link href="/static/css/room.css" rel="stylesheet" type="text/css" />  <!-- 调用外部css文件 -->
</head>
<body>
<div id="container">

    <div id="front">
        <label style="float: right;font-size: 20px;font-family: 微软雅黑;color: white;margin-top: 60px;margin-right: 50px">Welcome ${u.userName}!this is the ${r.roomId} room!</label>
    </div>

    <div id="index">
        <%--退出房间--%>
        <button class="btn" onclick="onclick_OutRoom(this);" thisRoom='${r.roomId}' >返回</button>
            <b></b>
        <div style="margin-left: 550px;">
            <img src="/static/images/user1.jpg" style="border-radius:50%;width: 200px;height: 193px;margin-top: 100px;margin-left: 25px;">

            <%--<div id="waiting" style="display: block">--%>
            <div id="waiting" style="display: block;margin-top: 50px">
                <label>人数不够，咱们一起等等其他朋友吧···</label>
            </div>
            <button onclick="startGame()" style="display: none">开始游戏</button>
            <%--<div id="start" style="display: none;">--%>
            <div id="start" style="display: none;">
                <p>快大胆猜一个！！<input id="myNums" type="text" name="myNums"></p>
                <button onclick="onclick_Submit()">就是它了！</button>
            </div>
        </div>

    </div>

    <div id="footer">
        here is footer
    </div>
</div>
</body>
</html>