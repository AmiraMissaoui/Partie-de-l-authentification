package com.example.stage1.Controller;

import com.example.stage1.Web.DTO.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Import Model class
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.stage1.Service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegestrationController {

    private final UserService userService;

    public UserRegestrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";  // Affiche la page d'inscription
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);  // Sauvegarde de l'utilisateur
        return "redirect:/welcome";  // Redirige vers la page de bienvenue après inscription
    }
}
