package com.med.ani.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.med.ani.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
