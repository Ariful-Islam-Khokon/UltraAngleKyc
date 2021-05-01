package com.ultraangle.service;

import java.util.List;
import java.util.UUID;

import com.ultraangle.entity.User;

public interface IUserService {
	public List<User> findAll();
	public User findById(UUID theId);
	public void save(User theUser);
	public void deleteById(UUID theId);
}
