package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.TourismObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TourismObjectRepository extends JpaRepository<TourismObject, Integer> {


    List<TourismObject> findAll();

    List<TourismObject> findByTypeId(int id);

    List<TourismObject> findByRegionId(int id);

    List<TourismObject> findByTypeIdAndRegionId(int idType, int idRegion);

    TourismObject getTourismObjectById(int idObject);

    //int addTourismObject(TourismObject tourismObject);
    //addTourismObject(TourismObject tourismObject);

    //ObjectsData findById(int id);
}
