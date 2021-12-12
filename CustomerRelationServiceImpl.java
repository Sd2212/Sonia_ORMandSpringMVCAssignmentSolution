package com.management.customerrelation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.management.customerrelation.entity.CustomerRelation;

@Repository
public class CustomerRelationServiceImpl implements CustomerRelationService {

	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	CustomerRelationServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<CustomerRelation> findAll() {
		Transaction tx = session.beginTransaction();

		List<CustomerRelation> customerRelations = session.createQuery("from CustomerRelation").list();

		tx.commit();

		return customerRelations;
	}

	@Transactional
	public CustomerRelation findById(int id) {

		CustomerRelation customerRelation = new CustomerRelation();

		Transaction tx = session.beginTransaction();

		customerRelation = session.get(CustomerRelation.class, id);

		tx.commit();

		return customerRelation;
	}

	@Transactional
	public void save(CustomerRelation theCustomerRelation) {

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(theCustomerRelation);

		tx.commit();

	}

	@Transactional
	public void deleteById(int id) {

		Transaction tx = session.beginTransaction();

		CustomerRelation customerRelation = session.get(CustomerRelation.class, id);

		session.delete(customerRelation);

		tx.commit();

	}

	@Transactional
	public void print(List<CustomerRelation> customerRelation) {

		for (CustomerRelation c : customerRelation) {
			System.out.println(c);
		}
	}
}
