package com.pegasus.arithmetic.expression.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pegasus.arithmetic.expression.commons.HibernateUtil;
import com.pegasus.arithmetic.expression.commons.Logs;
import com.pegasus.arithmetic.expression.entity.ArithmeticExpressionDetails;

@Repository
public class ArithmeticExpressionDAOImpl implements ArithmeticExpressionDAO {
	
	private static final Logger LOGGER = Logs.getAppLoggers();

	@Override
	public void saveArithmeticExpression(ArithmeticExpressionDetails arithmeticExpressionDetails) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(arithmeticExpressionDetails);
			transaction.commit();
		} catch (Exception e) {
			HibernateUtil.closeTransaction(transaction);
			LOGGER.error("Exception occurred in saveArithmeticExpression in ArithmeticExpressionDAOImpl : " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArithmeticExpressionDetails> listArithmeticExpression() {
		List<ArithmeticExpressionDetails> arithmeticExpressionDetailsList = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			arithmeticExpressionDetailsList = session.createQuery("from ArithmeticExpressionDetails order by id desc")
					.list();
		} catch (Exception e) {
			HibernateUtil.closeTransaction(transaction);
			LOGGER.error("Exception occurred in listArithmeticExpression in ArithmeticExpressionDAOImpl : " + e.getMessage());
		}
		return arithmeticExpressionDetailsList;
	}

}
