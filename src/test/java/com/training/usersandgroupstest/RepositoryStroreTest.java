package com.training.usersandgroupstest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.training.usersandgroups.RepositoryStore;
import com.training.usersandgroups.User;

public class RepositoryStroreTest {
  RepositoryStore repo=new RepositoryStore();
	@Test
	public void addUserTest() {
		User user=new User("user1","101");
		repo.addUser(user);
		assertEquals(1,repo.getNoOfUsers());
	}

}
