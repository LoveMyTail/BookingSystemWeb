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

    <title>用户信息的展示</title>
</head>
<body>
<div class="layui-container">
    <div class="layui-row">
        <fieldset class="layui-elem-field layui-field-title"
                  style="margin-top: 30px;">
            <legend>
                <font size=4 color="white">用户信息-详情
            </legend>
        </fieldset>
    </div>
    <div class="layui-row">
        <form class="layui-form" action="">


            <div class="layui-form-item">
                <label class="layui-form-label">用户编号</label>
                <div class="layui-input-block">
                    <input value="${obj.userId }" type="text" readonly name="title"
                           lay-verify="title" autocomplete="off" placeholder="未填写"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">用户昵称</label>
                <div class="layui-input-block">
                    <input value="${obj.nickname }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder=未填写 class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">用户性别</label>
                <div class="layui-input-block">
                    <input value="${obj.gender }" type="text" readonly name="title"
                           lay-verify="title" autocomplete="off" placeholder="未填写"
                           class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">所在国家</label>
                <div class="layui-input-block">
                    <input value="${obj.country }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder="未填写" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">所在省份</label>
                <div class="layui-input-block">
                    <input value="${obj.province }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder="未填写" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">所在城市</label>
                <div class="layui-input-block">
                    <input value="${obj.city }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder="未填写" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">个人邮箱</label>
                <div class="layui-input-block">
                    <input value="${obj.email }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder="未填写" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">联系方式</label>
                <div class="layui-input-block">
                    <input value="${obj.phoneNumber }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder="未填写" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">送货地址</label>
                <div class="layui-input-block">
                    <input value="${obj.address }" type="text" readonly
                           name="title" lay-verify="title" autocomplete="off"
                           placeholder="未填写" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">个人简介</label>
                <div class="layui-input-block">
                    <style>
                        textarea {
                            width: 100%;
                            height: 200px;
                        }
                    </style>

                    <textarea name="textarea">"${obj.introduction }"</textarea>

                </div>
            </div>

            <%--            <div class="layui-form-item">--%>
            <%--                <label class="layui-form-label">文章浏览量</label>--%>
            <%--                <div class="layui-input-block">--%>
            <%--                    <input value="${obj.articleView }" type="text" readonly--%>
            <%--                           name="title" lay-verify="title" autocomplete="off"--%>
            <%--                           placeholder="未填写" class="layui-input">--%>
            <%--                </div>--%>
            <%--            </div>--%>


            <button class="layui-btn" type="button"
                    onclick="javascript:history.back(-1)">返回
            </button>
    </div>
    </form>
</div>
</div>

</body>
</html>