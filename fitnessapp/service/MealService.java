package hu.bme.fitnessapp.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.bme.fitnessapp.entity.Log;
import hu.bme.fitnessapp.entity.Meal;
import hu.bme.fitnessapp.repository.LogRepository;
import hu.bme.fitnessapp.repository.MealRepository;

@Service
@Transactional
public class MealService {

	@Autowired
	MealRepository mealRepository;
	
	@Autowired
	LogRepository logRepository;
	
	public List<Meal> getAll() {
		return mealRepository.findAll();
	}
	
	public Meal getById( Long id) {
		return mealRepository.findById(id).orElse(null);
	}
	
	public List<Meal> getByUserIdAndDate(Long id, Date date) {
		List<Meal> meals = new ArrayList<>();
		List<Long> mealIds = logRepository.findByUserId(id).stream().map(Log::getMealId)
				.collect(Collectors.toList());

		for(Long mealId: mealIds) {
			meals.add(getById(mealId));
		}
		
		return meals;
	}
	
	public Map<String, Integer> getDiagram(Long id, Date date) {
		
		Map<String, Integer> diagram = new HashMap<String, Integer>();
		Map<Date, List<Log>> logs = logRepository.findByUserId(id).stream().collect(Collectors.groupingBy(Log::getDate));
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        localDate.getDayOfWeek().name();
         
         /*for (int i = 0; i < 7; i++) {
        	 
         }*/
		 return diagram;
	
	}
	
	public void save(Meal meal) {
		mealRepository.save(meal);
	}
	
	public void update(Long id, Meal newMeal) {
		Meal updatedMeal = getById(id);
		updatedMeal.setName(newMeal.getName());
		updatedMeal.setCalories(newMeal.getCalories());
		save(updatedMeal);
	}
	
	public void delete(Long id) {
		mealRepository.delete(getById(id));
	}
}
