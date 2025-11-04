const searchInput = document.querySelector(".search");
const searchButton = document.querySelector(".serbot");
const residentsListBox = document.querySelector(".residentsList");

function escapeRegex(text) {
  return text.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
}

function renderResidents(residents) {
  residentsListBox.innerHTML = "";

  if (residents.length === 0) {
    residentsListBox.innerHTML = "<p>No residents found.</p>";
    return;
  }

  const query = searchInput.value.trim().toLowerCase();
  const safeQuery = escapeRegex(query);

  const highlight = (text) => {
    if (!query || !text) return text || "";
    const regex = new RegExp(`(${safeQuery})`, "gi");
    return text.replace(regex, "<b style='color: black;'>$1</b>");
  };

  residents.forEach((resident) => {
    const info = document.createElement("div");
    info.classList.add("residentsInfo");

    const name = document.createElement("div");
    name.classList.add("residentsName");
    name.innerHTML = `ID: ${highlight(resident.id.toString())}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${highlight(resident.firstName)} ${highlight(resident.lastName)}`;

    const sitio = document.createElement("div");
    sitio.classList.add("residentsSitio");
    sitio.innerHTML = `Sitio: ${highlight(resident.sitio)} | Age: ${resident.age}`;

    info.style.cursor = "pointer";
    info.addEventListener("click", () => {
      window.location.href = `/resident/${resident.id}`;
    });

    info.append(name, sitio);
    residentsListBox.append(info);
  });
}

async function fetchResidents(query = "") {
  let url = "/api/residents";
  if (query) {
    url = `/api/residents/search?name=${encodeURIComponent(query)}`;
  }

  try {
    const response = await fetch(url);
    const data = await response.json();
    renderResidents(data);
  } catch (error) {
    console.error("Error:", error);
  }
}


searchButton.addEventListener("click", () => {
  const query = searchInput.value.trim();
  fetchResidents(query);
});

searchInput.addEventListener("input", (e) => {
  const query = e.target.value.trim();
  if (query === "") {
    fetchResidents();
  }
});

searchInput.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    fetchResidents(searchInput.value.trim());
  }
});

window.addEventListener("DOMContentLoaded", () => {
  fetchResidents();
});
