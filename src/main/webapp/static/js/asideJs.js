const aside_div = document.querySelector("aside div");
const aside = document.querySelector("aside");
const content = document.querySelector(".content-box")

window.addEventListener("scroll", () => {
    setAsidePosition();
});

function setAsidePosition(){
    let scroll_position = document.scrollingElement.scrollTop;
    if (scroll_position > 65 && window.innerWidth >= 760) {
        aside_div.style.position = "fixed";
        aside_div.style.top = "35";
    }
    else {
        aside_div.style.position = 'relative';
        aside_div.style.top = "0";
    }
}

function resize(){
    if (window.innerWidth < 760) {
        setAsidePosition();
        aside.classList.add('aside-width-2');
        aside.style.maxWidth = 'none';
        aside.classList.remove('aside-width-1');
        if (content !== null) {
            content.classList.add('content-box-width-2');
            content.classList.remove('content-box-width-1');
        }
    }
    else if (window.innerWidth < 1000) {
        setAsidePosition();
        aside.classList.add('aside-width-1');
        aside.style.maxWidth = 'none';
        aside.classList.remove('aside-width-2');
        if (content !== null) {
            content.classList.add('content-box-width-1');
            content.classList.remove('content-box-width-2');
        }
    }
    else {
        setAsidePosition();
        aside.classList.remove('aside-width-1');
        aside.classList.remove('aside-width-2');

        aside.style.maxWidth = '350px';
        if (content !== null) {
            content.classList.remove('content-box-width-2');
            content.classList.remove('content-box-width-1');
        }
    }
}

window.onresize = resize;

function init(){
    resize();
    setAsidePosition();
}

init();
