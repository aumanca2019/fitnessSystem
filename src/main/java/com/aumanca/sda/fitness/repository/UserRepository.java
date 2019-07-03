package com.aumanca.sda.fitness.repository;

import com.aumanca.sda.fitness.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteById(String id);

}
