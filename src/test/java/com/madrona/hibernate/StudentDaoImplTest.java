package com.madrona.hibernate;


import com.madrona.hibernate.dao.StudentDao;
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
        Student st2 = new Student("John Aces", 32);
        Student st3 = new Student("Ian Young", 29);

        boolean saved1 = studentDao.save(st1);
        Assert.assertEquals(saved1, true);
        boolean saved2 = studentDao.save(st2);
        Assert.assertEquals(saved2, true);
        boolean saved3 = studentDao.save(st3);
        Assert.assertEquals(saved3, true);



        //Get by id
        Student student = studentDao.findById(1);
        Assert.assertEquals(student.getAge(), 25);
        System.out.println("==========" + student);


        //update
        student.setName("Mayooran");
        boolean updatedStudent = studentDao.update(student);
        Assert.assertEquals(updatedStudent, true);


        List<Student> studentList = studentDao.getAll();
        Assert.assertEquals(studentList.size(), 3);
        for (Student aStudent : studentList) {
            System.out.println(aStudent);
            System.out.println("================");
        }

        List<Student> studentByProperty = studentDao.findByProperty("name", "Ian Young");
        Assert.assertEquals(studentByProperty.get(0).getAge(), 29);
        System.out.println("=======Find by property======" + studentByProperty);


        //Delete
        boolean deleted = studentDao.delete(studentByProperty.get(0));
        Assert.assertEquals(deleted, true);

    }
}