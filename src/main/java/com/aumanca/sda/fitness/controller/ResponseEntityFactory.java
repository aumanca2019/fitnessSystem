package com.aumanca.sda.fitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class ResponseEntityFactory<T> {

    public ResponseEntity<T> getResponseEntity(T input){
        if(input == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(input, HttpStatus.OK);
    }

    public ResponseEntity<List<T>> getResponseEntityList(List<T> input){
        if(input == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(input, HttpStatus.OK);
    }
}
