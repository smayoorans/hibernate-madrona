package com.madrona.hibernate.dao;

import com.madrona.hibernate.model.Employee;
import org.hibernate.ObjectNotFoundException;
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

    @Override
    public Employee findById(int id) throws ObjectNotFoundException {
        return super.getById(id);
    }


}
