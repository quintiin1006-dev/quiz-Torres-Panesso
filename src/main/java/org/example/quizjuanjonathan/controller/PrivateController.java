package org.example.quizjuanjonathan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateController {

    @GetMapping("/private")
    public String privateEndpoint() {
        return "Acceso privado correcto";
    }
}
