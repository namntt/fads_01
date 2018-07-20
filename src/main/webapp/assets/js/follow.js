$(document).ready(function() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajaxSetup({
		beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
		}
	});
	$('.follow').click(function() {
		var newsId = $('#newsId').val();
		var msg = $('.msg-follow').html();
		$.ajax({
			type : 'POST',
			url : 'news-follow.action',
			data : {
				newsId : newsId
			},
			dataType : 'json',
			success : function(data) {
				if (msg == "Favorite") {
					$('.msg-follow').html('Favorited');
				} else {
					$('.msg-follow').html('Favorite');
				}
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	})
});