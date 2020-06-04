package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.TourismObject;
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

    public void updateTourismObject(TourismObject updatedTourismObject, int idObject) {
        repo.findById(idObject).map(tourismObject -> {
            tourismObject.setAddress(updatedTourismObject.getAddress());
            tourismObject.setDescription(updatedTourismObject.getDescription());
            tourismObject.setName(updatedTourismObject.getName());
            tourismObject.setPhone(updatedTourismObject.getPhone());
            tourismObject.setRegion(updatedTourismObject.getRegion());
            tourismObject.setSubtype(updatedTourismObject.getSubtype());
            tourismObject.setType(updatedTourismObject.getType());
            return repo.save(tourismObject);
        });
    }
    public List<TourismObject> findByTypeIdAndRegionIdAndSubtypeId(int idType, int idRegion, int idSubtype) {
        return repo.findByTypeIdAndRegionIdAndSubtypeId(idType, idRegion, idSubtype);
    }
}
