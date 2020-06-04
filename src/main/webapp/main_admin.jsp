<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台管理-在线订票系统系统</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css">
    <link rel="stylesheet" href="css/layui.css" media="all">


</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">

        <style>
            body {
                background-image: url('images/timg1.jpg');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover
            }

        </style>


        <style>
            .footer {
                left: 0px;
                position: fixed;
                width: 100%;
                height: 30px;
                background-image: url();
                text-align: center;
                font-size: 18px;
                font-weight: bold;
                bottom: 0px;
            }

        </style>


        <div class="footer"><font size=3 color="white">
            版权所有 孙杨帆
        </div>

        <div class="layui-logo">在线订票系统-管理员端</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="javascript:go('showList');">演出信息管理</a></li>
            <li class="layui-nav-item"><a href="javascript:go('userList');">用户信息管理</a></li>
            <li class="layui-nav-item"><a href="javascript:go('feedbackList');">意见反馈管理</a></li>
            <li class="layui-nav-item"><a href="javascript:go('orderList');">用户订单管理</a></li>
            <li class="layui-nav-item"><a href="javascript:go('seatList');">座位信息管理</a></li>
            <li class="layui-nav-item"><a href="javascript:go('newshow/newshow.jsp');">发布演出信息</a></li>
            <li class="layui-nav-item"><a href="javascript:go('newseat/newseat.jsp');">添加座位信息</a></li>
            </li>
        </ul>


        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="<%=request.getContextPath() %>/images/004.jpg" class="layui-nav-img">
                </a>
                <dl class="layui-nav-child">

                    <dd>

                        <button class="layui-btn"
                                onclick="javascript:document.location.href='<%=request.getContextPath()%>/newshow/newshow.jsp';">
                            发布演出信息
                        </button>
                    </dd>

                    </dd>

                    </dd>


                </dl>
            </li>
            <li class="layui-nav-item"><a href="http://localhost:8888/index">退出</a></li>
        </ul>
    </div>


    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe onload="resetFrame()" id="main" style="border:0;width:100%;"></iframe>
    </div>

</div>
<script src="<%=request.getContextPath() %>/layui/layui.js"></script>
<script>
    function go(url) {
        //在iframe打开该地址
        // 获取iframe
        var obj = document.getElementById("main");
        // 通过设置src
        obj.src = "<%=request.getContextPath()%>/" + url;

    }

    function resetFrame() {
        var h = document.documentElement.scrollHeight || document.body.scrollHeight;
        var obj = document.getElementById("main");
        console.log(">>>" + h);
        obj.height = (h - 60 - 44 - 2) + "px";
    }

    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>

</body>
</html>
