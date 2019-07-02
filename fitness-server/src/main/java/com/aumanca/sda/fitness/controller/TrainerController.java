package com.aumanca.sda.fitness.controller;

import com.aumanca.sda.fitness.dto.TrainerRequest;
import com.aumanca.sda.fitness.model.Trainer;
import com.aumanca.sda.fitness.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/trainers")
public class TrainerController {

    @Autowired
    public TrainerService trainerService;

    @PostMapping
    public void createTrainer(@RequestBody TrainerRequest trainerRequest) {
        trainerService.save(trainerRequest);
    }

    @GetMapping
    public ResponseEntity<List<Trainer>> getAll(){
        List<Trainer> trainers = trainerService.findAll();

        if(trainers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }
}

