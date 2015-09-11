package com.madrona.hibernate;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends AbstractRepo<Employee> implements EmployeeDao {

    public EmployeeDaoImpl() {
        super(Employee.class);
    }

    @Override
    public boolean save(Employee employee) {
        return super.save(employee);
    }
}
