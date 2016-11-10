package com.resteasy.series.spring.hibernate.service;

import in.benchresources.cdm.customer.CustomerListType;
import in.benchresources.cdm.customer.CustomerType;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customerservice")
public interface ICustomerService {

	// Basic CRUD operations for Customer Service

	// http://localhost:8080/RestEasy-Spring-Hibernate/resteasy/customerservice/addcustomer  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-Spring-Hibernate/resteasy/customerservice/addcustomer  - JBoss AS7
	@POST
	@Path("addcustomer")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_FORM_URLENCODED})
	public String createOrSaveNewCustomerInfo(CustomerType customerType);

	// http://localhost:8080/RestEasy-Spring-Hibernate/resteasy/customerservice/getcustomer/10001  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-Spring-Hibernate/resteasy/customerservice/getcustomer/10001  - JBoss AS7
	@GET
	@Path("getcustomer/{id}")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public CustomerType getCustomerInfo(@PathParam("id") int customerId);

	// http://localhost:8080/RestEasy-Spring-Hibernate/resteasy/customerservice/updatecustomer  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-Spring-Hibernate/resteasy/customerservice/updatecustomer  - JBoss AS7
	@PUT
	@Path("updatecustomer")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_FORM_URLENCODED})
	public String updateCustomerInfo(CustomerType customerType);

	// http://localhost:8080/RestEasy-Spring-Hibernate/resteasy/customerservice/deletecustomer  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-Spring-Hibernate/resteasy/customerservice/deletecustomer  - JBoss AS7
	@DELETE
	@Path("deletecustomer")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_FORM_URLENCODED})
	public String deleteCustomerInfo(CustomerType customerType);

	// http://localhost:8080/RestEasy-Spring-Hibernate/resteasy/customerservice/getallcustomer  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-Spring-Hibernate/resteasy/customerservice/getallcustomer  - JBoss AS7
	@GET
	@Path("getallcustomer")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public CustomerListType getAllCustomerInfo();
}