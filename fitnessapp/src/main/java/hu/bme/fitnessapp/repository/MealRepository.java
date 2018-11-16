package hu.bme.fitnessapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.bme.fitnessapp.entity.Meal;

public interface MealRepository extends CrudRepository<Meal, Long> {

	List<Meal> findAll();
}
