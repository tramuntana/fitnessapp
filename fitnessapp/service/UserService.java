package hu.bme.fitnessapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.bme.fitnessapp.entity.User;
import hu.bme.fitnessapp.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public User getById( Long id) {
		return userRepository.findById(id).orElse(null);
	}
			
	public void save(User user) {
		userRepository.save(user);
	}
	
	public void update(Long id, User newUser) {
		User updatedUser = getById(id);
		updatedUser.setWeight(newUser.getWeight());
		updatedUser.setHeight(newUser.getHeight());
		save(updatedUser);
	}
	
	public void delete(Long id) {
		userRepository.delete(getById(id));
	}
}
