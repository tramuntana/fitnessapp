package hu.bme.fitnessapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.bme.fitnessapp.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAll();

}
