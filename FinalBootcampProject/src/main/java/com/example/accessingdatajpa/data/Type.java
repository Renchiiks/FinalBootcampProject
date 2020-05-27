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
public class Type {
    public Type() {
    }

    public Type(int id, String name) {
        this.type_id = id;
        this.type_name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int type_id;
    private String type_name;

    @Override
    public String toString() {
        return "Type{" +
                "type_id=" + type_id +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}
