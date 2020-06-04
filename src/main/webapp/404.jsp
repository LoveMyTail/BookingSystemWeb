<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>对不起！您输入的账号或密码错误</title>


    <style type="text/css">
        .head404 {
            width: 700px;
            height: 300px;
            margin: 100px auto 0 auto;
            background: url('images/error.jpg') no-repeat;
        }

        .txtbg404 {
            width: 499px;
            height: 169px;
            margin: 10px auto 0 auto;
            background: black;
            no-repeat;
        }

        .txtbg404 .txtbox {
            width: 390px;
            position: relative;
            top: 30px;
            left: 60px;
            color: #eee;
            font-size: 13px;
        }

        .txtbg404 .txtbox p {
            margin: 5px 0;
            line-height: 18px;
        }

        .txtbg404 .txtbox .paddingbox {
            padding-top: 15px;
        }

        .txtbg404 .txtbox p a {
            color: #eee;
            text-decoration: none;
        }

        .txtbg404 .txtbox p a:hover {
            color: #FC9D1D;
            text-decoration: underline;
        }
    </style>
</head>


<body bgcolor="black">


<div class="head404"></div>


<div class="txtbg404">


    <div class="txtbox">


        <p>
            <font size=5>对不起！您输入密码错误
        </p>


        <br>
        <p>
            》<a style="cursor: pointer" onclick="history.back()">返回上一页面</a>
        </p>


    </div>


</div>


</body>
</html>
