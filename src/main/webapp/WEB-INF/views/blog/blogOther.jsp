<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>はらぺこレシピ みんなの投稿</title>
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
				<li class="hd_menu"><a href="blog_form" class="rest">ミニブログ</a></li>
				<li class="hd_menu"><a href="blogOther"
					class="active">みんなの投稿</a></li>
				<li class="hd_menu mypage"><a href="mypage" class="rest">マイページ</a></li>
			</ul>
		</nav>
	</div>

	<div class="wrapper">

		<div class="icon_title">
			最新投稿
			<p class="title_side">みんなの投稿が新しい順に並びます</p>
		</div>
		<c:forEach items="${blogOtherNewList}" var="blogOther" varStatus="status">
		<ul class="new_blog">
			<li class="blog_list"><c:out value="${blogOther.dateString}" /> <c:out value="${blogOther.nickname}" />さん投稿　　
			<a class="title" href="/blog?index=${status.index}&judg=newOther"><c:out value="${blogOther.title}" /></a></li>
		</ul>
		</c:forEach>

		<div class="icon_title">
			人気の投稿
			<p class="title_side">LIKE！の多い投稿が並びます</p>
		</div>
		<c:forEach items="${blogLikeList}" var="blogLike" varStatus="status">
		<ul class="like_blog">
			<li><c:out value="${blogLike.dateString}" /> <c:out value="${blogLike.nickname}" />さん投稿　　<span class="likeColor"><c:out value="${blogLike.likeButton }" />LIKE!</span>　　
			<a class="title2" href="/blog?index=${status.index}&judg=like"><c:out value="${blogLike.title}" /></a>　
			</li>
		</ul>
		</c:forEach>


		<footer>
			<hr class="katorari">
		</footer>

	</div>

</body>
</html>
