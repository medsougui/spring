package com.med.ani.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.med.ani.entities.Categorie;
public interface CategorieRepository extends JpaRepository<Categorie, Long>
{
}
