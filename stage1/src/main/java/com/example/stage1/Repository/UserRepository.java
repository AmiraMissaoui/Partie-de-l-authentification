package com.example.stage1.Repository;

import com.example.stage1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Cette méthode permet de trouver un utilisateur par son email
    Optional<User> findByEmail(String email);

    // Cette méthode permet de vérifier si un utilisateur existe avec l'email donné
    boolean existsByEmail(String email);
}
