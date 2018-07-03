<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<div class="row">
	<s:form action="saveOrUpdateUser" method="post" id="formUser"
		validate="true" enctype="multipart/form-data">
		<div class="form-group">
			<s:textfield name="user.id" type="hidden" class="form-control"></s:textfield>
		</div>
		<div class="form-group">
			<s:textfield name="user.createdDate" type="hidden"
				class="form-control"></s:textfield>
		</div>
		<div class="form-group">
			<label><s:text name="users.index.username" /></label>
			<s:textfield name="user.username" placeholder="Enter username"
				class="form-control" id="username"></s:textfield>
			<s:fielderror fieldName="user.username" />
		</div>
		<div class="form-group">
			<label><s:text name="users.index.password" /></label>
			<s:password name="user.password" placeholder="Enter Password"
				class="form-control"></s:password>
			<s:fielderror fieldName="user.password" />
		</div>

		<div class="form-group">
			<label><s:text name="users.index.confirmPassword" /></label>
			<s:password name="confirmPassword" placeholder="Re-Enter Password"
				class="form-control"></s:password>
			<s:fielderror fieldName="confirmPassword" />
		</div>

		<div class="form-group">
			<label><s:text name="users.index.fullname" /></label>
			<s:textfield name="user.fullname" placeholder="Enter fullname"
				class="form-control" id="fullname"></s:textfield>
			<s:fielderror fieldName="user.fullname" />
		</div>

		<div class="form-group">
			<label>Example file input</label>
			<s:file name="fileUpload" label="Select a File to upload" size="40" />
			<s:fielderror fieldName="user.avatar" />
		</div>
		<div class="form-group">
			<label><s:text name="users.index.birthday" /></label>
			<sx:datetimepicker name="user.birthday" displayFormat="dd-MMM-yyyy" />
			<s:fielderror fieldName="user.birthday" />
		</div>

		<s:submit value="Submit" class="btn btn-default"></s:submit>
	</s:form>
</div>