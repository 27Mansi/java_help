package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vendors")
public class Vendor {
	private Integer id;
	@NotEmpty(message="Name must be supplied")
	private String name;
	@NotEmpty(message="Email must be supplied")
	@Email(message="Invalid email format")
	private String email;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="Invalid Password format")
	private String password;
	@NotNull(message="Role must be chosen")
	private Role userRole;
	@NotNull(message="reg must  must not be blank")
	@Range(min=100,max=5000,message="Invalid reg amount")
	private double regAmount;
	@NotNull(message="Reg date must be supplied")
	@DateTimeFormat(pattern="yyyy-MM-dd")//SDF sdf=new SDF("yyyy-MM-dd")
	private Date regDate;
	// one to many bi dir asso between 2 entities , inverse side, parent , one side
	private List<BankAccount> accounts = new ArrayList<>();

	public Vendor() {
		System.out.println("in vendor ctor");
	}

	public Vendor(String name, String email, String password, Role userRole, double regAmount, Date regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.regAmount = regAmount;
		this.regDate = regDate;
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

	@Column(length = 20, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role", length = 20)
	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	@Column(name = "reg_amt", columnDefinition = "double(6,1)")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reg_date")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}
	//add helper method to add/remove a/c
	public void addAccount(BankAccount a)
	{
		accounts.add(a);
		a.setOwner(this);
	}
	public void removeAccount(BankAccount a)
	{
		accounts.remove(a);
		a.setOwner(null);
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", userRole="
				+ userRole + ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}

}
