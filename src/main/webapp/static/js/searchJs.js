const filterTar = document.querySelector('#filter-target');
const filterOrd = document.querySelector('#filter-order');
const filterCat = document.querySelector('#filter-category');
const filterAge = document.querySelector('#filter-age');
const filterGen = document.querySelector('#filter-gender');
const inputKeyword = document.querySelector('#search-hidden-input');

const pagingPrev = document.getElementById("paging-prev");
const pagingNext = document.getElementById("paging-next");
const pagingCur = document.getElementById("paging-cur");
const pagingOther = document.getElementsByClassName("paging-other");


function init() {

    // 검색칸에 검색했던 단어 넣기
    const searchInput = document.querySelector('.search-input');
    searchInput.value = inputKeyword.value;


    // 검색 필터 유지
    const searchForm = document.querySelector('.form-search-input');
    searchForm.addEventListener('submit', function (event) {

        let URLSearch = new URLSearchParams(location.search);

        URLSearch.delete("q");
        URLSearch.delete("page");
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


    // 페이징 버튼
    if (pagingCur != null) {
        let curPage = pagingCur.innerText;
        pagingPrev.href = makePageURL(curPage - 3);
        for (let pageBtn of pagingOther)
            pageBtn.href = makePageURL(pageBtn.innerText);
        pagingNext.href = makePageURL(String(curPage + 3));
    } else {
        const searchScreen = document.querySelector('#search-list');
        searchScreen.innerHTML = `<ul><li><article>
                                    <div class="survey-header">
                                        <div class="survey-title">
                                            <h3>No results</h3>
                                        </div>
                                    </div>
                                    <div class="survey-body">
                                        <p>
                                            - Check if the word is spelled correctly.</br>
                                            - Try reducing the number of words in your search term or re-searching with more common search terms.</br>
                                            - If it's more than one word, check the spacing.</br>
                                            - Please change the search options and search again.</br>
                                        </p>
                                    </div>
                                </article></li></ul>`;
    }
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
    let URLSearch = new URLSearchParams(location.search);
    URLSearch.set("q", inputKeyword.value);
    URLSearch.delete("page");
    URLSearch.set("tar", target);
    URLSearch.set("ord", order)
    URLSearch.set("cat", category);
    URLSearch.set("age", age);
    URLSearch.set("gen", gender);

    return `./search?${URLSearch}`;
}

function makePageURL(page) {
    let pageURL = new URLSearchParams(location.search);

    if (page <= 0)
        page = 1;
    pageURL.set("page", page);

    return `./search?${pageURL}`;
}

function viewDetail(surveyId, username) {
    let registrantName;
    let data = {};
    data["surveyId"] = surveyId;
    data["username"] = username;

    $.ajax({
        url: `/search/${surveyId}`,
        type: "post",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (response) {
            if (response.canView)
                location.href= `../${response.registrant}/surveys/${surveyId}`;
            else {
                let isClick = confirm("You must participate in the survey to see the results.");
                if (isClick)
                    location.href= `../${response.registrant}/surveys/${surveyId}/answer`;
            }
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}

init();
