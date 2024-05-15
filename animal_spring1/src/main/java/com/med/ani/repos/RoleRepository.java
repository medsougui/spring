package com.med.ani.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.med.ani.entities.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
