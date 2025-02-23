package admin_user.service;

import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        var authorities = authentication.getAuthorities();
        var roles = authorities.stream().map(r -> r.getAuthority()).findFirst();
        String role = roles.orElse(null);

        // Log pour vérifier le rôle récupéré
        System.out.println("Rôle après authentification: " + role);

        if (role == null) {
            response.sendRedirect("/error");
        } else if (role.equals("Admin")) {
            response.sendRedirect("/admin-page");
        } else if (role.equals("Employé")) {
            response.sendRedirect("/employe-page");
        } else if (role.equals("Responsable RH")) {
            response.sendRedirect("/responsable-rh-page");
        } else if (role.equals("Chef Hiérarchique")) {
            response.sendRedirect("/chef-hierarchique-page");
        } else {
            response.sendRedirect("/error");
        }
    }
}
