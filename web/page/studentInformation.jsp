<%--
  Created by IntelliJ IDEA.
  User: 47052
  Date: 2023/7/8
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息管理表</title>

    <%--引入easyui框架--%>
    <link rel="stylesheet" type="text/css" href="../easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyUI/themes/icon.css">
    <script type="text/javascript" src="../easyUI/jquery.min.js">
    </script>
    <script type="text/javascript" src="../easyUI/jquery.easyui.min.js">
    </script>

    <script>
        $(function () {
            $('#studetinformationtable').datagrid({
                url:"/searchStudent2Servlet",
                pageList:[6,7,8,10,12,14],
                pageSize:14,
                pagination:true
            })
        })
        //班级查找
        function classsearch(value){
            $(function () {
                $('#studetinformationtable').datagrid({
                    url:"/searchStudent2Servlet",
                    pageList:[6,7,8,10,12,14],
                    pageSize:14,
                    pagination:true
                })
            })
            $('#studetinformationtable').datagrid('load',{
                sclass: value
            });
        }
        //姓名查找
        function namesearch(value) {
            $(function () {
                $('#studetinformationtable').datagrid({
                    url:"/searchStudent1Servlet",
                    pageList:[6,7,8,10,12,14],
                    pageSize:14,
                    pagination:true
                })
            })
            $('#studetinformationtable').datagrid('load',{
                sname: value
            });
        }
        //    row:获取该行的数据
        function addUpdate(val,row,index) {
            var btn;

            btn=' <a id="btn01" href="#" style="text-decoration: none" onclick="showUpdateDialog(' + row.sId + ',\'' + row.sName + '\' )">修改</a>';
            return btn;
        }

        function showUpdateDialog(sId,sName,sClass){
            $('#sIdtext').textbox("setValue",sId)
            $('#sNametext').textbox("setValue",sName)
            $('#sClasstext').textbox("setValue",sClass)
            $("#updatedialog").dialog({
                closed:false
            })
        }

        //    修改学生表的记录
        function updateOper() {
            //获取sId sName
            var sid = $("#sIdtext").textbox("getValue")
            var sname = $("#sNametext").textbox("getValue")
            var sclass = $("#sClasstext").textbox("getValue")
            //    给服务器端发送
            $.post({
                url: '/updateStudentServlet',
                data: {
                    sId: sid,
                    sName: sname,
                    sClass:sclass
                },
                success: function (result, status, xhr) {
                    //接受服务端响应的结果，根据不同的结果进行处理
                    //隐藏对话框
                    $("#updatedialog").dialog({
                        closed: true
                    })
                    if (result == 'true') {
                        //    重新加载页面
                        $("#studetinformationtable").datagrid("reload")
                        $.messager.show({
                            title: '修改结果',
                            msg: '修改成功',
                            timeout: 1000,
                            showType: 'slide'
                        });

                    } else {
                        $.messager.show({
                            title: '修改结果',
                            msg: '修改失败',
                            timeout: 1000,
                            showType: 'slide'
                        });
                    }
                }
            })
        }
        // 显示添加对话框
        function showAddDialog() {
            $("#adddialog").dialog({
                closed:false
            })
        }

        //    添加操作
        function addOper() {
            //    隐藏添加面板
            $("#adddialog").dialog({
                closed:true
            })
            //    获取学生姓名
            var sId=$("#addsId").textbox("getValue")
            var sName=$("#addsName").textbox("getValue")
            var sex=$("#addsex").textbox("getValue")
            var sClass=$("#addsClass").textbox("getValue")

            //    给服务器发送请求
            $.post({
                url: '/insertStudentServlet',
                data:{
                    sId: sId,
                    sName: sName,
                    sex: sex,
                    sClass: sClass
                },
                success:function (result,statud,xhl) {
                    //    根据结果进行处理
                    if (result=='true'){
                        $("#studetinformationtable").datagrid("reload")
                        $.messager.show({
                            title:'添加结果',
                            msg:'添加成功',
                            timeout:1000,
                            showType:'slide'
                        });
                    }else {
                        $.messager.show({
                            title:'添加结果',
                            msg:'添加失败',
                            timeout:1000,
                            showType:'slide'
                        });
                    }
                }
            })
        }

        //        删除
        function delereOper() {
            //判断石否至少选中一个
            var arr=$("#studetinformationtable").datagrid("getSelections")
            if (arr.length>0){
                //    如果是弹出确认消息框
                $.messager.confirm('删除信息', '确定要删除吗？', function(r){
                    if (r){
                        var str='(';
                        //    获取选中行的cid值
                        for (var i=0;i<arr.length;i++){
                            str=str+arr[i].sId
                            if (i<arr.length-1){
                                str=str+","
                            }
                        }
                        str=str+')'

                        //    给服务端发送请求
                        $.post({
                            url: '/deleteStudentServlet',
                            data: {
                                sIds:str
                            },
                            success:function (result,status,xhl) {
                                if (result=='true'){
                                    $("#studetinformationtable").datagrid("reload")
                                    $.messager.show({
                                        title:'删除结果',
                                        msg:'删除成功',
                                        timeout:1000,
                                        showType:'slide'
                                    });
                                }else {
                                    $.messager.show({
                                        title:'删除结果',
                                        msg:'删除失败',
                                        timeout:1000,
                                        showType:'slide'
                                    });
                                }
                            }
                        })
                    }
                });

            }else {
                //    如果不是 弹出警告消息框
                $.messager.alert('删除信息','至少选中一行','warning');
            }


        }

    </script>
    <style>
        ol{
            list-style-type:none ;
            margin: 0px;
            padding: 0px;
            text-align:center ;
            margin: 20px 0px;
        }
        li{
            display: inline-block;
        }
    </style>
</head>
<body>
<%--搜索框、添加按钮、删除按钮--%>
<div style="margin-bottom: 10px;">
    <input id="ss01" class="easyui-searchbox" style="width:300px"
           data-options="searcher:classsearch,prompt:'请输入查询的学生班级'"></input>
    <input id="ss02" class="easyui-searchbox" style="width:300px"
           data-options="searcher:namesearch,prompt:'请输入查询的学生姓名'"></input>
    <a id="btn01" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="showAddDialog()">添加</a>
    <a id="btn02" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="delereOper()" >删除</a>
</div>
<%--显示学生信息表格--%>
<table id="studetinformationtable" class="easyui-datagrid" data-options="fitColumns:true">
    <thead>
    <tr>
        <th data-options="field:'sId'" style="width: 200px"> 学号</th>
        <th data-options="field:'sName'" style="width: 200px">姓名</th>
        <th data-options="field:'sex'" style="width: 200px">性别</th>
        <th data-options="field:'sClass'" style="width: 200px" >班级</th>
        <th data-options="field:'_oper'" formatter="addUpdate" style="width: 200px">操作</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<%--修改操作对话框--%>
<div id="updatedialog" class="easyui-dialog" title="修改学生信息" style="width:400px;height:250px;"
     data-options="iconCls:'icon-save',resizable:false,modal:true,closed: true">
    <ol>
        <li>学号:</li>
        <li>
            <input id="sIdtext" class="easyui-textbox" style="width:200px"  data-options="disabled:true">
        </li>
    </ol>
    <ol>
        <li>姓名:</li>
        <li>
            <input id="sNametext" class="easyui-textbox"  style="width:200px" data-options="disabled:true">
        </li>
    </ol>
    <ol>
        <li>班级:</li>
        <li>
            <input id="sClasstext" class="easyui-textbox"  style="width:200px">
        </li>
    </ol>
    <ol>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="updateOper()">修改</a>
    </ol>

</div>

<%--添加操作对话框--%>
<div id="adddialog" class="easyui-dialog" title="添加学生" style="width:400px;height:300px;"
     data-options="iconCls:'icon-save',resizable:false,modal:true,closed: true">
    <ol>
        <li>学号:</li>
        <li>
            <input id="addsId" class="easyui-textbox" style="width:200px" >
        </li>
    </ol>
    <ol>
        <li>姓名:</li>
        <li>
            <input id="addsName" class="easyui-textbox"  style="width:200px">
        </li>
    </ol>
    <ol>
        <li>性别:</li>
        <li>
            <input id="addsex" class="easyui-textbox"  style="width:200px">
        </li>
    </ol>
    <ol>
        <li>班级:</li>
        <li>
            <input id="addsClass" class="easyui-textbox"  style="width:200px">
        </li>
    </ol>

    <ol>
        <a id="addbtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="addOper()">添加</a>
    </ol>
</div>


</body>
</html>
