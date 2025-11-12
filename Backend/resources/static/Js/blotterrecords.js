let blottersList = [];

async function loadBlotters() {
  try {
    const response = await fetch("/api/blotter");
    blottersList = await response.json();
    renderBlotters(blottersList);
  } catch (error) {
    console.error("Error fetching blotters:", error);
  }
}

function renderBlotters(blottersData) {
  const boxInfo = document.querySelector('.blottersList');
  boxInfo.innerHTML = '';

  blottersData.forEach(blotter => {
    const info = document.createElement('div');
    info.classList.add('blottersInfo');

    info.addEventListener("click", () => {
      if (blotter.id) {
        window.location.href = `/blotterinfo?id=${blotter.id}`;
      } else {
        console.error("Missing blotter ID:", blotter);
      }
    });

    const details = document.createElement('div');
    details.classList.add('blotterDetails');

    details.innerHTML = `
      <span class="caseNo">Case No. ${blotter.caseNo || "—"}</span>
      <span class="blotterName">${blotter.blotteredFirstName || ""} ${blotter.blotteredLastName || ""}</span>
      <span class="blotterStatus">
        Status: ${blotter.blotterStatus?.status || blotter.blotterStatus || "N/A"}
      </span>
    `;


    info.append(details);
    boxInfo.append(info);
  });
}

const searchInput = document.querySelector('.search');
const searchButton = document.querySelector('.serbot');

searchInput.addEventListener('input', search);
searchButton.addEventListener('click', search);

async function search() {
  const showBlotters = searchInput.value.trim().toLowerCase();

  if (showBlotters === "") {
    loadBlotters();
    return;
  }

  try {
    const url = `/api/blotter/search?name=${encodeURIComponent(showBlotters)}`;
    const response = await fetch(url);
    const data = await response.json();
    renderBlotters(data);
  } catch (error) {
    console.error("ERROR:", error);
  }
}

window.addEventListener('DOMContentLoaded', loadBlotters);
