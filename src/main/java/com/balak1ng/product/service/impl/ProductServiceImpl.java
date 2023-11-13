package com.balak1ng.product.service.impl;

import com.balak1ng.product.repository.ProductRepository;
import com.balak1ng.product.service.ProductService;
import com.balak1ng.product.web.dto.ProductDto;
import com.balak1ng.product.web.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.balak1ng.product.web.exception.NotFoundException;
import com.balak1ng.product.model.Product;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getById(UUID productId) {
        return productMapper.toDto(productRepository.findById(productId)
                .orElseThrow(() ->
                        new NotFoundException("Product with id = " + productId + " does not exist.")));
    }

    @Override
    public ProductDto saveNewProduct(ProductDto productDto) {
        return productMapper.toDto(productRepository
                .save(productMapper.toEntity(productDto)));
    }


    @Override
    public ProductDto updateProduct(UUID productId, ProductDto productDto) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new NotFoundException("Product with id = " + productId + " does not exist."));

        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setUpc(productDto.getUpc());

        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public List<ProductDto> getAll() {
        return productMapper.toDto(productRepository.findAll());
    }

}

