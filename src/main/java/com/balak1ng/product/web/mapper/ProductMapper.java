package com.balak1ng.product.web.mapper;

import com.balak1ng.product.model.Product;
import com.balak1ng.product.web.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class}, componentModel = "spring")
public interface ProductMapper extends Mappable<Product, ProductDto> {
}
