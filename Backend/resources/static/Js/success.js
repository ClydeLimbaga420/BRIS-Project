document.addEventListener("DOMContentLoaded", async () => {
  const params = new URLSearchParams(window.location.search);
  const id = params.get("id");
  if (!id) return;

  try {
    const response = await fetch(`/api/residents/${id}`);
    if (!response.ok) throw new Error("Resident not found");
    const resident = await response.json();


    displayResidentHeaderInfo(resident);


    displayResidentDetails(resident);
  } catch (err) {
    console.error("Error", error);
  }
});


function displayResidentHeaderInfo(resident) {
  const photo = document.getElementById('residentPhoto');
  photo.src = `/api/residents/${resident.id}/photo`;
  photo.onerror = () => (photo.src = '/Img/default-profile.jpg');
  photo.alt = `${resident.firstName ?? ''} ${resident.lastName ?? ''}`;

  const residentsHeader = document.querySelector('.residentHeaderInfo');
  residentsHeader.innerHTML = '';

  const name = document.createElement('div');
  name.classList.add('residentName');
  name.textContent = `${resident.firstName ?? ''} ${resident.middleName ?? ''} ${resident.lastName ?? ''}`.trim();

  const age = document.createElement('div');
  age.classList.add('residentAge');
  age.textContent = `Age: ${resident.age ?? 'N/A'} yrs old`;

  const sitio = document.createElement('div');
  sitio.classList.add('residentSitio');
  sitio.textContent = `Sitio: ${resident.sitio ?? 'N/A'}`;

  residentsHeader.append(name, age);
}


function displayResidentDetails(resident) {
  document.querySelector("#residentSex").textContent = resident.sex ?? "";
  document.querySelector("#residentOccupation").textContent = resident.occupation ?? "";
  document.querySelector("#residentSitio").textContent = resident.sitio ?? "";
  document.querySelector("#residentVoterStatus").textContent = resident.voterstatus ?? "";
  document.querySelector("#residentBirthDate").textContent = resident.birthdate ?? "";
  document.querySelector("#residentCivilStatus").textContent = resident.civilstatus ?? "";
  document.querySelector("#residentHouseholdMembers").textContent = resident.household ?? "";
  document.querySelector("#residentContact").textContent = resident.contactnumber ?? "";
  document.querySelector("#residentBloodType").textContent = resident.bloodtype ?? "";
  document.querySelector("#residentEmail").textContent = resident.email ?? "";
  document.querySelector("#residentEducationalAttainment").textContent = resident.education ?? "";
  document.querySelector("#residentReligion").textContent = resident.religion ?? "";
  document.querySelector("#residentPWD").textContent = resident.pwd ? "Yes" : "No";
  document.querySelector("#residentSuffix").textContent = resident.suffix ?? "";
  document.querySelector("#residentSenior").textContent = resident.senior ? "Yes" : "No";
  document.querySelector("#residentCondition").textContent = resident.condition ?? "";
}