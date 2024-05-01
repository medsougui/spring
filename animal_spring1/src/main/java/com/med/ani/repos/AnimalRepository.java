package com.med.ani.repos;

import com.med.ani.entities.Animal;
import com.med.ani.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(path = "rest")

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByNom(String nom); // Corrected method name here
    List<Animal> findByNomContains(String nom); // Corrected method name here
    @Query("select a from Animal a where a.nom like %:nom and a.age > :age and a.type = :type")
    List<Animal> findByNomAgeType(@Param("nom") String nom, @Param("age") int age, @Param("type") String type);
    @Query("select a from Animal a where a.categorie = :categorie")
    List<Animal> findByCategorie(Categorie categorie);
    List<Animal> findByCategorieIdCat(Long id);
    List<Animal> findAllByOrderByNomAsc(); // Change method name here
    @Query("select a from Animal a order by a.nom ASC, a.age DESC")
    List<Animal> trierAnimauxNomsPrix();
}
