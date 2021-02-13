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
    queryTitle.type = "text";
    queryTitle.placeholder = "Question";
    queryTitle.className = "query-title-input";

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
