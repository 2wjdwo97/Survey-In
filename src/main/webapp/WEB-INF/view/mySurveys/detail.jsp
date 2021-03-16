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

<link href="/css/framework.css" rel="stylesheet" type="text/css">
<link href="/css/style_detail.css" rel="stylesheet" type="text/css">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=PT+Sans:wght@400;700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">

<div class="display-flex flex-auto flex-direction-column content-box" style="padding:25px">
    <div class="display-flex content-header">
        <span style="height:fit-content; align-self: flex-end">${survey.title}</span>
    </div>
    <div class="display-flex flex-auto">
        <div class="survey-list padding-20">
            <div class="btmspace-30" style="font-size: 24px; font-weight: bold;">
                Questions
            </div>
            <c:forEach var="question" items="${survey.questions}" varStatus="st">
                <div>
                    <button class="btmspace-10 question-title" onclick="btn_clicked(${question.id}, ${st.index})">${st.index + 1}. ${question.title}</button>
                    <div class="chart-div hidden" >
                        <canvas id="chart${st.index}" class="btmspace-30"></canvas>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="survey-analysis">
            <div class="display-flex flex-direction-column detail-chart padding-20 position-relative">
                <div class="btmspace-30" style="font-size: 24px; font-weight: bold;">
                    Analysis
                </div>
                <div class="gender-area display-flex btmspace-80">
                    <div style="width:50%; height: 100%">
                        <canvas id="chart-men"></canvas>
                    </div>
                    <div style="width:50%; height: 100%">
                        <canvas id="chart-women"></canvas>
                    </div>
                </div>
                <div>
                    <canvas id="chart-age"></canvas>
                </div>
                <div id="no-result" class="hidden position-absolute display-flex flex-direction-column flex-content-center flex-content-cross-center">
                    <img class="btmspace-15" src="/images/no_result.png">
                    <span>No data</span>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
<script type="text/javascript" src="/js/detailJs.js"></script>
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
                    backgroundColor: bgc
                }]
            },
            options: {
                legend: {
                    position: 'bottom'
                }
            }
        });
        if(sum(data) === 0){
            charts["${st.index}"].font = "18px Arial";
            charts["${st.index}"].clearRect(0, 0, 100, 100);
            charts["${st.index}"].fillText("No data", 10, 50);
        }
    </c:forEach>

</script>
