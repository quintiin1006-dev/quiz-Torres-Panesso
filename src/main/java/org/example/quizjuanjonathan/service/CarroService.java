package org.example.quizjuanjonathan.service;

import org.example.quizjuanjonathan.model.Carro;
import org.example.quizjuanjonathan.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> listar() {
        return carroRepository.findAll();
    }

    public Optional<Carro> obtenerPorId(Long id) {
        return carroRepository.findById(id);
    }

    public Carro crear(Carro carro) {
        carro.setId(null);
        return carroRepository.save(carro);
    }

    public Optional<Carro> actualizar(Long id, Carro carroActualizado) {
        return carroRepository.findById(id).map(carro -> {
            carro.setMarca(carroActualizado.getMarca());
            carro.setModelo(carroActualizado.getModelo());
            carro.setAnio(carroActualizado.getAnio());
            carro.setPlaca(carroActualizado.getPlaca());
            return carroRepository.save(carro);
        });
    }

    public boolean eliminar(Long id) {
        if (!carroRepository.existsById(id)) {
            return false;
        }
        carroRepository.deleteById(id);
        return true;
    }
}
