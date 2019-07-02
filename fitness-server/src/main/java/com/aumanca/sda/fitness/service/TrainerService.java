package com.aumanca.sda.fitness.service;

import com.aumanca.sda.fitness.dto.TrainerRequest;
import com.aumanca.sda.fitness.mapper.TrainerMapper;
import com.aumanca.sda.fitness.model.Trainer;
import com.aumanca.sda.fitness.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



    @Service
    @Transactional //all public methods have transactional context
    public class TrainerService{

        private TrainerRepository repository;
        private TrainerMapper trainerMapper;

        @Autowired
        public TrainerService(TrainerRepository repository, TrainerMapper trainerMapper) {
            this.repository = repository;
            this.trainerMapper = trainerMapper;
        }

        public List<Trainer> findAll() {

            return repository.findAll();
        }

        public void save(TrainerRequest trainerRequest) {

            repository.save(trainerMapper.toEntity(trainerRequest));
        }
    }

