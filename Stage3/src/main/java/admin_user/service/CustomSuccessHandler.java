package admin_user.service;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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

        if (authentication == null) {
            response.sendRedirect("/error");  // En cas d'authentification nulle
            return;
        }

        // Récupérer les autorités (rôles) de l'utilisateur
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Si l'utilisateur n'a pas d'autorité, redirigez vers la page d'erreur
        if (authorities == null || authorities.isEmpty()) {
            response.sendRedirect("/error");
            return;
        }

        // Log pour vérifier les rôles
        System.out.println("Authorities: " + authorities);

        // Vérifier le rôle de l'utilisateur
        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();  // Le rôle de l'utilisateur sans "ROLE_"

            // Log pour vérifier le rôle de chaque autorité
            System.out.println("User Role: " + role);

            // Rediriger en fonction du rôle
            if ("admin".equals(role)) {
                response.sendRedirect("/admin-page");  // Redirection vers le dashboard Admin
                return;
            } else if ("user".equals(role)) {
                response.sendRedirect("/user-page");  // Redirection vers le dashboard User
                return;
            }
            // Ajouter d'autres vérifications pour d'autres rôles si nécessaire
        }

        // Si aucun rôle valide trouvé
        response.sendRedirect("/error");
    }
}
