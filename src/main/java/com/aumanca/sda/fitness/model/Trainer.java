package com.aumanca.sda.fitness.model;

import javax.persistence.*;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "trainer_seq_gen")
    @SequenceGenerator(name = "trainer_seq_gen", sequenceName = "trainer_seq", allocationSize = 1)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "skills")
    private String skills;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
