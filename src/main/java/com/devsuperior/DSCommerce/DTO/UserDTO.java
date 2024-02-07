package com.devsuperior.DSCommerce.DTO;

import com.devsuperior.DSCommerce.entities.User;
import com.devsuperior.DSCommerce.enums.Roles;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

    public record UserDTO(@NotBlank @NotNull @Size(min = 3, max = 30) String name, @NotBlank @NotNull @Email String email, @NotBlank @Pattern(regexp = "[0-9]{2}[0-9]{8,9}") String phone, @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate birthDate, String password, Roles roles) {
    public UserDTO (User user) {
        this(user.getName(), user.getEmail(), user.getPhone(), user.getBirthDate(), user.getPassword(), user.getRole());
    }
}
