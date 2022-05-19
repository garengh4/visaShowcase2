package com.visa.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

// import com.visa.demo.dto.InventoryDTO;
import com.visa.demo.dto.ProductDTO;
// import com.visa.demo.entity.Inventory;
import com.visa.demo.entity.Product;
import com.visa.demo.exception.VisaException;
// import com.visa.demo.repository.InventoryRepository;
import com.visa.demo.repository.ProductRepository;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  // TODO: seems to break mockito unit test -> might need to mock productMapper (?)
  // @Autowired
  // protected ProductMapper mapper;

  ProductMapper mapper = Mappers.getMapper(ProductMapper.class);


  @Autowired
  private ProductRepository productRepository;

  // @Autowired
  // private InventoryRepository inventoryRepository;

  @Override
  public Long addProduct(ProductDTO productDTO) throws VisaException {

    Product newProduct = mapper.productDTOToProduct(productDTO);
    Product returned = productRepository.save(newProduct);
    return returned.getProductId();

  }

  @Override
  public List<ProductDTO> getAllProducts() throws VisaException {
    Iterable<Product> products = productRepository.findAll();

    List<ProductDTO> productDTOs = new ArrayList<>();
    products.forEach(entity -> {
      ProductDTO dto = mapper.productToProductDTO(entity);
      productDTOs.add(dto);
    });

    return productDTOs;
  }

  @Override
  public ProductDTO getProductById(Long productId) throws VisaException {
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new VisaException("Product not found with that productId."));

    ProductDTO productDTO = mapper.productToProductDTO(product);
    productDTO.setProductId(productId);
    return productDTO;
  }

  @Override
  public ProductDTO updateProduct(ProductDTO productDTO) throws VisaException {
    Product product = productRepository.findById(productDTO.getProductId())
        .orElseThrow(() -> new VisaException("Product not found with that productId."));
    
    product.setProductName(productDTO.getProductName());
    product.setDescription(productDTO.getDescription());
    product.setSize(productDTO.getSize());
    product.setUnitPrice(productDTO.getUnitPrice());
    productRepository.save(product);
    
    // this should return product instead of productDTO (?)
    return productDTO;
  }

  @Override
  public void deleteProduct(Long productId) throws VisaException {
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new VisaException("Product not found with that productId."));

    productRepository.delete(product);

  }

  // @Override
  // public Long addInventory(InventoryDTO inventoryDTO) throws VisaException {
  //   Inventory inventory = new Inventory();
  //   inventory.setQuantity(inventoryDTO.getQuantity());
  //   Inventory returned = inventoryRepository.save(inventory);
  //   return returned.getInventoryId();
  // }

  // @Override
  // public List<InventoryDTO> getAllInventory() throws VisaException {
  //   // TODO Auto-generated method stub
  //   return null;
  // }

}