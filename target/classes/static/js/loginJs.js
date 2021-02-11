function validateMyForm(e)
{
    if(document.getElementById('id-field').value === "" || document.getElementById('pw-field').value === "")
    {
        e.preventDefault();
        alert("Incorrect ID or Password");
        return false;
    }

    return true;
}
