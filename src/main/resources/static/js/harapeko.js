
$(function() {
	$('.js-modal').fadeIn();
});

$(function() {
	$('.js-modal-close').on('click', function() {
		$('.js-modal').fadeOut();
	});
});

$(function() {
	$('.js-menu__item__link').each(function() {
		$(this).on('click', function() {
			$("+.submenu", this).slideToggle();
			return false;
		});
	});
});


$(function() {
	$('.Item').on('click', function() {
		$(this).toggleClass('isActive');
	});
});

$(function() {
	$('like_button').on('click', function() {
		$('.like_button').animate({
			backgroundColor: '#7fbfff',
			borderColor: '#20b2aa'
		}, 500);
		$('.font_js').animate({
			color: 'red'
		}, 500);
	});
});

$(function() {
	$('like_button').off('click', function() {
		$(this).removeAttr('style');
	});
});


$(function() {
	$("#likeButton").click(function() {
		var jsonString = $('#likeButton').val();
		$("#outputLike").text("");
		$.ajax({
			type: "POST",
			url: "/pushLike",
			data: jsonString,
			dataType: "json",
			contentType: 'application/json',
			success: function(result) {
				success(result);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				error(XMLHttpRequest, textStatus, errorThrown);
			}
		});
	});
});

function success(result) {
	$("#outputLike").append(result);
	$(".like_button").animate({
		backgroundColor: '#7fbfff',
		borderColor: '#20b2aa'
	}, 500);
	$(".font_js").animate({
		color: 'red'
	}, 500);
}

function error(XMLHttpRequest, textStatus, errorThrown) {
	alert('Error: ajax通信に失敗しました。');
	console.log("XMLHttpRequest : " + XMLHttpRequest.status);
	console.log("textStatus     : " + textStatus);
	console.log("errorThrown    : " + errorThrown.message);
}

$(window).bind("load", function(){
	if(document.URL.match(/mypage/)){
		$("#accordion").click(function() {
			$(this).next().slideDown();
			}, function() {
			 $(this).next().slideUp();
			}
		);
	}
});

$(window).bind("load", function(){
	if(document.URL.match(/form/)){
		$('#like_js').remove();
	}
});

