package com.home.entity;

import java.time.LocalDate;

public class Account {

	public int accoutID;
	public String email;
	public String userName;
	public String fullName;
	public Department department;
	public Position position;
	public LocalDate createDate;

	// Question 2:
	// Tạo constructor cho Account:
	// a) Không có parameters
	// b) Có các parameter là id, Email, Username, FirstName,
	// LastName (với FullName = FirstName + LastName)
	// c) Có các parameter là id, Email, Username, FirstName,
	// LastName (với FullName = FirstName + LastName) và
	// Position của User, default createDate = now
	// d) Có các parameter là id, Email, Username, FirstName,
	// LastName (với FullName = FirstName + LastName) và
	// Position của User, createDate

	public Account() {

	}

	public Account(int id, String email, String userName, String firstName, String lastName) {
		this.accoutID = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;

	}

	public Account(int id, String email, String userName, String firstName, String lastName, Position position) {
		this.accoutID = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = LocalDate.now();

	}

	public Account(int id, String email, String userName, String firstName, String lastName, Position position,
			LocalDate createDate) {
		this.accoutID = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = createDate;

	}

	public void showAccInfo() {
		System.out.println("Account [accoutID=" + this.accoutID + ", email=" + this.email + ", userName="
				+ this.userName + ", fullName=" + this.fullName + ", department=" + this.department + ", position="
				+ this.position + ", createDate=" + this.createDate + "]");
	}

}
