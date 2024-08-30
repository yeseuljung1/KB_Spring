<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>환영합니다.</h1>

<%--로그인이 안된경우 ture 로그아웃 되어 잇는 상태를 말함--%>
<sec:authorize access="isAnonymous()"> <!-- 로그인 안한 경우 -- >
<a href="/security/login">로그인</a>
</sec:authorize>

<%--로그인이 된겅우 true 로그인이 되어있는 상탤를 의미함--%>
<sec:authorize access="isAuthenticated()"> <!-로그인한 경우 -->
<sec:authentication property="principal.username"/>
<form action="/security/logout" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<input type="submit" value="로그아웃"/>
</form>
</sec:authorize>
</body>
</html>
