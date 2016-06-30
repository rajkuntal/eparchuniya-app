<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/normalize/2.1.0/normalize.css">
  <link rel="stylesheet" href="http://rawgit.com/Addepar/ember-charts/v0.3.0/dist/ember-charts.css">

  <link href="<c:url value='/resources/css/amberchart/amberchartcss.css' />"
  rel="stylesheet"></link>
  
  <!-- Ember and dependencies -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/handlebars.js/1.3.0/handlebars.js"></script>
  <script src="http://builds.emberjs.com/tags/v1.4.0/ember.js"></script>
  
  <!-- Ember Charts and dependencies -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/lodash.js/2.4.1/lodash.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/d3/3.4.10/d3.min.js"></script>
  <script src="http://rawgit.com/Addepar/ember-charts/v0.3.0/dist/ember-charts.js"></script>

  <script type="text/javascript"
  src="<c:url value='/resources/js/amberchart/amberchartexample.js' />"></script>
</head>

<body>
  <script type="text/x-handlebars">
    <h2> Welcome to Ember Charts!</h2>
    <p>Version 0.3.0</p>
    {{outlet}}
  </script>

  <script type="text/x-handlebars" data-template-name="index">
    <div class="chart-container">
      {{horizontal-bar-chart
        data=content
      }}
    </div>
    <div class="chart-container">
      {{vertical-bar-chart
        data=content
       }}
    </div>
    <div class="chart-container">
      {{pie-chart
        data=content
      }}
    </div>
    <div class="chart-container">
      {{scatter-chart
        data=scatterContent
        xValueDisplayName="Risk"
        yValueDisplayName="Return"
      }}
    </div>
    <div class="chart-container">
      {{time-series-chart
        barData=timeSeriesBarContent
        lineData=timeSeriesLineContent
      }}
    </div>
  </script>
</body>
</html>