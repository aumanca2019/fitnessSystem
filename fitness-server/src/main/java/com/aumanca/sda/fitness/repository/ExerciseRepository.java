package com.aumanca.sda.fitness.repository;

import com.aumanca.sda.fitness.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
