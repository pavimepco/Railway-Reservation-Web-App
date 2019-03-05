package com.chainsys.controller;

public class Passenger {
	private String email;
	@Override
	public String toString() {
		return "Passenger [email=" + email + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", mobileNumber=" + mobileNumber + "]";
	}
	private String password;
	private String name;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	private String gender;
	private int age;
	private long mobileNumber;
}
