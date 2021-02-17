const queryArea = document.querySelector('.query-area');
const menu_bar = document.querySelector('.floating-box');

function createQuery() {
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
    queryTitle.name = "queryTitle";
    queryTitle.type = "text";
    queryTitle.placeholder = "Question";
    queryTitle.className = "query-title-input";
    queryTitle.classList.add("text");

    newForm.appendChild(queryTitle);

    const createOptionButton = document.createElement("input");
    createOptionButton.type = "button";
    createOptionButton.value = "+";
    createOptionButton.addEventListener('click', function(){createOption(newForm)}, false);

    newDiv.appendChild(deleteButton);
    newDiv.appendChild(newForm);
    newDiv.appendChild(createOptionButton);

    queryArea.appendChild(newDiv);
}

function deleteElement(self, parent){
    const element = self.closest("div");
    parent.removeChild(element);
}

function createOption(form){
    const div = document.createElement("div");
    const option = document.createElement("input");
    option.name = "option";
    option.classList.add("text");
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

function checkValid(e) {
    e.preventDefault();
    const list = document.querySelectorAll('input');
    for(let inputForm of list) {
        if (inputForm.name !=="q" && inputForm.value === "") {
            alert(`Empty input: ${inputForm.name}`);
            inputForm.focus();
            return false;
        }
        if((inputForm.name === "point" || inputForm.name === "capacity") && !Number.isInteger(Number(inputForm.value))){
            alert(`Invalid input: ${inputForm.value}`);
            inputForm.focus();
            return false;
        }
    }
    if(setInputName(e)) {
        e.currentTarget.submit();
        return true;
    }
    return false;
}

function setInputName(e){
    const inputs = document.querySelectorAll("input.text");

    let origNames = [];
    for(let input of inputs){
        origNames.push(input.name);
    }

    let cnt = -1;
    let opCnt = 0;

    for(let input of inputs){
        if(input.name === "queryTitle"){
            if(opCnt === -1){
                alert("Create at least one option");
                for(let index in inputs){
                    inputs[index].name = origNames[index];
                }
                return false;
            }
            opCnt = -1;
            ++cnt;
            input.name = "list["+cnt+"].title";
        }
        else if(input.name === "option"){
            input.name = "list["+cnt+"].option";
            ++opCnt;
        }
    }

    if(opCnt === -1){
        alert("Create at least one option");
        for(let index in inputs){
            inputs[index].name = origNames[index];
        }
        return false;
    }

    if(cnt === -1){
        alert("Create at least one question");
        for(let index in inputs){
            inputs[index].name = origNames[index];
        }
        return false;
    }
    return true;
}
