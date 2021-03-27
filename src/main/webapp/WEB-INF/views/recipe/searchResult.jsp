<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>はらぺこレシピ レシピ検索・一覧</title>
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
				<li class="hd_menu"><a href="recipeList" class="active">レシピ</a></li>
				<li class="hd_menu"><a href="blog_form" class="rest">ミニブログ</a></li>
				<li class="hd_menu"><a href="blogOther" class="rest">みんなの投稿</a></li>
				<li class="hd_menu mypage" id="accordion"><a href="mypage"
					class="rest">マイページ</a>
			</ul>
		</nav>
	</div>

<div class="wrapper">

 <div class="search_result">検索結果</div>
 <h3>${word} ${nullMessage} ${message}</h3>
 	<br>
 		<div class="recipeSearchResult">
		<c:forEach items="${recipeResult}" var="result" varStatus="status">
		<ul class="recipe_list">
			<li>
				<a href="/recipe?recipe_id=${result.recipe_id}&menu=${result.menu_name}" class="sub_item">
				<c:out value="${result.menu_name}" /></a></li>
		</ul>
		</c:forEach>
		</div>
<footer>
	<a href="recipeList">レシピ一覧ページに戻る</a>
 <hr class="katorari">
</footer>
</div>

</body>
</html>