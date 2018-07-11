package com.zzy.test.entity;

public class Message {
	private int messageId;
	private String messageLabel;
	private String messageDate;
	private String username;
	public Message(int messageId, String messageLabel, String messageDate, String username) {
		super();
		this.messageId = messageId;
		this.messageLabel = messageLabel;
		this.messageDate = messageDate;
		this.username = username;
	}
	
	public Message(String messageLabel, String username) {
		super();
		this.messageLabel = messageLabel;
		this.username = username;
	}

	public Message(String messageLabel, String messageDate, String username) {
		super();
		this.messageLabel = messageLabel;
		this.messageDate = messageDate;
		this.username = username;
	}
	
	public Message(int messageId, String messageLabel, String messageDate) {
		super();
		this.messageId = messageId;
		this.messageLabel = messageLabel;
		this.messageDate = messageDate;
	}
	public Message() {
		
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessageLabel() {
		return messageLabel;
	}
	public void setMessageLabel(String messageLabel) {
		this.messageLabel = messageLabel;
	}
	public String getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
