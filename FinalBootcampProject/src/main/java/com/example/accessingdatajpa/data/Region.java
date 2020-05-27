package com.example.accessingdatajpa.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Region {
    public Region() {
    }

    public Region(int id, String name) {
        this.region_id = id;
        this.region_name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int region_id;
    private String region_name;


}
