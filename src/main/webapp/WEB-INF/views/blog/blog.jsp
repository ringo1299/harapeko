<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>はらぺこレシピ ミニブログ 投稿されたページ</title>
<link rel="stylesheet" href="/css/harapeko.css">
<link rel="shortcut icon" href="/images/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="/js/harapeko.js"></script>

</head>
<body>
<div id="header">
<img src="/images/logo.png">
 <nav id="menu_navi">
  <ul class="clearfix hd_bs">
   <li class="hd_menu">
   <a href="top" class="rest">トップ</a></li>
   <li class="hd_menu">
   <a href="recipeList" class="rest">レシピ</a></li>
   <li class="hd_menu">
   <a href="blog_form" class="active">ミニブログ</a></li>
   <li class="hd_menu">
   <a href="blogOther" class="rest">みんなの投稿</a></li>
    <li class="hd_menu mypage">
     <a href="mypage" class="rest">マイページ</a></li>
  </ul>
  </nav>
</div>

<div class="wrapper">
 <div class="container">

<div class="blog_contents clearfix">
<h3>${message }</h3>
<p>${blogData.dateString } 投稿</p>
<h1>${blogData.title }</h1>
<img src="/images/no_image.png" class="blog_img">
<p class="blog_main">${blogData.body }</p>
</div>

<div id="like_js">
この記事が気に入ったらLIKE！してね<br>
 <button class="like_button" id="likeButton" value="${blogData.id}"><span class="font_js">♡LIKE！ </span></button>
 <span id="outputLike"> ${blogData.likeButton }</span>
 </div>
</div>
<footer>
<a href="blogList">投稿一覧に戻る</a>
<br>
<a href="blog_form">投稿ページに戻る</a>
 <hr class="katorari">
</footer>
</div>
</body>
</html>
