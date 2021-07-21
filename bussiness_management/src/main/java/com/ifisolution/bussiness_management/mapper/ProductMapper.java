package com.ifisolution.bussiness_management.mapper;

import com.ifisolution.bussiness_management.dto.ProductDto;
import com.ifisolution.bussiness_management.models.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "name", source = "productName")
    @Mapping(target = "stock", source = "quantity")
    ProductDto mapProductToDto(Product product);

    @InheritInverseConfiguration
    Product mapProduct(ProductDto productDto);

}
