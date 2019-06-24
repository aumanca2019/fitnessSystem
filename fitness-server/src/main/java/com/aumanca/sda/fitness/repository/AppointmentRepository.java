package com.aumanca.sda.fitness.repository;

import com.aumanca.sda.fitness.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
