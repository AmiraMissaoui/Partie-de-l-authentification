package admin_user.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import admin_user.service.CustomSuccessHandler;
import admin_user.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    // Définit le PasswordEncoder utilisé pour encoder les mots de passe
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable()) // Désactive CSRF pour simplification

                .authorizeHttpRequests(request -> request
                        .requestMatchers("/admin-page").hasAuthority("Admin") // Accès réservé aux Admins
                        .requestMatchers("/employe-page").hasAuthority("Employé") // Accès réservé aux Employés
                        .requestMatchers("/responsable-rh-page").hasAuthority("Responsable RH") // Accès réservé aux Responsables RH
                        .requestMatchers("/chef-hierarchique-page").hasAuthority("Chef Hiérarchique") // Accès réservé aux Chefs Hiérarchiques
                        .requestMatchers("/registration", "/css/**").permitAll() // Pages d'inscription et CSS accessibles à tous
                        .anyRequest().authenticated()) // Toute autre page nécessite une authentification

                .formLogin(form -> form
                        .loginPage("/login") // Page de connexion personnalisée
                        .loginProcessingUrl("/login") // URL de traitement de la connexion
                        .successHandler(customSuccessHandler) // Gestionnaire de succès pour redirection après connexion
                        .permitAll()) // Permet l'accès à la page de login

                .logout(form -> form
                        .invalidateHttpSession(true) // Invalide la session lors de la déconnexion
                        .clearAuthentication(true) // Supprime l'authentification
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // URL pour la déconnexion
                        .logoutSuccessUrl("/login?logout") // Redirige après déconnexion
                        .permitAll()); // Permet l'accès à la déconnexion
        return http.build();
    }

    // Configure l'AuthenticationManagerBuilder pour utiliser le UserDetailsService personnalisé
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
