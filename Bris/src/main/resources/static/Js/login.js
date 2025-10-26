const inputForm = document.getElementById("login");
const usernameInput = document.getElementById("username");
const passwordInput = document.getElementById("password");

// Placeholder handling
usernameInput.addEventListener("focus", () => usernameInput.placeholder = "");
passwordInput.addEventListener("focus", () => passwordInput.placeholder = "");

usernameInput.addEventListener("blur", () => {
    if (usernameInput.value === "") usernameInput.placeholder = "Enter your username";
});

passwordInput.addEventListener("blur", () => {
    if (passwordInput.value === "") passwordInput.placeholder = "Enter your password";
});
