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

		<h3>レシピ検索</h3>
		<form action="/search" method="get">
			<input type="radio" name="way" value="title" checked>料理名から探す
			<input type="radio" name="way" value="foodstuff">食材名から探す
			<br>
			<input name="keyword">
			<button>検索</button>
		</form>
		<br>

		<h3>レシピ一覧</h3>
		<ul class="menu">
			<li class="menu__item"><a
				class="menu__item__link js-menu__item__link" href="">肉料理（クリックで開く）</a>
				<ul class="submenu clearfix">
					<c:forEach items="${recipeList1}" var="list1" varStatus="status">
						<li class="submenu__item"><a
							href="/recipe?recipe_id=${list1.recipe_id}&menu=${list1.menu_name}" class="sub_item"><c:out
									value="${list1.menu_name}" /></a></li>
					</c:forEach>
				</ul></li>
		</ul>

		<ul class="menu">
			<li class="menu__item"><a
				class="menu__item__link js-menu__item__link" href="">野菜料理（クリックで開く）</a>
				<ul class="submenu clearfix">
					<c:forEach items="${recipeList2}" var="list2" varStatus="status">
						<li class="submenu__item"><a
							href="/recipe?recipe_id=${list2.recipe_id}&menu=${list2.menu_name}" class="sub_item"><c:out
									value="${list2.menu_name}" /></a></li>
					</c:forEach>
				</ul></li>
		</ul>

		<ul class="menu">
			<li class="menu__item"><a
				class="menu__item__link js-menu__item__link" href="">魚料理（クリックで開く）</a>
				<ul class="submenu clearfix">
					<c:forEach items="${recipeList3}" var="list3" varStatus="status">
						<li class="submenu__item"><a
							href="/recipe?recipe_id=${list3.recipe_id}&menu=${list3.menu_name}" class="sub_item"><c:out
									value="${list3.menu_name}" /></a></li>
					</c:forEach>
				</ul></li>
		</ul>

		<footer>
			<a href="/top">トップに戻る</a>
			<hr class="katorari">
		</footer>
	</div>
</body>
</html>