<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
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


	<div class="wrapper">
		<div class="icon_title">投稿一覧</div>
		<div class="blog_all">
		<c:forEach items="${blogAll}" var="blogAll" varStatus="status">
		<ul class="blog_list">
			<li><c:out value="${blogAll.dateString}" />投稿　
				<a href="/blog?index=${status.index}&judg=all">
				<c:out value="${blogAll.title}" /></a></li>
		</ul>
		</c:forEach>
		</div>

		<footer>
			<a href="blog_form">ミニブログ投稿フォームへ</a>
			<hr class="katorari">
		</footer>
	</div>

</body>
</html>