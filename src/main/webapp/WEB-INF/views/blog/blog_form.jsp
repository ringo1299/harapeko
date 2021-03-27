<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>はらぺこレシピ ミニブログ</title>
<link rel="stylesheet" href="/css/harapeko.css">
<link rel="shortcut icon" href="/images/favicon.ico">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.js">

</script>
<script type="text/javascript" src="/js/harapeko.js"></script>
</head>
<body>
	<div id="header">
		<img src="/images/logo.png">
		<nav id="menu_navi">
			<ul class="clearfix hd_bs">
				<li class="hd_menu"><a href="top" class="rest">トップ</a></li>
				<li class="hd_menu"><a href="recipeList" class="rest">レシピ</a></li>
				<li class="hd_menu"><a href="blog_form" class="active">ミニブログ</a></li>
				<li class="hd_menu"><a href="blogOther" class="rest">みんなの投稿</a></li>
				<li class="hd_menu mypage"><a href="mypage" class="rest">マイページ</a></li>
			</ul>
		</nav>
	</div>

	<div class="blog_new">
		<h1>☆最新投稿☆</h1>
		<c:forEach items="${blogNew}" var="blogNew" varStatus="status">
		<ul class="blog_list">
			<li><c:out value="${blogNew.dateString}" />　<a href="/blog?index=${status.index}&judg=new"><c:out value="${blogNew.title}" /></a></li>
		</ul>
		</c:forEach>
		<a href="blogList" class="blog_catalog">⇒投稿一覧へ</a>
	</div>

	<br>
	<h1>投稿フォーム</h1>
	<form:form action="form" modelAttribute="blog_form">
		<form:input path="title" placeholder="タイトル" size="50" class="blog_title" autocomplete="off" />
		<form:errors path="title" cssStyle="color: red" />
		<br>
		<form:textarea path="body" placeholder="本文" rows="20" cols="100" class="blog_form" autocomplete="off" />
		<br>
		<input type="file" name="ファイル呼び出し" size="30">
		<form:button>投稿</form:button>
	</form:form>

</body>
</html>