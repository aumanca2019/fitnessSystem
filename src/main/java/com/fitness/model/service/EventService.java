package com.fitness.model.service;

import com.fitness.model.model.Event;
import com.fitness.model.model.User;
import com.fitness.model.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    public Iterable<Event> findByUser(User user){
        return eventRepository.findByTrainer_Id(user.getId());
    }
}
