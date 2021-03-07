const btns = document.querySelectorAll('button');
const boxes = document.querySelectorAll('.main-chart');
const details = document.querySelectorAll(".detail-chart");

for(let index in btns) {
    const box = boxes[parseInt(index)];
    btns[parseInt(index)].addEventListener("click", function(){
        toggle(box);
        btn_clicked(parseInt(index));
    }, false);
}

function toggle(box) {
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

    if (box.classList.contains('hidden')) {
        box.classList.remove('hidden');
        setTimeout(function () {
            box.classList.remove('visually-hidden');
        }, 10);
    } else {
        box.classList.add('visually-hidden');
        box.addEventListener('transitionend', function(e) {
            box.classList.add('hidden');
        }, {
            capture: false,
            once: true,
            passive: false
        });
    }
}

function btn_clicked(index){
    for(let detail of details){
        if(!detail.classList.contains('hidden') && detail !== details[parseInt(index)]){
            detail.classList.add('hidden');
        }
    }
    if(details[parseInt(index)].classList.contains('hidden')) {
        details[parseInt(index)].classList.remove('hidden');
    }
    else{
        details[parseInt(index)].classList.add('hidden');
    }
}