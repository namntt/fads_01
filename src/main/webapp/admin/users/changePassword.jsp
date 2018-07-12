<%@ taglib uri="/struts-tags" prefix="s"%>
<h3>Change Password</h3>
	<s:form action="updatePassword" namespace="/">
		<s:text name="user.currentPassword"></s:text>
		<br>
		<s:password name="currentPass" />
		<s:fielderror fieldName="currentPass"></s:fielderror>
		<br>
		<s:text name="user.newPassword"></s:text>
		<br>
		<s:password name="newPass" />
		<s:fielderror fieldName="newPass"></s:fielderror>
		<br>
		<s:text name="user.re_enterPassword"></s:text>
		<br>
		<s:password name="reenterPass" />
		<s:fielderror fieldName="reenterPass"></s:fielderror>
		<br>
		<s:submit value="Submit" name="save" />
	</s:form>
