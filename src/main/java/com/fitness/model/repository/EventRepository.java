package com.fitness.model.repository;

import com.fitness.model.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    Iterable<Event> findByTrainer_Id(Long id);
}
