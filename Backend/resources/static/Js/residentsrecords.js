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


function escapeRegex(text) {
  return text.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
}

function renderResidents(residentsData) {
  const boxInfo = document.querySelector('.residentsList');
  boxInfo.innerHTML = '';

  const query = document.querySelector('.search').value.trim().toLowerCase();
  const safeQuery = escapeRegex(query);


  const highlight = (text) => {
    if (!query || !text) return text || '';
    const regex = new RegExp(`(${safeQuery})`, 'gi');
    return text.replace(regex, "<b style='color:black;'>$1</b>");
  };

  residentsData.forEach(resident => {
    const info = document.createElement('div');
    info.classList.add('residentsInfo');


    info.addEventListener("click", () => {
      window.location.href = `/resident/${resident.id}`;
    });

    const name = document.createElement('div');
    name.classList.add('residentsName');
    name.innerHTML = ` ${highlight(resident.firstName)} ${highlight(resident.lastName)} `;

    const address = document.createElement('div');
    address.classList.add('residentsAddress');
    address.innerHTML = `Sitio: ${highlight(resident.sitio)} - Age: ${resident.age ?? 'N/A'}`;

    const id = document.createElement('div');
    id.classList.add('residentsId');
    id.innerHTML = `Id: ${highlight(resident.id.toString())}`;

    const infoLeft = document.createElement('div');
    infoLeft.append(name, address);

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
