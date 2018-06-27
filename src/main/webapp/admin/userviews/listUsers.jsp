<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="col-md-10">
	<div class="row">
		<div class="form-inline col-md-5">
			<form action="list" method="get">
				<div class="form-group">
					<s:textfield name="searchKeyword" placeholder="Search" class="form-control"></s:textfield>
				</div>
				<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="form-inline col-md-5">
			<s:a class="btn btn-success" href="#" value="Add new user" style="margin: 20px"><s:text name="users.action.addUser" /></s:a>
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
				</tr>
			</thead>
			<tbody>
				<s:iterator value="users" status="incr">
					<tr>
						<td>${id}</td>
						<td>${username}</td>
						<td>${fullname}</td>
						<td>${birthday}</td>
						<td>${createdDate}</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</div>