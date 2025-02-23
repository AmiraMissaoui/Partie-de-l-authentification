package com.example.stage1.Service;

import com.example.stage1.Entity.User;  // L'importation de la classe User
import com.example.stage1.Web.DTO.UserRegistrationDto;  // Correction de l'importation
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);  // Méthode utilisant UserRegistrationDto
}
