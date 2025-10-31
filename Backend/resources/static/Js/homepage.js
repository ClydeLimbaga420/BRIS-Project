
const Menubar = document.getElementById("dropdown");
const MenuDropdown = document.getElementById("menu_dropdown");

Menubar.addEventListener("click", () => {
  if(MenuDropdown.style.display === "none") {
    MenuDropdown.style.display = "block";
  } else {
    MenuDropdown.style.display = "none";
  }
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


