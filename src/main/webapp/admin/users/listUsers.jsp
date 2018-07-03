<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="row">
	<div class="form-inline col-md-5">
		<form action="list" method="get">
			<div class="form-group">
				<s:textfield name="searchKeyword" placeholder="Search"
					class="form-control"></s:textfield>
			</div>
			<button type="submit" class="btn btn-default">
				<i class="glyphicon glyphicon-search"></i>
			</button>
		</form>
	</div>
</div>
<div class="row">
	<div class="form-inline col-md-5">
		<s:a class="btn btn-success newUser" action="newUser"><s:text name="users.action.addUser" /></s:a>
	</div>
</div>
<div class="row">
	<table class="table table-hover" id="dev-table">
		<thead>
			<tr>
				<th><s:text name="users.index.id" /></th>
				<th><s:text name="users.index.username" /></th>
				<th><s:text name="users.index.fullname" /></th>
				<th><s:text name="users.index.birthday" /></th>
				<th><s:text name="users.index.createdDate" /></th>
				<th><s:text name="users.action.name" /></th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="users" status="incr">
				<s:url action="detail" var="detail">
					<s:param name="id">${id}</s:param>
				</s:url>
				<tr>
					<td><s:property value="%{#incr.index}" /></td>
					<td>${username}</td>
					<td>${fullname}</td>
					<td><s:date name="birthday" format="dd/MM/yyyy" /></td>
					<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
					<td><s:a href="%{detail}"><s:text name="users.action.details" /></s:a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
