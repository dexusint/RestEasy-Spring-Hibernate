package com.resteasy.series.spring.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.resteasy.series.spring.hibernate.model.Customer;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO	 {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public String insertNewCustomer(Customer customer) {

		// inserts into database & return customerId (primary_key)
		int customerId = (Integer) sessionFactory.getCurrentSession().save(customer);
		return "Customer information saved successfully with Customer_ID " + customerId;
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {

		// retrieve customer based on the id supplied in the formal argument
		Customer customer = (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
		return customer;
	}

	@Override
	@Transactional
	public String updateCustomer(Customer customer) {

		// update database with customer information and return success msg
		sessionFactory.getCurrentSession().update(customer);
		return "Customer information updated successfully";
	}

	@Override
	@Transactional
	public String deleteCustomer(Customer customer) {

		// delete customer information and return success msg
		sessionFactory.getCurrentSession().delete(customer);
		return "Customer information deleted successfully";
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Customer> getAllCustomer() {

		// get all customer info from database
		List<Customer> lstCustomer = sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
		return lstCustomer;
	}
}