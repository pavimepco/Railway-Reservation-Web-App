package com.chainsys.controller;

public class Details {
     private String name;
     private String gender;
     private int age;
     private long mobile_number;
     private int seats;
     
     @Override
	public String toString() {
		return "Details [name=" + name + ", gender=" + gender + ", age=" + age + ", mobile_number=" + mobile_number
				+ ", seats=" + seats + ", total=" + total + "]";
	}
	private double total;
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
	public long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
     
}