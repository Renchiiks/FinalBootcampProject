package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.Region;
import com.example.accessingdatajpa.data.Subtype;
import com.example.accessingdatajpa.data.TourismObject;
import com.example.accessingdatajpa.storage.FileStorageException;
import com.example.accessingdatajpa.storage.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class TourismObjectService {
    @Autowired
    private TourismObjectRepository repo;

    public List<TourismObject> findAll() {
        return repo.findAll();
    }

//    public List<Region> allRegions(int id) {
//        return repo.allRegions(id);
//    }
//
//    public List<Type> allTypes(int id) {
//        return repo.allTypes(id);
//    }
//
//    public List<Subtype> allSubtypes(int id) {
//        return repo.allSubtypes(id);
//    }

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
