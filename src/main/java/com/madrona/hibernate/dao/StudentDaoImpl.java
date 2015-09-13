package com.madrona.hibernate.dao;

import com.madrona.hibernate.model.Employee;
import com.madrona.hibernate.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl extends AbstractRepo<Student> implements StudentDao {

    public StudentDaoImpl() {
        super(Student.class);
    }

    public boolean save(Student student) {
        return super.save(student);
    }

    public Student findById(int id) {
        return super.getById(id);
    }

    public List<Student> getAll() {
        return super.getAll();
    }

    public List<Student> findByProperty(String propertyName, Object value) {
        return super.find(propertyName, value);
    }

    public boolean delete(Student Student) {
        return super.delete(Student);
    }

    public boolean update(Student Student) {
        return super.update(Student);
    }
}
