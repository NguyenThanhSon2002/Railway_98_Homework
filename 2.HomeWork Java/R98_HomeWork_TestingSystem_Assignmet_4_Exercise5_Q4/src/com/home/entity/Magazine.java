package com.home.entity;

public class Magazine extends Document {
	private int issueNumber;
	private int createMonth;

	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Magazine(int docID, String creator, int releaseNumber) {
		super(docID, creator, releaseNumber);
		// TODO Auto-generated constructor stub
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public int getcreateMonth() {
		return createMonth;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	public void setcreateMonth(int createMonth) {
		this.createMonth = createMonth;
	}

	@Override
	public String toString() {
		return "Magazine: " + super.toString() + "[issueNumber=" + issueNumber + ", createMonth=" + createMonth + "]";
	}

}
