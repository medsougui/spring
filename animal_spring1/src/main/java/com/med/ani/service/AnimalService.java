package com.med.ani.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.med.ani.entities.Animal;

public interface AnimalService {
    Animal saveAnimal(Animal animal);
    Animal updateAnimal(Animal animal);
    void deleteAnimal(Animal animal);
    void deleteAnimalById(Long id);
    Animal getAnimal(Long id);
    List<Animal> getAllAnimaux();
    Page<Animal> getAllAnimauxParPage(int page, int size);

}
