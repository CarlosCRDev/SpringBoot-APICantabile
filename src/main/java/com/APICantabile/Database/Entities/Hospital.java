package com.APICantabile.Database.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Hospitals")
public class Hospital implements Serializable {
    @Id
    private int id;
    private String name;
    private String city;
    private double raiting;

    public Hospital() {
    }

    public Hospital(int id, String name, String city, double raiting) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.raiting = raiting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRaiting() {
        return raiting;
    }

    public void setRaiting(double rating) {
        this.raiting = rating;
    }
}
