package com.app.dao;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmpDao {
	List<Employee> getAllEmps();
	Employee getDetailsById(int id);
	Employee addEmpDetails(Employee e);
}
