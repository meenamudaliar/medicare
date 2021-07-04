package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="adminname")
	private String adminname;
	@Column(name="password")
	private String password;
	@Column(name="email_id")
	private String emailid;
	@Column(name="address")
	private String address;
	@Column(name="phone_no")
	private long phoneno;
	public long getId() {
		return id;
	}
	public Admin() {
		
	}
	public Admin(long id, String adminname, String password, String emailid, String address, long phoneno) {
		super();
		this.id = id;
		this.adminname = adminname;
		this.password = password;
		this.emailid = emailid;
		this.address = address;
		this.phoneno = phoneno;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public void setId(long id) {
		this.id = id;
	}
}
