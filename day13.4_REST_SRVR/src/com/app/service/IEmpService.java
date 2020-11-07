package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmpService {
	List<Employee> getAllEmps();
	Employee getEmpById(int empId);
	Employee addEmpDetails(Employee e);//e --transient 
	void deleteEmpDetails(int empId);
}
