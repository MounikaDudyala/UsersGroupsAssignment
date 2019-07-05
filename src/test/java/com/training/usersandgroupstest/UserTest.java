package com.training.usersandgroupstest;

import static org.junit.Assert.*;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.training.usersandgroups.RepositoryStore;
import com.training.usersandgroups.User;

public class UserTest {

	@Test
	public void fieldNames_Are_Correct()
	{   User user=new User();
	Field[] fields=user.getClass().getFields();
		List<String> fieldNames=new ArrayList<String>();
		for(Field field:fields)
		{
		    	fieldNames.add(field.getName());
		}
		assertTrue(Arrays.asList("groupNames","groupid").containsAll(fieldNames));
		System.out.println("group field names are verified correctly ");
	}
	@Test
	public void getUserTest()
	{
		User user=new User("mounika","101");
		assertEquals("mounika",user.getUser());
		System.out.println("get user method tetsed correctly");
		
	}
	@Test
	public void UniqueIdentifierTest()
	{
		User user=new User("mounika","101");
		assertEquals("101",user.uniqueIdentifier());
		System.out.println("get uniqueIdentifier method tested correctly");
	}
	@Test
	public void addUserTest()
	{
		RepositoryStore repo=new RepositoryStore();
		User user1=new User("user1","100");
		User user2=new User("user2","101");
		repo.addUser(user1);
		repo.addUser(user2);
		assertEquals(2,repo.getNoOfUsers());
		System.out.println("add user method verified correctly");
	}
	@Test
	public void removeUserTest()
	{
		RepositoryStore repo=new RepositoryStore();
		User user1=new User("user1","100");
		User user2=new User("user2","101");
		repo.addUser(user1);
		repo.addUser(user2);
		repo.removeUser(user1.uniqueIdentifier());
		assertEquals(1,repo.getNoOfUsers());
		System.out.println("remove user method verified correctly");
	}
	

}
