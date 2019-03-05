package com.chainsys.controller;

public class Details {
     private int seats;
     private String category;
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Details [seats=" + seats + ", category=" + category + "]";
	}
}
