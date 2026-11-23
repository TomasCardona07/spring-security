package com.tomas.security_basics;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/publico")
    public String publico() {
        return "Cualquier persona puede ver esto";
    }

    @GetMapping("/perfil")
    public String perfil() {
        return "Bienvenido, has iniciado sesión";
    }
}