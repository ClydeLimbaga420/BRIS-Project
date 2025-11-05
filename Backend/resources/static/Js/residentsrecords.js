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

  residentsData.forEach(resident => {
    const info = document.createElement('div');
    info.classList.add('residentsInfo');

    info.addEventListener("click", () => {
      window.location.href = `/resident/${resident.id}`;
    });

    const name = document.createElement('div');
    name.classList.add('residentsName');
    name.textContent = `${resident.firstName} ${resident.lastName}`;

    const sitio = document.createElement('div');
    sitio.classList.add('residentsSitio');
    sitio.textContent = `Sitio: ${resident.sitio} - Age: ${resident.age ?? 'N/A'}`;

    const id = document.createElement('div');
    id.classList.add('residentsId');
    id.textContent = `Id: ${resident.id}`;

    const infoLeft = document.createElement('div');
    infoLeft.append(name, sitio);

    info.append(infoLeft, id);
    boxInfo.append(info);
  });
}

const searchInput = document.querySelector('.search');
const searchButton = document.querySelector('.serbot');

searchInput.addEventListener('input', search);
searchButton.addEventListener('click', search);

async function search() {
  const showResidents = searchInput.value.trim().toLowerCase();

  if (showResidents === "") {
    loadResidents();
    return;
  }

  try {
    const url = `/api/residents/search?name=${encodeURIComponent(showResidents)}`;
    const response = await fetch(url);
    const data = await response.json();
    renderResidents(data);
  } catch (error) {
    console.error("ERROR:", error);
  }
}

window.addEventListener('DOMContentLoaded', loadResidents);
