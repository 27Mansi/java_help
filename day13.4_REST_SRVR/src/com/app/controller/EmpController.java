package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.IEmpService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/employees")
public class EmpController {
	@Autowired
	private IEmpService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	// REST request handling method to get list of emps
	@GetMapping
	public ResponseEntity<?> listEmps() {
		System.out.println("in list emps");
		List<Employee> allEmps = service.getAllEmps();
		if (allEmps.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Employee>>(allEmps, HttpStatus.OK);
	}

	// REST request handling method to get emp by id
	@GetMapping("/{emp_id}")
	public ResponseEntity<?> getEmpDetails(@PathVariable int emp_id) {
		System.out.println("in emp dtls " + emp_id);
		Employee e = service.getEmpById(emp_id);
		if (e == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	// REST request handling method to create new resourec : Emp
	@PostMapping
	public ResponseEntity<?> addEmpDetails(@RequestBody Employee e) {
		System.out.println("in add emp dtls " + e);
		try {
			return new ResponseEntity<Employee>(service.addEmpDetails(e), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	// REST request handling method to delete existing resource : Emp
	@DeleteMapping("/{empId}")
	public void deleteEmpDetails(@PathVariable int empId)
	{
		System.out.println("in delete emp "+empId);
		service.deleteEmpDetails(empId);
	}
	
	

}
