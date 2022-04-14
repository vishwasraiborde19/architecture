package com.ecom.product.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

	private Long catID;
	private String categoryName;

	private Long productID;
	private String productName;
	private String productDescription;
	private String productImageURL;
	private Double productPrice;
}
