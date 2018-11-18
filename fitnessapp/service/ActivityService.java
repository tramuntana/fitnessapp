package hu.bme.fitnessapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.bme.fitnessapp.entity.Activity;
import hu.bme.fitnessapp.repository.ActivityRepository;

@Service
@Transactional
public class ActivityService {
	@Autowired
	ActivityRepository activityRepository;
	
	
	public List<Activity> getAll() {
		return activityRepository.findAll();
	}
	
	public Activity getById( Long id) {
		return activityRepository.findById(id).orElse(null);
	}
	
	public void save(Activity activity) {
		activityRepository.save(activity);
	}
	
	public void update(Long id, Activity newActivity) {
		Activity updatedActivity = getById(id);
		updatedActivity.setName(newActivity.getName());
		updatedActivity.setCountable(newActivity.getCountable());
		save(updatedActivity);
	}
	
	public void delete(Long id) {
		activityRepository.delete(getById(id));
	}
}
