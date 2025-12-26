package com.home.entity;

public class Book extends Document {
	private String nameCreator;
	private int pageNumber;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int docID, String creator, int releaseNumber) {
		super(docID, creator, releaseNumber);
		// TODO Auto-generated constructor stub
	}

	public String getNameCreator() {
		return nameCreator;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setNameCreator(String nameCreator) {
		this.nameCreator = nameCreator;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "Book: " + super.toString() + "[nameCreator=" + nameCreator + ", pageNumber=" + pageNumber + "]";
	}

}
