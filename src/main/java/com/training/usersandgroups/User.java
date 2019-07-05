package com.training.usersandgroups;

public class User {
	private String userName;
	private String userId;

	public User(String userName, String userId) {
		this.userName = userName;
		this.userId = userId;
	}

	public User() {
		super();
	}

	public String uniqueIdentifier() {
		return userId;
	}

	public String getUser() {
		return this.userName;
	}

	public String toString() {
		return "username:" + userName + ",userId:" + userId;
	}
}
