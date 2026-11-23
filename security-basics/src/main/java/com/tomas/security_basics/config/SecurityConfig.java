package com.tomas.security_basics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity 
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
                http
                    .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/publico").permitAll() //La ruta permite a cualquiera sin autenticar
                        .requestMatchers("/api/perfil").authenticated() //Debe estar autenticado
                        .requestMatchers("/api/productos").permitAll() //La ruta permite a cualquiera sin autenticar
                        .anyRequest().authenticated() //Cualquier otro no mencionado requiere autenticacion
                    )
                    .formLogin(Customizer.withDefaults());//Crea el login por defecto de Spring Security
        return http.build(); //Crea instancia de SecurityFilterChain segun nuestras reglas
    }
}