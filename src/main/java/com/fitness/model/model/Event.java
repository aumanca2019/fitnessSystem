package com.fitness.model.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    private User trainer;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "takes_place")
    private Date takesPlace;

    private double duration;

    public Event() {
        this.creationDate = new Date();
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_participants",
            joinColumns = {@JoinColumn(name = "user_id")})
    @Size(max = 20)
    private List<User> participants = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getTrainer() {
        return trainer;
    }

    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getTakesPlace() {
        return takesPlace;
    }

    public void setTakesPlace(Date takesPlace) {
        this.takesPlace = takesPlace;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
