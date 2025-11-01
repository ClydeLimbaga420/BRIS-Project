function goBack() {
  window.history.back();
}

document.getElementById("reportForm").addEventListener("submit", function (e) {
  e.preventDefault();



  const reportData = {
    case_no: caseNumber,
    complainant:
      document.getElementById("c_fname").value +
      " " +
      document.getElementById("c_mname").value +
      " " +
      document.getElementById("c_lname").value,
    respondent:
      document.getElementById("r_fname").value +
      " " +
      document.getElementById("r_mname").value +
      " " +
      document.getElementById("r_lname").value,
    case_desc: document.getElementById("case_desc").value,
    date_complain: document.getElementById("date_complain").value,
    status: document.getElementById("status").value,
    officer: document.getElementById("officer").value,
    location: document.getElementById("location").value,
    action_taken: document.getElementById("action_taken").value,
  };

  let reports = JSON.parse(localStorage.getItem("reports") || "[]");
  reports.push(reportData);
  localStorage.setItem("reports", JSON.stringify(reports));

  alert("Report added successfully!");
  window.location.href = "report-list.html";
});
