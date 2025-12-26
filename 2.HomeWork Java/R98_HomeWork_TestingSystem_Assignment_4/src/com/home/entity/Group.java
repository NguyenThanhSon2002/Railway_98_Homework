package com.home.entity;

import java.time.LocalDate;

public class Group {

	public int groupID;
	public String groupName;
	public Account creatorID;
	public LocalDate createDate;

	// Question 3:
	// Tạo constructor cho Group:
	// a) không có parameters
	// b) Có các parameter là GroupName, Creator, array Account[]
	// accounts, CreateDate
	// c) Có các parameter là GroupName, Creator, array String[]
	// usernames , CreateDate
	// Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
	// username, các thông tin còn lại = null).

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Group(int id, String groupName, Account creator, Account[] accounts, LocalDate creaDate) {
		this.groupID = id;
		this.groupName = groupName;
		this.creatorID = creator;
		this.createDate = creaDate;

	}

	public void showGrInfo() {
		System.out.println("Group [GroupID=" + groupID + ", GroupName=" + groupName + ", CreatorID=" + creatorID
				+ ", CreateDate=" + createDate + "]");
	}

}
