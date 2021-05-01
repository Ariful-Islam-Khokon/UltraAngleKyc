package com.ultraangle.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ultraangle.entity.User;
import com.ultraangle.repository.IUserRepository;



@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	//same
	@Override
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}

	//different
	@Override
	@Transactional
	public User findById(UUID theId) {
		Optional<User> result = userRepository.findById(theId);
		
		User theUser = null;
		if(result.isPresent()) {
			theUser = result.get();
		}else {
			throw new RuntimeException("Dint not find employee id -"+theId);
		}
		return theUser;
	}

	//same
	@Override
	@Transactional
	public void save(User theUser) {
		userRepository.save(theUser) ;

	}
	
	//same
	@Override
	@Transactional
	public void deleteById(UUID theId) {
		userRepository.deleteById(theId);

	}
}
