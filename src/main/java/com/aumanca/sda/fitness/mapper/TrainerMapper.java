package com.aumanca.sda.fitness.mapper;

import com.aumanca.sda.fitness.dto.TrainerRequest;
import com.aumanca.sda.fitness.dto.TrainerResponse;
import com.aumanca.sda.fitness.model.Trainer;
import org.springframework.stereotype.Component;

@Component
public class TrainerMapper {

    public Trainer toEntity(TrainerRequest dto) {
        Trainer trainer = new Trainer();
        trainer.setFirstName(dto.getFirstName());
        trainer.setLastName(dto.getLastName());
        trainer.setSkills(dto.getSkills());
        return trainer;
    }

    public TrainerResponse toDto(Trainer trainer) {
        TrainerResponse trainerResponse = new TrainerResponse();
        trainerResponse.setId(trainer.getId());
        trainerResponse.setFirstName(trainer.getFirstName());
        trainerResponse.setLastName(trainer.getLastName());
        trainerResponse.setSkills(trainer.getSkills());
        return trainerResponse;
    }
}
