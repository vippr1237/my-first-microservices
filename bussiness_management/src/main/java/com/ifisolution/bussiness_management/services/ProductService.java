package com.ifisolution.bussiness_management.services;


import com.ifisolution.bussiness_management.dto.ProductDto;
import com.ifisolution.bussiness_management.exceptions.ProductNotFoundException;
import com.ifisolution.bussiness_management.mapper.ProductMapper;
import com.ifisolution.bussiness_management.models.Product;
import com.ifisolution.bussiness_management.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public Product addProduct(ProductDto productDto) {
        return productRepo.save(productMapper.mapProduct(productDto));
    }

    public List<ProductDto> findAllProducts() {
        return productRepo.findAll()
                .stream().map(productMapper::mapProductToDto)
                .collect(toList());
    }

    public Product updateProduct(ProductDto productDto) {
        return productRepo.save(productMapper.mapProduct(productDto));
    }

    public ProductDto findProductById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product by id " + id + " was not found"));
        return productMapper.mapProductToDto(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteProductById(id);
    }
}