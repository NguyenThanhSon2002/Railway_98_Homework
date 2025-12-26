package com.home.entity;

public class Document {
	private int docID;
	private String creator;
	private int releaseNumber;

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(int docID, String creator, int releaseNumber) {
		super();
		this.docID = docID;
		this.creator = creator;
		this.releaseNumber = releaseNumber;
	}

	public int getDocID() {
		return docID;
	}

	public String getCreator() {
		return creator;
	}

	public int getReleaseNumber() {
		return releaseNumber;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setReleaseNumber(int releaseNumber) {
		this.releaseNumber = releaseNumber;
	}

	@Override
	public String toString() {
		return "Document: [docID=" + docID + ", creator=" + creator + ", releaseNumber=" + releaseNumber + "]";
	}

}