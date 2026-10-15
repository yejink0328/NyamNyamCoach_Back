import { getAllMeals } from "./meal-service.js";
import { getCurrentUser, getDisplayName, logoutBridge } from "./auth-adapter.js";

const recommendations = [
  { name: "닭가슴살 현미 비빔밥", kcal: 520, tag: "고단백" },
  { name: "연어 샐러드", kcal: 430, tag: "오메가3" },
  { name: "두부 채소 볶음", kcal: 380, tag: "균형식" },
];

function localToday() {
  const now = new Date();
  return new Date(now.getTime() - now.getTimezoneOffset() * 60000).toISOString().slice(0, 10);
}

function renderRecommendations() {
  document.querySelector("#recommendationList").innerHTML = recommendations.map((food) => `
    <article class="recommendation-item">
      <span class="food-tag">${food.tag}</span>
      <strong>${food.name}</strong>
      <small>${food.kcal} kcal</small>
    </article>
  `).join("");
}

function renderTodayMeals() {
  const meals = getAllMeals().filter((meal) => meal.date === localToday());
  const container = document.querySelector("#todayMeals");
  container.innerHTML = meals.length ? meals.map((meal) => `
    <a class="today-meal-item" href="./meal.html?id=${encodeURIComponent(meal.id)}">
      <span><strong>${meal.mealType}</strong> · ${meal.foodName}</span>
      <span>${meal.nutrition.calories} kcal</span>
    </a>
  `).join("") : `<div class="empty-state"><p>오늘 등록한 식단이 없습니다.</p></div>`;

  const ratings = meals.filter((meal) => meal.rating > 0).map((meal) => meal.rating);
  document.querySelector("#todayMealCount").textContent = `${meals.length}개`;
  document.querySelector("#todayRating").textContent = ratings.length
    ? (ratings.reduce((sum, rating) => sum + rating, 0) / ratings.length).toFixed(1)
    : "0.0";
}

function renderAuthState() {
  const user = getCurrentUser();
  const loggedIn = Boolean(user);
  document.querySelector("#guestAccount").classList.toggle("hidden", loggedIn);
  document.querySelector("#userAccount").classList.toggle("hidden", !loggedIn);
  document.querySelector("#guestMealMessage").classList.toggle("hidden", loggedIn);
  document.querySelectorAll(".auth-only").forEach((element) => element.classList.toggle("hidden", !loggedIn));
  document.querySelectorAll(".guest-only").forEach((element) => element.classList.toggle("hidden", loggedIn));
  document.querySelector("#headerAuthText").textContent = loggedIn ? `${getDisplayName(user)}님` : "로그인 전";
  if (loggedIn) {
    const displayName = getDisplayName(user);
    document.querySelector("#currentUserName").textContent = displayName;
    document.querySelector("#welcomeUserName").textContent = displayName;
    document.querySelector("#homeTitle").textContent = "김냠냠님, 오늘도 균형 잡힌 하루 보내요".replace("김냠냠", displayName);
    document.querySelector("#homeDescription").textContent = "오늘의 식단 기록과 영양 균형을 한눈에 확인하세요.";
    renderTodayMeals();
  }
}

document.querySelector("#quickLoginForm").addEventListener("submit", (event) => {
  event.preventDefault();
  const id = document.querySelector("#quickLoginId").value.trim();
  const password = document.querySelector("#quickLoginPassword").value;
  if (id !== "test" || password !== "1234") {
    document.querySelector("#quickLoginError").textContent = "아이디 또는 비밀번호를 확인해 주세요.";
    return;
  }
  localStorage.setItem("currentUser", JSON.stringify({ id: "test", name: "테스트회원" }));
  renderAuthState();
});

document.querySelector("#logoutBridgeBtn").addEventListener("click", () => {
  logoutBridge();
  renderAuthState();
});

window.addEventListener("storage", renderAuthState);
window.addEventListener("nyamnyam:auth-changed", renderAuthState);
renderRecommendations();
renderAuthState();
