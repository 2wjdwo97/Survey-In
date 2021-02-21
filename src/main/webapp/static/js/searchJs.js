const filterTarget = document.querySelector('#filter-target');
const filterCat = document.querySelector('#filter-category');
const filterAge = document.querySelector('#filter-age');
const inputKeyword = document.querySelector('#search-hidden-input');


function makeUrl(target, category, age) {
    const URLSearch = new URLSearchParams(location.search);

    URLSearch.set("q", inputKeyword.value);
    URLSearch.set("page", 1);       //TODO
    URLSearch.set("tar", target);
    URLSearch.set("cat", category);
    URLSearch.set("age", age);

    return `./search?${URLSearch}`;
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
    // 검색칸에 검색했던 단어 넣기
    const searchInput = document.querySelector('#search-input');
    searchInput.value = document.querySelector('#search-hidden-input').value;


    // 검색 필터 유지
    const searchForm = document.querySelector('#form-search-input');
    searchForm.addEventListener('submit', function (event) {

        const URLSearch = new URLSearchParams(location.search);

        URLSearch.delete("q");
        URLSearch.forEach(function (value, key) {
            let hiddenField = document.createElement('input');
            hiddenField.setAttribute('type', 'hidden');
            hiddenField.setAttribute('name', key);
            hiddenField.setAttribute('value', value);
            searchForm.appendChild(hiddenField);
        });
        searchForm.submit();
    });


    // 필터 변경 시 url 이동
    filterTarget.addEventListener('change', moveUrlByTarget);
    filterCat.addEventListener('change', moveUrlByCat);
    filterAge.addEventListener('change', moveUrlByAge);
}

init();
