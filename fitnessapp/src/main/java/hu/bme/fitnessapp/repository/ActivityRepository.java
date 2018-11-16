package hu.bme.fitnessapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.bme.fitnessapp.entity.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long>{

	List<Activity> findAll();

}
