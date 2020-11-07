package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmpDao;
import com.app.pojos.Employee;
@Service
@Transactional
public class EmpServiceImpl implements IEmpService {
	@Autowired
	private IEmpDao dao;
	
	@Override
	public List<Employee> getAllEmps() {
		return dao.getAllEmps();
	}

	@Override
	public Employee getEmpById(int id) {

		return dao.getDetailsById(id);
	}

	@Override
	public Employee addEmpDetails(Employee e) {
		return dao.addEmpDetails(e);
	}
 
}
