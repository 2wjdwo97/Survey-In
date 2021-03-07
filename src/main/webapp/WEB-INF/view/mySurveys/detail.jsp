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
            <c:forEach var="question" items="${survey.questions}" varStatus="st">
                <div class="display-flex flex-direction-column detail-chart hidden">
                    <div class="gender-area display-flex">
                        <div style="width:50%; height: 100%">
                            <canvas id="chart${st.index}-men" height="250"></canvas>
                        </div>
                        <div style="width:50%; height: 100%">
                            <canvas id="chart${st.index}-women" height="250"></canvas>
                        </div>
                    </div>
                    <div></div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
<script>
    let ageCharts=[];

    let charts=[];
    let charts_man = [];
    let charts_woman = [];

    let label;
    let data, manData, womanData;
    let massPopChart, manChart, womanChart;

    let w_cnt, m_cnt;

    for(let index = 0; index < "${fn:length(survey.questions)}"; index++) {
        const id = "chart"+index;
        const idMen = "chart" + index + "-men";
        const idWomen = "chart" + index + "-women";
        charts.push(document.getElementById(id).getContext('2d'));
        charts_man.push(document.getElementById(idMen).getContext('2d'));
        charts_woman.push(document.getElementById(idWomen).getContext('2d'));
    }

    <c:forEach items="${survey.questions}" var="q" varStatus="st">
        label = [];
        data = [];
        manData = [];
        womanData = [];
        <c:forEach var="op" items="${q.option}">
            label.push("${op.data}");
            data.push("${fn:length(op.answers)}");
            w_cnt = 0;
            m_cnt = 0;
            <c:forEach var="answer" items="${op.answers}">
                if("${answer.member.gender}" === "male")
                    m_cnt++;
                else
                    w_cnt++;
            </c:forEach>
            manData.push(m_cnt);
            womanData.push(w_cnt);
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

        manChart = new Chart(charts_man["${st.index}"], {
            type: 'pie',
            data: {
                labels: label,
                datasets: [{
                    label: "Men",
                    data: manData,
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
        womanChart = new Chart(charts_woman["${st.index}"], {
            type: 'pie',
            data: {
                labels: label,
                datasets: [{
                    label: "Women",
                    data: womanData,
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