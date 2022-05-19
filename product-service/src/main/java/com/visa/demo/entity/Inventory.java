// package com.visa.demo.entity;

// import java.util.UUID;

// import javax.persistence.CascadeType;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToOne;
// import javax.persistence.PrePersist;
// import javax.persistence.Table;

// @Entity
// @Table(name = "inventory")
// public class Inventory {

//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   @Column(name = "inventory_id")
//   private Long inventoryId;

//   @Column(name = "quantity")
//   private Integer quantity;

//   @Column(name = "sku_uuid")
//   private String skuUUID; 

//   @OneToOne(cascade = CascadeType.ALL)
//   @JoinColumn(name = "product_id")
//   private Product product;
//   /*----------------------------------------------------------------------------------------------------------------------- */

//   public Long getInventoryId() {
//     return inventoryId;
//   }

//   public void setInventoryId(Long inventoryId) {
//     this.inventoryId = inventoryId;
//   }

//   public Integer getQuantity() {
//     return quantity;
//   }

//   public void setQuantity(Integer quantity) {
//     this.quantity = quantity;
//   }

//   public String getSkuUUID() {
//     return skuUUID;
//   }

//   public void setSkuUUID(String skuUUID) {
//     this.skuUUID = skuUUID;
//   }

//   public Product getProduct() {
//     return product;
//   }

//   public void setProduct(Product product) {
//     this.product = product;
//   }

//   @PrePersist
// 	public void autofill() {
// 		this.setSkuUUID(UUID.randomUUID().toString());
// 	}

// }
