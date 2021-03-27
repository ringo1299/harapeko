<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>はらぺこレシピ</title>
<link rel="stylesheet" href="/css/harapeko.css">
<link rel="shortcut icon" href="/images/favicon.ico">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
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
				<li class="hd_menu mypage" id="accordion"><a href=""
					class="rest">マイページ</a>
			</ul>
		</nav>
	</div>

	<div class="wrapper">

<form action="/reipe_insert">
	材料名：<input name="foodstuff"><br>
	分量：<input name="quantity_num"><br>
	<select name="unit">
		<c:forEach items="${unitList}" var="unit">
			<option value="${unit.unit_id}"><c:out value="${unit.unit}" /></option>
		</c:forEach>
	</select>
	<button>登録</button>
</form>


		<footer>
			<a href="recipeList">レシピ一覧に戻る</a>
			<hr class="katorari">
		</footer>
	</div>
</body>
</html>
