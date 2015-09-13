package com.madrona.hibernate.dao;

import com.madrona.hibernate.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class EmployeeDaoImpl extends AbstractRepo<Employee> implements EmployeeDao {

    public EmployeeDaoImpl() {
        super(Employee.class);
    }

    public boolean save(Employee employee) {
        return super.save(employee);
    }

    public Employee findById(int id) {
        return super.getById(id);
    }

    public List<Employee> getAll() {
        return super.getAll();
    }

    public List<Employee> findByProperty(String propertyName, Object value) {
        return super.find(propertyName, value);
    }

    public boolean delete(Employee employee) {
        return super.delete(employee);
    }

    public boolean update(Employee employee) {
        return super.update(employee);
    }
}
