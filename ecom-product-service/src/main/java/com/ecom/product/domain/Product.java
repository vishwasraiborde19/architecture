package com.ecom.product.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long catID;
	private String categoryName;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productID;
	private String productName;
	private String productDescription;
	private String productImageURL;
	private Double productPrice;
}
