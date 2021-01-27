const form = document.querySelector('form');
const confirmImage = document.querySelector('.confirm-icon');
const passwordConfirm = document.querySelector('#pw-confirm');
const password = document.querySelector('#pw');
const passwordConfirmArea = document.querySelector('div.input-area');

passwordConfirm.addEventListener('keyup', toggleImage);
passwordConfirm.addEventListener('focusin', focus);
passwordConfirm.addEventListener('focusout', focus);

password.addEventListener('keyup', toggleImage);
form.addEventListener('submit', validateForm);

function focus(){
    passwordConfirmArea.classList.toggle('focused');
}

function validateForm(e)
{
    const list = document.querySelectorAll('input');
    let pw;
    let pwc;

    for(let inputForm of list) {
        if (inputForm.value === "") {
            e.preventDefault();
            alert(`We need your ${inputForm.placeholder}`);
            return false;
        }
        if (inputForm.name === 'pw'){
            pw = inputForm.value;
        }
        else if (inputForm.name === 'pwc'){
            pwc = inputForm.value;
        }
    }
    if(pw !== pwc) {
        e.preventDefault();
        alert('Check tour password and password confirm');
        return false;
    }
    return true;
}

function toggleImage(){
    if(password.value !== passwordConfirm.value) {
        confirmImage.classList.add("hidden");
    }
    else if(password.value !== ""){
        confirmImage.classList.remove("hidden");
    }
}