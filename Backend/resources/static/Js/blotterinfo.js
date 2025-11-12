const recordIdUrl = new URLSearchParams(window.location.search);
const recordId = recordIdUrl.get('id');

async function filterId(record) {
  try {
    const response = await fetch(`/api/blotter/${record}`);
    if (!response.ok) throw new Error('Record not found');
    const blotterRecord = await response.json();
    renderInfo(blotterRecord);
  } catch(error) {
    console.error(error);
    alert("Record Not Found");
    if(document.referrer){
      history.back();
    } else {
      window.location.href="blotterrecords";
    }
  }
}

function renderInfo(record) {
  const complianantNameParts = [record.complainantFirstName, record.complainantMiddleName, record.complainantLastName].filter(Boolean);
  const respondentNameParts = [record.blotteredFirstName, record.blotteredMiddleName, record.blotteredLastName].filter(Boolean);

  const info = {
    caseNum: record.caseNo,
    dateFiled: record.dateOfComplain,
    complianant: complianantNameParts.join(' '),
    respondent: respondentNameParts.join(' '),
    officerInCharge: record.officerInCharge,
    status: record.blotterStatus,
    caseDescription: record.statementOfComplain,
    complianantAge: record.complainantAge,
    complianantContact: record.complainantContact,
    complianantAddress: record.complainantAddress,
    respondentAge: record.complainedAge || record.blotteredAge,
    respondentContact: record.complainedContact || record.blotteredContact,
    respondentAddress: record.complainedAddress || record.blotteredAddress,
    locationIncident: record.locationOfIncidence,
    actionTaken: record.actionTaken,
  };

  Object.entries(info).forEach(([id, value]) => {
    const element = document.getElementById(id);
    if (element) element.textContent = value || "—";
  });

  const statusEl = document.getElementById('status');
  let statusValue = record.blotterStatus ? record.blotterStatus.trim().toLowerCase() : "";
  statusEl.classList.remove("pending", "resolved", "ongoing");
  if (statusValue === "pending") statusEl.classList.add("pending");
  if (statusValue === "resolved") statusEl.classList.add("resolved");
  if (statusValue === "active") statusEl.classList.add("active");

  const viewMore = document.getElementById('viewMore');
  const back = document.getElementById('back');
  const box1 = document.getElementById('box1');
  const box2 = document.getElementById('box2');

  viewMore.addEventListener('click', () => {
    box1.style.display = "none";
    box2.style.display = "block";
  });

  back.addEventListener('click', () => {
    box2.style.display = "none";
    box1.style.display = "block";
  });

  const markButtons = document.querySelectorAll(".mark");
  markButtons.forEach(markSettledBtn => {
    markSettledBtn.addEventListener("click", async () => {
      const confirmAction = confirm("Mark this case as resolved?");
      if (!confirmAction) return;
      try {
        const response = await fetch(`/api/blotter/${recordId}/status`, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({ status: "Resolved" })
        });
        if(!response.ok) throw new Error("Failed to update record");

        const updated = await response.json();


        let updatedStatus = updated.blotterStatus || updated.status;
        if (typeof updatedStatus === "object" && updatedStatus !== null) {
          updatedStatus = updatedStatus.status;
        }
        updatedStatus = updatedStatus.trim();

        statusEl.textContent = updatedStatus;

        statusEl.classList.remove("pending", "active", "resolved");
        if (updatedStatus.toLowerCase() === "pending") statusEl.classList.add("pending");
        if (updatedStatus.toLowerCase() === "resolved") statusEl.classList.add("resolved");
        if (updatedStatus.toLowerCase() === "active") statusEl.classList.add("active");

        alert("Case marked as resolved");
      } catch (error) {
        console.error(error);
        alert("Error");
      }
    });
  });

  const backb = document.getElementById("backb");
  backb.addEventListener('click', () => {
    if(document.referrer){
      history.back();
    } else {
      window.location.href = "/blotterrecords";
    }
  });

  const backc = document.querySelector('.back');
  backc.addEventListener('click', () => {
    if(document.referrer){
      history.back();
    } else {
      window.location.href = "/blotterrecords";
    }
  });
}

filterId(recordId);
