package com.anasdev.gestiondesutilisateursservice.repository;

import com.anasdev.gestiondesutilisateursservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
