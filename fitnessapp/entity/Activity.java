package hu.bme.fitnessapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	@NotNull
	private String name;
	
	@Column(name="COUNTABLE")
	@NotNull
	private Integer countable;
	
	@ManyToMany(mappedBy = "activities")
    private List<ActivityPlan> activityPlans = new ArrayList<>();
	
	
	Activity() {
	}
	
	Activity(Long id, String name, Integer countable) {
		this.id = id;
		this.name = name;
		this.countable = countable;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCountable() {
		return this.countable;
	}
	public void setCountable(Integer countable) {
		this.countable = countable;
	}
}
