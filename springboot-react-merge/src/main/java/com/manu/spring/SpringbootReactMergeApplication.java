package com.manu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manu.spring.model.User;
import com.manu.spring.repository.UserRepository;

@SpringBootApplication
public class SpringbootReactMergeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootReactMergeApplication.class, args);
	}

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.userRepository.save(new User("manu","salunke","manu@gmail.com"));
		this.userRepository.save(new User("Pradnyesh","salunke","pradnyesh@gmail.com"));
		this.userRepository.save(new User("Prasad","Bhalerao","prasad@gmail.com"));
		this.userRepository.save(new User("Nitish","adgaokar","nitish@gmail.com"));
		this.userRepository.save(new User("Rahul","phadke","rahul@gmail.com"));
		
		
	}

}
