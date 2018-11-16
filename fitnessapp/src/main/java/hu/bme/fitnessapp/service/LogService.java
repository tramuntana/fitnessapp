package hu.bme.fitnessapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.bme.fitnessapp.entity.Log;
import hu.bme.fitnessapp.repository.LogRepository;

@Service
@Transactional
public class LogService {
	@Autowired
	LogRepository logRepository;
	
	
	public List<Log> getAll() {
		return logRepository.findAll();
	}
	
	public Log getById( Long id) {
		return logRepository.findById(id).orElse(null);
	}
	
	
	public void save(Log log) {
		logRepository.save(log);
	}
	
	public void delete(Long id) {
		logRepository.delete(getById(id));
	}
}
