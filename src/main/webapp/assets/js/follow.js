$(document).ready(function() {
	$('.follow').click(function() {
		var newsId = $('#newsId').val();
		var msg = $('.msg-follow').html();
		$.ajax({
			type : "POST",
			url : "news-follow.action",
			data : "newsId=" + newsId,
			dataType : 'json',
			success : function(data) {
				if (msg == "Follow") {
					$('.msg-follow').html('Unfollow');
				} else {
					$('.msg-follow').html('Follow');
				}
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	})
});