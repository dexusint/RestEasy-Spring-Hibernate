package com.resteasy.series.spring.hibernate.service;

import in.benchresources.cdm.customer.CustomerListType;
import in.benchresources.cdm.customer.CustomerType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resteasy.series.spring.hibernate.dao.CustomerDAO;
import com.resteasy.series.spring.hibernate.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public String createOrSaveNewCustomerInfo(CustomerType customerType) {

		Customer newCustomer = new Customer();
		newCustomer.setCustomerId(customerType.getCustomerId());
		newCustomer.setName(customerType.getName());
		newCustomer.setAge(customerType.getAge());
		return customerDAO.insertNewCustomer(newCustomer);
	}

	@Override
	public CustomerType getCustomerInfo(int customerId) {

		Customer getCustomer = customerDAO.getCustomer(customerId);

		CustomerType customerType = new CustomerType();
		customerType.setCustomerId(getCustomer.getCustomerId());
		customerType.setName(getCustomer.getName());
		customerType.setAge(getCustomer.getAge());
		return customerType;
	}

	@Override
	public String updateCustomerInfo(CustomerType customerType) {

		Customer modifyCustomer = new Customer();
		modifyCustomer.setCustomerId(customerType.getCustomerId());
		modifyCustomer.setName(customerType.getName());
		modifyCustomer.setAge(customerType.getAge());
		return customerDAO.updateCustomer(modifyCustomer);
	}

	@Override
	public String deleteCustomerInfo(CustomerType customerType) {

		Customer removeCustomer = new Customer();
		removeCustomer.setCustomerId(customerType.getCustomerId());
		removeCustomer.setName(customerType.getName());
		removeCustomer.setAge(customerType.getAge());
		return customerDAO.deleteCustomer(removeCustomer);
	}

	@Override
	public CustomerListType getAllCustomerInfo() {

		List<Customer> lstCustomer = customerDAO.getAllCustomer();
		CustomerListType customerListType = new CustomerListType();

		for(Customer customer : lstCustomer){
			CustomerType customerType = new CustomerType();
			customerType.setCustomerId(customer.getCustomerId());
			customerType.setName(customer.getName());
			customerType.setAge(customer.getAge());
			customerListType.getCustomerType().add(customerType);
		}
		return customerListType;
	}
}