<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<header class="page-header site-header">
    <div class="header-inner">
      <a class="brand" href="./index.html"><span class="brand-mark">Y</span><span>냠냠코치</span></a>
      <nav class="main-nav" aria-label="주요 메뉴">
        <a class="nav-link active" href="${pageContext.request.contextPath}">홈</a>
        <a class="nav-link" href="dietboard?act=list">식단관리</a>
        <a class="nav-link member-page-link" href="./mypage.html">마이페이지</a>
      </nav>
      <div class="header-account"><span class="status-dot"></span><span id="headerAuthText">로그인 전</span></div>
    </div>
  </header>