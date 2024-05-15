package com.med.ani.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.med.ani.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}