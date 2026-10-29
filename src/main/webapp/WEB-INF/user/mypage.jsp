<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지 | 냠냠코치</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/meal.css">
</head>
<body>
    <c:set var="menu" value="mypage" scope="request" />
    <c:import url="/WEB-INF/include/header.jsp" />

    <main class="container">
        <section class="card">
            <h1>마이페이지</h1>

            <table>
                <tbody>
                    <tr>
                        <th>아이디</th>
                        <td><c:out value="${user.id}" /></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><c:out value="${user.userName}" /></td>
                    </tr>
                    <tr>
                        <th>키</th>
                        <td><c:out value="${user.userHeight}" /> cm</td>
                    </tr>
                    <tr>
                        <th>몸무게</th>
                        <td><c:out value="${user.userWeight}" /> kg</td>
                    </tr>
                </tbody>
            </table>

            <a class="button button-outline"
               href="${pageContext.request.contextPath}/">
                홈으로
            </a>

            <form action="${pageContext.request.contextPath}/user"
                  method="post">
                <input type="hidden" name="act" value="logout">
                <button class="button button-outline" type="submit">
                    로그아웃
                </button>
            </form>
        </section>
    </main>
</body>
</html>