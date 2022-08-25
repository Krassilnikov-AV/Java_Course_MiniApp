package com.javaСourse.hibernate.customer_1;


import org.hibernate.*;

import javax.persistence.NoResultException;

public class CustomerDAO {

	private SessionFactory sessionFactory = HibernateSessionFactoryUtil
		.sessionFactoryUtil;

	public Customer_1 findByName(String name) throws NoResultException {
		try (Session currentSession = sessionFactory.openSession()) {
			String query = "FROM Customer_1 c WHERE c.name = :name";
			return (Customer_1) currentSession.createQuery(query).setParameter("name", name)
				.getSingleResult();
		}
	}

	public void save(Customer_1 entity) {
		try (Session currentSession = sessionFactory.openSession()) {
			Transaction transaction = currentSession.beginTransaction();
			currentSession.save(entity);
			transaction.commit();
		}
	}

	public Customer_1 findByID(Long id) {
		try (Session currentSession = sessionFactory.openSession()) {
			Transaction transaction = currentSession.beginTransaction();
			Customer_1 entity =currentSession.get(Customer_1.class, id);
			transaction.commit();
			return entity;
		}
	}

	public void update(Customer_1 product) {
		try (Session currentSession = sessionFactory.openSession()) {
			Transaction transaction = currentSession.beginTransaction();
			currentSession.update(product);
			transaction.commit();
		}
	}

	public void buyProduct(Customer_1 customer_1, Product product) {
		try (Session currentSession = sessionFactory.openSession()) {
			Transaction transaction = currentSession.beginTransaction();
			CustomerProduct cp = new CustomerProduct(customer_1, product);
			currentSession.save(cp);
			transaction.commit();
		}
	}
}