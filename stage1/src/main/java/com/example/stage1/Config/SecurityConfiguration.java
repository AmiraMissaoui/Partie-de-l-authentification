//package com.example.stage1.Config;

//import com.example.stage1.Service.UserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//public class SecurityConfiguration {

    //private final UserService userService;

    // Injection via constructeur
   // public SecurityConfiguration(UserService userService) {
        //this.userService = userService;
  //  }

    // Bean pour l'encodeur de mot de passe
   // @Bean
   // public PasswordEncoder passwordEncoder() {
     //   return new BCryptPasswordEncoder();
// }

    // Bean pour DaoAuthenticationProvider
//  @Bean
//public DaoAuthenticationProvider authenticationProvider() {
// DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
// auth.setUserDetailsService(userService);  // Assurez-vous que userService implémente UserDetailsService
// auth.setPasswordEncoder(passwordEncoder()); // L'encodeur de mot de passe
// return auth;
// }

    // Bean pour AuthenticationManager (pour Spring Boot 3 / Spring Security 6)
// @Bean
// public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
// return http.getSharedObject(AuthenticationManager.class);  // Directement récupérer l'AuthenticationManager de http
//  }

    // Configuration de la sécurité HTTP (pour l'accès aux URL)
//   @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// http
//    .authorizeRequests()
//    .requestMatchers("/registration**", "/js/**", "/css/**", "/img/**").permitAll()
//     .anyRequest().authenticated()  // Toute autre demande nécessite une authentification
//              .and()
//              .formLogin()
//              .loginPage("/login")  // Page de connexion personnalisée
//              .permitAll()  // Permet à tout le monde d'accéder à la page de connexion
//              .and()
//              .logout()
//              .invalidateHttpSession(true)
//              .clearAuthentication(true)
//              .logoutUrl("/logout")  // URL de déconnexion
//              .logoutSuccessUrl("/login?logout")  // Redirection après la déconnexion
//               .permitAll();
//      return http.build();  // Retourne la configuration complète de sécurité
//   }
//}
