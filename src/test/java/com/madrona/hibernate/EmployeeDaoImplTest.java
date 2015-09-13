package com.madrona.hibernate;


import com.madrona.hibernate.dao.EmployeeDao;
import com.madrona.hibernate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


@ContextConfiguration(locations = {"/applicationContext.xml"})
public class EmployeeDaoImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSave() throws Exception {

        Employee em1 = new Employee("Mary Smith", 25);
        Employee em2 = new Employee("John Aces", 32);
        Employee em3 = new Employee("Ian Young", 29);

        boolean saved1 = employeeDao.save(em1);
        Assert.assertEquals(saved1, true);
        boolean saved2 = employeeDao.save(em2);
        Assert.assertEquals(saved2, true);
        boolean saved3 = employeeDao.save(em3);
        Assert.assertEquals(saved3, true);



        //Get by id
        Employee employee = employeeDao.findById(1);
        Assert.assertEquals(employee.getAge(), 25);
        System.out.println("==========" + employee);


        //update
        employee.setName("Mayooran");
        boolean updatedEmployee = employeeDao.update(employee);
        Assert.assertEquals(updatedEmployee, true);


        List<Employee> employeeList = employeeDao.getAll();
        Assert.assertEquals(employeeList.size(), 3);
        for (Employee anEmployeeList : employeeList) {
            System.out.println(anEmployeeList);
            System.out.println("================");
        }

        List<Employee> employeeByProperty = employeeDao.findByProperty("name", "Ian Young");
        Assert.assertEquals(employeeByProperty.get(0).getAge(), 29);
        System.out.println("=======Find by property======" + employeeByProperty);

        

    }
}