<%--
  Created by IntelliJ IDEA.
  User: 泷心阁
  Date: 2023/7/10
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>一班成绩等级分析雷达图</title>
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
            text: '计算机类1班成绩等级表'
        },
        legend: {
            data: ['计算机类1班']
        },
        radar: {
            // shape: 'circle',
            indicator: [
                { name: '优秀', max: 28 },
                { name: '良好', max: 28 },
                { name: '及格', max: 28 },
                { name: '不及格', max: 28 },

            ]
        },
        series: [
            {
                name: 'Budget vs spending',
                type: 'radar',
                data: [
                    {
                        value: [],
                        name: '计算机类1班'
                    },
                ]
            }
        ]
    };
    function getData(sclass) {
        $.post({
            url: "/ScoreLevelcontroller",
            data: {
                sclass: sclass-1,
            },
            success: function (result, statue, xhr) {
                var data = JSON.parse(result); // 将返回的数据解析为数组
                var convertedData = data.map(function(value) {
                        return { value: data, name: '计算机类'+sclass+'班'}
                });
                option.series[0].data = convertedData; // 更新雷达图的数据
                myChart.setOption(option); // 使用刚指定的配置项和数据显示图表。
            }
        });
    }
getData(1)


</script>


</body>
</html>
