const USERS_KEY = "users";
const CURRENT_USER_KEY = "currentUser";

function getUsers() {
  const savedUsers = localStorage.getItem(USERS_KEY);
  return savedUsers ? JSON.parse(savedUsers) : [];
}

document.querySelector("#SignupForm").addEventListener("submit", (event) => {
  event.preventDefault();

  const id = document.querySelector("#SignupId").value.trim();
  const password = document.querySelector("#SignupPassword").value;
  const passwordConfirm = document.querySelector("#SignupPasswordConfirm").value;
  const name = document.querySelector("#name").value.trim();
  const errorElement = document.querySelector("#SignupError");

  if (password !== passwordConfirm) {
    errorElement.textContent = "비밀번호가 일치하지 않습니다.";
    return;
  }

  const users = getUsers();
  const alreadyExists = users.some((user) => user.id === id);

  if (alreadyExists) {
    errorElement.textContent = "이미 사용 중인 아이디입니다.";
    return;
  }

  const newUser = {
    id,
    password,
    name,
    status: "active",
  };

  users.push(newUser);
  localStorage.setItem(USERS_KEY, JSON.stringify(users));

  // 자동 로그인 정책이라면 아래 두 줄을 사용해요.
  localStorage.setItem(CURRENT_USER_KEY, JSON.stringify({ id, name }));
  location.href = "../meal.html";
});
