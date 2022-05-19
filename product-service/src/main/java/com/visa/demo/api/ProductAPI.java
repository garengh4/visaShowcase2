package com.visa.demo.api;

import java.util.List;

import com.visa.demo.dto.ProductDTO;
import com.visa.demo.exception.VisaException;
import com.visa.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/product-api")
public class ProductAPI {

  @Autowired
  ProductService productService;

  @RequestMapping("/hi")
  public String home() {
    return "Hello World";
  }

  @PostMapping(value = "/add")
  public ResponseEntity<Long> addNewProduct(@RequestBody ProductDTO productDTO) throws VisaException {
    Long newProductId = productService.addProduct(productDTO);
    return new ResponseEntity<>(newProductId, HttpStatus.CREATED);
  }

  @GetMapping(value = "/getall")
  public ResponseEntity<List<ProductDTO>> getAllProduct() throws VisaException {
    List<ProductDTO> products = productService.getAllProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @GetMapping(value = "/getbyid/{productId}")
  public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) throws VisaException {
    ProductDTO product = productService.getProductById(productId);
    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @PutMapping(value = "/update")
  public ResponseEntity<ProductDTO> updateProductById(@RequestBody ProductDTO productDTO) throws VisaException {
    ProductDTO dto = productService.updateProduct(productDTO);
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/delete/{productId}")
  public ResponseEntity<Integer> deleteProductById(@PathVariable Long productId) throws VisaException {
    productService.deleteProduct(productId);
    return new ResponseEntity<>(HttpStatus.OK);
  }



  
  @GetMapping("paynow/{price}")
  public String payNow(@PathVariable int price) {
    return "Payment amount: " + price;
  }




}
