package com.factory;

public class StudentBean {

	private int id;
	private String name;
	private String sex;
	private String date;
	private String phone;
	private String email;
	private String address;
	private String other;
	
	public StudentBean() {
		
	}
	
	public StudentBean(int id, String name, String sex) {
		
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	
	public StudentBean(int id, String name, String sex, String date, String phone, String email, String address,
			String other) {
	
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.date = date;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.other = other;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
		
}
