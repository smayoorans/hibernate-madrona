package com.madrona.hibernate;


import com.madrona.hibernate.dao.EmployeeDao;
import com.madrona.hibernate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


@ContextConfiguration(locations = {"/applicationContext.xml"})
public class EmployeeDaoImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSave() throws Exception {

        Employee em1 = new Employee("Mary Smith", 25);
        Employee em2 = new Employee("John Aces", 32);
        Employee em3 = new Employee("Ian Young", 29);

        employeeDao.save(em1);

        System.out.println("Inserted into database");
    }
}