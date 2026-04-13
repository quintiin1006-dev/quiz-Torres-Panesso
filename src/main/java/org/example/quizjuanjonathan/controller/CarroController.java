package org.example.quizjuanjonathan.controller;

import org.example.quizjuanjonathan.model.Carro;
import org.example.quizjuanjonathan.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class
CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public List<Carro> listarCarros() {
        return carroService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") Long id) {
        return carroService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carro> crearCarro(@RequestBody Carro carro) {
        Carro creado = carroService.crear(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> actualizarCarro(@PathVariable("id") Long id, @RequestBody Carro carro) {
        return carroService.actualizar(id, carro)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarro(@PathVariable("id") Long id) {
        boolean eliminado = carroService.eliminar(id);
        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
