<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统登录</title>
    <%--导入easyui框架--%>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <script type="text/javascript" src="easyUI/jquery.min.js">
    </script>
    <script type="text/javascript" src="easyUI/jquery.easyui.min.js">
    </script>

      <style>
        body {
          background: linear-gradient(to bottom right, #62a8f1, #f699ce);
          display: flex;
          justify-content: center;
          align-items: center;
          height: 100vh; /* 填充整个浏览器窗口 */
        }

        .container {
          background-color: #6897bb; /* 设置容器背景颜色为白色 */
          padding: 20px;
          border-radius: 5px;
          box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
        }

        .textbox,
        .passwordbox {
          width: 300px;
          margin-bottom: 10px;
          height: 34px;
          padding: 5px;
        }
         ol{
           list-style-type: none;
           margin: 0px;
           padding:0px;
           text-align: center;
           margin: 10px;
         }
         li{
          display: inline-block;
        }
        .login-button {
          display: inline-block;
          padding: 8px 16px;
          border: 1px solid #ccc;
          border-radius: 4px;
          text-decoration: none;
        }
      </style>
    <script>
        function loginTab() {
            var account=$("#account").textbox("getValue");
            var password=$("#password").textbox("getValue");
            //alert("点击登录按钮事件开始传参")
            $.post({
                url:'/Login',
                data:{//与后端的获取的时候保持一致
                    account:account,
                    password:password,

                },
                // 接收客户端结果采取不同的方法

                success:function (result,status,xhr) {
                    if (result=="true"){
                        window.location.href = "page/home.jsp";
                    }else {
                        alert("登录失败")
                    }
                },
            })
        }
    </script>
</head>
<body>
  <div class="container">
    <div data-options="region:'north',title:'',split:false" style="height:50px;
            text-align: center;line-height: 60px;font-size: 20px;font-weight: bolder;">
      学生成绩管理系统
    </div>
    账号：<input id="account" class="easyui-textbox textbox"placeholder="请输入账号"></br>
    密码：<input id="password" class="easyui-textbox textbox"placeholder="请输入密码"></br>
    <ol>
      <a id="btndel" href="#" class="easyui-linkbutton login-button"onclick="loginTab()">登录</a>
    </ol>
  </div>
</body>
</html>
