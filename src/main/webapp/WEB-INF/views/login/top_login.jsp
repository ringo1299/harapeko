<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<body>
	<!-- 通常のログイン画面と、新規登録完了後のログイン画面での文字の表示を分岐する -->
	<div>
		<c:choose>
		<c:when test="${judg == 100 }">
			<iframe src="insertSuccess" class="iframe_login"></iframe>
		</c:when>
		<c:when test="${judg == -100 }">
			<iframe src="loginFail" class="iframe_login"></iframe>
		</c:when>
		<c:otherwise>
			<iframe src="login" class="iframe_login"></iframe>
		</c:otherwise>
		</c:choose>
	</div>

	<div id="after_login">
		<div id="header">
			<img src="/images/logo.png">
			<nav id="menu_navi">
				<ul class="clearfix hd_bs">
					<li class="hd_menu"><a href="top" class="active">トップ</a></li>
					<li class="hd_menu"><a href="harapeko_recipe.html"
						class="rest">レシピ</a></li>
					<li class="hd_menu"><a href="harapeko_blog.html" class="rest">ミニブログ</a></li>
					<li class="hd_menu"><a href="harapeko_eoblog.html"
						class="rest">みんなの投稿</a></li>
					<li class="hd_menu mypage"><a href="harapeko_mypage.html"
						class="rest">マイページ</a></li>
				</ul>
			</nav>
		</div>

		<div class="top">
			<h1>
				ようこそ<span id="output_message"></span>、はらぺこレシピへ
			</h1>
			<img src="/images/top.jpg" class="topp">
		</div>
		<p>
			このサイトでは様々なレシピを公開しています！<br>
			レシピを検索したり、必要な材料の量を自動で計算したり、料理日記を投稿したり…。<br> はらぺこレシピで料理を楽しみましょう♪
		</p>
		<p>
			レシピを見る→ <a href="harapeko_recipe.html">レシピ</a>
		<p>
			記事を投稿する→ <a href="harapeko_blog.html">ミニブログ</a>
		<p>
			他のユーザーの記事を見る→ <a href="harapeko_eoblog.html">みんなの投稿</a>
		<hr class="katorari">
	</div>
</body>
</html>
