package com.madrona.hibernate;


import com.madrona.hibernate.dao.StudentDao;
import com.madrona.hibernate.model.Address;
import com.madrona.hibernate.model.Employee;
import com.madrona.hibernate.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


@ContextConfiguration(locations = {"/applicationContext.xml"})
public class StudentDaoImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testSave() throws Exception {

        Student st1 = new Student("Mary Smith", 25);

        Address address1 = new Address();
        address1.setStreet("My Streeet");
        address1.setCity("Jaffna");
        address1.setStudent(st1);

        st1.setAddress(address1);

        boolean saved1 = studentDao.save(st1);
        Assert.assertEquals(saved1, true);




        //Get by id
        Student student = studentDao.findById(1);

        Assert.assertEquals(student.getAge(), 25);
        Assert.assertEquals(student.getAddress().getCity(), "Jaffna");

        System.out.println("==========" + student);


        //update
        student.setName("Mayooran");
        student.getAddress().setStreet("Velanai");
        boolean updatedStudent = studentDao.update(student);
        Assert.assertEquals(updatedStudent, true);


        List<Student> studentByProperty = studentDao.findByProperty("address.city", "Jaffna");
        Assert.assertEquals(studentByProperty.get(0).getAge(), 25);
        System.out.println("=======Find by property======" + studentByProperty.get(0));


        //Delete
//        boolean deleted = studentDao.delete(studentByProperty.get(0));
//        Assert.assertEquals(deleted, true);

    }
}