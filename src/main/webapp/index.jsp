<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="../../index-css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="../../index-css/demo.css"/>
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="../../index-css/component.css"/>
    <!--[if IE]>
    <script src="js/html5.js"></script>
    <![endif]-->
</head>

<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>管理员登录</h3>

                <form action="superadminadmin/main_admin" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span> <input name="adminID" class="text"
                                                            style="color: #FFFFFF !important" type="text"
                                                            placeholder="请输入账号">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span> <input name="password"
                                                            class="text"
                                                            style="color: #FFFFFF !important; position: absolute; z-index: 100;"
                                                            value="" type="password" placeholder="请输入密码">
                    </div>


                    <div class="mb2">
                        <center>
                            <button type="submit" class="act-but submit"
                                    style="color: white">登录
                            </button>
                        </center>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var msg = "${adminId}";
    if (msg != "") {
        alert(msg);
    }
</script>
<!-- /container -->
<script src="../../index-js/TweenLite.min.js"></script>
<script src="../../index-js/EasePack.min.js"></script>
<script src="../../index-js/rAF.js"></script>
<script src="../../index-js/demo-1.js"></script>
<div style="text-align: center;"></div>
</body>
</html>