<%@ taglib prefix="s" uri="/struts-tags"%>
<h2><s:text name="client.list.new" /></h2>
<s:iterator value="subCategory">
	<s:a>${tittle}</s:a>
	<s:a>${startDate}</s:a>	
</s:iterator>