<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- 引入layui的样式文件 -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/layui/css/layui.css">

    <title>意见反馈信息的展示</title>
</head>
<body>
<div class="layui-container">
    <div class="layui-row">
        <fieldset class="layui-elem-field layui-field-title"
                  style="margin-top: 30px;">
            <legend>
                <font size=4 color="white">意见反馈-详情
            </legend>
        </fieldset>
    </div>
    <div class="layui-row">
        <form class="layui-form" action="">


            <div class="layui-form-item">
                <label class="layui-form-label">意见编号</label>
                <div class="layui-input-block">
                    <input value="${obj.feedbackId }" type="text" readonly name="title"
                           lay-verify="title" autocomplete="off" placeholder="未填写"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">意见类型</label>
                <div class="layui-input-block">
                    <input value="${obj.feedbackType }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder=未填写 class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">反馈用户</label>
                <div class="layui-input-block">
                    <input value="${obj.userId }" type="text" readonly name="title"
                           lay-verify="title" autocomplete="off" placeholder="未填写"
                           class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">意见反馈内容</label>
                <div class="layui-input-block">
                    <style>
                        textarea {
                            width: 100%;
                            height: 200px;
                        }
                    </style>

                    <textarea name="textarea">"${obj.feedback }"</textarea>

                </div>
            </div>

            <button class="layui-btn" type="button"
                    onclick="javascript:history.back(-1)">返回
            </button>
    </div>
    </form>
</div>
</div>

</body>
</html>