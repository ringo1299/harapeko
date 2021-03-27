<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div id="after_login">
		<div id="header">
			<img src="/images/logo.png">
			<nav id="menu_navi">
				<ul class="clearfix hd_bs">
					<li class="hd_menu"><a href="top" class="active">トップ</a></li>
					<li class="hd_menu"><a href="recipeList"
						class="rest">レシピ</a></li>
					<li class="hd_menu"><a href="blog_form" class="rest">ミニブログ</a></li>
					<li class="hd_menu"><a href="blogOther"
						class="rest">みんなの投稿</a></li>
					<li class="hd_menu mypage"><a href="mypage"
						class="rest">マイページ</a></li>
				</ul>
			</nav>
		</div>

		<div class="top">
			<h1>
				ようこそ  <span id="output_message">${userData.nickname }</span>さん、はらぺこレシピへ
			</h1>
			<img src="/images/top.jpg" class="topp">
		</div>
		<p>
			このサイトでは様々なレシピを公開しています！<br>
			レシピを検索したり、必要な材料の量を自動で計算したり、料理日記を投稿したり…。<br> はらぺこレシピで料理を楽しみましょう♪
		</p>
		<br>
		<p>
			レシピを見る→ <a href="recipeList">レシピ</a>
		<p>
			記事を投稿する→ <a href="blog_form">ミニブログ</a>
		<p>
			他のユーザーの記事を見る→ <a href="blogOther">みんなの投稿</a>
		<hr class="katorari">
	</div>
</body>
</html>
