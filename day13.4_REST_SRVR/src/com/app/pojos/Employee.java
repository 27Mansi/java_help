package com.app.pojos;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "dac_emps")
@JsonIgnoreProperties(value= {"image"})//to exclude these props 
//during marshalling
public class Employee {
	@JsonProperty(value="no")
	private Integer id;
	private String name, address;
//	@JsonIgnore
	private byte[] image;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date hireDate;

	public Employee() {
		// TODO Auto-generated constructor stub
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

	@Lob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="hire_date")
	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", hireDate=" + hireDate + "]";
	}

}
