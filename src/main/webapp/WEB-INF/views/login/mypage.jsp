<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>はらぺこレシピ マイページ</title>
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
				<li class="hd_menu"><a href="blogOther" class="rest">みんなの投稿</a></li>
				<li class="hd_menu mypage" class="accordion"><a href="" class="active"  id="accordion">マイページ</a>
					<ul class="contents">
						<li class="mypage_menu"><a href="/edit">登録情報編集</a></li>
						<li class="mypage_menu"><a href="/logout">ログアウト</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>

	<div class="wrapper">

		<div class="mypage_layout">
			<h1 class="mypage_title">
				<img src="/images/nabe.png" class="nabe"><span>${user.nickname }</span>さんのマイページ
			</h1>
			<div class="clearfix">
				<img src="/images/ryouri_neko.png" class="mypage_icon">
				<ul class="mypage_log">
					<li class="border">ニックネーム：<span>${user.nickname }</span></li>
					<li class="float">ミニブログ数：<span>${blog}</span></li>
					<li class="border">LIKE!数：<span>${like}</span></li>
					<li class="border">一言コメント：<span>${user.message }</span></li>
				</ul>
				<br>
				<a href="/user_edit">ユーザー情報編集</a>
				<br>
				<a href="/logout">ログアウト</a>
			</div>
			<br>
			<hr>

		</div>
		<footer>
			<a href="harapeko_blog.html">投稿フォームへ</a>
			<hr class="katorari">
		</footer>
	</div>
</body>
</html>
