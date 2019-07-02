package com.aumanca.sda.fitness.controller;

import com.aumanca.sda.fitness.model.Trainer;
import com.aumanca.sda.fitness.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/trainers")
public class TrainerController {

    @Autowired
    public TrainerService service;

    @GetMapping("/all")
    public ResponseEntity<List<Trainer>> getAll(){
        List<Trainer> trainers= service.findAll();

        if(trainers.isEmpty()){
            return new ResponseEntity<List<Trainer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Trainer>>(trainers, HttpStatus.OK);
    }
}

