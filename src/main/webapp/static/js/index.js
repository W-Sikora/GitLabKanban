const signInTab = document.getElementById("signInTab");
const registerTab = document.getElementById("registerTab");
const signIn = document.getElementById("signIn");
const register = document.getElementById("register");

signIn.style.display = "inline";
register.style.display = "none";

signInTab.addEventListener("click", () => {
    signInTab.className = "is-active";
    registerTab.className = "";
    signIn.style.display = "inline";
    register.style.display = "none";
});

registerTab.addEventListener("click", () => {
    registerTab.className = "is-active";
    signInTab.className = "";
    register.style.display = "inline";
    signIn.style.display = "none";
});
