<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<%-- Default CSS --%>
<tilesx:useAttribute id="cssList" name="cssDefault" classname="java.util.List" />
<c:forEach var="item" items="${cssList}">
	<link rel="stylesheet" href="<c:url value='${item}'/>" type="text/css" />
</c:forEach>

<%-- Default JS --%>
<tilesx:useAttribute id="jsList" name="jsDefault" classname="java.util.List" />
<c:forEach var="item" items="${jsList}">
	<script src="<c:url value="${item}"/>"></script>
</c:forEach>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
<%-- Default CSS --%>
<tilesx:useAttribute name="cssAdd" id="cssAddList" classname="java.util.List"/>
<c:forEach var="item" items="${cssAddList}">
	<link rel="stylesheet" href="<c:url value='${item}'/>" type="text/css" />
</c:forEach>

<%-- Addition JS --%>
<tilesx:useAttribute name="jsAdd" id="jsAddList" classname="java.util.List"/>
<c:forEach var="item" items="${jsAddList}">
	<script src="<c:url value="${item}"/>"></script>
</c:forEach>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="container"><tiles:insertAttribute name="body" /></div>
	<tiles:insertAttribute name="footer" />
</body>
</html>
