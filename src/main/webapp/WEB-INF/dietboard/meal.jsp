<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>냠냠코치 - 식단 정보 관리</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/meal.css">
</head>
<body class="meal-management-page">

	<c:import url="/WEB-INF/include/header.jsp" />

  <section class="page-title-band">
    <div class="page-title-row">
      <div><p class="eyebrow dark">MEAL MANAGEMENT</p><h1>내 식단 기록 관리</h1><p>기록을 검색하고 상세 영양 정보를 확인하세요.</p></div>
      <button id="openCreateBtn" class="button button-primary" type="button">+ 새 식단 작성</button>
    </div>
  </section>

  <main class="container">
    <section class="card controls" aria-labelledby="listTitle">
      <div>
        <h2 id="listTitle">전체 식단 목록</h2>
        <p id="recordCount" class="muted">총 0건</p>
      </div>
      <div class="filter-group search-group">
        <label for="mealSearch">ID·음식 검색</label>
        <input id="mealSearch" type="search" placeholder="식단 ID 또는 음식명">
        <label for="dateFilter">날짜 필터</label>
        <input id="dateFilter" type="date">
        <button id="searchBtn" class="button button-primary" type="button">검색</button>
        <button id="clearFilterBtn" class="button button-outline" type="button">전체 목록</button>
      </div>
    </section>

    <section class="card analysis" aria-labelledby="analysisTitle">
      <div class="analysis-title-row">
        <div>
          <p class="eyebrow dark">NUTRITION ANALYSIS</p>
          <h2 id="analysisTitle">전체 식단 영양 분석</h2>
          <p id="analysisScope" class="muted">전체 기록 기준</p>
        </div>
        <strong id="nutritionScore" class="score">내 평균 0 / 5</strong>
      </div>
      <div id="nutritionSummary" class="nutrition-grid"></div>
      <p class="notice">영양소 합계와 사용자가 직접 입력한 식단 별점의 평균을 표시합니다.</p>
    </section>

    <section class="card table-card" aria-label="식단 목록">
      <div class="table-scroll">
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>날짜</th>
              <th>끼니</th>
              <th>음식</th>
              <th>수량</th>
              <th>열량</th>
              <th>관리</th>
            </tr>
          </thead>
          <tbody id="mealTableBody"></tbody>
        </table>
      </div>
      <div id="emptyState" class="empty-state hidden">
        <p>등록된 식단이 없습니다.</p>
        <button id="emptyCreateBtn" class="button button-primary" type="button">첫 식단 작성</button>
      </div>
    </section>
  </main>

	<c:import url="/WEB-INF/include/footer.jsp" />

  <dialog id="mealFormDialog">
    <form id="mealForm">
      <input id="mealId" type="hidden">
      <div class="dialog-heading">
        <h2 id="formTitle">식단 작성</h2>
        <button id="closeFormIconBtn" class="icon-button" type="button" aria-label="닫기">×</button>
      </div>

      <p class="form-description">섭취한 음식과 수량을 입력하면 영양정보가 자동으로 계산됩니다.</p>
      <div class="meal-form-grid">
        <div class="field-group">
          <label for="mealDate">날짜 <span aria-hidden="true">*</span></label>
          <input id="mealDate" type="date" required>
        </div>
        <div class="field-group">
          <label for="mealType">끼니 <span aria-hidden="true">*</span></label>
          <select id="mealType" required>
            <option value="">끼니 선택</option><option value="아침">아침</option><option value="점심">점심</option><option value="저녁">저녁</option><option value="간식">간식</option>
          </select>
        </div>
        <div class="field-group">
          <label for="foodName">음식 <span aria-hidden="true">*</span></label>
          <select id="foodName" required><option value="">음식 선택</option></select>
        </div>
        <div class="field-group">
          <label for="quantity">수량 <small>(1 = 1인분)</small></label>
          <input id="quantity" type="number" min="0.5" step="0.5" value="1" required>
        </div>
        <div class="field-group field-full">
          <label for="mealMemo">메모</label>
          <textarea id="mealMemo" rows="3" maxlength="200" placeholder="식단 메모를 입력하세요."></textarea>
        </div>
      </div>

      <fieldset class="rating-fieldset rating-card">
        <legend>식단 별점 <small>(직접 선택)</small></legend>
        <div class="rating-input" aria-label="식단 별점 선택">
          <input id="rating5" name="mealRating" type="radio" value="5"><label for="rating5" title="5점">★</label>
          <input id="rating4" name="mealRating" type="radio" value="4"><label for="rating4" title="4점">★</label>
          <input id="rating3" name="mealRating" type="radio" value="3"><label for="rating3" title="3점">★</label>
          <input id="rating2" name="mealRating" type="radio" value="2"><label for="rating2" title="2점">★</label>
          <input id="rating1" name="mealRating" type="radio" value="1"><label for="rating1" title="1점">★</label>
        </div>
      </fieldset>

      <p id="formError" class="error" aria-live="polite"></p>
      <div class="dialog-actions">
        <button id="cancelFormBtn" class="button button-outline" type="button">취소</button>
        <button class="button button-primary" type="submit">저장</button>
      </div>
    </form>
  </dialog>

  <dialog id="mealDetailDialog">
    <article>
      <div class="dialog-heading">
        <h2>식단 상세 조회</h2>
        <button id="closeDetailIconBtn" class="icon-button" type="button" aria-label="닫기">×</button>
      </div>
      <dl id="mealDetail" class="detail-list"></dl>
      <div class="dialog-actions">
        <button id="deleteMealBtn" class="button button-danger" type="button">삭제</button>
        <button id="editMealBtn" class="button button-primary" type="button">수정</button>
        <button id="closeDetailBtn" class="button button-outline" type="button">닫기</button>
      </div>
    </article>
  </dialog>

  <div id="toast" class="toast" role="status" aria-live="polite"></div>
  <div id="authRequiredOverlay" class="auth-overlay hidden">
    <div class="card auth-message">
      <h2>로그인이 필요합니다</h2>
      <p>식단 작성·조회·수정·삭제 기능은 로그인 후 이용할 수 있습니다.</p>
      <a class="button button-outline" href="./index.html">메인으로 돌아가기</a>
    </div>
  </div>
  <script type="module" src="${pageContext.request.contextPath}/js/meal-app.js"></script>
</body>
</html>
