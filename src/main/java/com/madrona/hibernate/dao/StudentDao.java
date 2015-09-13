package com.madrona.hibernate.dao;

import com.madrona.hibernate.model.Employee;
import com.madrona.hibernate.model.Student;

import java.util.List;

public interface StudentDao {

    boolean save(Student student);

    Student findById(int id);

    List<Student> getAll();

    List<Student> findByProperty(String propertyName, Object value);

    boolean update(Student student);

    boolean delete(Student student);
}
