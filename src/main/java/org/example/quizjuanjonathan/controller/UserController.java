package org.example.quizjuanjonathan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user")
    public String userEndpoint() {
        return "Acceso permitido para USER y ADMIN";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Acceso permitido SOLO para ADMIN";
    }
}
