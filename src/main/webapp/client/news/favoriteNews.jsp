<%@include file="/includedTags.jsp" %>
<s:iterator value="newses">
	<s:url action="news-detail" var="newsDetail">
		<s:param name="id">${id}</s:param>
	</s:url>
	<div class="row">
		<s:a href="%{newsDetail}">${tittle}</s:a>
	</div>
</s:iterator>

