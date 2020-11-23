package com.cybage.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cybage.controller.Users;

@Repository
public class UserDao {
	private List<Users> users=new ArrayList<>();
	{
		users.add(new Users(101,"user1"));
		users.add(new Users(102,"user2"));
		users.add(new Users(103,"user3"));
		users.add(new Users(104,"user4"));
		users.add(new Users(105,"user5"));
	}
	
	public List<Users> getUsers(){
		return users;
	}

	public void deleteById(int id) {
		users.removeIf(u->u.getId()==id);
	}

	public void addUser(Users user) {
		users.add(user);
		
	}

	public Object findById(int id) {
		return users.
				stream().
				filter(u->u.getId()==id).
				findFirst();
	}
	public void updateUser(Users user) {
		users.removeIf(u->u.getId()==user.getId());
		users.add(user);
		
	}
}
