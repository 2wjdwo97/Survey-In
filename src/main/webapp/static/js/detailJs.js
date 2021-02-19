const btns = document.querySelectorAll('button');
const boxes = document.querySelectorAll('.main-chart');


for(let index in btns) {
    const box = boxes[parseInt(index)];
    btns[parseInt(index)].addEventListener("click", function(){
        toggle(box);
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