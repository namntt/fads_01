<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row">
	<div class="row" id="search">
		<s:form id="search-form" action="news-list" method="POST"
			enctype="multipart/form-data">
			<s:textfield name="id" type="hidden"></s:textfield>
			<div class="row">
				<div class="form-group col-xs-9">
					<s:textfield class="form-control" placeholder="Search" name="keyword"></s:textfield>
				</div>
				<div class="form-group col-xs-3">
					<s:submit class="btn btn-block btn-primary" value="Search"></s:submit>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-3 col-xs-6">
					<s:select list="cityNames" class="form-control" name="choiceAdress"></s:select>
				</div>
			</div>
		</s:form>
	</div>
</div>
<div class="row">
	<div class="col-md-8">
		<table class="table">
			<thead>
				<tr>
					<td class="name"><s:text name="client.list.new" /></td>
				</tr>
			</thead>
			<s:iterator value="newses" var="news">
				<tbody>
					<tr>
						<td>
							<s:url action="news-detail" var="newsDetail">
								<s:param name="id">${id}</s:param>
							</s:url>
							<div class="title">
								<s:a href="%{newsDetail}">${tittle}</s:a>
							</div>
							<div class="price">
								${price}vnd
							</div>
							<div class="time">
								<s:date name="startDate" format="dd/MM/yyyy" />
							</div>
						</td>
					</tr>
				</tbody>

			</s:iterator>
		</table>
	</div>
	<div class="col-md-4"></div>
</div>