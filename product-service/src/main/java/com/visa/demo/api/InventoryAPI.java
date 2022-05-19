// package com.visa.demo.api;

// import com.visa.demo.dto.InventoryDTO;
// import com.visa.demo.exception.VisaException;
// import com.visa.demo.service.ProductService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin
// @RestController
// @RequestMapping(value = "/inventory-api")
// public class InventoryAPI {
//   @Autowired
//   private ProductService productService;

//   @PostMapping(value = "/add")
//   public ResponseEntity<Long> addNewProduct(@RequestBody InventoryDTO inventoryDTO) throws VisaException {
//     Long newInventoryId = productService.addInventory(inventoryDTO);
//     return new ResponseEntity<>(newInventoryId, HttpStatus.CREATED);
//   }
  
// }
