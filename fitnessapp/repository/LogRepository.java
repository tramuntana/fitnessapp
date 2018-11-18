package hu.bme.fitnessapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.bme.fitnessapp.entity.Log;

public interface LogRepository extends CrudRepository<Log, Long>{

	List<Log> findAll();

	List<Log> findByUserId(Long id);
	
	List<Log> findByDate(Date date);
}
