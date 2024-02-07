package com.devsuperior.DSCommerce.controller;

import com.devsuperior.DSCommerce.DTO.AuthDTO;
import com.devsuperior.DSCommerce.DTO.LoginDTO;
import com.devsuperior.DSCommerce.DTO.UserDTO;
import com.devsuperior.DSCommerce.repositories.UserRepository;
import com.devsuperior.DSCommerce.services.TokenService;
import com.devsuperior.DSCommerce.entities.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final TokenService service;
    private final UserRepository repository;
    private final AuthenticationManager manager;

    public UserController(TokenService service, UserRepository repository, AuthenticationManager manager) {
        this.service = service;
        this.repository = repository;
        this.manager = manager;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserDTO dto){
            if (this.repository.findByEmail(dto.email()) != null) return ResponseEntity.badRequest().build();

            String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
            User user = new User(dto.name(), dto.email(), dto.phone(), LocalDate.now(), encryptedPassword, dto.roles());
            this.repository.save(user);
            return ResponseEntity.ok().build();
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        try {
            Authentication authentication = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password())
            );
            var token = service.generateToken((User) authentication.getPrincipal());
            return ResponseEntity.ok(new AuthDTO(token));
        } catch (Exception e) {
            throw new RuntimeException("Falha no login");
        }
    }
}
