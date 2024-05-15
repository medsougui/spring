package com.med.ani.entities;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
private Long user_id;

@Column(unique=true)
private String username;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<Role> getRoles() {
	return roles;
}
public void setRoles(List<Role> roles) {
	this.roles = roles;
}
private String password;
private Boolean enabled;
@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") ,
 inverseJoinColumns = @JoinColumn(name="role_id"))
private List<Role> roles;
public User(Long user_id, String username, String password, Boolean enabled, List<Role> roles) {
    this.user_id = user_id;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.roles = roles;
    
}
public User() {
}
}