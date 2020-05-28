package com.example.accessingdatajpa.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "objects_data")
public class TourismObject {


    protected TourismObject() {
    }

    public TourismObject(int id, String name, String address, String phone, Region region, Type type, Subtype subtype) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.region = region;
        this.type = type;
        this.subtype = subtype;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "object_id")
    private int id;
    @Column(name = "object_name")
    private String name;
    @Column(name = "object_address")
    private String address;
    @Column(name = "object_phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "object_region_id")
    private Region region;
    @ManyToOne
    @JoinColumn(name = "object_type_id")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "object_subtype_id")
    private Subtype subtype;

//    @Override
//    public String toString() {
//        return "Object{" +
//                "id=" + object_id +
//                ", name='" + object_name + '\'' +
//                ", address=" + object_address //+
//        ", phone='" + object_phone// + '\'' +
////                ", region=" + region +
////                ", type=" + type +
////                ", subtype=" + subtype +
////                '}'
//        ;

}

