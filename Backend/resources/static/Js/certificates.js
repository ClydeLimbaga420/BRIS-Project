document.getElementById("backBtn").addEventListener("click", () => {
  window.history.back();
});

document.getElementById("clearanceForm").addEventListener("submit", (e) => {
  e.preventDefault();
  alert("Viewing Barangay Clearance Form...");
});

document.getElementById("certificateForm").addEventListener("submit", (e) => {
  e.preventDefault();
  alert("Viewing Certificate Form...");
});