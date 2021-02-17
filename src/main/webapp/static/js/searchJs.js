const filterTarget = document.querySelector('#filter-target');
const filterCat = document.querySelector('#filter-category');
const filterAge = document.querySelector('#filter-age');
const inputKeyword = document.querySelector('#search-hidden-input');


function makeUrl(target, category, age) {
    let keyword = inputKeyword.value;
    let page = 1;   //TODO

    return `./search?q=${keyword}&p=${page}&tar=${target}&cat=${category}&age=${age}`;
}

function moveUrlByTarget() {
    let category = filterCat.options[filterCat.selectedIndex].value;
    let age = filterAge.options[filterAge.selectedIndex].value;

    location.href = makeUrl(this.value, category, age);
}

function moveUrlByCat() {
    let target = filterTarget.options[filterTarget.selectedIndex].value;
    let age = filterAge.options[filterAge.selectedIndex].value;

    location.href = makeUrl(target, this.value, age);
}

function moveUrlByAge() {
    let target = filterTarget.options[filterTarget.selectedIndex].value;
    let category = filterCat.options[filterCat.selectedIndex].value;

    location.href = makeUrl(target, category, this.value);
}


function init() {
    const searchInput = document.querySelector('#search-input');
    searchInput.value = document.querySelector('#search-hidden-input').value;

    filterTarget.addEventListener('change', moveUrlByTarget);
    filterCat.addEventListener('change', moveUrlByCat);
    filterAge.addEventListener('change', moveUrlByAge);
}

init();
