$(document).ready(function() {
	$('#please-wait-data').hide();
	$('#div-errors').hide();
	$("#errorOutput").hide();
	$("#successOutput").hide();

	$("#submitForm").on('click', function() {
		submitForm();
	});

	getArithmeticExpressionList();
	
});

function callEnterKeyPress(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode === 13) {
        submitForm();
        return false;
    }
}

function submitForm() {
	$('#please-wait-data').show();
	$('#div-errors').hide();
	var formName = "arithmeticForm";
	clearClientErrors(formName);
	onloadClearServerErrors();
	onloadClearServerSuccess();

	var expression = $("#expression").val();
	if (required(expression)) {
		$("#" + $("#expression").attr("id") + "-error").text(
				"Arithmetic Expression" + requiredMessage);
	}

	var validate = isFormValidated(formName);
	if (validate) {
		$('#div-errors').hide();
		$('#submitForm').hide();
		processForm(expression);
	} else {
		$('#div-errors').show();
		$('#please-wait-data').hide();
	}
}

function processForm(expression) {
	$.ajax({
		url : "arithmetic-expression-process",
		dataType : 'json',
		type : "POST",
		data : {
			'expression' : expression
		},
		success : function(data, textStatus, jqXHR) {
			var successMessage = expression + " = " + data;
			$('#please-wait-data').hide();
			$('#submitForm').show();
			$("#div-errors").hide();
			$("#expression").val("");
			afterSuccess(successMessage);
			getArithmeticExpressionList();
		},
		error : function(data, textStatus, jqXHR) {
			$("#div-errors").hide();
			$('#please-wait-data').hide();
			$('#submitForm').show();
			var errorMessage = "Invalid Expression.";
			afterError(errorMessage);
		}
	});
}

function afterSuccess(message) {
	$("#errorOutput").hide();
	$("#successOutputText").html(message);
	$("#successOutput").show();
}

function afterError(message) {
	$("#successOutput").hide();
	$("#errorOutputText").html(message);
	$("#errorOutput").show();
}

function getArithmeticExpressionList() {
	$.ajax({
		url : "arithmetic-expression-list",
		dataType : 'json',
		type : "GET",
		success : function(data, textStatus, jqXHR) {
			var tableBody = '';

			for (var i = 0; i < data.length; i++) {
				var result = data[i];

				var srNo = (i + 1);
				var expression = result.expression;
				var output = result.output;
				var createdDatetime = result.createdDatetime;

				tableBody += '<tr>';
				tableBody += '<td>' + srNo + '</td>';
				tableBody += '<td>' + expression + '</td>';
				tableBody += '<td>' + output + '</td>';
				tableBody += '<td>' + createdDatetime + '</td>';
				tableBody += '</tr>';
			}

			$("#arithmeticExpressionList").html(tableBody);
		},
		error : function(data, textStatus, jqXHR) {
		}
	});
}