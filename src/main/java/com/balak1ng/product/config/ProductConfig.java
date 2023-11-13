package com.balak1ng.product.config;

import com.balak1ng.product.model.Product;
import com.balak1ng.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ProductConfig {

    public static final String PRODUCT_1_UPC = "0631234200036";
    public static final String PRODUCT_2_UPC = "0631234300019";
    public static final String PRODUCT_3_UPC = "0083783375213";

    private final ProductRepository productRepository;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Product product1 = Product.builder()
                    .title("Milk")
                    .price(new BigDecimal("79.90"))
                    .upc(PRODUCT_1_UPC)
                    .build();
            Product product2 = Product.builder()
                    .title("Bread")
                    .price(new BigDecimal("40.00"))
                    .upc(PRODUCT_2_UPC)
                    .build();
            Product product3 = Product.builder()
                    .title("Coca-Cola")
                    .price(new BigDecimal("59.90"))
                    .upc(PRODUCT_3_UPC)
                    .build();

            productRepository.saveAll(List.of(product1, product2, product3));
        };
    }

}
