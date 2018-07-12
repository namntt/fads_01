<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<sx:head/>
		<title>Login Page</title>
		<tiles:importAttribute name="jsDefault" />
			<c:forEach var="item" items="${jsDefault}">
				<script src="<c:url value="${item}"/>"></script>
			</c:forEach>
		<tiles:importAttribute name="cssDefault" />
			<c:forEach var="item" items="${cssDefault}">
				<link rel="stylesheet" href="<c:url value='${item}'/>" type="text/css" />
			</c:forEach>
		<tiles:importAttribute name="cssAdd" />
			<c:forEach var="item" items="${cssAdd}">
				<link rel="stylesheet" href="<c:url value='${item}'/>" type="text/css" />
			</c:forEach>

		<%-- Addition JS --%>
		<tiles:importAttribute name="jsAdd" />
			<c:forEach var="item" items="${jsAdd}">
				<script src="<c:url value="${item}"/>"></script>
			</c:forEach>
	</head>
	<body>
		<div class="login-form">
			<s:form action="login" method="post" validate="true">
		        <h2 class="text-center">Log in</h2>       
		        <div class="form-group">
		        	<label></label>
		        	<s:textfield name="username" class="form-control" placeholder="Username" />
		       		<s:fielderror fieldName="username" />
		        </div>
		        <div class="form-group">
		        	<s:password name="password" class="form-control" placeholder="Password" /><br>
		      		<s:fielderror fieldName="password" />
		        </div>
		        <div class="form-group">
		            <s:submit value="Submit" class="btn btn-primary btn-block"></s:submit>
		        </div>
		        <div class="clearfix">
		            <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
		            <a href="#" class="pull-right">Forgot Password?</a>
		        </div>        
		    </s:form>
	    	<p class="text-center"><a href="#">Create an Account</a></p>
		</div>
	</body>
</html>