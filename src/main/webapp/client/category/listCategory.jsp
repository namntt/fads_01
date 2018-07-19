<%@include file="/includedTags.jsp" %>
<div class="row">
		<div class="row col-md-8 col-lg-8">
			<h3>
				<s:text name="client.list.category" />
			</h3>
			<s:iterator value="categories">
					        <div class="col-md-4">
					          <div class="thumbnail">
					            <img src="http://placehold.it/500x250/EEE">
					              <div class="caption categoryName">
					                <s:url action="news-list" var="newsList">
										<s:param name="id" value="id" />
									</s:url>
									<s:a href="%{newsList}">${name}</s:a>
					            </div>
					          </div>
			        </div>
			</s:iterator>
		</div>
		<div class="col-md-4 col-lg-4">
			<ul class="media-list main-list">
				<h3>
					<s:text name="client.top.news" />
				</h3>
				<s:iterator value="newses" var="news">
				  <li class="media">
				    <a class="pull-left" href="#">
				      <img class="media-object" src="http://placehold.it/150x90" alt="...">
				    </a>
				    <div class="media-body">
				    	<s:url action="news-detail" var="newsDetail">
							<s:param name="id" value="id" />
						</s:url>
				      <h5 class="media-heading rankingNew"><s:a href="%{newsDetail}">${tittle}</s:a></h5>
				      <p class="by-author"><s:property value="#news.user.username"/></p>
				    </div>
				  </li>
				  </s:iterator>
			</ul>
		</div>
</div>