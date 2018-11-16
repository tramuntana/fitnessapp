package hu.bme.fitnessapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.bme.fitnessapp.entity.ActivityPlan;
import hu.bme.fitnessapp.repository.ActivityPlanRepository;

@Service
@Transactional
public class ActivityPlanService {
	@Autowired
	ActivityPlanRepository activityPlanRepository;
	
	
	public List<ActivityPlan> getAll() {
		return activityPlanRepository.findAll();
	}
	
	public ActivityPlan getById( Long id) {
		return activityPlanRepository.findById(id).orElse(null);
	}
	
	public void save(ActivityPlan activityPlan) {
		activityPlanRepository.save(activityPlan);
	}
	
	public void update(Long id, ActivityPlan newActivityPlan) {
		ActivityPlan updatedActivityPlan = getById(id);
		updatedActivityPlan.setName(newActivityPlan.getName());
		updatedActivityPlan.setActivities(newActivityPlan.getActivities());
		save(updatedActivityPlan);
	}
	
	public void delete(Long id) {
		activityPlanRepository.delete(getById(id));
	}
}
