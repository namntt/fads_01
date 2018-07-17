$(document).ready(function() {
	var dict = [];
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