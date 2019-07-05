package com.training.usersandgroupstest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.*;
import org.junit.Test;

import com.training.usersandgroups.Group;
import com.training.usersandgroups.RepositoryStore;
import com.training.usersandgroups.Service;
import com.training.usersandgroups.User;


public class GroupTest {

	@Test
	public void fieldNames_Are_Correct()
	{   Group group=new Group();
	Field[] fields=group.getClass().getFields();
		List<String> fieldNames=new ArrayList<String>();
		for(Field field:fields)
		{
		    	fieldNames.add(field.getName());
		}
		assertTrue(Arrays.asList("groupNames","groupid").containsAll(fieldNames));
		System.out.println("group field names are verified correctly ");
	}
	@Test
	public void getGroupTest()
	{
		Group group=new Group("g1","1");
		assertEquals("g1",group.getGroup());
		System.out.println("get group method verified correctly");
	}
	@Test
	public void uniqueIdentiferTest()
	{
		Group group=new Group("g1","1");
		assertEquals("1",group.uniqueIdentifier());
		System.out.println("get uniqeuIdentifier verified correctly ");
		
	}
	@Test
	public void addGroupTest()
	{
		RepositoryStore repo=new RepositoryStore();
		Group group1=new Group("group11","100");
		Group group2=new Group("group2","101");
		repo.addGroup(group1);
		repo.addGroup(group2);
		assertEquals(2,repo.getNoOfGroups());
		System.out.println("add Group method verified correctly");
	}
	@Test
	public void removeGroupTest()
	{
		RepositoryStore repo=new RepositoryStore();
		Group group1=new Group("group11","100");
		Group group2=new Group("group2","101");
		repo.addGroup(group1);
		repo.addGroup(group2);
		repo.removeGroup(group1.uniqueIdentifier());
		assertEquals(1,repo.getNoOfGroups());
		System.out.println("remove Group method verified correctly");
	}
	@Test
	public void addUserToTheGroupTest()
	{
		User user1=new User("user1","100");
		User user2=new User("user2","100");
		Service service=new Service();
		service.addUserToGroup(user1);
		service.addUserToGroup(user2);
		assertEquals(2,service.getNoOfUsersOfAGroup());
		
	}
	@Test
	public void removeUserFromGroupTest()
	{
		User user1=new User("user1","100");
		User user2=new User("user2","100");
		Service service=new Service();
		service.addUserToGroup(user1);
		service.addUserToGroup(user2);
		service.removeUserFromGroup(user1);
		assertEquals(1,service.getNoOfUsersOfAGroup());
	}
	@Test
	public void addGroupToGroupTest()
	{
		Group group1=new Group("group1","102");
		Group group2=new Group("group2","103");
		Service service=new Service();
		service.addGroupToGroup(group1);
		service.addGroupToGroup(group2);
		assertEquals(2,service.getNoOfGroupsOfAGroup());
		
		
	}
	@Test
	public void removeGroupFromAGroupTest()
	{
		Group group1=new Group("group1","102");
		Group group2=new Group("group2","103");
		Service service=new Service();
		service.addGroupToGroup(group1);
		service.addGroupToGroup(group2);
		service.removeGroupFromGroup(group2);
		assertEquals(1,service.getNoOfGroupsOfAGroup());
		
	}

}
