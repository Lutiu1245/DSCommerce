package com.devsuperior.DSCommerce.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthDTO(String token) {
}
