package com.pegasus.arithmetic.expression.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pegasus.arithmetic.expression.commons.Common;
import com.pegasus.arithmetic.expression.commons.EvaluateString;
import com.pegasus.arithmetic.expression.commons.Logs;
import com.pegasus.arithmetic.expression.entity.ArithmeticExpressionDetails;
import com.pegasus.arithmetic.expression.service.ArithmeticExpressionService;

@Controller
public class ArithmeticExpressionController {

	private static final Logger LOGGER = Logs.getAppLoggers();

	@Autowired
	ArithmeticExpressionService arithmeticExpressionService;

	@RequestMapping(value = "/arithmetic-expression", method = RequestMethod.GET)
	public String arithmeticExpression(ModelMap model) {
		model.addAttribute("arithmeticExpressionDetails", new ArithmeticExpressionDetails());
		model.addAttribute("arithmeticExpressions", this.arithmeticExpressionService.listArithmeticExpression());
		return "arithmetic-expression";
	}

	@RequestMapping(value = "/arithmetic-expression-process", method = RequestMethod.POST)
	@ResponseBody
	public String arithmeticExpressionEvaluate(
			@ModelAttribute(value = "arithmeticExpressionDetails") ArithmeticExpressionDetails arithmeticExpressionDetails,
			BindingResult result, Model model) {
		String output = StringUtils.EMPTY;
		try {

			//Use of Functional Interface - Java 1.8
	        Function<String, String> function = EvaluateString::evaluate;
	        output = function.apply(arithmeticExpressionDetails.getExpression());

			if (StringUtils.isNotEmpty(output)) {
				String pattern = "yyyy-MM-dd HH:mm:ss";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				String currentDateTime = simpleDateFormat.format(new Date());

				arithmeticExpressionDetails.setOutput(output);
				arithmeticExpressionDetails.setCreatedDatetime(currentDateTime);
				arithmeticExpressionDetails.setUpdatedDatetime(currentDateTime);

				arithmeticExpressionService.saveArithmeticExpression(arithmeticExpressionDetails);
			}
		} catch (Exception e) {
			LOGGER.error("Exception occurred in arithmeticExpressionEvaluate in ArithmeticExpressionController : "
					+ e.getMessage());
		}
		return output;
	}

	@RequestMapping(value = "/arithmetic-expression-list", method = RequestMethod.GET)
	@ResponseBody
	public String arithmeticExpressionList() {
		String responseJSON = StringUtils.EMPTY;
		List<ArithmeticExpressionDetails> arithmeticExpressionList = this.arithmeticExpressionService
				.listArithmeticExpression();
		responseJSON = Common.objectToJSON(arithmeticExpressionList);
		return responseJSON;
	}
}