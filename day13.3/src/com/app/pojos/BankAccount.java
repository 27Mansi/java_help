package com.app.pojos;
import javax.persistence.*;

@Entity
@Table(name="vendor_accts")
public class BankAccount {
	private Integer acctId;
	private double balance;
	private AcType type;
	//bi dir asso between entities
	//owning side, many side, child side
	private Vendor owner;
	public BankAccount() {
		System.out.println("in bank accts ctor");
	}
	public BankAccount(double balance, AcType type) {
		super();
		this.balance = balance;
		this.type = type;
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="acct_id")
	public Integer getAcctId() {
		return acctId;
	}
	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Enumerated(EnumType.STRING)
	@Column(length=20,name="ac_type")
	public AcType getType() {
		return type;
	}
	public void setType(AcType type) {
		this.type = type;
	}
	@ManyToOne
	@JoinColumn(name="vendor_id")
	public Vendor getOwner() {
		return owner;
	}
	public void setOwner(Vendor owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "BankAccount [acctId=" + acctId + ", balance=" + balance + ", type=" + type + "]";
	}
	

}
