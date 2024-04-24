package com.med.ani.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.med.ani.entities.Animal;
import com.med.ani.repos.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;
    @Override
    public Page<Animal> getAllAnimauxParPage(int page, int size) {
        return animalRepository.findAll(PageRequest.of(page, size));
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
}
