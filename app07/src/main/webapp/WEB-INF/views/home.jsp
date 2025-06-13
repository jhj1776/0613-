<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>KH</title>
        </head>

        <body>
            <%@ include file="/WEB-INF/views/common/header.jsp" %>

                <main>
                    <h1>원메선</h1>
                    <c:if test="${not empty loginMember}">
                        <h2>${loginMember.userNick}님 환영합니다</h2>
                        <a href="member/logout">로그아웃</a>
                    </c:if>
                    <c:if test="${empty loginMember}">
                        <h2>게하</h2>
                        <a href="/member/join">회원가입</a>
                        <br>
                        <a href="/member/login">로그인</a>
                    </c:if>

                </main>

                <%@ include file="/WEB-INF/views/common/footer.jsp" %>
        </body>

        </html>