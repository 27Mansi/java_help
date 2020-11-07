package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;
@Repository
public class EmpDaoImpl implements IEmpDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Employee> getAllEmps() {
		String jpql="select e from Employee e";
		return sf.getCurrentSession().createQuery(jpql,Employee.class).getResultList();
	}

	@Override
	public Employee getDetailsById(int id) {
		
		return sf.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public Employee addEmpDetails(Employee e) {
		sf.getCurrentSession().persist(e);
		return e;
	}
	
}
