package com.resteasy.series.spring.hibernate.service;

import in.benchresources.cdm.book.BookListType;
import in.benchresources.cdm.book.BookType;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bookservice")
public interface IBookService {

	// Basic CRUD operations for Book Service

	// http://localhost:8080/RestEasy-Spring-Hibernate/resteasy/bookservice/addbook  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-Spring-Hibernate/resteasy/bookservice/addbook  - JBoss AS7
	@POST
	@Path("addbook")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_FORM_URLENCODED})
	public String createOrSaveNewBookInfo(BookType bookType);

	// http://localhost:8080/RestEasy-Spring-Hibernate/resteasy/bookservice/getbook/10001  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-Spring-Hibernate/resteasy/bookservice/getbook/10001  - JBoss AS7
	@GET
	@Path("getbook/{id}")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public BookType getBookInfo(@PathParam("id") int bookId);

	// http://localhost:8080/RestEasy-Spring-Hibernate/resteasy/bookservice/updatebook  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-Spring-Hibernate/resteasy/bookservice/updatebook  - JBoss AS7
	@PUT
	@Path("updatebook")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_FORM_URLENCODED})
	public String updateBookInfo(BookType bookType);

	// http://localhost:8080/RestEasy-Spring-Hibernate/resteasy/bookservice/deletebook  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-Spring-Hibernate/resteasy/bookservice/deletebook  - JBoss AS7
	@DELETE
	@Path("deletebook")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_FORM_URLENCODED})
	public String deleteBookInfo(BookType bookType);

	// http://localhost:8080/RestEasy-Spring-Hibernate/resteasy/bookservice/getallbook  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-Spring-Hibernate/resteasy/bookservice/getallbook  - JBoss AS7
	@GET
	@Path("getallbook")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public BookListType getAllBookInfo();
}