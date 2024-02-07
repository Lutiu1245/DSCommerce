package com.devsuperior.DSCommerce.DTO;

import com.devsuperior.DSCommerce.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginDTO (@NotBlank @NotNull String email, @NotNull @NotBlank String password) {
    public LoginDTO (User user) {
        this(user.getEmail(), user.getPassword());
    }
}
