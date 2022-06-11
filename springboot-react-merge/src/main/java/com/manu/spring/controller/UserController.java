package com.manu.spring.controller;

import java.util.List;
import java.util.Optional;

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

import com.manu.spring.model.User;
import com.manu.spring.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("welcome")
	public String welcome() {
		return "Hello World";
	}

	@GetMapping("users")
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	@PostMapping("addUsers")
	public String addUsers(@RequestBody User user) {
		this.userRepository.save(user);
		return "data added";
	}

	@PutMapping("updateUsers")
	public String updateUsers(@RequestBody User user) {

		User oldUser = null;

		Optional<User> optionaluser = userRepository.findById(user.getId());
		if (optionaluser.isPresent()) {
			oldUser = optionaluser.get();
			oldUser.setFirstName(user.getFirstName());
			oldUser.setLastName(user.getLastName());
			oldUser.setEmail(user.getEmail());
			userRepository.save(oldUser);
			return "Data Updated";
		} else {
			return "Data not Updated";
		}

	}

	@DeleteMapping("deleteUsers/{id}")
	public String deleteUsers(@PathVariable("id") long id) {
		this.userRepository.deleteById(id);
		return "data deleted";
	}

}
