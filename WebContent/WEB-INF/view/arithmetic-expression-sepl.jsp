<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Arithmetic Expression | Spring MVC Example</title>
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

<spring:url value="/resources/js/validator.js" var="validatorjs" />
<script type="text/javascript" src="${validatorjs}"></script>

<spring:url value="/resources/js/arithmetic-expression-sepl.js"
	var="arithmeticexpressionsepljs" />
<script type="text/javascript" src="${arithmeticexpressionsepljs}"></script>
</head>
<body>
	<div class="main-div">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<h2 class="text-center">Arithmetic Expression</h2>
					<hr>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div id="div-errors" class="div-errors">
						<ul>
							<li id="expression-error" class="error"></li>
						</ul>
					</div>
				</div>

				<div class="col-md-12 col-sm-12 col-xs-12">
					<form:form action="arithmetic-expression-sepl-process" method="post" modelAttribute="arithmeticExpressionDetails" id="arithmeticForm">
						<div class="form-group col-md-12">
							<div class="col-md-2">
								<label>Arithmetic Expression</label>
							</div>
							<div class="col-md-10">
								<form:input path="expression" class="form-control" placeholder="Arithmetic Expression" id="expression" onkeypress="callEnterKeyPress(event);"/>
							</div>
						</div>
						<div class="form-group col-md-12">
							<div class="col-md-12 text-center">
								<hr>
								<spring:url value="/resources/img/loading.gif" var="loadinggif" />
								<label id="please-wait-data">
									<img src="${loadinggif}" alt="" width="20px" height="20px"> Please wait while we are processing details....
								</label> 
								<input type="button" class="btn btn-primary btn-md" id="submitForm" value="Submit" />
								<hr>
							</div>
						</div>
						<div class="form-group col-md-12">
							<div class="col-md-12 text-center">
								<div class="alert alert-success" id="successOutput">
									<strong>Result : </strong> <label id="successOutputText"></label>
								</div>
								<div class="alert alert-warning" id="errorOutput">
									<strong>Error : </strong> <label id="errorOutputText"></label>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<h2 class="text-center">Arithmetic Expression History</h2>
					<hr>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<table class="col-md-12 table-list">
						<tr>
							<th width="10%">Sr. No.</th>
							<th width="35%">Expression</th>
							<th width="35%">Output</th>
							<th width="20%">Created Date Time</th>
						</tr>
						<tbody id="arithmeticExpressionList">
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>