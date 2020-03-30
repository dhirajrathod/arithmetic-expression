package com.pegasus.arithmetic.expression.dao;

import java.util.List;

import com.pegasus.arithmetic.expression.entity.ArithmeticExpressionDetails;

public interface ArithmeticExpressionDAO {
	
	public void saveArithmeticExpression(ArithmeticExpressionDetails arithmeticExpressionDetails);

	public List<ArithmeticExpressionDetails> listArithmeticExpression();
}
