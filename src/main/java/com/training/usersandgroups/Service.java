package com.training.usersandgroups;

import java.util.ArrayList;
import java.util.List;


public class Service {
	private List<User> users = new ArrayList<User>();
	private List<Group> groups = new ArrayList<Group>();

	public void addUserToGroup(User user) {

		users.add(user);

	}

	public void removeUserFromGroup(User user) {
		if (user == null)
			throw new RuntimeException("user not exist");
		if (users.contains(user)) {
			users.remove(user);
		}

	}

	public List<String> usersInTheUsersList() {
		List<String> usersNames = new ArrayList<String>();
		for (User user : users) {
			if (user == null || users.isEmpty()) {
				throw new RuntimeException("no users added");

			}
			usersNames.add(user.getUser());

		}
		return usersNames;
	}

	public void addGroupToGroup(Group group) {
		groups.add(group);
	}

	public void removeGroupFromGroup(Group group) {
		if (group == null)
			throw new RuntimeException("group not exist");
		if (groups.contains(group)) {
			groups.remove(group);
		}

	}

	public List<String> groupsInTheGroupsList() {
		List<String> groupNames = new ArrayList<String>();
		for (Group group : groups) {
			if (group == null || groups.isEmpty()) {
				System.out.println("users of this group:");
				throw new RuntimeException("no users added");

			}
			groupNames.add(group.getGroup());

		}
		return groupNames;
	}
	public int getNoOfUsersOfAGroup()
	{
		return users.size();
	}
	public int getNoOfGroupsOfAGroup()
	{
		return groups.size();
	}
}
