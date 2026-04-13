package org.example.quizjuanjonathan.config;

import org.example.quizjuanjonathan.model.Carro;
import org.example.quizjuanjonathan.repository.CarroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoaderConfig {

    @Bean
    public CommandLineRunner cargarDatosIniciales(CarroRepository carroRepository) {
        return args -> {
            if (carroRepository.count() > 0) {
                return;
            }

            Carro carro1 = new Carro();
            carro1.setMarca("Toyota");
            carro1.setModelo("Corolla");
            carro1.setAnio(2022);
            carro1.setPlaca("ABC123");

            Carro carro2 = new Carro();
            carro2.setMarca("Mazda");
            carro2.setModelo("CX-5");
            carro2.setAnio(2021);
            carro2.setPlaca("XYZ789");

            carroRepository.saveAll(List.of(carro1, carro2));
        };
    }
}
