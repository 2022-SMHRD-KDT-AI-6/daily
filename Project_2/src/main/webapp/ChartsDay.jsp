<%@page import="Model.t_expenseDTO"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<t_expenseDTO> list = (ArrayList<t_expenseDTO>)request.getAttribute("list");
System.out.print(list.get(0).getExp_price());

%>
<div id="main" style="width:1300px; height:400px;"></div>
    <script type="text/javascript">
    	
        var chartDom = document.getElementById('main');
        var myChart = echarts.init(chartDom);
        var option;
        
        option = {
        xAxis: { // 카테고리
            type: 'category',
            data: [
            	<%for(int i = 0; i < list.size(); i ++){%>
            	"<%=list.get(i).getExp_category()%>",
            	<%}%>
            ]
        },
        yAxis: { // 원
            type: 'value'
        },
        series: [
            {
            data: [
            	<%for(int i = 0; i < list.size(); i++){%>
            	parseInt(<%=list.get(i).getExp_price() %>),
            	<%}%>
            ],
            type: 'bar'
            }
        ]
        };

        myChart.setOption(option);

    </script>
</body>
</html>