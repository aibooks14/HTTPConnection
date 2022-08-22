package com.example.demo.HttpRequestDone;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L ;
	
	private String name ;
	private String job ;
	private int tel ;
	private String address ;
	



	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Student(String name, String job, int tel, String address) {
		super();
		this.name = name;
		this.job = job;
		this.tel = tel;
		this.address = address;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	

	
	
	
}
