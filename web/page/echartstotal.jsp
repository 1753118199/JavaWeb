<%--
  Created by IntelliJ IDEA.
  User: 泷心阁
  Date: 2023/7/10
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级总人数柱状图</title>
    <script src="../echart/echarts.min.js"></script>
    <%--导入easyui框架--%>
    <link rel="stylesheet" type="text/css" href="../easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyUI/themes/icon.css">
    <script type="text/javascript" src="../easyUI/jquery.min.js">
    </script>
    <script type="text/javascript" src="../easyUI/jquery.easyui.min.js">
    </script>
</head>
<body>

<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main" style="width: 100%;height:100%;"></div>

<script type="text/javascript">



    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    //var chart = echarts.init(dom, 'dark');
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '班级总人数'
        },
        tooltip: {},
        legend: {
            data: ['总人数']
        },
        xAxis: {
            data: ['计算机类1班','计算机类2班','计算机类3班'],
        },
        yAxis: {},
        series: [
            {//一班
                name: '总人数',
                type: 'bar',
                data: []
            },

        ]
    };

    function getData(){
        $.post({
            url:"/Totalpeoplecontroller",
            data:{
            },
            success:function (result,statue,xhr) {
                eval("option.series[0].data="+result)
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        })
    }
    getData();

</script>
</body>
</html>
