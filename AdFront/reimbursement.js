const url = "http://localhost:8080/project0/"

document.getElementById("loginbtn").addEventListener("click", loginFunc);

async function loginFunc() {
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username: usern,
        password: userp
    }
    
    let resp = await fetch(url + "login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials: "include"
    })

    if (resp.status === 200) {
        redirectToHomePages()
    } else {
        document.getElementById("login-row").innerText = "Login failed!";
    }
}

async function redirectToHomePages() {

    let resp = await fetch(url+"success", {
        method: 'GET',
        credentials: "include"
    });
console.log(resp)
    if(resp.status===200) {
        let data = await resp.json();
        if (data.usr_rlid.userole === 'empl') window.location.href = 'employee.html';
        else window.location.href = 'manager.html';
    }
    else console.log(' --- err ---')
}
