package com.pegasus.arithmetic.expression.service;

import java.util.List;

import com.pegasus.arithmetic.expression.entity.ArithmeticExpressionDetails;

public interface ArithmeticExpressionService {
	
	public void saveArithmeticExpression(ArithmeticExpressionDetails arithmeticExpressionDetails);

	public List<ArithmeticExpressionDetails> listArithmeticExpression();

}
