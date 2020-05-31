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

    @GetMapping("/tourism/{idType}")
    public String tourismType(@PathVariable int idType, Model model) {
        List<TourismObject> tourismObjects = service.findByTypeId(idType);
        model.addAttribute("tourismObjects", tourismObjects);
        return "tourismObjects";

    }

    @GetMapping("/tourism/{idType}/region/{idRegion}")
    public String tourismByRegion(@PathVariable int idType, @PathVariable int idRegion, Model model) {
        List<TourismObject> tourismObjectsByRegion = service.findByTypeIdAndRegionId(idType, idRegion);
        model.addAttribute("tourismObjects", tourismObjectsByRegion);
        return "tourismObjects";
    }


    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }
    @GetMapping("/regionCity")
    public String regionCity(Model model) {
        model.addAttribute("title", "Region city");
        return "regionCity";
    }

    @GetMapping("/regionCountry")
    public String regionCounty(Model model) {
        model.addAttribute("title", "Region country");
        return "regionCountry";
    }


//    @PostMapping(value = "/tourism/add", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public ResponseEntity<Integer> addTourismObject(@RequestBody TourismObject tourismObject) {
//        service.addTourismObject(tourismObject);
//        return ResponseEntity.ok(tourismObject.getId);
//
//    }

}

