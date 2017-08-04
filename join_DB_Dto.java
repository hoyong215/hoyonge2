package com.exam.spring01.Dto;

public class join_DB_Dto {
	private int customercode;
	private String userid;
	private String pass;
	private String name;
	private int phone;
	private int jumin;
	private String email;

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getJumin() {
		return jumin;
	}
	public void setJumin(int jumin) {
		this.jumin = jumin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCustomercode() {
		return customercode;
	}
	public void setCustomercode(int customercode) {
		this.customercode = customercode;
	}
	@Override
	public String toString() {
		return "join_DB_Dto [customercode=" + customercode + ", userid=" + userid + ", pass=" + pass + ", name=" + name
				+ ", phone=" + phone + ", jumin=" + jumin + ", email=" + email + "]";
	}
	public join_DB_Dto(int customercode, String userid, String pass, String name, int phone, int jumin, String email) {
		super();
		this.customercode = customercode;
		this.userid = userid;
		this.pass = pass;
		this.name = name;
		this.phone = phone;
		this.jumin = jumin;
		this.email = email;
	}

	
	

	
}
