package hu.bme.fitnessapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.bme.fitnessapp.entity.ActivityPlan;

public interface ActivityPlanRepository extends CrudRepository<ActivityPlan, Long> {

	List<ActivityPlan> findAll();

}
