package com.madrona.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeTest  extends AbstractRepo<Employee>{

	public EmployeeTest() {
		super(Employee.class);
	}

	public static void main(String[] args) {

		Employee em1 = new Employee("Mary Smith", 25);
		Employee em2 = new Employee("John Aces", 32);
		Employee em3 = new Employee("Ian Young", 29);

		EmployeeTest employeeTest = new EmployeeTest();

		employeeTest.save(em1);

		Employee byId = employeeTest.getById(1);
		System.out.println(byId);

		System.exit(0);


	}
	
}
