package com.devsuperior.DSCommerce.services;

import com.devsuperior.DSCommerce.DTO.ProductDTO;
import com.devsuperior.DSCommerce.entities.Product;
import com.devsuperior.DSCommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> productList = repository.findAll(pageable);
        return productList.map(x -> new ProductDTO(x));
        // return productList.map(ProductDTO::new);
    }
    @Transactional()
    public ProductDTO insert(ProductDTO productDTO) {
        Product product = new Product();
        copyDTO(product, productDTO);
        product = repository.save(product);
        return new ProductDTO(product);
    }
    @Transactional()
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = repository.getReferenceById(id);
        copyDTO(product, productDTO);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @Transactional()
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void copyDTO(Product product, ProductDTO productDTO) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImgUrl(productDTO.getImgUrl());
    }
}
