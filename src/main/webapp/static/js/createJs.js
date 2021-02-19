const queryArea = document.querySelector('.query-area');
const menu_bar = document.querySelector('.floating-box');
let cnt = 0;

function createQuery() {
    const constCount = cnt;
    const newDiv = document.createElement("div");
    newDiv.className = "query-box position-relative";

    const deleteButton = document.createElement("input");
    deleteButton.type = "button";
    deleteButton.value = 'X';
    deleteButton.className = "delete-query-button"
    deleteButton.addEventListener('click', function(){deleteElement(this, queryArea)}, false);

    const newForm = document.createElement("div");
    newForm.className = "query-form"

    const queryTitle = document.createElement("input");
    queryTitle.name = "list["+cnt+"].title";
    queryTitle.type = "text";
    queryTitle.placeholder = "Question";
    queryTitle.className = "query-title-input";

    newForm.appendChild(queryTitle);

    const createOptionButton = document.createElement("input");
    createOptionButton.type = "button";
    createOptionButton.value = "+";
    createOptionButton.addEventListener('click', function(){createOption(newForm, constCount)}, false);

    newDiv.appendChild(deleteButton);
    newDiv.appendChild(newForm);
    newDiv.appendChild(createOptionButton);

    queryArea.appendChild(newDiv);
    cnt += 1;
}

function deleteElement(self, parent){
    const element = self.closest("div");
    parent.removeChild(element);
}

function createOption(form, count){
    const div = document.createElement("div");
    const option = document.createElement("input");
    option.name = "list["+count+"].option";
    option.type = "text";

    const deleteButton = document.createElement("input");
    deleteButton.type = "button";
    deleteButton.value = 'X';
    deleteButton.addEventListener('click', function(){deleteElement(this, form)}, false);

    div.appendChild(option);
    div.appendChild(deleteButton);

    form.appendChild(div);
}


window.addEventListener("scroll", () => {
    let scroll_position = document.scrollingElement.scrollTop;
    if (scroll_position > 65)
        menu_bar.style.top = String(scroll_position-15);
    else
        menu_bar.style.top = '50';
});

const createButton = document.querySelector("#create-button");
createButton.addEventListener("click", createQuery);

function validForm(e)
{
    const list = document.querySelectorAll('input');
    for(let inputForm of list) {
        if (inputForm.name !=="q" && inputForm.value === "") {
            e.preventDefault();
            alert(`Empty input: ${inputForm.name}`);
            inputForm.focus();
            return false;
        }
        if((inputForm.name === "point" || inputForm.name === "capacity") && !Number.isInteger(Number(inputForm.value))){
            e.preventDefault();
            alert(`Invalid input: ${inputForm.value}`);
            inputForm.focus();
            return false;
        }
    }

    if(cnt === 0){
        e.preventDefault();
        alert("Create your question");
        return false;
    }
    return true;
}