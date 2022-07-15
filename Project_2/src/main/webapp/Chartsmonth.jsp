<%@page import="Model.t_expenseDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="echarts.js"></script>
</head>
<body>
<%
System.out.print("Chartsmonth in");

int sum1 = (int)request.getAttribute("sum1");
int sum2 = (int)request.getAttribute("sum2");
int sum3 = (int)request.getAttribute("sum3");
int sum4 = (int)request.getAttribute("sum4");
int sum5 = (int)request.getAttribute("sum5");
int sum6 = (int)request.getAttribute("sum6");
int sum7 = (int)request.getAttribute("sum7");
int sum8 = (int)request.getAttribute("sum8");
int sum9 = (int)request.getAttribute("sum9");
int sum10 = (int)request.getAttribute("sum10");
int sum11 = (int)request.getAttribute("sum11");
int sum12 = (int)request.getAttribute("sum12");

%>

<div id="main" style="width:800px; height:700px;"></div>
    <script>
        var chartDom = document.getElementById('main');
        var myChart = echarts.init(chartDom);
        var option;
        // DB에서 가격 정보 받아올 곳

        option = {
        legend: {
            top: 'bottom'
        },
        toolbox: {
            show: true,
            feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            restore: { show: true },
            saveAsImage: { show: true }
            }
        },
        series: [
            {
            name: 'Nightingale Chart',
            type: 'pie',
            radius: [50, 250],
            center: ['50%', '50%'],
            roseType: 'area',
            itemStyle: {
                borderRadius: 8
            },
           
            data: [
                { value: <%=sum1%>, name: 'Jan' },
                { value: <%=sum2%>, name: 'Feb' },
                { value: <%=sum3%>, name: 'Mar' },
                { value: <%=sum4%>, name: 'Apr' },
                { value: <%=sum5%>, name: 'May' },
                { value: <%=sum6%>, name: 'Jun' },
                { value: <%=sum7%>, name: 'Jul' },
                { value: <%=sum8%>, name: 'Aug' },
                { value: <%=sum9%>, name: 'Sep' },
                { value: <%=sum10%>, name: 'Oct' },
                { value: <%=sum11%>, name: 'Nov' },
                { value: <%=sum12%>, name: 'Dec' }
            ]
            }
        ]
        };

        option && myChart.setOption(option);
    </script>
</body>
</html>