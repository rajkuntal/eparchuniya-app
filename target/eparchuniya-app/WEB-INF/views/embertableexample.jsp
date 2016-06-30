<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--           Ember Table Dependencies                       -->

<!--           				css           					 -->
<link href="<c:url value='/resources/css/embertable/antiscroll.css' />"
	rel="stylesheet"></link>

<link href="<c:url value='/resources/css/embertable/ember-table.css' />"
	rel="stylesheet"></link>
	
<!--           				js           					 -->
<script type="text/javascript"
src="<c:url value='/resources/js/embertable/antiscroll.js' />"></script>
	
<script type="text/javascript"
src="<c:url value='/resources/js/embertable/ember-table.js' />"></script>

<script type="text/javascript"
src="<c:url value='/resources/js/embertable/jquery-ui.js' />"></script>

<script type="text/javascript"
src="<c:url value='/resources/js/embertable/jquery.mousewheel.js' />"></script>

<script type="text/javascript"
src="<c:url value='/resources/js/embertable/embertableexample.js' />"></script>

<script type="text/javascript"
src="<c:url value='/resources/js/embertable/ember-template-compiler.js' />"></script>

<script type="text/javascript"
src="<c:url value='/resources/js/embertable/ember.debug.js' />"></script>

<script type="text/javascript"
src="<c:url value='/resources/js/jquery-1.7.js' />"></script>

<script type="text/javascript"
src="<c:url value='/resources/js/embertable/ember-0.9.8.1.js' />"></script>


<!--           				           					 -->

<title>Insert title here</title>
</head>
<body>
<script type="text/x-handlebars">
    <h2>Welcome to Ember Table!</h2>
    <p>Version 0.9.2</p>
    {{outlet}}
  </script>

  <script type="text/x-handlebars" data-template-name="index">
    <div class="table-container">
      {{table-component
        hasFooter=false
        columns=tableColumns
        content=tableContent
      }}
    </div>
  </script>
</body>
</html>