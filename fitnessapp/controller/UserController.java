package hu.bme.fitnessapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.bme.fitnessapp.entity.User;
import hu.bme.fitnessapp.service.UserService;

@RestController
@RequestMapping("/api/users/")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		userService.save(user);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User newUser) {
		userService.update(id, newUser);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}
}