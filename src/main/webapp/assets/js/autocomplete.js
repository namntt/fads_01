$(document).ready(function() {
	var dict = [];
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajaxSetup({
		beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
		}
	});
	$.ajax({
		type : 'GET',
		url : 'news-tittle.action',
		dataType : 'json'
	}).done(function(data) {
		$.each(data.tittles, function() {
			dict.push(this.toString())
		});
		return dict;
	});
	$("#searchTittle").autocomplete({
		source : dict,
		minLength : 3
	});
});