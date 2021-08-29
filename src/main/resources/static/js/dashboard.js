function toggleAddEmployeeFormVisibility() {
    const addEmployeeForm = document.getElementById("add-employee-form-dialog");
    const previousDisplay = addEmployeeForm.style.display;

    console.log(`dialog-box previous display: ${previousDisplay}`);

    addEmployeeForm.style.display = (previousDisplay == "block") ? "none" : "block";
    console.log(`dialog-box new display set to: ${addEmployeeForm.style.display}`);
}

// function addUser() {
//     const email = document.getElementById("name").value;
//     const name = document.getElementById("name").value;
//     const jobTitle = document.getElementById("job-title").value;
//     const phone = document.getElementById("phone").value;

//     fetch("/employee/add", {
//         headers: {
//             "Content-Type": "application/json"
//         },
//         method: "post",
//         body: { email, name, jobTitle, phone }
//     })
//         .catch(err => console.log(`Something went wrong: ${err}`))
//         .then(res => {
//             console.log(`Response: ${res}`);
//             window.location = "/";
//         });
// }
