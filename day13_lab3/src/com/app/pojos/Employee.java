package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

//import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="dac_employees")
@JsonIgnoreProperties(value = {"image","salary"})
public class Employee {
	@JsonProperty(value = "no")
	private Integer id;
	private String name,address;
	private double salary;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone ="IST" )
	//timezone should be applied to avoid one day offset
	
	private Date hireDate;
	private byte[] image;
	
	public Employee() {
		System.out.println("in employee ctor");
	}
	
	public Employee(String name, String address, Date hireDate) {
		super();
		this.name = name;
		this.address = address;
		this.hireDate = hireDate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 20)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="hire_date")
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	@Lob
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Column(name="salary",columnDefinition="double(6,1)")
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", "
				+ "salary=" + salary + ", hireDate="
				+ hireDate + "]";
	}
	
}
