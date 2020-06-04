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
    <link rel="stylesheet" href="css/layui.css" media="all">

    <title>新座位信息发布</title>
</head>
<body>
<div class="layui-container">


    <div class="layui-row">
        <fieldset class="layui-elem-field layui-field-title"
                  style="margin-top: 30px;">
            <legend>
                <font size=4 color="white">增加座位信息
            </legend>
        </fieldset>
    </div>


    <div class="layui-row">
        <form class="layui-form" action="<%=request.getContextPath() %>/addSeat" method="post">

            <div class="layui-form-item">
                <label class="layui-form-label">演出编号</label>

                <div class="layui-input-block">
                    <input value="${showId }" type="text"  id="showId" name="showId"
                           lay-verify="show" autocomplete="off" placeholder="请输入演出编号"
                           class="layui-input" >
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">排数</label>

                <div class="layui-input-block">
                    <input value="${coordinateX }" type="text"  id="coordinateX" name="coordinateX"
                           lay-verify="show" autocomplete="off" placeholder="请输入座位排数"
                           class="layui-input" >
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">列数</label>
                <div class="layui-input-block">
                    <input value="${coordinateY }" type="text" id="coordinateY"
                           name="coordinateY" lay-verify="show" autocomplete="off"
                           placeholder="请输入座位列数" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">是否已经被选</label>
                <div class="layui-input-block">
                    <input value="${choosen }" type="text"  name="choosen" id="choosen"
                           lay-verify="show" autocomplete="off" placeholder="请输入true或false"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">是否可选</label>
                <div class="layui-input-block">
                    <input value="${status }" type="text"  name="status" id="status"
                           lay-verify="show" autocomplete="off" placeholder="请输入true或false"
                           class="layui-input">
                </div>
            </div>




            <div>
                <button class="layui-btn"  onclick="validate()">保存</button>
            </div>
        </form>
    </div>
</div>



<script type="text/javascript">
    function isExistSeat(obj){
        var showName = obj.value;
        url ="<%=request.getContextPath()%>/isExistSeat";
        $.post(url,{showId:showId},function(data){
            console.log(">>>"+data);
            if(data == "yes"){
                alert("系统已经存在该演出信息了")
            }
        });
    }

    function validate(){
        var showId = document.getElementById("showId");
        var coordinateX = document.getElementById("coordinateX");
        var coordinateY = document.getElementById("coordinateY");
        console.log(showId.value)
        if(showId!=null){
            alert(showId.value);
            alert("演出编号不为空");
            url ="<%=request.getContextPath()%>/isExist";
            $.ajax({
                type: "POST",
                url: url,
                data: "showId="+showId.value + "coordinateX="+coordinateX.value + "coordinateY="+ coordinateY.value,
                success: function(data){
                    if(data == "yes"){
                        alert("系统已经存在该座位的信息了");
                        return false;
                    }else{
                        console.log(">>>返回true");
                        $("#form1").submit();
                        return true;
                    }
                },
                async: false
            });
        }else{
            alert("演出编号为空");
            return false;
        }


    }

</script>
</body>
</html>