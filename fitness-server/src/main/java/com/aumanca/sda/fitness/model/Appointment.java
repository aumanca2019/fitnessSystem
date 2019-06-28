package com.aumanca.sda.fitness.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_seq_gen")
    @SequenceGenerator(name = "app_seq_gen", sequenceName = "app_seq", allocationSize = 1)
    private Long id;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "no_hours")
    private float noHours;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public float getNoHours() {
        return noHours;
    }

    public void setNoHours(float noHours) {
        this.noHours = noHours;
    }
}



