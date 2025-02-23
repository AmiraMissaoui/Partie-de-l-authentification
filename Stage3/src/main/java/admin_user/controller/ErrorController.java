package admin_user.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public String handleError(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";  // Affiche la page d'erreur personnalisée
    }

    // Si vous avez des erreurs spécifiques, vous pouvez également définir des méthodes spécifiques.
}
