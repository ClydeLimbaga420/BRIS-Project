const loginForm = document.getElementById("loginForm");
const username = document.getElementById("username");
const password = document.getElementById("password");

username.addEventListener("focus", () => username.placeholder = "");
password.addEventListener("focus", () => password.placeholder = "");

username.addEventListener("blur", () => {
    if (username.value === "") username.placeholder = "Enter your username";
});

password.addEventListener("blur", () => {
    if (password.value === "") password.placeholder = "Enter your password";
});

loginForm.addEventListener("submit", (event) => {
    if (username.value.trim() === "" || password.value.trim() === "") {
        event.preventDefault();
        alert("Please fill in both username and password");
    }
});
