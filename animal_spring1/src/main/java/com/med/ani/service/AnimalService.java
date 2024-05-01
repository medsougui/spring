package com.med.ani.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.med.ani.entities.Animal;
import com.med.ani.entities.Categorie;

public interface AnimalService {
    Animal saveAnimal(Animal animal);
    Animal updateAnimal(Animal animal);
    void deleteAnimal(Animal animal);
    void deleteAnimalById(Long id);
    Animal getAnimal(Long id);
    List<Animal> getAllAnimaux();
    Page<Animal> getAllAnimauxParPage(int page, int size);
    List<Animal> findByNomAnimal(String nom);
    List<Animal> findByNomContains(String nom);
    List<Animal> findByNomAgeType(String nom, int age, String type);
    List<Animal> findByCategorie(Categorie categorie);
    List<Animal> findByCategorieIdCat(Long id);
    List<Animal> findAllByOrderByNameAsc();
    List<Animal> trierAnimauxNomsPrix();
}
