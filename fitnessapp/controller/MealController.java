package hu.bme.fitnessapp.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

import hu.bme.fitnessapp.entity.Meal;
import hu.bme.fitnessapp.service.MealService;

@RestController
@RequestMapping("/api/meal/")
public class MealController {

	@Autowired
	MealService mealService;
	
	@GetMapping
	public List<Meal> getMeals() {
		return mealService.getAll();
	}
	
	@GetMapping("/{id}")
	public Meal getMealById(@PathVariable Long id) {
		return mealService.getById(id);
	}
	
	@GetMapping("/{id}/{date}")
	public Meal getByUserIdAndDate(@PathVariable Long id, @PathVariable Date date) {
		return mealService.getById(id);
	}
	
	@GetMapping("/diagram")
	public Map<String, Integer> getDiagrambyUserId(Long userId, Date date) {
		return mealService.getDiagram(userId, date);
	}
	
	@PostMapping
	public ResponseEntity<Object> createMeal(@RequestBody Meal meal) {
		mealService.save(meal);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateMeal(@PathVariable Long id, @RequestBody Meal newMeal) {
		mealService.update(id, newMeal);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteMeal(@PathVariable Long id) {
		mealService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
