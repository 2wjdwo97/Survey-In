const queryArea = document.querySelector('.query-area');
const menu_bar = document.querySelector('.floating-box-group');

function createQuery() {
    const newDiv = document.createElement("div");
    newDiv.className = "query-box position-relative";

    const deleteButton = document.createElement("button");
    deleteButton.type = "button";
    deleteButton.className = "delete-button top-right-corner position-absolute";
    deleteButton.addEventListener('click', function(){deleteElement(this, queryArea)}, false);

    const newForm = document.createElement("div");
    newForm.className = "query-form";

    const queryTitle = document.createElement("input");
    queryTitle.name = "queryTitle";
    queryTitle.type = "text";
    queryTitle.placeholder = "Question";
    queryTitle.className = "query-title-input text";

    newForm.appendChild(queryTitle);

    const createOptionButton = document.createElement("button");
    createOptionButton.type = "button";
    createOptionButton.className = "create-button";
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
    div.style.marginBottom = "16px";
    div.className = "display-flex";

    const radioBtn = document.createElement("img");
    radioBtn.src = "/images/radioButton.png";
    radioBtn.style.width = "20px";
    radioBtn.style.height = "20px";
    radioBtn.style.marginRight = "8px";
    radioBtn.className = "align-self-center";

    const option = document.createElement("input");
    option.name = "option";
    option.placeholder = "Option";
    option.classList.add("text");
    option.classList.add("option");
    option.type = "text";

    const deleteButton = document.createElement("button");
    deleteButton.type = "button";
    deleteButton.className = "delete-button align-self-center";
    deleteButton.addEventListener('click', function(){deleteElement(this, form)}, false);

    div.appendChild(radioBtn);
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

const createButton = document.querySelector(".create-button");
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


/**
 *  @brief Set input names when user presses the create button
 *  @date 2021-02-17
 *  @return false: error (no question, no option)
 *          true: no error
 *  @param submit event e
 */
function setInputName(e){
    const inputs = document.querySelectorAll("input.text");
    let origNames = [];
    let cnt = -1;
    let opCnt = 0;

    // Save original input name values
    // so that we can recover names when error occurs during the naming process
    for(let input of inputs){
        origNames.push(input.name);
    }

    //Naming process
    //Return false when there's no question or option
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
            input.name = "questions["+cnt+"].title";
        }
        else if(input.name === "option"){
            input.name = "questions["+cnt+"].option";
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
