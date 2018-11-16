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

import hu.bme.fitnessapp.entity.ActivityPlan;
import hu.bme.fitnessapp.service.ActivityPlanService;

@RestController
@RequestMapping("/api/activityplan/")
public class ActivityPlanController {

	@Autowired
	ActivityPlanService activityPlanService;
	
	
	@GetMapping
	public List<ActivityPlan> getActivityPlans() {
		return activityPlanService.getAll();
	}
	
	@GetMapping("/{id}")
	public ActivityPlan getActivityPlanById(@PathVariable Long id) {
		return activityPlanService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<Object> createActivityPlan(@RequestBody ActivityPlan activityPlan) {
		activityPlanService.save(activityPlan);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateActivityPlan(@PathVariable Long id, @RequestBody ActivityPlan newActivityPlan) {
		activityPlanService.update(id, newActivityPlan);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteActivityPlan(@PathVariable Long id) {
		activityPlanService.delete(id);
		return ResponseEntity.ok().build();
	}
}

