<%@include file="/includedTags.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
	<div class="container">
		<div id="loginbox"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 m-t-50">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
					<div class="fogot_password">
						<a href="#">Forgot password?</a>
					</div>
				</div>

				<div class="panel-body p-t-30">

					<c:url var="loginUrl" value="/login" />
					<form action="${loginUrl}" method="post" id="loginform"
						class="form-horizontal" role="form">

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="input-group m-b-25">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control" name="username" value=""
								placeholder="username or email">
						</div>

						<div class="input-group m-b-25">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="password"
								placeholder="password">
						</div>



						<div class="input-group">
							<div class="checkbox">
								<label> <input id="login-remember" type="checkbox"
									name="remember" value="1"> Remember me
								</label>
							</div>
						</div>

						<div class="form-group m-t-10">
							<!-- Button -->

							<div class="col-sm-12 controls">
								<div class="row">
									<div class="col-sm-2">
										<button id="btn-login" class="btn btn-success">LOGIN</button>
									</div>
									<div class="col-sm-6">
										<a id="btn-fblogin" href="#" class="btn btn-primary">Login
											with Facebook</a>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12 control">
								<div class="s-link-register">
									Don't have an account! <a href="#"
										onClick="$('#loginbox').hide(); $('#signupbox').show()">
										Sign Up Here </a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>