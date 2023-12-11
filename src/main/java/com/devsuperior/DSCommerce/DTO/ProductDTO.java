package com.devsuperior.DSCommerce.DTO;

import com.devsuperior.DSCommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    private Long id;
    @Size(min = 3, max = 80, message = "Numero de caracteres deve ser entre 3-80")
    @NotBlank(message = "Campo requerido")
    private String name;
    @Size(min = 10, message = "Campo descrição deve ter no minimo 10")
    @NotBlank(message = "Campo requerido")
    private String description;
    @Positive(message = "Preço deve ser um valor positivo")
    private double price;
    private String imgUrl;

    public ProductDTO() {

    }

    public ProductDTO(Long id, String name, String description, double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
