package com.training.usersandgroups;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RepositoryStore {
	private static Map<String, User> usersMap = new ConcurrentHashMap<String, User>();
	private static Map<String, Group> groupMap = new ConcurrentHashMap<String, Group>();

	public RepositoryStore() {
		super();
	}

	public void addUser(final User user) {
		usersMap.put(user.uniqueIdentifier(), user);
	}

	public void removeUser(final String userId) {

		if (usersMap.containsKey(userId)) {
			for (Group group : groupMap.values()) {
				List<String> usersList = group.service.usersInTheUsersList();
				for (String user : usersList) {
					if (user.equals(usersMap.get(userId).getUser()))
						group.service.removeUserFromGroup(usersMap.get(userId));
				}
			}
			usersMap.remove(userId);
		}

	}

	public void addGroup(final Group group) {
		groupMap.put(group.uniqueIdentifier(), group);
	}

	public void removeGroup(final String gId) {
		if (groupMap.containsKey(gId)) {
			for (Group group : groupMap.values()) {
				List<String> groupsList = group.service.groupsInTheGroupsList();
				for (String groupName : groupsList) {
					if (groupName.equals(groupMap.get(gId).getGroup()))
						group.service.removeGroupFromGroup(groupMap.get(gId));
				}
			}
			groupMap.remove(gId);
		}
	}

	public User retriveUser(String id) {
		for (User user : usersMap.values()) {
			if (user.uniqueIdentifier().contentEquals(id))
				return user;

		}
		return null;
	}

	public List<User> retriveUsers() {
		List<User> usersList = new ArrayList<User>();
		for (User user : usersMap.values())
			usersList.add(user);
		return usersList;

	}

	public Group retriveGroup(String id) {
		for (Group group : groupMap.values()) {
			if (group.uniqueIdentifier().contentEquals(id))
				return group;

		}
		return null;

	}
   public List<Group> retriveGroups()
   {
	   List<Group> groupsList = new ArrayList<Group>();
		for (Group group : groupMap.values())
			groupsList.add(group);
		return groupsList;
   }
	public List<List<String>> usersAndGroupsOfGroup() {
		List<Group> groupList = new ArrayList<Group>();
		for (Group group : groupMap.values())
			groupList.add(group);
		for (Group group : groupList) {
			if (group == null)
				throw new RuntimeException("group not exist");

			else {
				
				List<List<String>> list = new ArrayList<List<String>>();
				List<String> usersList = new ArrayList<String>();
				List<String> groupsList = new ArrayList<String>();
				usersList = group.service.usersInTheUsersList();
				groupsList = group.service.groupsInTheGroupsList();

				list.add(usersList);
				list.add(groupsList);
				return list;
			}

		}

		return null;
	}

	public int getNoOfUsers() {
		return usersMap.size();
	}

	public int getNoOfGroups() {
		return groupMap.size();
	}
}
