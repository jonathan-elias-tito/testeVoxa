package com.TrabalhoCibele.Voxa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.TrabalhoCibele.Voxa.Entities.User;
import com.TrabalhoCibele.Voxa.Repository.UserRepository;

@SpringBootApplication
public class VoxaApplication implements CommandLineRunner {

    // Injeção de dependência normal (SEM o static)
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(VoxaApplication.class, args);
    }

    // O método run executa automaticamente LOGO APÓS o Spring Boot iniciar totalmente
    @Override
    public void run(String... args) throws Exception {
        User usuario1 = new User(null, "Vitor", "Vitor@gmail.com", 1245);
        userRepository.save(usuario1);
    }
}