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

    <title>演出信息的展示</title>
</head>
<body>
<div class="layui-container">
    <div class="layui-row">
        <fieldset class="layui-elem-field layui-field-title"
                  style="margin-top: 30px;">
            <legend>
                <font size=4 color="white">演出信息-详情
            </legend>
        </fieldset>
    </div>
    <div class="layui-row">
        <form class="layui-form" action="">



            <div class="layui-form-item">
                <label class="layui-form-label">演出名称</label>
                <div class="layui-input-block">
                    <input value="${obj.showName }" type="text" readonly name="title"
                           lay-verify="title" autocomplete="off" placeholder="未填写"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">演出类型</label>
                <div class="layui-input-block">
                    <input value="${obj.showType }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder=未填写 class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">演出地点</label>
                <div class="layui-input-block">
                    <input value="${obj.showSite }" type="text" readonly name="title"
                           lay-verify="title" autocomplete="off" placeholder="未填写"
                           class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">演出简介</label>
                <div class="layui-input-block">
                    <style>
                        textarea {
                            width: 100%;
                            height: 200px;
                        }
                    </style>

                    <textarea name="textarea">
		 "${obj.showIntroduction }"
	</textarea>

                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">演出时间</label>
                <div class="layui-input-block">
                    <input value="${obj.showTime }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder="未填写" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">演出价格</label>
                <div class="layui-input-block">
                    <input value="${obj.price }" type="text" readonly
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