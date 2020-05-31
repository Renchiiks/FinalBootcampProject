package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.TourismObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

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

    public void save(TourismObject object) {
        repo.save(object);
    }


    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<TourismObject> findByRegion(int id) {
        return repo.findByRegionId(id);
    }

    public List<TourismObject> findByTypeIdAndRegionId(int idType, int idRegion) {
        return repo.findByTypeIdAndRegionId(idType, idRegion);
    }

    public void addTourismObject(TourismObject tourismObject) {

         repo.save(tourismObject);
    }

    public TourismObject findById(int idObject) {
        return repo.getOne(idObject);
    }
}
