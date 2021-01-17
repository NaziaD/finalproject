<!-- chart.jsp-->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Data Chart Page</title>
    <style><%@include file="../css/style.css"%></style>
    <script type="text/javascript">
        window.onload = function() {
            var dps = [[]];
            var chart = new CanvasJS.Chart("chart", {
                animationEnabled: true,
                title: {
                    text: "Covid Cases By State"
                },
                axisY: {
                    title: "Number of cases",
                    lineThickness: 1,
                },
                data: [{
                    type: "column",
                    data: dps[0]
                }]
            });
            var yValue;
            var label;

            <c:forEach items="${dataList}" var="data" varStatus="loop">
            <c:forEach items="${data}" var="data">``
            yValue = parseFloat("${data.y}");
            label = "${data.label}";
            dps[parseInt("${loop.index}")].push({
                label : label,
                y : yValue,
            });
            </c:forEach>
            </c:forEach>

            chart.render();
        }
    </script>
</head>
<body>
<div id="chart" style="height: 350px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<br><br><br><br>
<a href="/home">Return to Homepage.</a>
<br><br><br><br>
</body>
</html>