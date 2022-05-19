package com.visa.demo.repository;

import java.util.Optional;

import com.visa.demo.entity.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryTest {
  @Autowired
  private ProductRepository productRepository;

  private Product product;

  @BeforeEach
  public void setUp() {
    product = new Product();
    product.setProductId(1L);
    product.setProductName("visa card");
  }

  @Test
  public void saveProductValidTest() {
    Product productToDB = productRepository.save(product);
    Assertions.assertEquals("visa card", productToDB.getProductName());
  }

  @Test
  public void findByIdValidTest() {
    productRepository.save(product);
    Optional<Product> productContainer = productRepository.findById(1L);
    Assertions.assertTrue(productContainer.isPresent());
  }


}