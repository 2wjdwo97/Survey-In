const boxes = document.querySelectorAll('.main-chart');


const chartMan = document.querySelector("#chart-men").getContext('2d');
const chartWoman = document.querySelector("#chart-women").getContext('2d');
const chartAge = document.querySelector("#chart-age").getContext('2d');
const bgc = [
    'rgba(255, 99, 132, 0.7)',
    'rgba(54, 162, 235, 0.7)',
    'rgba(255, 206, 86, 0.7)',
    'rgba(75, 192, 192, 0.7)',
    'rgba(153, 102, 255, 0.7)',
    'rgba(255, 159, 64, 0.7)'
];

let manChart = new Chart(chartMan, {});
let womanChart = new Chart(chartWoman, {});
let ageChart = new Chart(chartAge, {});


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
    let data_10 = [];
    let data_20 = [];
    let data_30 = [];
    let data_40 = [];
    let data_50 = [];

    for(const option of question.option){
        label.push(option.data);
        let cntMan = 0, cntWoman = 0;
        let age_10 = 0, age_20 = 0, age_30 = 0, age_40 = 0, age_50 = 0;
            for(const answer of option.answers){
            const mem = answer.member;
            if(mem.gender === "male")
                cntMan ++;
            else
                cntWoman ++;

            const age = mem.age;
            if(age >= 10 && age < 20)
                age_10 ++;
            else if(age >= 20 && age < 30)
                age_20 ++;
            else if(age >= 30 && age < 40)
                age_30 ++;
            else if(age >= 40 && age < 50)
                age_40 ++;
            else if(age >= 50 && age < 60)
                age_50 ++;
        }
        dataMan.push(cntMan);
        dataWoman.push(cntWoman);
        data_10.push(age_10);
        data_20.push(age_20);
        data_30.push(age_30);
        data_40.push(age_40);
        data_50.push(age_50);
    }

    manChart.destroy();
    womanChart.destroy();
    ageChart.destroy();

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
                    backgroundColor: bgc
                }]
            },
            options: {
                title: {
                    display: true,
                    text: 'Male'
                },
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
                    backgroundColor: bgc
                }]
            },
            options: {
                title: {
                    display: true,
                    text: 'Female'
                },
                legend: {
                    position: 'bottom'
                }
            }
        });
    }

    const dataSets = [];
    for(let index in label) {
        dataSets.push({
            label: label[index],
            backgroundColor: bgc[index],
            data: [data_10[index], data_20[index], data_30[index], data_40[index], data_50[index]],
        });
    }


    ageChart = new Chart(chartAge, {
        type: 'bar',
        data: {
            labels: ['10', '20', '30', '40', '50'],
            datasets: dataSets
        },
        options: {
            responsive: true,
            hoverMode: 'index',
            stacked: false,
            title: {
                display: true,
                text: 'By age group'
            },
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero:true
                        , callback: function (value) {
                            if (0 === value % 1) {
                                return value;
                            }
                        }
                    }
                }]
            },
            legend: {
                position: 'bottom'
            }
        }
    });
}

function sum(arr){
    let sum = 0;
    for(const ele of arr)
        sum += ele;

    return sum;
}