function deleteSurvey(e) {
    e.preventDefault();

    let isDelete = confirm("FOR SURE?");
    if (isDelete) {
        e.currentTarget.submit();
        // location.reload();
    }
}