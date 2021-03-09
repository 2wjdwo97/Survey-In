const boxes = document.querySelectorAll('.main-chart');


const chartMan = document.querySelector("#chart-men").getContext('2d');
const chartWoman = document.querySelector("#chart-women").getContext('2d');

let manChart = new Chart(chartMan, {
    type: 'pie',
    data: {
        labels: [],
        datasets: [{
            label: "# of Votes",
            data: [],
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
let womanChart = new Chart(chartMan, {
    type: 'pie',
    data: {
        labels: [],
        datasets: [{
            label: "# of Votes",
            data: [],
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


function btn_clicked(questionId, index){
    toggle(index);
    showDetail(questionId);
}

function toggle(index) {
    for(let b of boxes){
        if (!b.classList.contains('hidden')) {
            b.classList.add('visually-hidden');
            b.addEventListener('transitionend', function (e) {
                b.classList.add('hidden');
            }, {
                capture: false,
                once: true,
                passive: false
            });
        }
    }

    boxes[index].classList.remove('hidden');
    setTimeout(function () {
        boxes[index].classList.remove('visually-hidden');
    }, 10);
}

function showDetail(questionId){
    let question;
    $.ajax({
        url: "detail",
        type: "get", //send it through get method
        async : false,
        data: {
            questionId: questionId,
        },
        success: function(response) {
            question = response;
        },
        error:function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });

    let label = [];
    let dataMan = [];
    let dataWoman = [];

    for(const option of question.option){
        label.push(option.data);
        let cntMan = 0, cntWoman = 0;
        for(const answer of option.answers){
            if(answer.member.gender === "male")
                cntMan ++;
            else
                cntWoman ++;
        }
        dataMan.push(cntMan);
        dataWoman.push(cntWoman);
    }

    manChart.destroy();
    womanChart.destroy();

    if(sum(dataMan) === 0) {
        chartMan.font = "10px Arial";
        chartMan.fillText("No data", 10, 50);
    }
    else {
        manChart = new Chart(chartMan, {
            type: 'pie',
            data: {
                labels: label,
                datasets: [{
                    label: "# of Votes",
                    data: dataMan,
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
    }
    if(sum(dataWoman) === 0) {
        chartWoman.font = "10px Arial";
        chartWoman.fillText("No data", 10, 50);
    }
    else {
        womanChart = new Chart(chartWoman, {
            type: 'pie',
            data: {
                labels: label,
                datasets: [{
                    label: "# of Votes",
                    data: dataWoman,
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
    }
}

function sum(arr){
    let sum = 0;
    for(const ele of arr)
        sum += ele;

    return sum;
}