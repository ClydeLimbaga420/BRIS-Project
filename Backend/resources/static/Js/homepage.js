const Menubar = document.getElementById("dropdown");
const MenuDropdown = document.getElementById("menu_dropdown");

Menubar.addEventListener("click", () => {
  MenuDropdown.style.display = MenuDropdown.style.display === "none" ? "block" : "none";
});

const logoutbutton = document.getElementById("logoutbutton");
const logoutconfirm = document.getElementById("logoutconfirm");
const cancel = document.getElementById("cancel");
const logout = document.getElementById("logout");

logoutbutton.addEventListener("click", () => {
  logoutconfirm.style.display = "flex";
});

cancel.addEventListener("click", () => {
  logoutconfirm.style.display = "none";
});

logout.addEventListener("click", () => {
  window.location.href = "/login";
});

window.addEventListener("click", (e) => {
  if (e.target === logoutconfirm) {
    logoutconfirm.style.display = "none";
  }
});

let totalResidents = 0;


async function loadResidentCount() {
  try {
    const response = await fetch("/api/residents");
    const residentsList = await response.json();
    totalResidents = residentsList.length;
    document.getElementById("residentsRecords").textContent = totalResidents;
  } catch (error) {
    console.error("Error:", error);
    document.getElementById("residentsRecords").textContent = 0;
  }
}


document.addEventListener("DOMContentLoaded", () => {
  loadResidentCount();
});

async function loadBlotterCount() {
    try {
        const response = await fetch("/api/blotter");
        const blottersList = await response.json();
        totalBlotters = blottersList.length;

        document.getElementById("blotterRecords").textContent = totalBlotters;
    } catch (error) {
    console.error("Error:", error);
    document.getElementById("blotterRecords").textContent = 0;
    }
}

document.addEventListener("DOMContentLoaded", () => {
loadBlotterCount();
});