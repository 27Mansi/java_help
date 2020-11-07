package com.app.dao;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmpDao {
	List<Employee> getAllEmps();
	Employee getEmpById(int empId);
	Employee addEmpDetails(Employee e);//e --transient 
	void deleteEmp(Employee e);
}
