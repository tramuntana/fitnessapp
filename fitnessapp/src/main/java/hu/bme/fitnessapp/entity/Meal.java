package hu.bme.fitnessapp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="MEAL")
public class Meal {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	@NotNull
	private String name;
	
	@Column(name="CALORIES")
	@NotNull
	private Integer calories;
	
	
	public String getName() {
		return this.name;
	}
	
	Meal() {
	}
	
	Meal(Long id, String name, Integer calories) {
		this.id = id;
		this.name = name;
		this.calories = calories;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCalories() {
		return this.calories;
	}
	public void setCalories(Integer calories) {
		this.calories = calories;
	}
	
}
