<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html: charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<%--모델에서 받아온 exception의 메시지를 출력--%>
<h4><c:out value="${exception.getMessage()}"></c:out></h4>

<ul>
<%--    exception의 stacktrace를 돌면서 stack이란 이름으로 가져와서 하났기 출력하겠다--%>
    <c:forEach items="${exception.getStackTrace()}" var="stack">
        <li><c:out value="${stack}"></c:out></li>
    </c:forEach>
</ul>
</body>
</html>
