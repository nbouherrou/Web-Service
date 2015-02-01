package com.nacer_ahmed.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "office")
@XmlAccessorType(XmlAccessType.FIELD)
public class Office implements Comparable<Office> {
	private int ID;
	private String city;
	private String manager_name;
	private int year_founded;
	private String email;

	public Office(String city, String manager_name, int year_founded,
			String email) {
		super();
		this.city = city;
		this.manager_name = manager_name;
		this.year_founded = year_founded;
		this.email = email;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public int getYear_founded() {
		return year_founded;
	}

	public void setYear_founded(int year_founded) {
		this.year_founded = year_founded;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Office o) {
		// TODO Auto-generated method stub
		return (this.city.compareTo(o.city));

	}

	public Office() {
		super();
	}

}
