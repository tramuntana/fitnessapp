package hu.bme.fitnessapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.bme.fitnessapp.entity.User;

public interface StatisticsRepository extends JpaRepository<User, Long> {

}
