package com.example.stage1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.stage1.Entity.User;
import com.example.stage1.Repository.UserRepository;
import java.util.Optional;

@Controller
public class MainController {

    private final UserRepository userRepository;

    // Injection via constructeur
    @Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        // Vérification du mot de passe en clair
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            return "redirect:/welcome";  // Rediriger vers une page d'accueil après la connexion
        }
        return "redirect:/login?error";  // Rediriger en cas d'erreur
    }
}
