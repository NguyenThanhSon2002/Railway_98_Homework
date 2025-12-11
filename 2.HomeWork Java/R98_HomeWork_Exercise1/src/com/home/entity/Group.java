package com.home.entity;

import java.time.LocalDate;

public class Group {

	public int GroupID;
	public String GroupName;
	public Account CreatorID;
	public LocalDate CreateDate;

	@Override
	public String toString() {
		return "Group [GroupID = " + GroupID + ", GroupName = " + GroupName + ", CreatorID = " + CreatorID
				+ ", CreateDate = " + CreateDate + "]";
	}

}
