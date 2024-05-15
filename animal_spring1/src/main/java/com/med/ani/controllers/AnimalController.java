package com.med.ani.controllers;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.med.ani.entities.Animal;
import com.med.ani.entities.Categorie;
import com.med.ani.service.AnimalService;

import jakarta.validation.Valid;

@Controller
public class AnimalController {

    @Autowired
    AnimalService animalService;
    @GetMapping(value = "/")
    public String welcome() {
     return "index";
    }
    @RequestMapping("/ListeAnimaux")
    public String listeAnimaux(ModelMap modelMap,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Animal> animaux = animalService.getAllAnimauxParPage(page, size);
        modelMap.addAttribute("animaux", animaux);
        modelMap.addAttribute("pages", new int[animaux.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeAnimaux";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
    	List<Categorie> cats = animalService.getAllCategories();
        modelMap.addAttribute("animal", new Animal());
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("categories", cats);
        return "formAnimal";
    }
    @RequestMapping("/saveAnimal")
    public String saveAnimal(@Valid Animal animal, BindingResult bindingResult,
                             @RequestParam(name = "page", defaultValue = "0") int page,
                             @RequestParam(name = "size", defaultValue = "2") int size) {
        int currentPage;
        boolean isNew = false;
        if (bindingResult.hasErrors()) return "formAnimal";
        if (animal.getId() == null) 
            isNew = true;
        animalService.saveAnimal(animal);
        if (isNew) 
        {
            Page<Animal> animals = animalService.getAllAnimauxParPage(page, size);
            currentPage = animals.getTotalPages() - 1;
        } else 
            currentPage = page;
        return ("redirect:/ListeAnimaux?page=" + currentPage + "&size=" + size);
    }

    @RequestMapping("/supprimerAnimal")
    public String supprimerAnimal(@RequestParam("id") Long id,
                                   ModelMap modelMap,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "2") int size) {
        animalService.deleteAnimalById(id);
        Page<Animal> animaux = animalService.getAllAnimauxParPage(page, size);
        modelMap.addAttribute("animaux", animaux);
        modelMap.addAttribute("pages", new int[animaux.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeAnimaux";
    }

    @RequestMapping("/modifierAnimal")
    public String editerAnimal(@RequestParam("id") Long id, 
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "2") int size,
                               ModelMap modelMap) {
        Animal animal = animalService.getAnimal(id);
        List<Categorie> cats = animalService.getAllCategories();
        modelMap.addAttribute("animal", animal);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("categories", cats);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formAnimal";
    }

    @RequestMapping("/updateAnimal")
    public String updateAnimal(@ModelAttribute Animal animal, ModelMap modelMap) {
        animalService.updateAnimal(animal);
        List<Animal> animaux = animalService.getAllAnimaux();
        modelMap.addAttribute("animaux", animaux);
        return "listeAnimaux";
    }
}

