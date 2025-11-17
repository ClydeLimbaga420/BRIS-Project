let residentsList = [];

async function loadResidents() {
  try {
    const response = await fetch("/api/residents");
    residentsList = await response.json();
    renderResidents(residentsList);
  } catch (error) {
    console.error("Error fetching residents:", error);
  }
}

function renderResidents(residentsData) {
  const boxInfo = document.querySelector('.residentsList');
  boxInfo.innerHTML = '';

  if (!residentsData || residentsData.length === 0) {
    boxInfo.innerHTML = '<p style="text-align:center;">No residents found.</p>';
    return;
  }

  residentsData.forEach(resident => {
    const info = document.createElement('div');
    info.classList.add('residentsInfo');

    info.addEventListener("click", () => {
      window.location.href = `/residentsinfo?id=${resident.id}`;
    });

    const name = document.createElement('div');
    name.classList.add('residentsName');
    name.textContent = `${resident.firstName} ${resident.lastName}`;

    const sitio = document.createElement('div');
    sitio.classList.add('residentsSitio');
    sitio.textContent = `Sitio: ${resident.sitio} - Age: ${resident.age ?? 'N/A'}`;

    const idDiv = document.createElement('div');
    idDiv.classList.add('residentsId');
    idDiv.textContent = `ID: ${resident.id}`;

    const infoLeft = document.createElement('div');
    infoLeft.append(name, sitio);

    info.append(infoLeft, idDiv);
    boxInfo.append(info);
  });
}

function searchResidents() {
  const query = document.querySelector('.search').value.trim().toLowerCase();

  if (query === "") {
    renderResidents(residentsList);
    return;
  }

  const filtered = residentsList.filter(resident =>
    `${resident.firstName} ${resident.lastName} ${resident.sitio} ${resident.age} ${resident.condition}` .toLowerCase().includes(query)

  );

  renderResidents(filtered);
}

async function refreshResidentById(id) {
  try {
    const response = await fetch(`/api/residents/${id}`);
    if (!response.ok) return;

    const updatedResident = await response.json();
    const index = residentsList.findIndex(r => r.id === updatedResident.id);

    if (index !== -1) {
      residentsList[index] = updatedResident;
    } else {
      residentsList.push(updatedResident);
    }

    renderResidents(residentsList);
  } catch (error) {
    console.error("Error refreshing resident:", error);
  }
}

window.addEventListener('DOMContentLoaded', () => {
  const searchInput = document.querySelector('.search');
  const searchButton = document.querySelector('.serbot');

  searchInput.addEventListener('input', searchResidents);
  searchButton.addEventListener('click', searchResidents);

  loadResidents();
});
