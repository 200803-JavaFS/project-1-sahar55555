const url = "http://localhost:8080/project0/"

document.getElementById("listbtn").addEventListener("click", listFunc);
document.getElementById("listallbtn").addEventListener("click", listAllFunc);
document.getElementById("approvebtn").addEventListener("click", approveFunc);
document.getElementById("denybtn").addEventListener("click", denyFunc);

async function listFunc() {
    document.getElementById("list-body").innerText=' ';
    document.getElementById("list-section").style.display = 'block';
    document.getElementById("listall-section").style.display = 'none';

    let resp = await fetch(url+"getPending", {
        method: 'GET',
        credentials: "include"
    });

    if(resp.status===200) {
        let data = await resp.json();
    
       for(let reim of data)
       {console.log(reim)
           let row=document.createElement("tr");

           let cell=document.createElement("td");
           cell.innerHTML=reim.reimb_id;
           row.appendChild(cell);

           let cell1=document.createElement("td");
           cell1.innerHTML=reim.reim_athr.usr_fname + " " + reim.reim_athr.usr_lname;
           row.appendChild(cell1);

           let cell2=document.createElement("td");
           cell2.innerHTML=reim.reimb_amt;
           row.appendChild(cell2);

           let cell3=document.createElement("td");
           cell3.innerHTML=new Date(reim.reim_submtd).toDateString();
           row.appendChild(cell3);

           let cell4=document.createElement("td");
           cell4.innerHTML=reim.reim_typId.reim_tp;
           row.appendChild(cell4);

           let cell5=document.createElement("td");
           cell5.innerHTML=reim.reim_desc;
           row.appendChild(cell5);

           document.getElementById("list-body").appendChild(row);
       }
     }
    else console.log(' --- err ---')
}
    
async function approveFunc() {
    let ticket = {
        id : document.getElementById("reimb_id").value,
        rStatus : "Approved"
    }
    let resp = await fetch(url+"updatestatus", {
        method: 'POST',
        body: JSON.stringify(ticket),
        credentials: "include"
    });

    console.log(resp);
    if(resp.status===201) {
        alert("Reimbursement status updated")
    }
    else{
        alert("Error updating: "+resp.status)
    }
}
    
async function denyFunc() {
    let ticket = {
        id : document.getElementById("reimb_id").value,
        rStatus : "Denied"
    }
    let resp = await fetch(url+"updatestatus", {
        method: 'POST',
        body: JSON.stringify(ticket),
        credentials: "include"
    });

    console.log(resp);
    if(resp.status===201) {
        alert("Reimbursement status updated")
    }
    else{
        alert("Error updating: "+resp.status)
    }
}
    
async function listAllFunc() {
    document.getElementById("listall-body").innerText=' ';
    document.getElementById("listall-section").style.display = 'block';
    document.getElementById("list-section").style.display = 'none';

    let resp = await fetch(url+"reimbursemnets", {
        method: 'GET',
        credentials: "include"
    });

    console.log(resp)

    if(resp.status===200) {
        let data = await resp.json();

        for(let reim of data)
       {
            let row=document.createElement("tr");
            let cell0=document.createElement("td");
            cell0.innerHTML=reim.reim_athr.usr_fname + " " + reim.reim_athr.usr_lname;
            row.appendChild(cell0);

           let cell=document.createElement("td");
           cell.innerHTML=reim.reimb_amt;
           row.appendChild(cell);

           let cell2=document.createElement("td");
           cell2.innerHTML=reim.reim_stts.reim_status;
           row.appendChild(cell2);

           let cell3=document.createElement("td");
           cell3.innerHTML=(reim.reim_submtd) ?new Date(reim.reim_submtd).toDateString() :'';
           row.appendChild(cell3);

           let cell4=document.createElement("td");
           cell4.innerHTML=(reim.reim_resolvd) ?new Date(reim.reim_resolvd).toDateString() :'';
           row.appendChild(cell4);

           let cell5=document.createElement("td");
           cell5.innerHTML=reim.reim_typId.reim_tp;
           row.appendChild(cell5);

           document.getElementById("listall-body").appendChild(row);
       }
     }
    else console.log(' --- err ---')
}
    
