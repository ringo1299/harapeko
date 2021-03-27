<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>はらぺこレシピ</title>
<link rel="stylesheet" href="/css/harapeko.css">
<link rel="shortcut icon" href="/images/favicon.ico">
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.js">
</script>
<script type="text/javascript" src="/js/harapeko.js"></script>
</head>
<body class="back_login">
<form:form id="form1" action="judgLogin" modelAttribute="login">
 <div class="modal js-modal">
        <div class="modal__bg"></div>
        <div class="modal__content">
            <h1>ようこそ！はらぺこレシピへ</h1>
            <p>${loginMessage}</p>
            <form:input path="user_id" placeholder="ユーザーID" pattern="^[0-9A-Za-z]+$" autocomplete="off"/>
            <form:errors path="user_id" cssStyle="color: red"/><br>
            <form:password path="pass" placeholder="パスワード" pattern="^[0-9A-Za-z]+$" autocomplete="off"/>
            <form:errors path="pass" cssStyle="color: red"/><br>
            <form:button>ログイン</form:button><br>
            <a href="new_user" >新規登録はこちら</a>
        </div><!--modal__inner-->
    </div><!--modal-->
</form:form>
</body>
</html>