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
public class Subtype {
    public Subtype() {
    }

    public Subtype(int id, String name) {
        this.subtype_id = id;
        this.subtype_name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subtype_id;
    private String subtype_name;

    @Override
    public String toString() {
        return "Subtype{" +
                "subtype_id=" + subtype_id +
                ", subtype_name='" + subtype_name + '\'' +
                '}';
    }
}
