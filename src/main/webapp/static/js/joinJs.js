function validateForm(e)
{
    const list = document.querySelectorAll('input');

    for(let inputForm of list) {
        if (inputForm.value === "") {
            e.preventDefault();
            alert(`We need your ${inputForm.placeholder}`);
            return false;
        }
    }

    return true;
}
