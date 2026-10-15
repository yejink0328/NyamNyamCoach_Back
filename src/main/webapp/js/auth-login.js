import { getCurrentUser } from "./auth-adapter.js";

if (getCurrentUser()) {
  location.replace("../meal.html");
}

document.querySelector("#quickLoginForm").addEventListener("submit", (event) => {
  event.preventDefault();

  const id = document.querySelector("#quickLoginId").value.trim();
  const password = document.querySelector("#quickLoginPassword").value;
  const errorElement = document.querySelector("#quickLoginError");

  const users = JSON.parse(localStorage.getItem("users")) || [];

  const foundUser = users.find((user) =>
    user.id === id && user.password === password
  );

  if (!foundUser) {
    errorElement.textContent = "아이디 또는 비밀번호가 올바르지 않습니다.";
    return;
  }

  // 비밀번호는 저장하지 않고 식단 화면에서 필요한 최소 정보만 저장합니다.
  localStorage.setItem("currentUser", JSON.stringify({
    id: foundUser.id,
    name:  foundUser.name,
  }));

  location.href = "../meal.html";
});
