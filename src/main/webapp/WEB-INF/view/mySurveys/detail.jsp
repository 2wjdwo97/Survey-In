<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-02-16
  Time: 오후 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
<link href="/css/style_detail.css" rel="stylesheet" type="text/css">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=PT+Sans:wght@400;700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">

<div class="display-flex flex-auto flex-direction-column" style="padding:25px">
    <div class="display-flex content-header">
        <span style="height:fit-content; align-self: flex-end">${survey.title}</span>
    </div>
    <div class="display-flex flex-auto">
        <div class="survey-list">
            <c:forEach var="question" items="${survey.questions}" varStatus="st">
                <div>
                    <button class="question-title">${st.index + 1}. ${question.title}</button>

                    <div>
                        <canvas id="chart${st.index}" class="main-chart hidden"></canvas>
                    </div>
                    <br/>
                </div>
            </c:forEach>
        </div>
        <div class="survey-analysis">

        </div>
    </div>
</div>

<script>
    let charts=[];
    let label;
    let data;
    let massPopChart;

    for(let index = 0; index < "${fn:length(survey.questions)}"; index++) {
        const id = "chart"+index;
        charts.push(document.getElementById(id).getContext('2d'));
    }

    <c:forEach items="${survey.questions}" var="q" varStatus="st">
        label = [];
        data = [];
        <c:forEach var="op" items="${q.option}">
            label.push("${op.data}");
            data.push("${fn:length(op.answers)}");
        </c:forEach>

        massPopChart = new Chart(charts["${st.index}"], {
            type: 'pie',
            data: {
                labels: label,
                datasets: [{
                    label: "# of Votes",
                    data: data,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.7)',
                        'rgba(54, 162, 235, 0.7)',
                        'rgba(255, 206, 86, 0.7)',
                        'rgba(75, 192, 192, 0.7)',
                        'rgba(153, 102, 255, 0.7)',
                        'rgba(255, 159, 64, 0.7)'
                    ]
                }]
            },
            options: {
                legend: {
                    position: 'bottom'
                }
            }
        });
    </c:forEach>

</script>
<script type="text/javascript" src="/js/detailJs.js"></script>