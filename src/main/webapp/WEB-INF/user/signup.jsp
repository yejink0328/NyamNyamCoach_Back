<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 | 냠냠코치</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/meal.css">
</head>
<body class="login-page">

    <main class="login-shell">
        <section class="card login-card">
            <h1>회원가입</h1>

            <p class="error">
                <c:out value="${error}" />
            </p>

            <form action="${pageContext.request.contextPath}/user"
                  method="post">

                <input type="hidden" name="act" value="signup">

                <label for="signupId">아이디</label>
                <input id="signupId"
                       name="Id"
                       type="text"
                       pattern="[A-Za-z0-9_]{4,50}"
                       maxlength="50"
                       autocomplete="username"
                       placeholder="영문, 숫자, 밑줄 4~50자"
                       required>

                <label for="signupPw">비밀번호</label>
                <input id="signupPw"
                       name="Pw"
                       type="password"
                       minlength="8"
                       maxlength="128"
                       autocomplete="new-password"
                       required>

                <label for="confirmPw">비밀번호 확인</label>
                <input id="confirmPw"
                       name="confirmPw"
                       type="password"
                       minlength="8"
                       maxlength="128"
                       autocomplete="new-password"
                       required>

                <label for="name">이름</label>
                <input id="name"
                       name="name"
                       type="text"
                       maxlength="100"
                       required>

                <label for="height">키(cm)</label>
                <input id="height"
                       name="height"
                       type="number"
                       min="1"
                       max="300"
                       step="1"
                       required>

                <label for="weight">몸무게(kg)</label>
                <input id="weight"
                       name="weight"
                       type="number"
                       min="0.1"
                       max="1000"
                       step="0.1"
                       required>

                <button class="button button-primary" type="submit">
                    회원가입
                </button>
            </form>

            <a href="${pageContext.request.contextPath}/">
                홈으로
            </a>
        </section>
    </main>

</body>
</html>