package com.madrona.hibernate.dao;

import com.madrona.hibernate.model.Employee;

public interface EmployeeDao {

    boolean save(Employee employee);

}
