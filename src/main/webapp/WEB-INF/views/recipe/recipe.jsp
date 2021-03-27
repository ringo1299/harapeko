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
				<li class="hd_menu mypage" id="accordion"><a href="mypage"
					class="rest">マイページ</a>
			</ul>
		</nav>
	</div>

	<div class="wrapper">

		<div class="recipe_ov clearfix">
			<h2 class="hamburg_title">
				<c:out value="${overview.menu_name}" />
			</h2>
			<hr>
			<img src="/images/no_image.png" class="recipe_img">
			<p>
				<c:out value="${overview.comment}" />
				<br> <span class="recipe_exp">所要時間 <c:out
						value="${overview.time}" /></span>
			</p>

			<table class="tb_recipe">
				<tr class="tr_recipe">
					<th>材料</th>
					<th>1人前</th>
					<th><form:form action="/calc?recipe_id=${overview.recipe_id}&menu=${overview.menu_name}">
							<input pattern="^[0-9]+$" autocomplete="off" size="2" maxlength="2" step="1" name="numberOfPeople" value="${num}" required>
							<button class="recipe_button" name="calcSubmit" value="${overview.recipe_id}">人前</button>
						</form:form>
					</th>
				</tr>
				<c:forEach items="${foodstuffList}" var="foodstuff"
					varStatus="status">
					<tr class="tr_recipe">
						<td><c:out value="${foodstuff.foodstuff}" /></td>
						<td class="amo_recipe"><c:out value="${foodstuff.quantity}" /></td>
						<td class="cal_recipe" id="cal_recipe"><c:out value="${foodstuff.calc}" /></td>
					</tr>
				</c:forEach>
			</table>

			<div class="coment_bl">
				<p>
					人数を入力して<br>必要な量を<br>計算してみよう！
				</p>
			</div>
		</div>

		<div class="howto_recipe">
			<h2 class="howto_title">作り方</h2>
			<c:forEach items="${process}" var="process" varStatus="status">
				<ul class="recipe_process">
					<li><c:out value="${status.count}" />. <c:out
							value="${process.process}" /></li>
				</ul>
			</c:forEach>
		</div>

		<footer>
			<a href="recipeList">レシピ一覧に戻る</a>
			<hr class="katorari">
		</footer>
	</div>
</body>
</html>
