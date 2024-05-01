package com.med.ani.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.med.ani.entities.Animal;
import com.med.ani.service.AnimalService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AnimalRESTController {

    @Autowired
    AnimalService animalService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Animal> getAllAnimaux() {
        return animalService.getAllAnimaux();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Animal getAnimalById(@PathVariable("id") Long id) {
        return animalService.getAnimal(id);
    }

    @RequestMapping(value="/animauxcat/{idCat}", method = RequestMethod.GET)
    public List<Animal> getAnimauxByCatId(@PathVariable("idCat") Long idCat) {
        return animalService.findByCategorieIdCat(idCat);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.saveAnimal(animal);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Animal updateAnimal(@RequestBody Animal animal) {
        return animalService.updateAnimal(animal);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteAnimal(@PathVariable("id") Long id) {
        animalService.deleteAnimalById(id);
    }
}
