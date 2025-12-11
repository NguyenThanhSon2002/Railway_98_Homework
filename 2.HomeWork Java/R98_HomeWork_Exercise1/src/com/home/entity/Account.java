package com.home.entity;

import java.time.LocalDate;

public class Account {

	public int AccoutID;
	public String Email;
	public String UserName;
	public String FullName;
	// java ko tham chiếu kiểu khóa ngoại giống db mà tham chiếu theo đối tượng
	public Department Department;
	public Position Position;
	public LocalDate createDate;

	// thể hiện account tham gia nhiều group
	public Group[] groups;

	@Override
	public String toString() {
		return "Account [AccoutID = " + AccoutID + ", Email = " + Email + ", UserName = " + UserName + ", FullName = "
				+ FullName + ", Department = " + Department + ", Position = " + Position + ", createDate = "
				+ createDate + "]";
	}

}
