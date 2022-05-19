package com.visa.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.visa.demo.dto.ProductDTO;
import com.visa.demo.entity.Product;
import com.visa.demo.exception.VisaException;
import com.visa.demo.repository.ProductRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
  
  @Mock
  private ProductRepository productRepository;

  // @InjectMocks
  // private ProductMapper mapper = new ProductMapperImpl();

  @InjectMocks
  private ProductService productService = new ProductServiceImpl();

  @Test
  public void addProductValidTest() throws VisaException {
    Product productInDB = new Product();
    productInDB.setProductId(1L);
    productInDB.setProductName("visa");
    Mockito.when(productRepository.save(Mockito.any())).thenReturn(productInDB);

    ProductDTO productDTO = new ProductDTO();   

    Long newProductId = productService.addProduct(productDTO);
    Assertions.assertEquals(1L, newProductId);
  }

  @Test
  public void getAllProductsValidTest() throws VisaException {

    List<Product> productsInDB = new ArrayList<>();
    Product productOne = new Product();
    productOne.setProductId(1L);
    productsInDB.add(productOne);
    Product productTwo = new Product();
    productTwo.setProductId(2L);
    productsInDB.add(productTwo);
    Mockito.when(productRepository.findAll()).thenReturn(productsInDB);

    List<ProductDTO> returned = productService.getAllProducts();
    Assertions.assertEquals(2, returned.size());
  }

  @Test
  public void getProductByIdValidTest() throws VisaException {
    Product productInDB = new Product();
    productInDB.setProductId(1L);
    productInDB.setProductName("visa card");
    Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(productInDB));

    ProductDTO returned = productService.getProductById(1L);
    Assertions.assertEquals(1L, returned.getProductId());
    
  }

  @Test
  public void updateProductValidTest() throws VisaException {
    Product productInDB = new Product();
    productInDB.setProductId(1L);
    productInDB.setProductName("visa card");
    Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(productInDB));

    ProductDTO newProductUpdate = new ProductDTO();
    newProductUpdate.setProductId(productInDB.getProductId());
    newProductUpdate.setProductName("master card");

    ProductDTO returned = productService.updateProduct(newProductUpdate);
    Assertions.assertEquals("master card", returned.getProductName());
  }

  @Test
  public void deleteProductValidTest() throws VisaException {
    Product productInDB = new Product();
    productInDB.setProductId(23L);
    productInDB.setProductName("legacy product");
    Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(productInDB));

    Assertions.assertDoesNotThrow(() -> productService.deleteProduct(44L));

  }

  
}
