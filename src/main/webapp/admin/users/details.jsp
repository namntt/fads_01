<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">
			<s:text name="users.index.panelTitle" />
		</h3>
	</div>
	<div class="panel-body">
		<div class="row">
			<div class=" col-md-9 col-lg-9 ">
				<table class="table table-user-information">
					<tbody>
						<tr>
							<td><s:text name="users.index.username" />:</td>
							<td><s:property value="user.username" /></td>
						</tr>

						<tr>
							<td><s:text name="users.index.fullname" />:</td>
							<td><s:property value="user.fullname" /></td>
						</tr>

						<tr>
							<td><s:text name="users.index.birthday" />:</td>
							<td><s:date name="user.birthday" format="dd/MM/yyyy" /></td>
						</tr>

						<tr>
							<td><s:text name="users.index.createdDate" />:</td>
							<td><s:date name="user.createdDate" format="dd/MM/yyyy" /></td>
						</tr>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>