<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- 引入layui的样式文件 -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/layui/css/layui.css">

    <title>座位信息的展示</title>
</head>
<body>
<div class="layui-container">
    <div class="layui-row">
        <fieldset class="layui-elem-field layui-field-title"
                  style="margin-top: 30px;">
            <legend>
                <font size=4 color="white">座位信息-详情
            </legend>
        </fieldset>
    </div>
    <div class="layui-row">
        <form class="layui-form" action="">


            <div class="layui-form-item">
                <label class="layui-form-label">座位编号</label>
                <div class="layui-input-block">
                    <input value="${obj.seatId }" type="text" readonly name="title"
                           lay-verify="title" autocomplete="off" placeholder="未填写"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">演出编号</label>
                <div class="layui-input-block">
                    <input value="${obj.showId }" type="text" readonly name="title"
                           lay-verify="title" autocomplete="off" placeholder="未填写"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">排数</label>
                <div class="layui-input-block">
                    <input value="${obj.coordinateX }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder=未填写 class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">列数</label>
                <div class="layui-input-block">
                    <input value="${obj.coordinateY }" type="text" readonly name="title"
                           lay-verify="title" autocomplete="off" placeholder="未填写"
                           class="layui-input">
                </div>
            </div>



            <div class="layui-form-item">
                <label class="layui-form-label">是否被选</label>
                <div class="layui-input-block">
                    <input value="${obj.choosen }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder="未填写" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">是否可选</label>
                <div class="layui-input-block">
                    <input value="${obj.status }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder="未填写" class="layui-input">
                </div>
            </div>

            <button class="layui-btn" type="button"
                    onclick="javascript:history.back(-1)">返回</button>
    </div>
    </form>
</div>
</div>

</body>
</html>