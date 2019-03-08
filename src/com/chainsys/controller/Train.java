package com.chainsys.controller;

public class Train {
	private int id;
	private String name;
	private String source;
	private String destination;
	private String duration;
	private String category;
	private double price;
	
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	
	
	@Override
	public String toString() {
		return "Train [id=" + id + ", name=" + name + ", source=" + source + ", destination=" + destination
				+ ", duration=" + duration + ", category=" + category + ", price=" + price + "]";
	}
}
