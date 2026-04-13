package org.example.quizjuanjonathan.service;

import org.example.quizjuanjonathan.model.User;
import org.example.quizjuanjonathan.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listar() {
        return userRepository.findAll();
    }

    public Optional<User> obtenerPorId(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> obtenerPorUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User crear(User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    public Optional<User> actualizar(Long id, User userActualizado) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userActualizado.getUsername());
            user.setPassword(userActualizado.getPassword());
            user.setRoles(userActualizado.getRoles());
            return userRepository.save(user);
        });
    }

    public boolean eliminar(Long id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}
