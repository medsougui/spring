package com.med.ani;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.med.ani.entities.Role;
import com.med.ani.entities.User;
import com.med.ani.service.UserService;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class AnimalSpring1Application implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(AnimalSpring1Application.class, args);
    }
    /* @PostConstruct
    void init_users() {
   //ajouter les rôles
    userService.addRole(new Role(null,"ADMIN"));
    userService.addRole(new Role(null,"AGENT"));
    userService.addRole(new Role(null,"USER"));
    //ajouter les users
    userService.saveUser(new User(null,"admin","123",true,null));
    userService.saveUser(new User(null,"nadhem","123",true,null));
    userService.saveUser(new User(null,"user1","123",true,null));
    //ajouter les rôles aux users
    userService.addRoleToUser("admin", "ADMIN");
    userService.addRoleToUser("nadhem", "USER");
    userService.addRoleToUser("nadhem", "AGENT");
    userService.addRoleToUser("user1", "USER");
    }*/
    @Override
    public void run(String... args) throws Exception {
        // System.out.println("Password Encoded BCRYPT :******************** ");
        // System.out.println(passwordEncoder.encode("123"));
        
        // animalService.saveAnimal(new Animal("Cat", 2, "Mammal"));
        // animalService.saveAnimal(new Animal("Dog", 4, "Mammal"));
        // animalService.saveAnimal(new Animal("Parrot", 1, "Bird"));
        // repositoryRestConfiguration.exposeIdsFor(Animal.class);
    }
}
