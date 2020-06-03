package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.TourismObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class MainController {

    @Autowired
    private TourismObjectService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }

    @GetMapping("/tourism/{id}/region")
    public String regionCity(@PathVariable int id, Model model) {
        String title;
        if (id == 1) {
            title = "PILSĒTĀ";
        } else {
            title = "LAUKOS";
        }
        model.addAttribute("title", title);
        return "region";
    }

    @GetMapping("/tourism/{idType}/region/{idRegion}")
    public String tourismByRegion(@PathVariable int idType, @PathVariable int idRegion, Model model) {
        List<TourismObject> tourismObjectsByRegion = service.findByTypeIdAndRegionId(idType, idRegion);
        model.addAttribute("tourismObjects", tourismObjectsByRegion);
        return "tourismObjects";
    }

//    @PostMapping("/tourism/add")
//    public ResponseEntity<Integer> addTourismObject(@RequestBody TourismObject tourismObject) {
//        service.addTourismObject(tourismObject);
//        return ResponseEntity.ok(tourismObject.getId());
//
//    }

    @GetMapping("tourismobject/{idObject}")
    public String tourismObject(@PathVariable int idObject, Model model) {
        TourismObject tourismObject = service.findById(idObject);
        model.addAttribute("tourismObject", tourismObject);
        return "singleObject";
    }

//    @PutMapping("tourismobject/update/{idObject}")
//    public ResponseEntity<?> updateTourismObject(@RequestBody TourismObject updatedTourismObject, @PathVariable int idObject) {
//        service.updateTourismObject(updatedTourismObject, idObject);
//
//        return ResponseEntity.ok(tourismObject(idObject));
//    }

}

