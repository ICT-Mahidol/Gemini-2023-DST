fetch("http://localhost:8080/scienceplans?id="+localStorage.getItem("userid"))
  .then((response) => response.json())
  .then((data) => {
    const tableBody = document.querySelector("#table-body");
    data.forEach((plan) => {
      const row = document.createElement("tr");
      row.innerHTML = `
      <td>${plan.planNo}</td>
      <td>${plan.creator}</td>
      <td>${plan.fundingInUSD}</td>
      <td>${plan.starSystem}</td>
      <td>${plan.startDate}</td>
      <td>${plan.endDate}</td>
      <td>${plan.telescopeLocation}</td>
      <td>${plan.status}</td>
      
    `;
      tableBody.appendChild(row);
    });
  });

  function checkUserId() {
    if (localStorage.getItem("userid")==0) {
      location.replace("/");
    }
    if (localStorage.getItem("permission")==2) {
      location.replace("/observer");
    }
    console.log(localStorage.getItem("userid"));
  }
  
  window.onload = checkUserId;


async function logout() {
  localStorage.setItem("check_login", false);
  localStorage.setItem("userid", 0);
  location.replace("/");
}
