const searchInput = document.querySelector(".search");
const searchButton = document.querySelector(".serbot");
const residentsListBox = document.querySelector(".residentsList");


function renderResidents(residents) {
  residentsListBox.innerHTML = ""; 

  if (residents.length === 0) {
    residentsListBox.innerHTML = "<p>No residents found.</p>";
    return;
  }

  residents.forEach(resident => {
    const info = document.createElement("div");
    info.classList.add("residentsInfo");

    const name = document.createElement("div");
    name.classList.add("residentsName");
    name.textContent = `${resident.firstName} ${resident.lastName}`;

    const address = document.createElement("div");
    address.classList.add("residentsSitio");
    address.textContent = `Sitio: ${resident.sitio} | Age: ${resident.age}`;

    info.append(name, address);
    residentsListBox.append(info);
  });
}


async function searchResidents() {
  const query = searchInput.value.trim();
  if (query === "") {
    residentsListBox.innerHTML = "<p>Please enter a name to search.</p>";
    return;
  }

  try {
    const response = await fetch(`/api/residents/search?name=${query}`);
    const data = await response.json();
    renderResidents(data);
  } catch (error) {
    console.error("Error fetching residents:", error);
  }
}


searchButton.addEventListener("click", searchResidents);


searchInput.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    searchResidents();
  }
});
