package com.aumanca.sda.fitness.repository;

import com.aumanca.sda.fitness.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository <Location, Long> {
}
