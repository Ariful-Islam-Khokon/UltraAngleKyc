package com.ultraangle.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ultraangle.entity.User;
import com.ultraangle.service.IUserService;

/*@CrossOrigin("*")*/
@RestController
@RequestMapping//("/api")
public class UserController {
	@Autowired
	private IUserService userService;

	
	//expose "/employees" and return list of empolyees
	@GetMapping("/users")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	//add mapping for GET /employees/{userId}
	@GetMapping("/users/{userId}")
	public User findById(@PathVariable String userId){
		User theUser= userService.findById(UUID.fromString(userId));
		if(theUser == null) {
			throw new RuntimeException("Employee id not valid - "+userId);
		}
		return theUser;
	}
	
	//add mapping for POST /save a employee
	@PostMapping("/users")
	public User addEmployee(@RequestBody User theUser){
		theUser.setId(null);
		userService.save(theUser);

		return theUser;
	}

	//add mapping for PUT /update a employee
	@PutMapping("/users")
		public User updateEmployee(@RequestBody User theUser){
			//theUser.setId(null);
		userService.save(theUser);

			return theUser;
		}
	//add mapping for DELETE / delete a employee
	@DeleteMapping("/users/{userId}")
	public String deleteEmployee(@PathVariable String userId) {
		User tempEmployee= userService.findById(UUID.fromString(userId));
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not valid - "+userId);
		}
		userService.deleteById(UUID.fromString(userId));
		 return "Deleted employee id - "+userId;
		
	}
	
}
