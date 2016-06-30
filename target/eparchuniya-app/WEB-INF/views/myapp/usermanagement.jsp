
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value='/resources/js/myapp/usermgmt_controller2.js' />"></script>

<title>usermanagement</title>
</head>
<body>
	<div class="container submenubar">
		<ul class="nav nav-tabs">
			<li class="active"><a data-target="#usergroups"
				data-toggle="tab">USER GROUPS</a></li>
			<li><a data-target="#users" data-toggle="tab">USERS</a></li>
		</ul>
	</div>
	<div class="tab-content" ng-app="myApp" ng-controller="UserGroupCtrl">
		<div class="tab-pane active" id="usergroups">
			<jsp:include page="usermgmt_usergroup.jsp"></jsp:include>
		</div>
		<div class="tab-pane" id="users">
			<jsp:include page="usermgmt_user.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>