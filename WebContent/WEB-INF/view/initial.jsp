<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home | Spring MVC Example</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=Droid+Sans"
	rel="stylesheet">

<spring:url value="/resources/css/style.css" var="stylecss" />
<link rel="stylesheet" href="${stylecss}">

<spring:url value="/resources/js/jquery.min.js" var="jqueryminjs" />
<script type="text/javascript" src="${jqueryminjs}"></script>

<spring:url value="/resources/js/jquery-latest.js" var="jquerylatestjs" />
<script src="${jquerylatestjs}"></script>

<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapminjs" />
<script src="${bootstrapminjs}"></script>
</head>
<body>
	<div class="main-div">

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<strong class="text-center">Created Two programs one using core java method and other using Spring Expression Language. </strong>
					<hr>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<a href="arithmetic-expression"><strong>1. Arithmetic Expression</strong></a>
				</div>

				<div class="col-md-12 col-sm-12 col-xs-12">
					<a href="arithmetic-expression-sepl"><strong>2. Arithmetic Expression - SEPL</strong></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>