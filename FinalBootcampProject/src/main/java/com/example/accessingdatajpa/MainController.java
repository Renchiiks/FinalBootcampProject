package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.Region;
import com.example.accessingdatajpa.data.Subtype;
import com.example.accessingdatajpa.data.TourismObject;
import com.example.accessingdatajpa.data.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

public class MainController {

    @Autowired
    private TourismObjectService tourismService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private SubtypeService subtypeService;

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
    public String tourismByTypeAndRegion(@PathVariable int idType, @PathVariable int idRegion, Model model) {
        List<TourismObject> byTypeIdAndRegionId = tourismService.findByTypeIdAndRegionId(idType, idRegion);

        List<Subtype> subtypes = new ArrayList<>();
        for (TourismObject tourismObject : byTypeIdAndRegionId) {
            Subtype subtype = tourismObject.getSubtype();
            if (!subtypes.contains(subtype)) {
                subtypes.add(subtype);
            }
        }

        List<Type> typeList = typeService.allTypes();
        List<Region> regionsList = regionService.allRegions();
        List<Subtype> subtypeList = subtypeService.allSubtypes();

        model.addAttribute("subtypesFilter", subtypes);

        model.addAttribute("regions", regionsList);
        model.addAttribute("types", typeList);
        model.addAttribute("subtypes", subtypeList);

        model.addAttribute("tourismObjects", byTypeIdAndRegionId);
        model.addAttribute("newTourismObject", new TourismObject());
        return "tourismObjects";
    }


    @PostMapping("/tourism/add")
    public String addTourismObject(@ModelAttribute("newTourismObject")  TourismObject newTourismObject, Model model) {

        tourismService.addTourismObject(newTourismObject);

        model.addAttribute("tourismObject", newTourismObject);
        return "singleObject";
    }

    @GetMapping("tourismobject/{idObject}")
    public String tourismObject(@PathVariable int idObject, Model model) {
        TourismObject tourismObject = tourismService.findById(idObject);
        model.addAttribute("tourismObject", tourismObject);
        return "singleObject";
    }


//    @PutMapping("tourismobject/update/{idObject}")
//    public ResponseEntity<?> updateTourismObject(@RequestBody TourismObject updatedTourismObject, @PathVariable int idObject) {
//        service.updateTourismObject(updatedTourismObject, idObject);
//
//        return ResponseEntity.ok(tourismObject(idObject));
//    }

    @GetMapping("/tourism/{idType}/region/{idRegion}/subtype/{idSubtype}")
    public String tourismByRegionAndSubtype(@PathVariable int idType, @PathVariable int idRegion, @PathVariable int idSubtype, Model model) {
        List<TourismObject> tourismObjectsByRegionAndSubtype = tourismService.findByTypeIdAndRegionIdAndSubtypeId(idType, idRegion, idSubtype);
        model.addAttribute("tourismObjects", tourismObjectsByRegionAndSubtype);
        model.addAttribute("idRegion", idRegion);
        model.addAttribute("idType", idType);

        return "tourismObjects";
    }

}

