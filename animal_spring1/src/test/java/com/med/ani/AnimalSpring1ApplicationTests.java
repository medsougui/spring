package com.med.ani;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.med.ani.entities.Animal;
import com.med.ani.repos.AnimalRepository;
import com.med.ani.service.AnimalService;
@SpringBootTest
class AnimalSpring1ApplicationTests {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private AnimalService animalService;
    @Test
    public void testCreateAnimal() {
        Animal animal = new Animal("Rex", 5, "Chien");
        animalRepository.save(animal);
    }
    @Test
    public void testFindByNomAnimalContains() {
        Page<Animal> animaux = animalService.getAllAnimauxParPage(0, 2);
        System.out.println(animaux.getSize());
        System.out.println(animaux.getTotalElements());
        System.out.println(animaux.getTotalPages());
        animaux.getContent().forEach(animal -> {
            System.out.println(animal.toString());
        });
    }
    @Test
    public void testFindAnimal() {
        Animal animal = animalRepository.findById(1L).orElse(null);
        System.out.println(animal);
    }

    @Test
    public void testUpdateAnimal() {
        Animal animal = animalRepository.findById(1L).orElse(null);
        if (animal != null) {
            animal.setAge(7);
            animalRepository.save(animal);
        }
    }

    @Test
    public void testDeleteAnimal() {
        animalRepository.deleteById(1L);
    }

    @Test
    public void testListerTousAnimaux() {
        List<Animal> animaux = animalRepository.findAll();
        for (Animal animal : animaux) {
            System.out.println(animal);
        }
    }

}
