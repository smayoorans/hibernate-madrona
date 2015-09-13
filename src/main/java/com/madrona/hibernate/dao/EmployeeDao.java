package com.madrona.hibernate.dao;

import com.madrona.hibernate.model.Employee;

import java.util.List;

public interface EmployeeDao {

    boolean save(Employee employee);

    Employee findById(int id);

    List<Employee> getAll();

    List<Employee> findByProperty(String propertyName, Object value);

    boolean update(Employee employee);

    boolean delete(Employee employee);
}
