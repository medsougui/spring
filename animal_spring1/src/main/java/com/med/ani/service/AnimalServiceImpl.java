package com.med.ani.service;

import com.med.ani.entities.Animal;
import com.med.ani.entities.Categorie;
import com.med.ani.repos.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public Page<Animal> getAllAnimauxParPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return animalRepository.findAll(pageable);
    }

    @Override
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal(Animal animal) {
        animalRepository.delete(animal);
    }

    @Override
    public void deleteAnimalById(Long id) {
        animalRepository.deleteById(id);
    }

    @Override
    public Animal getAnimal(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Animal> getAllAnimaux() {
        return animalRepository.findAll();
    }

    @Override
    public List<Animal> findByNomAnimal(String nom) {
        return animalRepository.findByNom(nom);
    }

    @Override
    public List<Animal> findByNomContains(String nom) {
        return animalRepository.findByNomContains(nom);
    }

    @Override
    public List<Animal> findByNomAgeType(String nom, int age, String type) {
        return animalRepository.findByNomAgeType(nom, age, type);
    }

    @Override
    public List<Animal> findByCategorie(Categorie categorie) {
        return animalRepository.findByCategorie(categorie);
    }

    @Override
    public List<Animal> findByCategorieIdCat(Long id) {
        return animalRepository.findByCategorieIdCat(id);
    }

    @Override
    public List<Animal> findAllByOrderByNameAsc() {
        return animalRepository.findAllByOrderByNomAsc();
    }

    @Override
    public List<Animal> trierAnimauxNomsPrix() {
        return animalRepository.trierAnimauxNomsPrix();
    }
}
