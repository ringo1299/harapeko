<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>はらぺこレシピ ユーザー情報編集</title>
<link rel="stylesheet" href="/css/harapeko.css">
<link rel="shortcut icon" href="/images/favicon.ico">
<script type="text/javascript" src="/js/harapeko.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.js">

</script>
<script type="text/javascript" src="/js/harapeko.js"></script>
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
</head>
<body>


	<div id="header">
		<img src="/images/logo.png">
		<div class="icon_title">ユーザー情報編集</div>
	</div>
	<form:form action="/edit" modelAttribute="edit">
		<dl>
			<dt>ニックネーム：</dt>
			<dd>
				<form:input path="nickname" autocomplete="off" value="${userData.nickname}" /><form:errors path="nickname" cssStyle="color: red"/>
			</dd>
			<dt>ユーザーID：</dt>
			<dd>
				<form:input path="user_id" placeholder="半角英数字"
					pattern="^[0-9A-Za-z]+$" autocomplete="off" value="${userData.user_id}" />
					<form:errors path="user_id" cssStyle="color: red" /><span style="color: red">${exception }</span>
			</dd>


			<dt>パスワード：</dt>
			<dd>
				<form:input path="pass" placeholder="半角英数字"
					pattern="^[0-9A-Za-z]+$" autocomplete="off" value="${userData.pass}" /><form:errors path="pass" cssStyle="color: red"/>
			</dd>
			<dt>一言メッセージ：</dt>
			<dd>
				<form:input path="message" size="50" autocomplete="off" value="${userData.message}" />
			</dd>
			<dt>アイコン：</dt>
			<dd>
				<input type="file" name="ファイル呼び出し" size="30" />
			</dd>
		</dl>
	<br>
	<form:button >変更</form:button>
	</form:form>
	<br>
	<a href="mypage">マイページに戻る</a>


	<hr class="katorari">
</body>
</html>