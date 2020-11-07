package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmpDao;
import com.app.pojos.Employee;

@Service // B.L methods
@Transactional
public class EmpServiceImpl implements IEmpService {
	@Autowired
	private IEmpDao dao;

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return dao.getAllEmps();
	}

	@Override
	public Employee getEmpById(int empId) {
		// TODO Auto-generated method stub
		return dao.getEmpById(empId);
	}

	@Override
	public Employee addEmpDetails(Employee e) {
		// TODO Auto-generated method stub
		return dao.addEmpDetails(e);
	}

	@Override
	public void deleteEmpDetails(int empId) {
		Employee empById = dao.getEmpById(empId);
		if(empById != null)
			dao.deleteEmp(empById);
		
	}
	
	

}
