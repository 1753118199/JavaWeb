<%--
  Created by IntelliJ IDEA.
  User: 47052
  Date: 2023/7/8
  Time: 8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩管理系统</title>
    <%--引入easyui框架--%>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <script type="text/javascript" src="easyUI/jquery.min.js">
    </script>
    <script type="text/javascript" src="easyUI/jquery.easyui.min.js">
    </script>

    <script>
        function selectTab01() {
            //判断是否存在该按钮对应的卡片
            var ok= $("#studenttab").tabs("exists","学生信息管理")

            if (ok){
                //有，则选中
                $("#studenttab").tabs("select","学生信息管理")
            }else {
                //没有，则在选项卡中添加卡片
                // add a unselected tab panel
                $('#studenttab').tabs('add',{
                    title: '学生信息管理',
                    selected: true,
                    closable:true,
                    content:'<iframe height="100%" width="100%" src="studentInformation.jsp" frameborder="0"></iframe>'
                });
            }
        }
        function selectTab02() {
        //判断是否存在该按钮对应的卡片
            var ok= $("#studenttab").tabs("exists","学生成绩管理")

        if (ok){
            //有，则选中
            $("#studenttab").tabs("select","学生成绩管理")
        }else {
            //没有，则在选项卡中添加卡片
            // add a unselected tab panel
            $('#studenttab').tabs('add',{
                title: '学生成绩管理',
                selected: true,
                closable:true,
                content:'<iframe height="100%" width="100%" src="studentGrade.jsp" frameborder="0"></iframe>'
            });
        }
        }
        function selectTab03() {
            //判断是否存在该按钮对应的卡片
            var ok= $("#studenttab").tabs("exists","高数成绩分析")

            if (ok){
                //有，则选中
                $("#studenttab").tabs("select","高数成绩分析")
            }else {
                //没有，则在选项卡中添加卡片
                // add a unselected tab panel
                $('#studenttab').tabs('add',{
                    title: '高数成绩分析',
                    selected: true,
                    closable:true,
                    content:'<iframe height="100%" width="100%" src="echartsmath.jsp"></iframe>'
                });
            }
        }
        function selectTab04() {
            //判断是否存在该按钮对应的卡片
            var ok= $("#studenttab").tabs("exists","英语成绩分析")

            if (ok){
                //有，则选中
                $("#studenttab").tabs("select","英语成绩分析")
            }else {
                //没有，则在选项卡中添加卡片
                // add a unselected tab panel
                $('#studenttab').tabs('add',{
                    title: '英语成绩分析',
                    selected: true,
                    closable:true,
                    content:'<iframe height="100%" width="100%" src="echartsenglish.jsp"></iframe>'
                });
            }
        }
        function selectTab05() {
            //判断是否存在该按钮对应的卡片
            var ok= $("#studenttab").tabs("exists","计网成绩分析")

            if (ok){
                //有，则选中
                $("#studenttab").tabs("select","计网成绩分析")
            }else {
                //没有，则在选项卡中添加卡片
                // add a unselected tab panel
                $('#studenttab').tabs('add',{
                    title: '计网成绩分析',
                    selected: true,
                    closable:true,
                    content:'<iframe height="100%" width="100%" src="echartsnetwork.jsp"></iframe>'
                });
            }
        }
        function selectTab07() {
            //判断是否存在该按钮对应的卡片
            var ok= $("#studenttab").tabs("exists","计算机类1班")

            if (ok){
                //有，则选中
                $("#studenttab").tabs("select","计算机类1班")
            }else {
                //没有，则在选项卡中添加卡片
                // add a unselected tab panel
                $('#studenttab').tabs('add',{
                    title: '计算机类1班',
                    selected: true,
                    closable:true,
                    content:'<iframe height="100%" width="100%" src="echartsone.jsp"></iframe>'
                });
            }
        }
        function selectTab08() {
            //判断是否存在该按钮对应的卡片
            var ok= $("#studenttab").tabs("exists","计算机类2班")

            if (ok){
                //有，则选中
                $("#studenttab").tabs("select","计算机类2班")
            }else {
                //没有，则在选项卡中添加卡片
                // add a unselected tab panel
                $('#studenttab').tabs('add',{
                    title: '计算机类2班',
                    selected: true,
                    closable:true,
                    content:'<iframe height="100%" width="100%" src="echartstwo.jsp"></iframe>'
                });
            }
        }
        function selectTab09() {
            //判断是否存在该按钮对应的卡片
            var ok= $("#studenttab").tabs("exists","计算机类3班")

            if (ok){
                //有，则选中
                $("#studenttab").tabs("select","计算机类3班")
            }else {
                //没有，则在选项卡中添加卡片
                // add a unselected tab panel
                $('#studenttab').tabs('add',{
                    title: '计算机类3班',
                    selected: true,
                    closable:true,
                    content:'<iframe height="100%" width="100%" src="echartsthree.jsp"></iframe>'
                });
            }
        }
        function selectTab10() {
            //判断是否存在该按钮对应的卡片
            var ok= $("#studenttab").tabs("exists","各班总人数")

            if (ok){
                //有，则选中
                $("#studenttab").tabs("select","各班总人数")
            }else {
                //没有，则在选项卡中添加卡片
                // add a unselected tab panel
                $('#studenttab').tabs('add',{
                    title: '各班总人数',
                    selected: true,
                    closable:true,
                    content:'<iframe height="100%" width="100%" src="echartstotal.jsp"></iframe>'
                });
            }
        }
    </script>

    <style>
        .mainTop{
            height:200px;
            text-align: center;
            color: #e68900;
            line-height: 98px;
            font-weight: bolder;
            font-size: 30px;
            background-image: url("images/background01.jpg");
            background-size: 100% 100%;
        }

    </style>
</head>

<body>
    <div id="cc" class="easyui-layout" data-options="fit:true">
        <div class="mainTop" data-options="region:'north',split:false">
            学生成绩管理系统
        </div>
        <div data-options="region:'west',title:'功能界面',split:false" style="width:200px;">
            <div id="aa" class="easyui-accordion" data-options="fit:true">
                <div title="功能选择" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">
                    <a id="btn01" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 100%" onclick="selectTab01()">学生信息管理</a>
                    <a id="btn02" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 100%" onclick="selectTab02()">学生成绩管理</a>
                </div>
                <div title="成绩分析" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">
                    <a id="btn04" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 100%" onclick="selectTab03()">高数成绩分析</a>
                    <a id="btn05" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 100%" onclick="selectTab04()">英语成绩分析</a>
                    <a id="btn06" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 100%" onclick="selectTab05()">计网成绩分析</a>
                </div>
                <div title="各班成绩等级分析" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">
                    <a id="btn07" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 100%" onclick="selectTab07()">计算机类1班</a>
                    <a id="btn08" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 100%" onclick="selectTab08()">计算机类2班</a>
                    <a id="btn09" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 100%" onclick="selectTab09()">计算机类3班</a>
                </div>
                <div title="各班人数" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">
                    <a id="btn10" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 100%" onclick="selectTab10()">各班总人数</a>
                </div>
            </div>
        </div>
        <div data-options="region:'center',title:'管理界面'" style="padding:5px;background:#eee;">
            <div id="studenttab" class="easyui-tabs"  data-options="fit:true">
                <div title="学生信息管理" data-options="closable:true" >
                    <iframe height="100%" width="100%" src="studentInformation.jsp" frameborder="0"></iframe>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
