<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/layui/css/layui.css">
    <link rel="stylesheet" href="css/layui.css" media="all">
    <%--    <link rel="stylesheet" href="/static/build/layui.css" media="all">--%>
    <title>新演出信息发布</title>
</head>
<body>
<div class="layui-container">


    <div class="layui-row">
        <fieldset class="layui-elem-field layui-field-title"
                  style="margin-top: 30px;">
            <legend>
                <font size=4 color="white">发布演出信息
            </legend>
        </fieldset>
    </div>


    <div class="layui-row">
        <form class="layui-form" action="<%=request.getContextPath() %>/addShow" method="post">

            <%--            <div class="layui-form-item">--%>
            <%--                <label class="layui-form-label">演出编号</label>--%>

            <%--                <div class="layui-input-block">--%>
            <%--                    <input value="${showId }" type="text"  id="showId" name="showId"--%>
            <%--                           lay-verify="show" autocomplete="off" placeholder="请输入演出编号"--%>
            <%--                           class="layui-input" >--%>
            <%--                </div>--%>
            <%--            </div>--%>


            <div class="layui-form-item">
                <label class="layui-form-label">演出名称</label>

                <div class="layui-input-block">
                    <input value="${showName }" type="text" id="showName" name="showName"
                           lay-verify="show" autocomplete="off" placeholder="请输入演出名称"
                           class="layui-input" onblur="isExist(this)">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">演出类型</label>
                <div class="layui-input-block">
                    <input value="${showType }" type="text" id="showType"
                           name="showType" lay-verify="show" autocomplete="off"
                           placeholder="请输入演出类型" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">演出地点</label>
                <div class="layui-input-block">
                    <input value="${showSite }" type="text" name="showSite" id="showSite"
                           lay-verify="show" autocomplete="off" placeholder="请输入演出地点"
                           class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">演出简介</label>
                <div class="layui-input-block">
                    <input value="${showIntroduction }" type="text" name="showIntroduction" id="showIntroduction"
                           lay-verify="show" autocomplete="off" placeholder="请输入演出简介"
                           class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">演出时间</label>
                <div class="layui-input-block">
                    <input value="${showTime }" type="date" id="showTime"
                           name="showTime" lay-verify="show" autocomplete="off"
                           placeholder="请输入演出时间" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">演出价格</label>
                <div class="layui-input-block">
                    <input value="${price }" type="text" id="price"
                           name="price" lay-verify="show" autocomplete="off"
                           placeholder="请输入演出价格" class="layui-input">
                </div>
            </div>

            <%--            <button type="button" class="layui-btn" id="test1">--%>
            <%--                <i class="layui-icon">&#xe67c;</i>上传图片--%>
            <%--            </button>--%>


            选择图片:<input type="file" name="file" accept="image/*"/> <br>
            <%--                <input type="submit" value="立刻上传">--%>
<%--            <button class="layui-btn">立刻上传</button>--%>

            <%--            <div class="layui-form-item">--%>
            <%--                <label class="layui-form-label">图片路径</label>--%>
            <%--                <div class="layui-input-block">--%>
            <%--                    <input value="${imgUrl }" type="text" id="imgUrl"--%>
            <%--                           name="imgUrl" lay-verify="show" autocomplete="off"--%>
            <%--                           placeholder="请输入图片路径" class="layui-input">--%>
            <%--                </div>--%>
            <%--            </div>--%>


            <%--            <div>--%>
            <%--                <form action="upload" method="post" enctype="multipart/form-data">--%>
            <%--                    选择图片:<input type="file" name="file" accept="image/*" /> <br>--%>
            <%--                    <button class="layui-btn" type="submit">立刻上传</button>--%>
            <%--                    <input type="submit" value="立刻上传">--%>
            <%--                </form>--%>
            <%--            </div>--%>

            <div>
                <button class="layui-btn" onclick="validate()">保存</button>
            </div>
        </form>
    </div>
</div>

<script src="/layui/layui.js"></script>
<script>
    layui.use('upload', function () {
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            , url: 'http://localhost:8888/upload' //上传接口
            , done: function (res) {
                //上传完毕回调
            }
            , error: function () {
                //请求异常回调
            }
        });
    });
</script>

<script type="text/javascript">
    function isExist(obj) {
        var showName = obj.value;
        url = "<%=request.getContextPath()%>/isExist";//验证姓名
        $.post(url, {showName: showName}, function (data) {
            console.log(">>>" + data);
            if (data == "yes") {
                alert("系统已经存在该演出信息了")
            }
        });
    }

    function validate() {
        var showname = document.getElementById("showName");
        alert("确定保存"+showname.value+"的相关信息吗？");
        if (showname.value == "") {
            //alert("演出名称为空");
            return false;
        } else {
            // alert("演出名称不为空");
            url = "<%=request.getContextPath()%>/isExist";
            $.ajax({
                type: "POST",
                url: url,
                data: "showName=" + showname.value,
                success: function (data) {
                    if (data == "yes") {
                        alert("系统已经存在该演出的信息了");
                        return false;
                    } else {
                        console.log(">>>返回true");
                        $("#form1").submit();
                        return true;
                    }
                },
                async: false
            });
        }
    }

</script>
</body>
</html>