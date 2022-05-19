package com.visa.demo.service;

import com.visa.demo.dto.ProductDTO;
import com.visa.demo.entity.Product;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  public ProductDTO productToProductDTO(Product product);
  public Product productDTOToProduct(ProductDTO productDTO);
}
