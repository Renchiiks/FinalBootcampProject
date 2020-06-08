package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    List<Region> findAll();
}