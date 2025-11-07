const loginForm = document.getElementById("loginForm");
const gmail = document.getElementById("gmail");
const password = document.getElementById("password");

gmail.addEventListener("focus", () => gmail.placeholder = "");
password.addEventListener("focus", () => password.placeholder = "");

gmail.addEventListener("blur", () => {
    if (gmail.value === "") gmail.placeholder = "Enter your gmail account";
});

password.addEventListener("blur", () => {
    if (password.value === "") password.placeholder = "Enter your password";
});

loginForm.addEventListener("submit", (event) => {
    if (gmail.value.trim() === "" || password.value.trim() === "") {
        event.preventDefault();
        alert("Please fill in both gmail account and password");
    }
});
