<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>냠냠코치</title>
  <link rel="stylesheet" href="./css/meal.css">
</head>
<body class="main-page">
  <header class="page-header site-header">
    <div class="header-inner">
      <a class="brand" href="./index.html"><span class="brand-mark">Y</span><span>냠냠코치</span></a>
      <nav class="main-nav" aria-label="주요 메뉴">
        <a class="nav-link active" href="./index.html">홈</a>
        <a class="nav-link" href="dietboard?act=list">식단관리</a>
        <a class="nav-link member-page-link" href="./mypage.html">마이페이지</a>
      </nav>
      <div class="header-account"><span class="status-dot"></span><span id="headerAuthText">로그인 전</span></div>
    </div>
  </header>

  <section class="home-heading">
    <div><p class="eyebrow dark">HEALTHY DAILY ROUTINE</p><h1 id="homeTitle">오늘도 맛있는 식사, 냠냠코치와 함께</h1><p id="homeDescription">추천 메뉴를 둘러보고 로그인하여 오늘의 식단을 기록해 보세요.</p></div>
  </section>

  <main class="container dashboard-grid">
    <aside class="card recommendation-panel">
      <p class="eyebrow dark">RECOMMENDATION</p>
      <h2>추천 식단</h2>
      <div id="recommendationList"></div>
    </aside>

    <aside class="welcome-card hidden">
      <span class="welcome-badge">오늘의 코치</span>
      <h2><span id="welcomeUserName">회원</span>님,<br>반갑습니다!</h2>
      <p>꾸준한 기록이 건강한 변화를 만들어요.</p>
      <dl class="welcome-stats">
        <div><dt>오늘 기록</dt><dd id="todayMealCount">0개</dd></div>
        <div><dt>평균 별점</dt><dd id="todayRating">0.0</dd></div>
      </dl>
      <a class="button welcome-button" href="./meal.html?create=1">식단 기록하기</a>
    </aside>

    <section class="card today-panel">
      <div class="controls">
        <div>
          <p class="eyebrow dark">TODAY</p>
          <h2>오늘 하루 식단</h2>
        </div>
        <a id="writeMealLink" class="button button-primary auth-only hidden" href="./meal.html?create=1">+ 식단 작성</a>
      </div>

      <div id="guestMealMessage" class="empty-state">
        <div class="empty-icon">⌁</div>
        <h3>내 식단 기록을 로그인 후 확인해요</h3>
        <p>아침·점심·저녁 식단을 기록하고 영양 정보를 관리할 수 있어요.</p>
      </div>
      <div id="todayMeals" class="meal-summary-list auth-only hidden"></div>
      <a class="button button-outline auth-only hidden" href="./meal.html">전체 식단 관리</a>
    </section>

    <aside class="card account-panel">
      <div id="guestAccount">
        <p class="eyebrow dark">ACCOUNT</p>
        <form id="quickLoginForm" class="quick-login-form">
          <label for="quickLoginId">아이디</label>
          <input id="quickLoginId" value="1111" required>
          <label for="quickLoginPassword">비밀번호</label>
          <input id="quickLoginPassword" type="password" value="1111" required>
          <p id="quickLoginError" class="error"></p>
          <button class="button button-primary" type="submit">로그인</button>
        </form>
        <a class="button button-outline account-link" href="./signup.html">회원가입</a>
      </div>
      <div id="userAccount" class="hidden">
        <div class="profile-avatar">Y</div>
        <p class="eyebrow dark">MY COACH</p>
        <h2><span id="currentUserName">회원</span>님</h2>
        <div class="goal-box"><span>오늘의 목표</span><strong>균형 잡힌 세 끼 기록</strong><div class="goal-progress"><i></i></div></div>
        <a class="button button-outline account-link" href="./mypage.html">마이페이지</a>
        <button id="logoutBridgeBtn" class="button button-outline" type="button">로그아웃</button>
      </div>
    </aside>
  </main>

  <footer class="site-footer"><strong>냠냠코치</strong><span>건강한 하루를 만드는 가장 쉬운 습관</span><span>© 2026 NyamNyam Coach</span></footer>

  <script type="module" src="./js/main-page.js"></script>
  <script type="module" src="./js/auth-login.js"></script>

</body>
</html>
