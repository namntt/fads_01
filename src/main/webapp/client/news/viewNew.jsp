<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="col-md-6">
	<div class="row">
		<div class="row">
			<h2>
				<s:property value="news.tittle" />
			</h2>
		</div>
	</div>

	<div class="row">
		<s:property value="news.content" />
	</div>
</div>
<div class="col-md-3">
	<div class="row" style="text-align: center">
		<s:property value="news.price" />
	</div>
</div>

<div class="col-md-3">
	<s:form id="search-form" action="" method="GET">
		<s:textfield name="id" type="hidden" id="newsId"></s:textfield>
	</s:form>
	<s:if test= "%{userFollowNews!=null}" >
	<button class="follow btn btn-info">
			<span class="msg-follow">Unfollow</span>
	</button>
	</s:if>
	<s:if test= "%{userFollowNews==null}" >
	<button class="follow btn btn-info">			
			<span class="msg-follow">Follow</span>
	</button>
	</s:if>
</div>
<div class="row">
	<h2><s:property value="news.tittle"/></h2>
</div>

<div class="row">
	<s:property value="news.content"/>
</div>
<div class="row">
	<s:property value="news.price"/>
</div>
