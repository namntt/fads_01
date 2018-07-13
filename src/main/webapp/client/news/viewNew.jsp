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
	<s:if test="%{userFollowNews!=null}">
		<button class="follow btn btn-info">
			<span class="msg-follow">Favorited</span>
		</button>
	</s:if>
	<s:if test="%{userFollowNews==null}">
		<button class="follow btn btn-info">
			<span class="msg-follow">Favorite</span>
		</button>
	</s:if>
	<!-- Your share button code -->
	<div class="fb-share-button"
		data-href="http://dantri.com.vn/the-gioi/tho-lan-dau-tien-tim-thay-doi-bong-thai-lan-chung-toi-khong-phai-nguoi-hung-2018071307304996.htm"
		data-layout="button_count" data-size="small" data-mobile-iframe="true">
		<a target="_blank" href="" class="fb-xfbml-parse-ignore">Chia sẻ</a>
	</div>
</div>
<div class="row">
	<h2>
		<s:property value="news.tittle" />
	</h2>
</div>
<div class="row">
	<s:property value="news.content" />
</div>
<div class="row">
	<s:property value="news.price" />
</div>
