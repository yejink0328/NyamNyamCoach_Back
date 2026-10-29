<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<c:set var="ctx" value="${pageContext.request.contextPath}" />

<header class="page-header site-header">
	<div class="header-inner">
		<a class="brand" href="index.jsp"><span class="brand-mark">Y</span><span>냠냠코치</span></a>
		<nav class="main-nav" aria-label="주요 메뉴">
			<a class="nav-link ${menu eq 'home' ? 'active' : ''}" href="${ctx}/">홈</a>
			<a class="nav-link ${menu eq 'diet' ? 'active' : ''}"
				href="${ctx}/dietboard?act=list">식단관리</a> <a
				class="nav-link member-page-link ${menu eq 'mypage' ? 'active' : ''}"
				href="${ctx}/user?act=mypage"">마이페이지</a>
		</nav>
		<div class="header-account">
			<span class="status-dot"></span><span id="headerAuthText"> <c:choose>
					<c:when test="${not empty sessionScope.login}">
						<c:out value="${sessionScope.login.userName}" />님
        </c:when>
					<c:otherwise>
            로그인 전
        </c:otherwise>
				</c:choose>
			</span>
		</div>
	</div>
</header>