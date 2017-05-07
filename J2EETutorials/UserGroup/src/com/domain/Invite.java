package com.domain;

public class Invite {

	private final int id;
	private String message;
	private int groupID;
	private int senderID;
	private int recipientID;
	private String status;
	
	public Invite(int id,String message,int groupID,int recipientID,String status)
	{
		this.id = id;
		this.message = message;
		this.groupID = groupID;
		this.recipientID = recipientID;
		this.status = status;
	}
	public void accept(){
		
	}
	
	public void decline(){
	
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getSenderID() {
		return senderID;
	}

	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}

	public int getRecipientID() {
		return recipientID;
	}

	public void setRecipientID(int recipientID) {
		this.recipientID = recipientID;
	}

	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
