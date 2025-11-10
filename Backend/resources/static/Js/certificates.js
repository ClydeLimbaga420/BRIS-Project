document.getElementById("backBtn").addEventListener("click", () => {
  window.history.back();
});


document.getElementById("clearanceForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const form = e.target;
  const issueDate = form.querySelector('input[type="date"]').value;
  const certificate = form.querySelector('input[name="clearType"]:checked').nextSibling.textContent.trim();
  const fullname = form.querySelector('input[placeholder="Enter full name"]').value;
  const age = form.querySelector('input[placeholder="Enter age"]').value;
  const sitio = form.querySelector('input[placeholder="Enter address"]').value;
  const purpose = form.querySelector('textarea').value;

  const data = {
    issueDate,
    certificate,
    fullname,
    age,
    sitio,
    purpose
  };

  try {
    const response = await fetch("/api/certificates", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data)
    });

    if (response.ok) {
      alert("Barangay Clearance saved");
      form.reset();
    } else {
      alert("Error");
    }
  } catch (error) {
    console.error(error);
    alert("Failed");
  }
});


document.getElementById("certificateForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const form = e.target;
  const issueDate = form.querySelector('input[type="date"]').value;
  const certificate = form.querySelector('input[name="certType"]:checked').nextSibling.textContent.trim();
  const fullname = form.querySelector('input[placeholder="Enter full name"]').value;
  const age = form.querySelector('input[placeholder="Enter age"]').value;
  const sitio = form.querySelector('input[placeholder="Enter address"]').value;
  const purpose = form.querySelector('textarea').value;

  const data = {
    issueDate,
    certificate,
    fullname,
    age,
    sitio,
    purpose
  };

  try {
    const response = await fetch("/api/certificates", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data)
    });

    if (response.ok) {
      alert("Certificate record saved");
      form.reset();
    } else {
      alert("Error");
    }
  } catch (error) {
    console.error(error);
    alert("Failed");
  }
});
