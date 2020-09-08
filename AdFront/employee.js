const url = "http://localhost:8080/project0/"

document.getElementById("listbtn").addEventListener("click", listFunc);
document.getElementById("addbtn").addEventListener("click", addFunc);
document.getElementById("addsubmitbtn").addEventListener("click", addSubmitFunc);

async function listFunc() {
    document.getElementById("list-body").innerText=' ';
    document.getElementById("list-section").style.display = 'block';
    document.getElementById("add-section").style.display = 'none';

    let resp = await fetch(url+"myreimbursements", {
        method: 'GET',
        credentials: "include"
    });

    if(resp.status===200) {
        let data = await resp.json();

       for(let empl of data)
       {
           let row=document.createElement("tr");
           let cell=document.createElement("td");
           cell.innerHTML=empl.reimb_amt;
           row.appendChild(cell);

           let cell2=document.createElement("td");
           cell2.innerHTML=empl.reim_stts.reim_status;
           row.appendChild(cell2);

           let cell3=document.createElement("td");
           cell3.innerHTML=(empl.reim_submtd) ?new Date(empl.reim_submtd).toDateString() :"";
           row.appendChild(cell3);

           let cell4=document.createElement("td");
           cell4.innerHTML=(empl.reim_resolvd) ?new Date(empl.reim_resolvd).toDateString() :"";
           row.appendChild(cell4);

           let cell5=document.createElement("td");
           cell5.innerHTML=empl.reim_typId.reim_tp;
           row.appendChild(cell5);

           document.getElementById("list-body").appendChild(row);
       }
     }
    else console.log(' --- err ---')
}
    

async function addFunc() {
    document.getElementById("list-section").style.display = 'none';
    document.getElementById("add-section").style.display = 'block';
}

async function addSubmitFunc() {
    let sAmount = document.getElementById("amount").value;
    let sType = document.getElementById("type").value;
    let sDesc = document.getElementById("description").value;

    let ticket = {
        amt : sAmount,
        rType : sType,
        description : sDesc
    }

    let resp = await fetch(url + "addticket", {
        method: 'POST',
        body: JSON.stringify(ticket),
        credentials: "include"
    })

    if(resp.status === 201){
        alert("Your ticket is submitted successfully!");
    } else {
        alert("Error submitting your ticket");
    }

}