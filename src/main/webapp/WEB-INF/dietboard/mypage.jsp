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
	
	
	<c:import url="/WEB-INF/include/footer.jsp" />
	
	<script type="module" src="./js/main-page.js"></script>
</body>
</html>