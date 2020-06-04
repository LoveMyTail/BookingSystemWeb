<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/layui/css/layui.css">

    <title>座位信息的展示</title>


    <script>
        function query() {
            var seatId = document.getElementById("seat_id").value;
            var showId = document.getElementById("show_id").value;
            document.location.href = "<%=request.getContextPath()%>/seatList?pageNum=1&pageSize=6&show_id=" + showId + "&seat_id=" + seatId;
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
        <font size=4 color="white">座位信息管理
    </legend>
    </br>
    </br>
</fieldset>
<div class="layui-container">
    <div class="layui-row">
        <table>
            <tr>
                <td>座位编号：<input id="seat_id" name="seat_id" value="${seat_id }"/></td>
                <td>演出编号：<input id="show_id" name="show_id" value="${show_id }"/></td>
                <td>
                    <button class="layui-but" onclick="query()">查询</button>
                </td>
            </tr>
        </table>
        <table class="layui-table" style="background: transparent">
            <thead>
            <tr class="123" style="background: #29374D">
                <th>序号</th>
                <th>座位编号</th>
                <th>演出编号</th>
                <th>排数</th>
                <th>列数</th>
                <th width="200px">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list }" var="t" varStatus="st">
                <tr>
                    <td>${st.count}</td>
                    <td>${t.seatId}</td>
                    <td>${t.showId}</td>
                    <td>${t.coordinateX}</td>
                    <td>${t.coordinateY}</td>
                    <td>
                        <div class="layui-btn-group">
                            <button class="layui-btn"
                                    onclick="javascript:document.location.href='<%=request.getContextPath()%>/viewSeat?seatId=${t.seatId }';">
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
    layui.use('laypage', function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'test1', //注意，这里的 test1 是 ID，不用加 # 号
            count: ${pageInfo.total}, //数据总数，从服务端得到
            limit: ${pageInfo.pageSize},// 每页显示的最大记录数
            curr: ${pageInfo.pageNum}, // 指明当前页
            jump: function (obj, first) {
                //obj包含了当前分页的所有参数，比如：
                console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                console.log(obj.limit); //得到每页显示的条数
                if (!first) {
                    var seatId = document.getElementById("seat_id").value;
                    var showId = document.getElementById("show_id").value;
                    var url = "<%=request.getContextPath()%>/seatList?pageNum=" + obj.curr + "&pageSize=" + obj.limit + "&seat_id=" + seatId + "&show_id=" + showId;

                    document.location.href = url;// 改变当前页的地址
                }
            }
        });
    });
</script>
</body>

</html>










