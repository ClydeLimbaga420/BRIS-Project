const searchInput = document.querySelector(".search");
const searchButton = document.querySelector(".serbot");
const residentsListBox = document.querySelector(".residentsList");

function renderResidents(residents) {
  residentsListBox.innerHTML = "";

  if (residents.length === 0) {
    residentsListBox.innerHTML = "<p>No residents found.</p>";
    return;
  }

  const query = searchInput.value.trim().toLowerCase();


  const highlight = (text) => {
    if (!text) return "";
    const regex = new RegExp(`(${query})`, "gi");
    return text.replace(regex, "<b style='color: black;'>$1</b>");
  };

  residents.forEach(resident => {
    const info = document.createElement("div");
    info.classList.add("residentsInfo");

    const name = document.createElement("div");
    name.classList.add("residentsName");
    name.innerHTML = `Id: ${resident.id}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${highlight(resident.firstName)} ${highlight(resident.lastName)}`;

    const sitio = document.createElement("div");
    sitio.classList.add("residentsSitio");
    sitio.innerHTML = `Sitio: ${highlight(resident.sitio)} | Age: ${resident.age}`;

    info.append(name, sitio);
    residentsListBox.append(info);
  });
}

async function searchResidents() {
  const query = searchInput.value.trim();
  if (query === "") {
    residentsListBox.innerHTML = "<p>Enter a name to search.</p>";
    return;
  }

  try {
    const response = await fetch(`/api/residents/search?name=${query}`);
    const data = await response.json();
    renderResidents(data);
  } catch (error) {
    console.error("Error:", error);
  }
}

searchButton.addEventListener("click", searchResidents);

searchInput.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    searchResidents();
  }
});
