package com.visa.demo.service;

import java.util.List;

// import com.visa.demo.dto.InventoryDTO;
import com.visa.demo.dto.ProductDTO;
import com.visa.demo.exception.VisaException;

import org.springframework.stereotype.Component;

@Component
public interface ProductService {

  Long addProduct(ProductDTO productDTO) throws VisaException; //returns new productId
  List<ProductDTO> getAllProducts() throws VisaException;
  ProductDTO getProductById(Long productId) throws VisaException;
  ProductDTO updateProduct(ProductDTO productDTO) throws VisaException;
  void deleteProduct(Long productId) throws VisaException;

  // Long addInventory(InventoryDTO inventoryDTO) throws VisaException;
  // List<InventoryDTO> getAllInventory() throws VisaException;
}
