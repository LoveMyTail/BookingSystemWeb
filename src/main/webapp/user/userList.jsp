<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- 引入标签jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


    <script>
        function query() {
            var userId = document.getElementById("user_id").value;

            document.location.href = "<%=request.getContextPath()%>/userList?pageNum=1&pageSize=4&user_id=" + userId ;
        }
    </script>


    <style>
        tr {
            color: white
        }

        tr td {
            color: white
        }
    </style>

</head>
<body>
<fieldset class="layui-elem-field layui-field-title"
          style="margin-top: 30px;">
    </br>
    </br>
    <legend>
        <font size=4 color="white">用户信息管理
    </legend>
    </br>
    </br>
</fieldset>
<div class="layui-container">
    <div class="layui-row">
        <table>
            <tr>
                <td>用户编号：<input id="user_id" name="user_id" value="${user_id }"/></td>
                <%--                <td>用户昵称：<input id="nickname" name="nickname" value="${nickname }"/></td>--%>

                <td>
                    <button class="layui-but" onclick="query()">查询</button>
                </td>
            </tr>
        </table>
        <!-- 用table -->
        <table class="layui-table" style="background: transparent">
            <thead>
            <tr class="123" style="background: #29374D">
                <th>序号</th>
                <th>用户编号</th>
                <th>用户昵称</th>
                <th width="200px">操作</th>
            </tr>
            </thead>
            <tbody>
            <!-- 如何展示集合对象   使用标签c:forEach  items 集合对象的名字-->
            <c:forEach items="${pageInfo.list }" var="t" varStatus="st">
                <tr>
                    <td>${st.count}</td>
                    <td>${t.userId}</td>
                    <td>${t.nickname}</td>

                    <td>
                        <div class="layui-btn-group">
                            <button class="layui-btn"
                                    onclick="javascript:document.location.href='<%=request.getContextPath()%>/viewUser?userId=${t.userId }';">
                                查看
                            </button>

                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div id="test1"></div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/layui/layui.js"></script>
<script type="text/javascript">
    var msg = "${msg}";
    if (msg != "") {
        alert(msg);
    }
    // 使用laypage
    layui.use('laypage', function () {
        var laypage = layui.laypage;
        //执行一个laypage实例
        laypage.render({
            elem: 'test1', //注意，这里的 test1 是 ID，不用加 # 号
            count: ${pageInfo.total}, //数据总数，从服务端得到
            limit: ${pageInfo.pageSize},// 每页显示的最大记录数
            curr: ${pageInfo.pageNum}, // 指明当前页
            jump: function (obj, first) {
                //obj包含了当前分页的所有参数，比如：
                console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                console.log(obj.limit); //得到每页显示的条数
                //首次不执行
                if (!first) {
                    // 改变当前的地址
                    var userId = document.getElementById("user_id").value;
                    var nickname = document.getElementById("nickname").value;

                    var url = "<%=request.getContextPath()%>/userList?pageNum=" + obj.curr + "&pageSize=" + obj.limit + "&user_id=" + userId + "&nickname=" + nickname;
                    console.log(url);
                    document.location.href = url;// 改变当前页的地址
                }
            }
        });
    });
</script>
</body>

</html>










