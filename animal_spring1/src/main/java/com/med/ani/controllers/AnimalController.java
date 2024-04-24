package com.med.ani.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.med.ani.entities.Animal;
import com.med.ani.service.AnimalService;

@Controller
public class AnimalController {

    @Autowired
    AnimalService animalService;

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
    public String showCreate() {
        return "createAnimal";
    }

    @RequestMapping("/saveAnimal")
    public String saveAnimal(@ModelAttribute Animal animal, ModelMap modelMap) {
        Animal savedAnimal = animalService.saveAnimal(animal);
        String msg = "Animal enregistré avec Id " + savedAnimal.getId();
        modelMap.addAttribute("msg", msg);
        return "createAnimal";
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


    @RequestMapping("/editerAnimal")
    public String editerAnimal(@RequestParam Long id, ModelMap modelMap) {
        Animal animal = animalService.getAnimal(id);
        modelMap.addAttribute("animal", animal);
        return "editerAnimal";
    }

    @RequestMapping("/updateAnimal")
    public String updateAnimal(@ModelAttribute Animal animal, ModelMap modelMap) {
        animalService.updateAnimal(animal);
        List<Animal> animaux = animalService.getAllAnimaux();
        modelMap.addAttribute("animaux", animaux);
        return "listeAnimaux";
    }
}

