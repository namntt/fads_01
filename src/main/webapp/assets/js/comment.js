$(document).ready(function() {
	$('#commentNews').click(function() {
		var description=$('#description').val();
		var newsId=$('#newsId').val();
		var userAccount=$('#userAccount').text();
		var object = $(this);
		$.ajax({
			type : 'POST',
			url : 'comment-new.action',
			data : {
				description:description,
				newsId:newsId
			},
			dataType : 'json',
			success : function(data) {
				var html_newcomment ='<div class="comment-main-level">'
						+'<div class="comment-box">'
							+'<div class="comment-head">'
								+'<h6 class="comment-name by-author">'+userAccount+'</h6>'
								+'<span>hace 20 minutos</span>'
							+'</div>'
							+'<div class="comment-content">'+description+'</div>'
						+'</div>';
					object.parent().next().find(".parent-comment").append(html_newcomment);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	});
	
	$('.subCommentNews').bind("click", function(event) {
		  event.preventDefault();
		  var parentId=$(this).eq(0).prev().find("input").eq(0).val();
		  var subDescription=$(this).eq(0).prev().find("input").eq(1).val();
		  var newsId=$('#newsId').val();
		  var userAccount=$('#userAccount').text();
		  var object = $(this);
		  $.ajax({
				type : 'POST',
				url : 'comment-new.action',
				data : {
					subDescription: subDescription,
					parentId: parentId,
					newsId: newsId
				},
				dataType : 'json',
				success : function(data) {
					var html_newcomment = '<ul class="comments-list reply-list">'
					+'<li><div class="comment-box"><div class="comment-head">'
								+'<h6 class="comment-name">'+userAccount+'</h6>'
								+'<span>hace 10 minutos</span>'
							+'</div>'
							+'<div class="comment-content">'
							+ '<div>'+subDescription+'</div>'
							+ '</div></div></li></ul>';
					console.log(object.parent().find(".subComment-append"));
					object.parent()
						.find(".subComment-append").append(html_newcomment);
					$(".subComment").attr("placeholder","Comment....");
					$(".subComment").val("");
				},
				error : function(data) {
					alert(parentId);
				}
			});
		});
});