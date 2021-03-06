package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.data.TourismObject;
import com.example.accessingdatajpa.repository.TourismObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TourismObjectService {
    @Autowired
    private TourismObjectRepository repo;

    public List<TourismObject> findAll() {
        return repo.findAll();
    }


    public List<TourismObject> findByTypeId(int id) {
        return repo.findByTypeId(id);

    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<TourismObject> findBySubtype(int id) {
        return repo.findByRegionId(id);
    }

    public List<TourismObject> findByTypeIdAndRegionId(int idType, int idRegion) {
        return repo.findByTypeIdAndRegionId(idType, idRegion);
    }

    public void addTourismObject(TourismObject tourismObject) {
        repo.save(tourismObject);
    }

    public TourismObject findById(int idObject) {
        return repo.getTourismObjectById(idObject);
    }

    public TourismObject updateTourismObject(TourismObject newTourismObject, int objectId) {//
        Optional<TourismObject> optionalTourismObject = repo.findById(objectId);

        if(!optionalTourismObject.isPresent()){
         return null;
        }

        newTourismObject.setId(objectId);
        return repo.save(newTourismObject);
    }

    public List<TourismObject> findByTypeIdAndRegionIdAndSubtypeId(int idType, int idRegion, int idSubtype) {
        return repo.findByTypeIdAndRegionIdAndSubtypeId(idType, idRegion, idSubtype);
    }
}
