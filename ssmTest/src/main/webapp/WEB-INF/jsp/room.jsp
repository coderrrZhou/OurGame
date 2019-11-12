<%--
  Created by IntelliJ IDEA.
  User: ZG
  Date: 2019/11/4
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开始游戏</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>    <!-- 引用外部插件 -->
    <script src="/static/js/playGame.js" type="text/javascript"></script>  <!--调用外部js文件-->
    <link href="/static/css/room.css" rel="stylesheet" type="text/css" />  <!-- 调用外部css文件 -->
</head>
<div id="container">

    <div id="front">
        <label style="float: right">Welcome ${u.userName}!this is the ${r.roomId} room!</label>
        <b></b>
    </div>

    <%--&lt;%&ndash;退出房间&ndash;%&gt;--%>
    <%--<button onclick="onclick_OutRoom(this);" thisRoom='${r.roomId}'>不和他们玩！</button>--%>

    <div id="index">
        <%--退出房间--%>
        <button class="btn" onclick="onclick_OutRoom(this);" thisRoom='${r.roomId}' >返回</button>
        <div style="margin-left: 550px;">
            <img src="/static/images/user1.jpg" style="border-radius:50%;width: 200px;height: 193px;margin-top: 100px;margin-left: 25px;">

            <form action="/gameController/submitNums" method="post">
                <p style="font-family: 微软雅黑;font-size: 20px;color: white">快点猜一个！！<input type="text" name="myNums"></p>
                <%--<p><input type="text" name="userName" style="display: none">${u.userName}</p>--%>
                <p>
                    <button class="btn" type="submit"  name="submitNum" >这是它了！</button>
                </p>
            </form>
        </div>


        <%--<div id="waiting" style="display: block">--%>
        <%--<div id="waiting" style="display: none">--%>
            <%--<label>人数不够，咱们一起等等其他朋友吧···</label>--%>
        <%--</div>--%>

        <%--<div id="start" style="display: none;">--%>
        <%--<div id="start" style="display: block;">--%>
            <%--<p>快大胆猜一个！！<input id="myNums" type="text" name="myNums"></p>--%>
            <%--<button onclick="onclick_Submit()">就是它了！</button>--%>
        <%--</div>--%>

        <%--<button onclick="isOver()">查看游戏结果</button>--%>



    </div>

    <div id="footer">
        here is footer
    </div>
</div>
</html>
