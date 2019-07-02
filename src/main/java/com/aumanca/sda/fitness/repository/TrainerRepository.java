package com.aumanca.sda.fitness.repository;

import com.aumanca.sda.fitness.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
