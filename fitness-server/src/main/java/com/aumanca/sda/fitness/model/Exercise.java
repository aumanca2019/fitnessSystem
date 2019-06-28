package com.aumanca.sda.fitness.model;

import javax.persistence.*;


@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ex_seq_gen")
    @SequenceGenerator(name = "ex_seq_gen", sequenceName = "ex_seq", allocationSize = 1)
    private Long id;

    @Column(name ="category")
    private String category;

    @Column(name ="no_places")
    private int noPlaces;


    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoPlaces() {
        return noPlaces;
    }

    public void setNoPlaces(int noPlaces) {
        this.noPlaces = noPlaces;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
