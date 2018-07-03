<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Page</title>
	</head>
	<body>
		<h2>Welcome User, please login below</h2>
		<s:form action="login" method="post">
			<s:textfield name="username" key="users.index.username"></s:textfield>
			<s:password name="password" key="users.index.password"></s:password>
			<s:submit name="submit" key="users.action.login" align="center"></s:submit>
		</s:form>
		
		<s:url var="vietnam" namespace="/" action="locale">
			<s:param name="request_locale">vn</s:param>
		</s:url>
		<s:url var="english" namespace="/" action="locale">
			<s:param name="request_locale">en</s:param>
		</s:url>
	
		<s:a href="%{english}">English</s:a>
		<s:a href="%{vietnam}">Vietnamese</s:a>
</body>
</html>