<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>임시 로그인 - 냠냠코치</title>
  <link rel="stylesheet" href="./css/meal.css">
</head>
<body class="login-page">
  <header class="page-header site-header">
    <div class="header-inner">
      <a class="brand" href="./index.html"><span class="brand-mark">Y</span><span>냠냠코치</span></a>
    </div>
  </header>

  <main class="login-shell">
    <section class="card login-card">
      <p class="eyebrow dark">SIGN UP</p>
      <h1>회원가입</h1>
      <p class="muted">냠냠코치를 이용하기 위해 회원가입 해주세요.</p>


      <form id="SignupForm">

          <label for="SignupId">아이디</label>
          <input
          id="SignupId"
          placeholder="사용할 아이디를 입력하세요"
          autocomplete="username" required>

          <label for="SignupPassword">비밀번호</label>
          <input 
            id="SignupPassword" 
            type="password" 
            placeholder="사용할 비밀번호를 입력하세요"
            autocomplete="current-password" required>
          
          <label for="SignupPasswordConfirm">비밀번호 확인</label>
          <input 
            id="SignupPasswordConfirm" 
            type="password" 
            placeholder="비밀번호를 다시 입력하세요"
            autocomplete="current-password" required>


        <label for="name">이름</label>
        <input
          id="name"
          name="name"
          type="text"
          placeholder="이름을 입력하세요"
          required
        />

        <label for="height">키(cm)</label>
        <input
          id="height"
          name="height"
          type="number"
          min="1"
          placeholder="예: 170"
          required
        />
        
        <label for="weight">몸무게(kg)</label>
        <input
          id="weight"
          name="weight"
          type="number"
          min="1"
          step="0.1"
          placeholder="예: 65.5"
          required
        />

        <label for="disease">질환 또는 건강 유의사항</label>
        <input
          id="disease"
          name="disease"
          type="text"
          placeholder="없으면 '없음'이라고 입력하세요"
        />

        <p id="SingupError" class="error" aria-live="polite"></p>
        <button class="button button-primary login-signup-submit" type="submit">회원가입</button>
      </form>
    </section>
  </main>

  <script type="module" src="./js/auth-signup.js"></script>
</body>
</html>
    