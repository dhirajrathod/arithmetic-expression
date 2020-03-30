package com.pegasus.arithmetic.expression.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pegasus.arithmetic.expression.entity.ArithmeticExpressionDetails;

@Repository
public class ArithmeticExpressionDAOImpl implements ArithmeticExpressionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveArithmeticExpression(ArithmeticExpressionDetails arithmeticExpressionDetails) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(arithmeticExpressionDetails);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArithmeticExpressionDetails> listArithmeticExpression() {
		Session session = this.sessionFactory.openSession();
		List<ArithmeticExpressionDetails> arithmeticExpressionDetailsList = session.createQuery("from ArithmeticExpressionDetails order by id desc").list();
		session.close();
		return arithmeticExpressionDetailsList;
	}

}
