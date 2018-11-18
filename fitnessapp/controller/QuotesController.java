package hu.bme.fitnessapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.bme.fitnessapp.entity.Quotes;
import hu.bme.fitnessapp.repository.QuotesRepository;

@RestController
@RequestMapping("/api/quotes/")
public class QuotesController {
	
	@Autowired
	QuotesRepository quotesRepository;
	
	@GetMapping
	public List<Quotes> getUsers() {
		return quotesRepository.findAll();
	}

}
