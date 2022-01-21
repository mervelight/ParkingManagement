package com.example.parkingmanagementsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class CarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	private String firstname; //isim
	private String lastname; //soyisim
	private String make; //marka
	private String model; //model
	private String color; //renk
	private String platenumber; //plaka
	
	//constructor yapısını oluşturuyoruz.Neden üç tane
	public CarEntity() {
		super();
	}

	
	public CarEntity(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}


	public CarEntity(String firstname, String lastname, String make, String model, String color, String platenumber) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.make = make;
		this.model = model;
		this.color = color;
		this.platenumber = platenumber;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", make=" + make
				+ ", model=" + model + ", color=" + color + ", platenumber=" + platenumber + "]";
	}
	

}