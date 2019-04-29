package com.employee.rest.empmngr.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.employee.rest.empmngr.AbstractTest;
import com.employee.rest.empmngr.model.Employee;


public class EmployeeControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void getEmployeeList() throws Exception {
      String uri = "/employee/getall";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Employee[] employeeList = super.mapFromJson(content, Employee[].class);
      assertTrue(employeeList.length > 0);
   }
   @Test
   public void createEmployee() throws Exception {
      String uri = "/employee/create";
      Employee emp = new Employee();
      emp.setEmpId(321);
      emp.setName("Sam");
      String inputJson = super.mapToJson(emp);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(201, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Employee records created.");
   }
   @Test
   public void updateEmployee() throws Exception {
      String uri = "/employee/update/2";
      Employee emp = new Employee();
      emp.setName("zam");
      String inputJson = super.mapToJson(emp);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Employee record for employee-id= " + emp.getEmpId() + " updated.");
   }
   @Test
   public void deleteProduct() throws Exception {
      String uri = "/employee/delete/2";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Employee record for employee-id= " + 2 + " deleted.");
   }
}