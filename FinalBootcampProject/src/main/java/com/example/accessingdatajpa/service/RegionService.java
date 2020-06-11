package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.data.Region;
import com.example.accessingdatajpa.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegionService {
    @Autowired
    private RegionRepository repo;

    public List<Region> allRegions() {
        return repo.findAll();
    }

    public Region getByRegionId(int id) {
        return repo.getOne(id);
    }

}
