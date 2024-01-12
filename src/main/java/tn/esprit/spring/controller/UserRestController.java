package tn.esprit.spring.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.IServiceUser;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "User")
@RequestMapping("/user")
public class UserRestController {
	
	
	@Autowired
	IServiceUser userservice;
	
	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsers(){
		return userservice.retrieveAllUser();
	}
	@GetMapping("/user/{id}")
	@ResponseBody
	public Optional<User> getUserById(@PathVariable("id") Long id){
		return userservice.retrieveUserById(id);
		
	}
	 @PostMapping("/adduser")
		@ResponseBody
		public User addUser(@RequestBody User user) {
			return userservice.addUser(user);
}
	 
	 @PutMapping("/updateuser")
		@ResponseBody
		public User updateUser(@RequestBody User user) {
		return userservice.updateUser(user);
		}
	 
	 
	 
}