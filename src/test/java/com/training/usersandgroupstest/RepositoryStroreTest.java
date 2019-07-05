package com.training.usersandgroupstest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import com.training.usersandgroups.Group;
import com.training.usersandgroups.RepositoryStore;
import com.training.usersandgroups.User;

public class RepositoryStroreTest {
  RepositoryStore repo=new RepositoryStore();
	@Test
	public void addUserTest() {
		User user1=new User("user1","101");
		User user2=new User("user2","102");
		repo.addUser(user1);
		repo.addUser(user2);
		assertEquals(2,repo.getNoOfUsers());
	}
	@Test
	public void removeUserTest()
	{ 
	   repo.removeUser("101");
	   assertEquals(0,repo.getNoOfUsers());
	}
   @Test
   public void addGroupTest()
   {Group group1=new Group("group1","103");
      repo.addGroup(group1);
      assertEquals(1,repo.getNoOfGroups());
	   
   }
   @Test
   public void removeGroupTest()
   {
	   repo.removeGroup("103");
	   assertEquals(0,repo.getNoOfGroups());
   }
   @Test
   public void retrieveUserTest()
   {
	   assertEquals(null,repo.retriveUser("103"));
   }
   @Test
   public void retriveGroupTest()
   {
	   assertEquals(null,repo.retriveGroup("104"));
   }
   @Test
   public void getNoOfUsersTest()
   {
	   User user1=new User("user1","101");
		User user2=new User("user2","102");
		repo.addUser(user1);
		repo.addUser(user2);
		assertEquals(2,repo.getNoOfUsers());
   }
   @Test
   public void getNoOfGroupsTest()
   {
	   Group group1=new Group("group1","103");
	      repo.addGroup(group1);
	      assertEquals(1,repo.getNoOfGroups());
   }
   @Test
   public void retriveUsersTest()
   {  RepositoryStore repository=new RepositoryStore();
	   User user1=new User("user1","101");
		User user2=new User("user2","102");
		repo.addUser(user1);
		repo.addUser(user2);
		List<User> usersList=repository.retriveUsers();
		assertEquals(2,usersList.size());
   }
   @Test
   public void retriveGroupsTest()
   {  RepositoryStore repository=new RepositoryStore();
      Group group1=new Group("group1","103");
      repo.addGroup(group1);
      List<Group> groupsList=repository.retriveGroups();
      assertEquals(1,groupsList.size());
	   
   }
   
}
