package hu.bme.fitnessapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.bme.fitnessapp.entity.Quotes;

public interface QuotesRepository extends CrudRepository<Quotes, Long>{

	List<Quotes> findAll();

}
