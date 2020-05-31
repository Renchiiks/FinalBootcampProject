package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.TourismObject;
import com.example.accessingdatajpa.data.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface TourismObjectRepository extends JpaRepository<TourismObject, Integer> {

    //List<ObjectsData> findByName(String name);
    List<TourismObject> findAll();
    List<TourismObject> findByTypeId(int id);

    //ObjectsData findById(int id);
}
