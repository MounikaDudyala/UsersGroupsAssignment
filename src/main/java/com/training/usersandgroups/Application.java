package com.training.usersandgroups;

import java.util.Scanner;

public class Application {
	static Scanner sc = new Scanner(System.in);
	static RepositoryStore repository=new RepositoryStore();
		public static void main(String args[]) {

			printMenu();
			processMenu();
		}
	
		public static void printMenu() {
			System.out.println("1.Create User\t2.Create Group\t3.Remove User\t4.Remove Group\t5.Add User to the Group");
			System.out.println("6.Remove User From a group\t7.Add group to a Group\t8.Available users\t9.Available Groups");
		}

		public static void processMenu() {
			System.out.println("choose your option");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				createUser();
				break;
			case 2:
				createGroup();
				break;
			case 3:
				removeUser();
				break;
			case 4:
				removeGroup();
				break;
			case 5:
				addUserToGroup();
				break;
			case 6:
				removeUserFromGroup();
				break;
			case 7:
				addGroupToGroup();
				break;
			case 8:
				availableUsers();
				break;
			case 9:
				availableGroups();
				break;
			default:
				System.out.println("please choose valid option");
			}
			printMenu();
			processMenu();
		}

		public static void createUser() {
			System.out.println("give userName");
			String userName = sc.next();
			System.out.println("give userId");
			String id = sc.next();
			User user = new User(userName, id);
			//Repository repository = Repository.getInstance();
			repository.addUser(user);
			System.out.println("user created");

		}

		public static void createGroup() {
			System.out.println("give groupName");
			String groupName = sc.next();
			System.out.println("give groupId");
			String id = sc.next();
			Group group = new Group(groupName, id);
			//Repository repository = Repository.getInstance();
			repository.addGroup(group);
			System.out.println("group created");

		}

		public static void removeUser() {
			System.out.println("give user id you want to remove");
			String id = sc.next();
			//Repository repository = Repository.getInstance();
			repository.removeUser(id);
	      
		}

		public static void removeGroup() {
			System.out.println("give group id you want to remove");
			String id = sc.next();
			//Repository repository = Repository.getInstance();
			repository.removeGroup(id);
		}

		public static void addUserToGroup() {
			System.out.println("give groupId to which group you wants to add");
			String id = sc.next();
			//Repository repository = Repository.getInstance();
			addingUserToTheGroup(repository.retriveGroup(id));
		}

		public static void addingUserToTheGroup(Group group) {
			System.out.println("give user id you want to add to group");
			String id = sc.next();
			//Repository repository = Repository.getInstance();
			 
			group.addUserToGroup(repository.retriveUser(id));
			

		}

		public static void addGroupToGroup() {
			System.out.println("give groupId to which group you wants to add");
			String id = sc.next();
			//Repository repository = Repository.getInstance();
			addingGroupToGroup(repository.retriveGroup(id));
		}

		public static void addingGroupToGroup(Group group) {
			System.out.println("give Group id you want to add to group");
			String id = sc.next();
			//Repository repository = Repository.getInstance();
			
			group.addGroupToGroup(repository.retriveGroup(id));

		}

		public static void removeUserFromGroup() {
			System.out.println("give Group id you want to remove from it");
			String id = sc.next();
			//Repository repository = Repository.getInstance();
			removingUserFromGroup(repository.retriveGroup(id));
		}

		public static void removingUserFromGroup(Group group) {
			System.out.println("give User id you want to remove from a group");
			String id = sc.next();
			//Repository repository = Repository.getInstance();
			 
			group.removeUserFromGroup(repository.retriveUser(id));

		}

		public static void availableUsers() {
			//Repository repository = Repository.getInstance();

			repository.retriveUsers();
		}

		public static void availableGroups() {
			//Repository repository = Repository.getInstance();

			repository.retriveGroups();
		}
}
