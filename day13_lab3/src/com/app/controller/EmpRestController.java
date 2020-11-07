package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Employee;
import com.app.service.IEmpService;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping("/employees")
@CrossOrigin//the def val of(origins = *)

public class EmpRestController {
	@Autowired
	private IEmpService service;
	@PostConstruct
	public void init() {
		System.out.println("in init "+service);
	}
	
	//REQ handling methods to get all emps
	@GetMapping
	public ResponseEntity<?> getAllEmps(){
		System.out.println("in get all emps");
		List<Employee> allEmps=service.getAllEmps();
		if(allEmps.size()==0)			
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Employee>>(allEmps,HttpStatus.OK);
		
	}
	@GetMapping("/{emp_id}")
	public ResponseEntity<?> getEmpDetails(@PathVariable int emp_id) {
		System.out.println("in emp dtls " + emp_id);
		Employee e = service.getEmpById(emp_id);
		if (e == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	
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
}


















