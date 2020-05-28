package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.TourismObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller

public class MainController {

    @Autowired
    private TourismObjectService service;


    @GetMapping("/citytourism")
    public String cityTourism(Model model) {
        List<TourismObject> getAllObjects = service.findAll();
        model.addAttribute("getAllObjects", getAllObjects);
        return "citytourism";

    }

    @GetMapping( "/countrytourism")
    public String countryTourism(Model model) {
        List<TourismObject> getAllObjects = service.findAll();
        model.addAttribute("getAllObjects", getAllObjects);
        return "countrytourism";

    }

    @GetMapping( "/home")
    public String home(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }
}

