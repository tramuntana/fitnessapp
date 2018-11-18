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

import hu.bme.fitnessapp.entity.Activity;
import hu.bme.fitnessapp.service.ActivityService;

@RestController
@RequestMapping("/api/activity/")
public class ActivityController {

	@Autowired
	ActivityService activityService;
	
	@GetMapping
	public List<Activity> getActivities() {
		return activityService.getAll();
	}
	
	@GetMapping("/{id}")
	public Activity getActivityById(@PathVariable Long id) {
		return activityService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<Object> createActivity(@RequestBody Activity activity) {
		activityService.save(activity);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateActivity(@PathVariable Long id, @RequestBody Activity newActivity) {
		activityService.update(id, newActivity);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteActivity(@PathVariable Long id) {
		activityService.delete(id);
		return ResponseEntity.ok().build();
	}
}
