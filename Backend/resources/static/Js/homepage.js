const Menubar = document.getElementById("dropdown");
const MenuDropdown = document.getElementById("menu_dropdown");
const logoutbutton = document.getElementById("logoutbutton");
const logoutconfirm = document.getElementById("logoutconfirm");
const cancel = document.getElementById("cancel");
const logout = document.getElementById("logout");
let totalResidents = 0;
let totalBlotters = 0;
const blockBackNavigation = () => {
    history.pushState(null, "", location.href);
};


document.addEventListener("DOMContentLoaded", () => {
    blockBackNavigation();
    window.addEventListener("popstate", blockBackNavigation);

    loadResidentCount();
    loadBlotterCount();
});
Menubar.addEventListener("click", () => {
  MenuDropdown.style.display = MenuDropdown.style.display === "none" ? "block" : "none";
});
logoutbutton.addEventListener("click", () => {
  logoutconfirm.style.display = "flex";
});

cancel.addEventListener("click", () => {
  logoutconfirm.style.display = "none";
});

logout.addEventListener("click", () => {

  sessionStorage.clear();
  localStorage.clear();
  window.removeEventListener("popstate", blockBackNavigation);


  window.location.href = "/logout";
});


window.addEventListener("click", (e) => {
  if (e.target === logoutconfirm) {
    logoutconfirm.style.display = "none";
  }
});


async function loadResidentCount() {
  try {
    const response = await fetch("/api/residents");
    const residentsList = await response.json();
    totalResidents = residentsList.length;
    document.getElementById("residentsRecords").textContent = totalResidents;
  } catch (error) {
    console.error("Error loading resident count:", error);
    document.getElementById("residentsRecords").textContent = 0;
  }
}

async function loadBlotterCount() {
  try {
    const response = await fetch("/api/blotter");
    const blottersList = await response.json();
    totalBlotters = blottersList.length;
    document.getElementById("blotterRecords").textContent = totalBlotters;
  } catch (error) {
    console.error("Error loading blotter count:", error);
    document.getElementById("blotterRecords").textContent = 0;
  }
}


window.addEventListener("pageshow", function (event) {
  if (event.persisted) {

    window.location.replace("/login");
  }
});


document.addEventListener("keydown", function (e) {
  if ((e.ctrlKey && (e.key === 'z' || e.key === 'y')) ||
      (e.metaKey && (e.key === 'z' || e.key === 'y'))) {
    e.preventDefault();
  }
});