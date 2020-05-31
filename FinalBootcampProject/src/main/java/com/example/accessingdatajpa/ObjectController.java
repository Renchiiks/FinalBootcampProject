package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.TourismObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tourismobject", produces = {MediaType.APPLICATION_JSON_VALUE})

public class ObjectController {
    @Autowired
    TourismObjectRepository repo;

    @GetMapping("/{idObject}")
    public TourismObject tourismObject(@PathVariable int idObject) {
        return repo.getTourismObjectById(idObject);
    }

}
