function checkUserId() {
    if (localStorage.getItem("check_login")) {
        localStorage.setItem("userid", 0);
    }
    console.log(localStorage.getItem("userid"));
}
window.onload = checkUserId;


async function login(username, password) {
    event.preventDefault();

    if (!validateForm()) {
        return;
    }

    const res = await (await fetch(`http://localhost:8080/login?username=${username}&password=${password}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
    })).json();

    if (res == 0) {
        document.getElementById("loginalert").innerHTML="the username or password is incorrect"
        document.getElementById("loginalert").style.display = "block";
    } else {
        const permission = await (await fetch(`http://localhost:8080/getperms?id=${res}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })).json();
        localStorage.setItem("check_login", true)
        localStorage.setItem("userid", res);
        if(permission == 1){
            localStorage.setItem("permission", 1);
            location.replace("astronomer");
        }else{
            localStorage.setItem("permission", 2);
            location.replace("observer");
        }
    }
}

async function register() {
    event.preventDefault();

    if (!validateForm()) {
        return;
    }

    username = document.getElementById("username").value
    password = document.getElementById("password").value
    accountname = document.getElementById("accountname").value
    permission = document.getElementById("permission").value
    
    const data = {
        userUsername: username,
        userPassword: password,
        userAccountName: accountname,
        userPermission: permission
    };
      
    const res = await (await fetch(`http://localhost:8080/adduser`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify(data)
    })).json();

    if (res == 0) {
        document.getElementById("loginalert").className = "alert alert-danger"
        document.getElementById("loginalert").innerHTML="The username is already used"
        document.getElementById("loginalert").style.display = "block";
    } else {
        document.getElementById("loginalert").className = "alert alert-success"
        document.getElementById("loginalert").innerHTML = "your account has been created successfully"
        document.getElementById("loginalert").style.display = "block";
    }
}

function validateForm() {
    const inputs = document.getElementsByTagName('input');
    const selects = document.getElementsByTagName('select');
    let valid = true;
  
    for (let i = 0; i < inputs.length; i++) {
      if (inputs[i].value.trim() === '') {
        inputs[i].style.borderColor = 'red';
        valid = false;
      } else {
        inputs[i].style.borderColor = 'black';
      }
    }
  
    for (let i = 0; i < selects.length; i++) {
      if (selects[i].value.trim() === '') {
        selects[i].style.borderColor = 'red';
        valid = false;
      } else {
        selects[i].style.borderColor = 'black';
      }
    }
  
    return valid;
  }

async function logout() {
    localStorage.setItem("check_login", false)
    localStorage.setItem("userid", 0);
    location.replace("Login.html");
}