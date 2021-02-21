const filterTar = document.querySelector('#filter-target');
const filterOrd = document.querySelector(`#filter-order`);
const filterCat = document.querySelector('#filter-category');
const filterAge = document.querySelector('#filter-age');
const filterGen = document.querySelector(`#filter-gender`)
const inputKeyword = document.querySelector('#search-hidden-input');


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
    filterTar.addEventListener('change', moveUrl);
    filterOrd.addEventListener('change', moveUrl);
    filterCat.addEventListener('change', moveUrl);
    filterAge.addEventListener('change', moveUrl);
    filterGen.addEventListener('change', moveUrl);
}


function moveUrl() {
    let target = filterTar.options[filterTar.selectedIndex].value;
    let order = filterOrd.options[filterOrd.selectedIndex].value;
    let category = filterCat.options[filterCat.selectedIndex].value;
    let age = filterAge.options[filterAge.selectedIndex].value;
    let gender = filterGen.options[filterGen.selectedIndex].value;

    location.href = makeUrl(target, order, category, age, gender);
}


function makeUrl(target, order, category, age, gender) {
    const URLSearch = new URLSearchParams(location.search);

    URLSearch.set("q", inputKeyword.value);
    URLSearch.set("page", 1);       //TODO
    URLSearch.set("tar", target);
    URLSearch.set("ord", order)
    URLSearch.set("cat", category);
    URLSearch.set("age", age);
    URLSearch.set("gen", gender);

    return `./search?${URLSearch}`;
}

init();
