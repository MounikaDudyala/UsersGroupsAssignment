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
	User user=new User("mounika","100");
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
		
		assertEquals("mounika",user.getUser());
		System.out.println("get user method tetsed correctly");
		
	}
	@Test
	public void UniqueIdentifierTest()
	{
		
		assertEquals("100",user.uniqueIdentifier());
		System.out.println("get uniqueIdentifier method tested correctly");
	}

}
