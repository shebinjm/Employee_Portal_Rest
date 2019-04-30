package com.employee.rest.empmngr.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.employee.rest.empmngr.AbstractTest;
import com.employee.rest.empmngr.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeRepositoryIntegrationTest extends AbstractTest{

  @Autowired
  private EmployeeRepository employeeRepository;

  public EmployeeRepositoryIntegrationTest() {
  }

  @Before
  public void initializeDatabase() {
      System.out.println("seeding embedded database");
      Employee sam = new Employee();
      sam.setEmpId(1001);
      sam.setDesignation("Senior Manager");
      sam.setName("Sam");
      employeeRepository.save(sam);

      Employee sanjay = new Employee();
      sanjay.setEmpId(1002);
      sanjay.setDesignation("Senior Lead");
      sanjay.setName("Sanjay");
      employeeRepository.save(sanjay);
  }

  @Test
  @DirtiesContext
  public void testCount() {
      System.out.println("count");
      long employeeCount = employeeRepository.count();
      assertNotNull(employeeCount);
      assertEquals(2, employeeCount);
  }

  @Test
  @DirtiesContext
  public void testFindAll() {
      System.out.println("findAll");
      Collection<Employee> result = (Collection<Employee>) employeeRepository.findAll();
      assertNotNull(result);
      assertEquals(2, result.size());
  }



  @Test
  @DirtiesContext
  public void testDeleteAll() {
      System.out.println("deleteAll");
      employeeRepository.deleteAll();
      Collection<Employee> result = (Collection<Employee>) employeeRepository.findAll();
      assertEquals(0, result.size());
  }
}
