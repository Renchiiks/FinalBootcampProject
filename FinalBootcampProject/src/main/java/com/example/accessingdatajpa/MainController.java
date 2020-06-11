package com.example.accessingdatajpa;

import com.example.accessingdatajpa.data.Region;
import com.example.accessingdatajpa.data.Subtype;
import com.example.accessingdatajpa.data.TourismObject;
import com.example.accessingdatajpa.data.Type;
import com.example.accessingdatajpa.service.RegionService;
import com.example.accessingdatajpa.service.SubtypeService;
import com.example.accessingdatajpa.service.TourismObjectService;
import com.example.accessingdatajpa.service.TypeService;
import com.example.accessingdatajpa.storage.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private TourismObjectService tourismService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private SubtypeService subtypeService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Galvena");
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Galvena");
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

        getRequired(model, byTypeIdAndRegionId);

        model.addAttribute("tourismObjects", byTypeIdAndRegionId);

        model.addAttribute("newTourismObject", new TourismObject());

        return "tourismObjects";
    }

    @Transactional
    @PostMapping("/tourism/add")
    public String addTourismObject(@RequestParam("file") MultipartFile file, @ModelAttribute("newTourismObject") TourismObject newTourismObject, Model model) {
        if (!file.isEmpty()) {

            String fileName = fileStorageService.storeFile(file);
            newTourismObject.setImagePath("/media/" + fileName);
            model.addAttribute("file", fileName);
        }

        getClassifierLists(model);

        if (newTourismObject.getId() == 0) {
            tourismService.addTourismObject(newTourismObject);

        } else {
            tourismService.updateTourismObject(newTourismObject, newTourismObject.id);
        }

        model.addAttribute("newTourismObject", newTourismObject);
        return "singleObject";
    }

    @GetMapping("tourismobject/{idObject}")
    public String tourismObject(@PathVariable int idObject, Model model) {
        TourismObject tourismObject = tourismService.findById(idObject);

        getClassifierLists(model);

        model.addAttribute("newTourismObject", tourismObject);
        return "singleObject";
    }

    @GetMapping("/tourism/{idType}/region/{idRegion}/subtype/{idSubtype}")
    public String tourismByRegionAndSubtype(@PathVariable int idType, @PathVariable int idRegion, @PathVariable int idSubtype, Model model) {
        List<TourismObject> tourismObjectsByRegionAndSubtype = tourismService.findByTypeIdAndRegionIdAndSubtypeId(idType, idRegion, idSubtype);
        model.addAttribute("tourismObjects", tourismObjectsByRegionAndSubtype);
        model.addAttribute("idRegion", idRegion);
        model.addAttribute("idType", idType);

        getRequired(model, tourismObjectsByRegionAndSubtype);

        model.addAttribute("newTourismObject", new TourismObject());

        return "tourismObjects";
    }

    @GetMapping(value = "/tourismobject/delete/{id}")
    public String delete(@PathVariable int id) {
        tourismService.findById(id);
        try {
            tourismService.delete(id);
            return "redirect:/home";
        } catch (Exception ex) {
            return HttpStatus.BAD_REQUEST.toString();
        }
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    private void getRequired(Model model, List<TourismObject> byTypeIdAndRegionId) {
        List<Subtype> subtypes = new ArrayList<>();
        for (TourismObject tourismObject : byTypeIdAndRegionId) {
            Subtype subtype = tourismObject.getSubtype();
            if (!subtypes.contains(subtype)) {
                subtypes.add(subtype);
            }
        }
        model.addAttribute("subtypesFilter", subtypes);

        getClassifierLists(model);

    }

    private void getClassifierLists(Model model) {
        List<Type> typeList = typeService.allTypes();
        List<Region> regionsList = regionService.allRegions();
        List<Subtype> subtypeList = subtypeService.allSubtypes();

        model.addAttribute("regions", regionsList);
        model.addAttribute("types", typeList);
        model.addAttribute("subtypes", subtypeList);
    }


}

