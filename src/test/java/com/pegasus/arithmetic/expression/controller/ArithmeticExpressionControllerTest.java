package com.pegasus.arithmetic.expression.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.pegasus.arithmetic.expression.config.TestBeanConfig;
import com.pegasus.arithmetic.expression.entity.ArithmeticExpressionDetails;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class ArithmeticExpressionControllerTest {

	@Autowired
	private ArithmeticExpressionController arithmeticExpressionController;
	
	@Test
	public void arithmeticExpressionEvaluate() {
		ArithmeticExpressionDetails arithmeticExpressionDetails = new ArithmeticExpressionDetails();
		arithmeticExpressionDetails.setExpression("(2*5)+5");

		BindingResult bindingResult = null;
		Model model = null;
		String result = arithmeticExpressionController.arithmeticExpressionEvaluate(arithmeticExpressionDetails,
				bindingResult, model);
		assertNotNull(result);
		assertEquals("15", result);
	}
					
	@Test
	public void arithmeticExpressionList() {
		String result = arithmeticExpressionController.arithmeticExpressionList();
		assertNotNull(result);
		assertTrue(result.length() > 0);
	}

}