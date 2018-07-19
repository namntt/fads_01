<%@include file="/includedTags.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row">
	<div class="col-md-8">
		<div class="row">
				<p class="tittleNews">
					<s:property value="news.tittle" />
				</p>
		</div>
		
		<div class="row priceNews">
			<s:property value="news.price" />$
		</div>

		<div class="row">
			<div class="col-md-8 content">
				<s:property value="news.content" />
			</div>
		</div>
	</div>
	<%-- <div class="col-md-2">
		<div class="row" style="text-align: center">
			<s:property value="news.price" />
		</div>
	</div> --%>

	<div class="col-md-4">
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
			data-layout="button_count" data-size="small"
			data-mobile-iframe="true">
			<a target="_blank" href="" class="fb-xfbml-parse-ignore">Chia
				sẻ</a>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-6">
		<s:form id="formComment">
			<div class="form	-group">
				<h2>
					<s:text name="client.action.comment" />
				</h2>
				<s:textarea name="description" placeholder="Comment......."
					class="form-control" id="description"></s:textarea>
			</div>
		</s:form>
		<button id="commentNews" class="btn btn-default">Submit</button>
	</div>
</div>

<div class="row commentNews">
	<div class="comments-container">
		<ul id="comments-list" class="comments-list parent-comment">
			<s:iterator value="comments" var="parentComment">
				<s:if test="#parentComment.parentId==0">
					<li>
						<div class="comment-main-level">
							<div class="comment-box">
								<div class="comment-head">
									<h6 class="comment-name by-author">
										<s:property value="#parentComment.userAccount.username" />
									</h6>
									<span>hace 20 minutos</span>
								</div>
								<div class="comment-content">
									<s:property value="#parentComment.description" />
								</div>
							</div>
						</div> <!-- Respuestas de los comentarios --> <s:iterator
							value="comments" var="subComment">
							<s:if test="#subComment.parentId==#parentComment.id">
								<ul class="comments-list reply-list">
									<li>
										<!-- Contenedor del Comentario -->
										<div class="comment-box">
											<div class="comment-head">
												<h6 class="comment-name">
													<s:property value="#subComment.userAccount.username" />
												</h6>
												<span>hace 10 minutos</span>
											</div>
											<div class="comment-content">
												<div>
													<s:property value="#subComment.description" />
												</div>
											</div>
										</div>
									</li>
								</ul>
							</s:if>
						</s:iterator>
						<div class="subComment-append"></div> <s:form
							class="subDescription">
							<div class="form	-group">
								<s:hidden name="parentId" value="%{id}" />
								<s:textfield name="subDescription" placeholder="Comment......."
									class="form-control subComment"></s:textfield>
							</div>
						</s:form>
						<button class="subCommentNews">Submit</button>
					</li>
				</s:if>
			</s:iterator>
		</ul>
	</div>
</div>

