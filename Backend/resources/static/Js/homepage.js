const menuBtn = document.getElementById("menu-btn");
const sidebar = document.getElementById("sidebar");

menuBtn.addEventListener("click", () => {
  sidebar.style.display = sidebar.style.display === "block" ? "none" : "block";
});
