package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.TourismObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/api")

public class MainController {
    @Autowired
    private TourismObjectService service;


    @GetMapping(path = "/all")
    public @ResponseBody
    List<TourismObject> getAllObjects() {
        return service.findAll();
    }


}

