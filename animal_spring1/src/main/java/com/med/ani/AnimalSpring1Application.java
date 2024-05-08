package com.med.ani;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.med.ani.entities.Animal;
import com.med.ani.service.AnimalService;

@SpringBootApplication
public class AnimalSpring1Application implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(AnimalSpring1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //animalService.saveAnimal(new Animal("Cat", 2, "Mammal"));
        //animalService.saveAnimal(new Animal("Dog", 4, "Mammal"));
        //animalService.saveAnimal(new Animal("Parrot", 1, "Bird"));
    	//repositoryRestConfiguration.exposeIdsFor(Animal.class);
    }
}
