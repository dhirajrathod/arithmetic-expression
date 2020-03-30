package com.pegasus.arithmetic.expression.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pegasus.arithmetic.expression.dao.ArithmeticExpressionDAO;
import com.pegasus.arithmetic.expression.entity.ArithmeticExpressionDetails;

@Service
public class ArithmeticExpressionServiceImpl implements ArithmeticExpressionService {

	@Autowired
	ArithmeticExpressionDAO arithmeticExpressionDAO;
	
	@Override
	@Transactional
	public void saveArithmeticExpression(ArithmeticExpressionDetails arithmeticExpressionDetails) {
		this.arithmeticExpressionDAO.saveArithmeticExpression(arithmeticExpressionDetails);
	}

	@Override
	@Transactional
	public List<ArithmeticExpressionDetails> listArithmeticExpression() {
		return this.arithmeticExpressionDAO.listArithmeticExpression();
	}
}
