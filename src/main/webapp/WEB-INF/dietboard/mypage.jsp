<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/include/head.jsp" />
<body>
	<c:import url="/WEB-INF/include/header.jsp" />
	
	<section class="page-title-band">
    <div class="page-title-row">
      <div><p class="eyebrow dark">My page</p><h1>MyPage</h1><p>내 기록과 정보를 확인하세요.</p></div>
      <button id="openCreateBtn" class="button button-primary" type="button">정보 수정하기</button>
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
	
    <table>
		<tr>
			<th>식단ID</th>
			<th>메뉴</th>
			<th>칼로리</th>
			<th>탄수화물</th>
			<th>단백질</th>
			<th>지방</th>			
		</tr>
		
		<c:forEach items="${list}" var="diet">
			<tr>
				<td>${diet.dietId}</td>
				<td>${diet.dietMenu}</td>
				<td>${diet.dietKcal}</td>
				<td>${diet.dietCarbs}</td>
				<td>${diet.dietProtein}</td>
				<td>${diet.dietFat}</td>				
			</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<tr>
				<td colspan="6"> 등록 게시물 없음</td> 
			</tr>
		</c:if>
	</table>
    
    </main>
	<c:import url="/WEB-INF/include/footer.jsp" />
	
</body>
</html>