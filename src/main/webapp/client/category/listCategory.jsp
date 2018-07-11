<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="col-md-9">
	<h2>
		<s:text name="client.list.category" />
	</h2>
	<s:iterator value="categories">
		<div class="col-md-3 categories">
			<s:url action="news-list" var="newsList">
				<s:param name="id" value="id" />
			</s:url>
			<s:a href="%{newsList}">${name}</s:a>
		</div>
	</s:iterator>
</div>
<div class="col-md-3">
	<h2>
		<s:text name="client.top.news" />
	</h2>
	<ul class="list-group">
		<s:iterator value="newses">
			<s:url action="news-detail" var="newsDetail">
				<s:param name="id" value="id" />
			</s:url>
			<li class="list-group-item"><s:a href="%{newsDetail}">${tittle}</s:a></li>
		</s:iterator>
	</ul>
</div>