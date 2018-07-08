<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>
	<s:text name="client.list.category" />
</h2>
	<s:iterator value="categories">
		<div class="col-md-3 categories">
			<s:url action="news-list" var="news-list">
				<s:param name="id" value="id"/>
			</s:url>
			<s:a href="%{news-list}">${name}</s:a>
		</div>
	</s:iterator>