<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value='/resources/css/bootstrap.min.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/resources/css/myapp/custom.css' />"
	rel="stylesheet"></link>

<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-2.2.4.min.js' />"></script>

<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.min.js' />"></script>

<script type="text/javascript"
	src="<c:url value='/resources/js/angular.js' />"></script>
	
<script type="text/javascript"
	src="<c:url value='/resources/js/myapp/app.js' />"></script>
	
<script type="text/javascript"
	src="<c:url value='/resources/js/ui-bootstrap-tpls-0.13.2.min.js' />"></script>
	
</head>
<body>
	<div>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#">Company Name</a>
			    </div>
				<div class="collapse navbar-collapse">
				    <ul class="nav navbar-nav">
				    	<li> <a data-target="#home" data-toggle="tab">Home</a></li> 
				    	<li class ="active"> <a data-target="#usermanagement" data-toggle="tab">User Management</a></li>
				    	<li class = "dropdown">
					        <a class = "dropdown-toggle" data-toggle = "dropdown" href = "#"> Grid Examples <span class = "caret"></span></a>
					        <ul class = "dropdown-menu">
						      	<li><a data-target="#angularjs" data-toggle="tab">Angular Js</a></li>
					            <li><a data-target="#datatable" data-toggle="tab">Data Table</a></li>
						        <li class = "divider"></li>
						        <li><a href = "#">Separated link</a></li>
					      	</ul> 
				    	</li>
				    </ul>
				</div>
			</div>
		</nav>
	</div>
		<div class="customBody">
			<div class="tab-content">
				<div class="tab-pane" id="home">
					<jsp:include page="home.jsp"></jsp:include>
				</div>
				<div class="tab-pane active" id="usermanagement">
					<jsp:include page="usermanagement.jsp"></jsp:include>
				</div>
				</div>
			</div>
		</div>


	<script type="text/javascript">
		jQuery(function() {
			jQuery('#myTab a:last').tab('show')
		});
	</script>
</body>
</html>
