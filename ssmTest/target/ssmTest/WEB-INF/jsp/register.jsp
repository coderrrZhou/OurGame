<%--
  Created by IntelliJ IDEA.
  User: ZG
  Date: 2019/10/31
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link href="/static/css/login.css" rel="stylesheet" type="text/css" />  <!-- 调用外部css文件 -->
    <title>三剑客的游戏</title>
</head>
<body>

<div id="container">

    <div id="front">
        <h2 style="font-family: 华文彩云;">黄金点游戏</h2>
    </div>

    <div id="index" style="align-content: center">
        <form action="/userController/proRegister" method="post">
            <p><input class="form_input" type="text" name="userName" ></p>
            <p><input class="form_input" type="password" name="pwd" ></p>
            <p>
                <button class="btn" type="submit"  name="register">注册</button>
            </p>
        </form>
    </div>

    <div id="footer">

    </div>
</div>
</body>
</html>