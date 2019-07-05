package com.training.usersandgroups;

public class Group {
	Service service=new Service();
	private String groupName;
	private String groupId;
	public Group(String gName, String gId) {
		groupName = gName;
		groupId = gId;
	}
public Group()
{
	
}
	public String uniqueIdentifier() {
		return groupId;
	}

	public String getGroup() {
		return groupName;
	}
	public String toString() {
		return "groupName:" + groupName + ",groupId:" + groupId;
	}

	public void addGroupToGroup(Group group) {
		service.addGroupToGroup(group);
		
	}

	public void addUserToGroup(User user) {
		service.addUserToGroup(user);
		
	}

	public void removeUserFromGroup(User user) {
		service.removeUserFromGroup(user);
		
	}
}
