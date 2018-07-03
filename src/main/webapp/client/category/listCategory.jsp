<%@ taglib prefix="s" uri="/struts-tags"%>
<h2><s:text name="client.list.category" /></h2>
<s:iterator value="categories">
	<s:url action="detail-news" var="detail">
		<s:param name="id">${id}</s:param>
	</s:url>
	<s:a href="%{detail}">${name}</s:a>
</s:iterator>